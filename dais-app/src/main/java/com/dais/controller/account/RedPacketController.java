package com.dais.controller.account;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.DateUtils;
import com.common.utils.MathUtils;
import com.dais.controller.BaseController;
import com.dais.model.Account;
import com.dais.model.Fvirtualcointype;
import com.dais.model.RedPacket;
import com.dais.model.User;
import com.dais.service.AccountService;
import com.dais.service.RedPacketService;
import com.dais.service.UserService;
import com.dais.service.VirtualCoinService;
import com.dais.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxp
 * @version 2017- 10- 12 19:27
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/redpacket")
public class RedPacketController extends BaseController{
    private static Logger logger = Logger.getLogger(RedPacketController.class);

    @Autowired
    private RedPacketService redPacketService;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private VirtualCoinService virtualCoinService;

    @RequestMapping(value="/sendprivate", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel sendPrivateRedPacket(Double total,String remarks,int symbol, int touserid,String token){
        User user = this.userService.queryUser(token);
        Account account = this.accountService.getAccount(user.getFid(),symbol);
        if (account == null){
            return ResultModel.build(403,"账户余额不足");
        }
        if (account.getTotal().compareTo(total) == -1){
            return ResultModel.build(403,"账户余额不足");
        }
        RedPacket redPacket = new RedPacket();
        redPacket.setTotal(total);
        redPacket.setUserid(user.getFid());
        redPacket.setRemarks(remarks);
        redPacket.setSymbol(symbol);
        redPacket = redPacketService.updateSendPrivateRedPacket(redPacket,touserid);
        redPacket.setNickName(user.getFnickName());
        redPacket.setHeadImgUrl(user.getFheadImgUrl());
        return ResultModel.ok(redPacket);
    }

    /**
     * 发送群聊红包
     * @param total
     * @param remarks
     * @param symbol
     * @param amount
     * @param token
     * @return
     */
    @RequestMapping(value="/sendgroup", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel sendGroupRedPacket(Double total,String remarks,int symbol, int amount,String token){
        User user = this.userService.queryUser(token);
        Account account = this.accountService.getAccount(user.getFid(),symbol);
        if (account == null){
            return ResultModel.build(403,"账户余额不足");
        }
        if (account.getTotal().compareTo(total) == -1){
            return ResultModel.build(403,"账户余额不足");
        }
        RedPacket redPacket = new RedPacket();
        redPacket.setTotal(total);
        redPacket.setAmount(amount);
        redPacket.setUserid(user.getFid());
        redPacket.setRemarks(remarks);
        redPacket.setSymbol(symbol);
        redPacket = this.redPacketService.updateSendGroupRedPacket(redPacket);
        redPacket.setNickName(user.getFnickName());
        redPacket.setHeadImgUrl(user.getFheadImgUrl());
        return ResultModel.ok(redPacket);
    }

    /**
     * 抢群聊红包
     * @param token
     * @param redPacketId
     * @return
     */
    @RequestMapping(value="/grabgroup", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel grabRedPacket(String token, int redPacketId){
        User user = this.userService.queryUser(token);
        return this.redPacketService.updateGrabRedPacket(user.getFid(),redPacketId);
    }

    /**
     * 查看私聊红包
     * @param token
     * @param redPacketId
     * @return
     */
    @RequestMapping(value="/grabprivate", method = RequestMethod.POST)
    @ResponseBody
    public  ResultModel grabPrivateRedPacket(String token, int redPacketId){
        try {
            Map map = new HashMap<>();
            RedPacket redPacket = this.redPacketService.getRedPacketById(redPacketId);
            User user = this.userService.queryUser(redPacket.getUserid());
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
            map.put("receiveHeadImgUrl",null);
            map.put("receiveNickName",null);
            map.put("receiveTotal",null);
            map.put("receiveTime",null);
            map.put("receiveUserid",null);
            map.put("flag",2);
            if(redPacket.getStatus() == 2){
                map.put("status",2);
                RedPacket receive = this.redPacketService.getRedPacketByParentid(redPacketId).get(0);
                User u = this.userService.queryUser(receive.getUserid());
                map.put("receiveHeadImgUrl",u.getFheadImgUrl());
                map.put("receiveNickName",u.getFnickName());
                map.put("receiveTotal",receive.getTotal());
                map.put("receiveTime",receive.getCreateTime());
                map.put("receiveUserid",receive.getUserid());
            }else if(redPacket.getStatus() == 1){
                map.put("status",1);
                if(this.userService.queryUser(token).getFid() != redPacket.getUserid()){
                    map.put("flag",1);
                }
            }
            if( DateUtils.getHoursAfter(redPacket.getCreateTime(),24).compareTo(Utils.getTimestamp()) == -1){
                map.put("status",3);
                map.put("flag",2);
            }
            return ResultModel.ok(map);
        } catch (Exception e) {
            logger.error("查看私聊红包信息异常"+e);
            e.printStackTrace();
            return ResultModel.build(500,"数据异常");
        }
    }

    @RequestMapping(value="/openprivate", method = RequestMethod.POST)
    @ResponseBody
    public  ResultModel openPrivateRedPacket(String token, int redPacketId){
        User user = this.userService.queryUser(token);
        return this.redPacketService.updateOpenPrivate(user.getFid(),redPacketId);
    }

    /**
     * 拆红包
     * @param token
     * @param redPacketId
     * @return
     */
    @RequestMapping(value="/open", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel openRedPacket(String token, int redPacketId){
        User user = this.userService.queryUser(token);
        return this.redPacketService.updateOpenRedPacket(user.getFid(),redPacketId);
    }

    /**
     * 查看红包详情
     * @param token
     * @param redPacketId
     * @return
     */
    @RequestMapping(value="/getDetail", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel getRedPacketDetail(String token,int redPacketId){
        try {
            int userid = this.userService.queryUser(token).getFid();
            Map map = new HashMap<>();
            List list = new ArrayList<>();
            RedPacket parent = this.redPacketService.getRedPacketById(redPacketId);
            map.put("userId",parent.getUserid());
            map.put("amount",parent.getAmount());
            map.put("total",parent.getTotal());
            map.put("remarks",parent.getRemarks());
            List<RedPacket> redPackets = this.redPacketService.getRedPacketByParentid(parent.getId());
            User user = this.userService.queryUser(parent.getUserid());
            map.put("nickName",user.getFnickName());
            map.put("headImgUrl",user.getFheadImgUrl());
            Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(parent.getSymbol());
            map.put("unit",fvirtualcointype.getFshortname());
            map.put("myReceiveStatus",1);//未领取
            Double mytotal = null;
            if (CollectionUtils.isEmpty(redPackets)){
                map.put("receiveAmount",0);
                map.put("receiveTotal",0);
            }else {
                Double temp = 0d;
                Map data = null;
                User receiver = null;
                for (RedPacket redPacket : redPackets){
                    data = new HashMap<>();
                    receiver = this.userService.queryUser(redPacket.getUserid());
                    data.put("unit",fvirtualcointype.getFshortname());
                    data.put("nickName",receiver.getFnickName());
                    data.put("headImgUrl",receiver.getFheadImgUrl());
                    data.put("createTime",redPacket.getCreateTime());
                    data.put("total",redPacket.getTotal());
                    temp = MathUtils.add(temp,redPacket.getTotal());
                    list.add(data);
                    if(receiver.getFid() == userid){
                        mytotal = redPacket.getTotal();
                        map.put("myReceiveStatus",2);//已领取
                    }
                }
                map.put("receiveAmount",redPackets.size());
                map.put("receiveTotal",temp);
            }
            map.put("receiveList",list);
            map.put("myTotal",mytotal);
            return ResultModel.ok(map);
        } catch (Exception e) {
            logger.error("查看红包详情失败:"+e);
            e.printStackTrace();
            return ResultModel.build(500,"数据异常");
        }
    }

}
