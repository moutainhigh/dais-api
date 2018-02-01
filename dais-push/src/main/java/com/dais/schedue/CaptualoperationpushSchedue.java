package com.dais.schedue;

import com.common.utils.CollectionUtils;
import com.common.utils.JsonUtils;
import com.dais.mapper.CaptualoperationpushMapper;
import com.dais.model.*;
import com.dais.push.WebSocketPush;
import com.dais.service.FvirtualcaptualoperationService;
import com.dais.service.UserService;
import com.dais.service.VirtualCoinService;
import com.dais.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.common.utils.MathUtils.convert2;

/**
 * @author xxp
 * @version 2017- 09- 22 14:18
 * @description
 * @copyright www.zhgtrade.com
 */
@Component
public class CaptualoperationpushSchedue {
    private static Logger logger = Logger.getLogger(CaptualoperationpushSchedue.class);

    @Autowired
    private CaptualoperationpushMapper captualoperationpushMapper;
    @Autowired
    private FvirtualcaptualoperationService fvirtualcaptualoperationService;
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private UserService userService;


    public void run(){
        try {
            CaptualoperationpushExample example = new CaptualoperationpushExample();
            CaptualoperationpushExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(1);//状态为1或者2
            List<Captualoperationpush> captualoperationpushes = captualoperationpushMapper.selectByExample(example);
            if(CollectionUtils.isEmpty(captualoperationpushes)) return;
            for (Captualoperationpush captualoperationpush : captualoperationpushes){
                checkAndSendMsg(captualoperationpush);
            }
        } catch (Exception e) {
            logger.error("定时推送充值提现记录异常"+e);
            e.printStackTrace();
        }

    }

    private String getCoinOperation(Fvirtualcaptualoperation fvirtualcaptualoperation) throws Exception{
        Fvirtualcointype fvct = this.virtualCoinService.selectByPrimaryKey(fvirtualcaptualoperation.getFviFid2());
        Map map = new HashMap<>();
        map.put("fid",fvirtualcaptualoperation.getFid());
        map.put("famount",convert2(fvirtualcaptualoperation.getFamount(),8));
        map.put("ftype",fvirtualcaptualoperation.getFtype());
        map.put("fstatus",fvirtualcaptualoperation.getFstatus());
        map.put("fcreatetime",fvirtualcaptualoperation.getFcreatetime());
        map.put("ffees",fvirtualcaptualoperation.getFfees());
        map.put("coinName",fvct.getFshortname());
        map.put("tradeuniquenumber",fvirtualcaptualoperation.getFtradeuniquenumber());
        map.put("blocknumber",fvirtualcaptualoperation.getBlockindex());
        map.put("fconfirmations",fvirtualcaptualoperation.getFconfirmations()+"项确认");
        if(fvirtualcaptualoperation.getFtype() == 1){//此时自己为收款方
            map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvirtualcaptualoperation));
            map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvirtualcaptualoperation));
        }else{
            map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvirtualcaptualoperation));
            map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvirtualcaptualoperation));
        }
        return JsonUtils.objectToJson(map);
    }

    public void checkAndSendMsg(Captualoperationpush captualoperationpush){
        try {
            Fvirtualcaptualoperation fvirtualcaptualoperation = fvirtualcaptualoperationService.selectByPrimaryKey(captualoperationpush.getOperationid());
            if(fvirtualcaptualoperation == null) return;
            User user =  userService.queryUser(fvirtualcaptualoperation.getFusFid2());
            if(user == null) return;
            boolean isSend = true;
            int count = captualoperationpush.getRetryTimes();
            while(isSend){
                count ++;
                boolean flag = WebSocketPush.sendMessage(user.getToken(),getCoinOperation(fvirtualcaptualoperation));
                if(flag){
                    isSend = false;
                    captualoperationpush.setStatus(3);
                }else{
                    if(count >= 3){
                        isSend = false;
                        captualoperationpush.setStatus(2);
                    }
                }
            }
            captualoperationpush.setUpdateTime(Utils.getTimestamp());
            captualoperationpush.setRetryTimes(count);
            this.captualoperationpushMapper.updateByPrimaryKeySelective(captualoperationpush);
        } catch (Exception e) {
            logger.error("推送数据异常:"+e);
            e.printStackTrace();
        }
    }

    public void checkUserMsg(String token){
        try {
            User user =  userService.queryUser(token);
            CaptualoperationpushExample example = new CaptualoperationpushExample();
            CaptualoperationpushExample.Criteria criteria = example.createCriteria();
            if (user == null) return;
            criteria.andUseridEqualTo(user.getFid());
            criteria.andStatusEqualTo(2);//推送失败
            criteria.andRetryTimesEqualTo(3);//推送三次的
            List<Captualoperationpush> captualoperationpushes = captualoperationpushMapper.selectByExample(example);
            if(CollectionUtils.isEmpty(captualoperationpushes)) return;
            for (Captualoperationpush captualoperationpush : captualoperationpushes){
                checkAndSendMsg(captualoperationpush);
            }
        } catch (Exception e) {
            logger.error("推送数据异常:"+e);
            e.printStackTrace();
        }
    }
}
