package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.DateUtils;
import com.common.utils.JsonUtils;
import com.common.utils.MathUtils;
import com.dais.mapper.RedPacketMapper;
import com.dais.model.*;
import com.dais.service.*;
import com.dais.utils.JedisClient;
import com.dais.utils.StringUtils;
import com.dais.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @author xxp
 * @version 2017- 10- 12 14:18
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class RedPacketServiceImpl implements RedPacketService{

    private static CopyOnWriteArraySet<Integer> userIdSet = new CopyOnWriteArraySet<Integer>();
    @Autowired
    private RedPacketMapper redPacketMapper;
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountOperationService accountOperationService;
    @Autowired
    private UserService userService;
    @Autowired
    private VirtualCoinService virtualCoinService;

    @Override
    public RedPacket updateSendPrivateRedPacket(RedPacket redPacket,int touserid) {
        redPacket.setType(1);//私聊红包
        redPacket.setStatus(1);//待领取
        redPacket.setParenid(0);
        redPacket.setCreateTime(Utils.getTimestamp());
        redPacket.setAmount(1);
        redPacket.setCategory(1);//发送
        int rows = redPacketMapper.insertSelective(redPacket);
        int rows2 = updateAccount(redPacket.getUserid(),touserid,redPacket.getSymbol(),-redPacket.getTotal());
        if (rows > 0 && rows2 > 0){
            return redPacket;
        }
       throw new RuntimeException();
    }

    @Override
    public RedPacket updateSendGroupRedPacket(RedPacket redPacket) {
        redPacket.setType(2);//群发红包
        redPacket.setStatus(1);//待领取
        redPacket.setParenid(0);
        redPacket.setCreateTime(Utils.getTimestamp());
        redPacket.setCategory(1);//发送
        User user = this.userService.queryUser(redPacket.getUserid());
        redPacket.setNickName(user.getFnickName());
        redPacket.setHeadImgUrl(user.getFheadImgUrl());
        int rows = redPacketMapper.insertSelective(redPacket);
        int rows2 = updateAccount(redPacket.getUserid(),0,redPacket.getSymbol(),-redPacket.getTotal());
        if (rows > 0 && rows2 >0){
            String key = redPacket.getId()+"_redpacket";
            jedisClient.set(key, JsonUtils.objectToJson(redPacket));
            jedisClient.expire(key,86400);
            return redPacket;
        }
        throw new RuntimeException();
    }

    @Override
    public RedPacket updateReceiveRedPacket(RedPacket redPacket,int touserid) {
        redPacket.setAmount(1);
        redPacket.setCreateTime(Utils.getTimestamp());
        redPacket.setStatus(2);
        redPacket.setCategory(2);
        int rows = this.redPacketMapper.insertSelective(redPacket);
        int rows2 = updateAccount(redPacket.getUserid(),touserid,redPacket.getSymbol(),redPacket.getTotal());
        if (rows > 0 && rows2 >0){
            return redPacket;
        }
        throw new RuntimeException();
    }

    @Override
    public RedPacket grabPrivateRedPacket(int redPacketId) {
        return this.getRedPacketById(redPacketId);
    }

    @Override
    public synchronized ResultModel updateOpenPrivate(int userId, int redPacketId) {
        RedPacket redPacket = this.getRedPacketById(redPacketId);
        if(redPacket == null){
            return ResultModel.build(403,"红包不存在");
        }
        if( DateUtils.getHoursAfter(redPacket.getCreateTime(),24).compareTo(Utils.getTimestamp()) == -1){
            return ResultModel.build(403,"红包已过期");
        }
        if(redPacket.getUserid() == userId){
            if(redPacket.getStatus() == 2){
                return ResultModel.build(403,"对方已领取");
            }else{
                return ResultModel.build(403,"等待对方领取");
            }
        }
        if(redPacket.getStatus() == 2){
            return ResultModel.build(403,"已领取红包");
        }

        //修改私聊红包状态
        redPacket.setStatus(2);
        this.redPacketMapper.updateByPrimaryKey(redPacket);

        RedPacket openRedPacket = new RedPacket();
        openRedPacket.setParenid(redPacketId);
        openRedPacket.setSymbol(redPacket.getSymbol());
        openRedPacket.setUserid(userId);
        openRedPacket.setType(1);
        openRedPacket.setTotal(redPacket.getTotal());
        openRedPacket = this.updateReceiveRedPacket(openRedPacket,redPacket.getUserid());
        User user = this.userService.queryUser(redPacket.getUserid());
        if(openRedPacket == null){
            ResultModel.build(500,"数据异常");
        }
        Map map = new HashMap<>();
        Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(redPacket.getSymbol());
        map.put("redPacketId",redPacketId);
        map.put("status",redPacket.getStatus());
        map.put("remarks",redPacket.getRemarks());
        map.put("headImgUrl",user.getFheadImgUrl());
        map.put("nickName",user.getFnickName());
        map.put("unit",fvirtualcointype.getFshortname());
        map.put("createTime",redPacket.getCreateTime());
        map.put("total",redPacket.getTotal());
        map.put("userid",redPacket.getUserid());
        User receive = this.userService.queryUser(userId);
        map.put("receiveHeadImgUrl",receive.getFheadImgUrl());
        map.put("receiveNickName",receive.getFnickName());
        map.put("receiveTotal",openRedPacket.getTotal());
        map.put("receiveTime",openRedPacket.getCreateTime());
        map.put("receiveUserid",openRedPacket.getUserid());
        map.put("flag",2);
        return ResultModel.ok(map);
    }

    @Override
    public ResultModel updateGrabRedPacket(int userId, int redPacketId) {
        String key = redPacketId+"_redpacket";
        String result = jedisClient.get(key);
        Map map = new HashMap<>();
        map.put("userId",null);
        map.put("remarks",null);
        map.put("nickName",null);
        map.put("headImgUrl",null);
        map.put("redPacketId",redPacketId);
        if(StringUtils.isEmpty(result)){
            map.put("status",3);
            return ResultModel.ok(map);
        }
        RedPacket redPacket = JsonUtils.jsonToPojo(result,RedPacket.class);
        map.put("userId",redPacket.getUserid());
        if( DateUtils.getHoursAfter(redPacket.getCreateTime(),24).compareTo(Utils.getTimestamp()) == -1){
            map.put("status",3);
            return ResultModel.ok(map);
        }
        map.put("remarks",redPacket.getRemarks());
        map.put("nickName",redPacket.getNickName());
        map.put("headImgUrl",redPacket.getHeadImgUrl());
        if(redPacket.getReceiveIds() != null && redPacket.getReceiveIds().contains("-"+userId+"-")){
            map.put("status",2);
            return ResultModel.ok(map);
        }
        if(redPacket.getAmount() <= 0){
            map.put("status",4);
            return ResultModel.ok(map);
        }
        map.put("status",1);
        return ResultModel.ok(map);
    }

    @Override
    public synchronized ResultModel updateOpenRedPacket(int userId, int redPacketId) {
        String key = redPacketId+"_redpacket";
        String result = jedisClient.get(key);
        Map map = new HashMap<>();
        map.put("remarks",null);
        map.put("nickName",null);
        map.put("headImgUrl",null);
        map.put("redPacketId",redPacketId);
        if(StringUtils.isEmpty(result)){
            map.put("status",3);
            return ResultModel.ok(map);
        }
        RedPacket redPacket = JsonUtils.jsonToPojo(result,RedPacket.class);
        if( DateUtils.getHoursAfter(redPacket.getCreateTime(),24).compareTo(Utils.getTimestamp()) == -1){
            map.put("status",3);
            return ResultModel.ok(map);
        }
        map.put("remarks",redPacket.getRemarks());
        map.put("nickName",redPacket.getNickName());
        map.put("headImgUrl",redPacket.getHeadImgUrl());
        if(redPacket.getReceiveIds() != null && redPacket.getReceiveIds().contains("-"+userId+"-")){
            map.put("status",2);//已领取
            return ResultModel.ok(map);
        }
        if(redPacket.getAmount() <= 0){
            map.put("status",4);//领完
            return ResultModel.ok(map);
        }

        RedPacket openRedPacket = new RedPacket();
        openRedPacket.setParenid(redPacketId);
        openRedPacket.setSymbol(redPacket.getSymbol());
        openRedPacket.setUserid(userId);
        openRedPacket.setType(2);
        if (redPacket.getAmount() == 1) {
            openRedPacket.setTotal(redPacket.getTotal());
            redPacket.setAmount(0);
            redPacket.setTotal(0d);
        }else{
            Random r = new Random();
            double max = MathUtils.divide(redPacket.getTotal(),redPacket.getAmount()) * 2;
            double money = MathUtils.multiply(r.nextDouble(),max);
            openRedPacket.setTotal(money);
            redPacket.setTotal(MathUtils.subtract(redPacket.getTotal(),money));
            redPacket.setAmount(redPacket.getAmount()-1);
        }
        String receiveIds = redPacket.getReceiveIds();
        if(StringUtils.isEmpty(receiveIds)){
            receiveIds = "-"+userId+"-";
        }else{
            receiveIds = receiveIds+",-"+userId+"-";
        }
        redPacket.setReceiveIds(receiveIds);
        jedisClient.set(key,JsonUtils.objectToJson(redPacket));
        openRedPacket = this.updateReceiveRedPacket(openRedPacket,redPacket.getUserid());
        if (openRedPacket == null){
            return ResultModel.build(500,"数据异常");
        }
        map.put("status",2);//已领取
        return ResultModel.ok(map);
    }

    @Override
    public RedPacket getRedPacketById(int id) {
        return this.redPacketMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RedPacket> getRedPacketByParentid(int parentid) {
        RedPacketExample example = new RedPacketExample();
        example.createCriteria().andParenidEqualTo(parentid);
        return this.redPacketMapper.selectByExample(example);
    }

    @Override
    public synchronized void checkExpireRedPacket(){
        System.out.println("开始进入："+DateUtils.formatDate(Utils.getTimestamp()));
        RedPacketExample example = new RedPacketExample();
        RedPacketExample.Criteria criteria = example.createCriteria();
        criteria.andParenidEqualTo(0);
        criteria.andStatusEqualTo(1);
        criteria.andCreateTimeLessThanOrEqualTo(Utils.getDateBefore(-1));
        List<RedPacket> redPackets = this.redPacketMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(redPackets)){
            return;
        }
        for (RedPacket redPacket : redPackets){
            redPacket.setStatus(3);
            this.redPacketMapper.updateByPrimaryKeySelective(redPacket);

            RedPacketExample example2 = new RedPacketExample();
            example2.createCriteria().andParenidEqualTo(redPacket.getId());
            List<RedPacket> receives = this.redPacketMapper.selectByExample(example2);
            if(CollectionUtils.isEmpty(receives)){
                this.updateDrawback(redPacket.getUserid(),redPacket.getSymbol(),redPacket.getTotal());
                continue;
            }
            if(receives.size() == redPacket.getAmount()){
                //无需退款
            }else {
                //循环计算退款
                Double temp = 0d;
                for (RedPacket r : receives){
                    temp = MathUtils.add(temp,r.getTotal());
                }
                Double drawback = MathUtils.subtract(redPacket.getTotal(),temp);
                if (drawback > 0){
                    this.updateDrawback(redPacket.getUserid(),redPacket.getSymbol(),drawback);
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(DateUtils.formatDate(Utils.getTimestamp()));
    }

    private void  updateDrawback(int userid,int symbol,double withdrawAmount){
        Account account = this.accountService.getAccount(userid, symbol);
        if (account == null){
            return;
        }
        account.setTotal(MathUtils.add(account.getTotal(),withdrawAmount));
        account.setUpdateTime(Utils.getTimestamp());
        this.accountService.updateAccount(account);
        this.accountOperationService.save(symbol,account.getUserid(),0,"红包退款","dais红包退款",withdrawAmount,0d,1);
    }

    private int updateAccount(int userid,int touserId,int symbol,double withdrawAmount){
        Account account = this.accountService.getAccount(userid, symbol);
        if(account == null){
            account = new Account();
            account.setUserid(userid);
            account.setSymbol(symbol);
            account.setCreateTime(Utils.getTimestamp());
            account.setUpdateTime(Utils.getTimestamp());
            account.setTotal(withdrawAmount);
            this.accountService.insertAccount(account);
        }else{
            account.setTotal(MathUtils.add(account.getTotal(),withdrawAmount));
            account.setUpdateTime(Utils.getTimestamp());
            this.accountService.updateAccount(account);
        }
        int type = 1;
        if(withdrawAmount < 0){
            type = 2;
        }
        return this.accountOperationService.save(symbol,account.getUserid(),touserId,"dais红包","dais红包",Math.abs(withdrawAmount),0d,type);
    }



}
