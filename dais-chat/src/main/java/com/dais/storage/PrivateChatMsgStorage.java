package com.dais.storage;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.JsonUtils;
import com.dais.bean.MsgBean;
import com.dais.model.PrivatechatMsg;
import com.dais.model.User;
import com.dais.service.PrivatechatMsgService;
import com.dais.service.UserService;
import com.dais.utils.DateUtils;
import com.dais.utils.Utils;
import com.dais.websocket.WebSocketPrivateChat;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import javax.websocket.Session;
import java.util.*;
import java.util.concurrent.*;

import static com.dais.websocket.WebSocketPrivateChat.sendMessage;


/**
 * @author xxp
 * @version 2017- 09- 26 19:12
 * @description
 * @copyright www.zhgtrade.com
 */

public class PrivateChatMsgStorage {

    private static Queue<PrivatechatMsg> queues = new ConcurrentLinkedQueue<>();
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
    private static ConcurrentMap<String,Date> timeMap = new ConcurrentHashMap<>();
    @Autowired
    private PrivatechatMsgService privatechatMsgService;
    @Autowired
    private UserService userService;

    public void work(){
        for (int i = 0; i < 8; i++) {
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        PrivatechatMsg privatechatMsg = null;
                        while (true){
                            if((privatechatMsg = queues.poll()) != null){
                                saveMsg(privatechatMsg);
                            }
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void ckeckMsg(String token,String jsonMsg){
        try {
            User user = this.userService.queryUser(token);
            if(user == null){
                sendMessage(token,JsonUtils.objectToJson(ResultModel.build(401,"token无效")));
                return ;
            }
            MsgBean msgBean = JsonUtils.jsonToPojo(jsonMsg,MsgBean.class);
            User user2 = userService.queryUser(msgBean.getTouserId());
            if(user2 == null){
                sendMessage(token,JsonUtils.objectToJson(ResultModel.build(403,"用户不存在")));
                return ;
            }
            PrivatechatMsg privatechatMsg = new PrivatechatMsg();
            privatechatMsg.setId(UUID.randomUUID().toString());
            privatechatMsg.setContent(msgBean.getMsgContent());
            privatechatMsg.setUserId(user.getFid());
            privatechatMsg.setTouserId(msgBean.getTouserId());
            privatechatMsg.setCreateTime(Utils.getTimestamp());
            privatechatMsg.setHeadImg(user2.getFheadImgUrl());
            privatechatMsg.setNickName(user2.getFnickName());
            privatechatMsg.setStatus(1);
            privatechatMsg.setType(1);
            privatechatMsg.setMsgType(msgBean.getType());
            String timeKey = privatechatMsg.getUserId()+"-"+privatechatMsg.getTouserId();
            Date lastTime = timeMap.get(timeKey);
            if(lastTime == null){
                timeKey = privatechatMsg.getTouserId()+"-"+privatechatMsg.getUserId();
                lastTime = timeMap.get(timeKey);
                if(lastTime == null){
                    privatechatMsg.setTimestr(DateUtils.formatDate(privatechatMsg.getCreateTime(),"HH:mm"));
                }
            }
            if(lastTime != null){
                if(DateUtils.getMinute(lastTime,privatechatMsg.getCreateTime()) > 3){
                    privatechatMsg.setTimestr(DateUtils.formatDate(privatechatMsg.getCreateTime(),"HH:mm"));
                }
            }
            timeMap.put(timeKey,privatechatMsg.getCreateTime());
            queues.add(privatechatMsg);
            sendMessage(token,JsonUtils.objectToJson(ResultModel.ok(privatechatMsg)));

            PrivatechatMsg privatechatMsg2 = new PrivatechatMsg();
            privatechatMsg2.setId(UUID.randomUUID().toString());
            privatechatMsg2.setContent(msgBean.getMsgContent());
            privatechatMsg2.setUserId(msgBean.getTouserId());
            privatechatMsg2.setTouserId(user.getFid());
            privatechatMsg2.setCreateTime(Utils.getTimestamp());
            privatechatMsg2.setStatus(1);
            privatechatMsg2.setHeadImg(user.getFheadImgUrl());
            privatechatMsg2.setNickName(user.getFnickName());
            privatechatMsg2.setType(2);
            privatechatMsg2.setMsgType(msgBean.getType());
            privatechatMsg2.setTimestr(privatechatMsg.getTimestr());
            queues.add(privatechatMsg2);

            boolean flag = false;
            int count = 0;
            while (!flag){
                count ++;
                flag = WebSocketPrivateChat.sendMessage(user2.getToken(),JsonUtils.objectToJson(ResultModel.ok(privatechatMsg2)));
                if(!flag && count == 3){//重试三次失败，则记录失败
                    privatechatMsg2.setStatus(2);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendMessage(token,JsonUtils.objectToJson(ResultModel.build(500,"数据异常")));
        }
    }

    private void saveMsg(PrivatechatMsg privatechatMsg){
        try {
            privatechatMsgService.insertMsg(privatechatMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //1正常，2推送失败,3上线推送成功，4上线推送失败
    public void ckeckPushErrorMsg(String token){
        try {
            List<String> tokens = new ArrayList<>();
            tokens.add(token);
            User user = this.userService.queryUser(token);
            List<PrivatechatMsg> privatechatMsgs = this.privatechatMsgService.getPrivatechatMsgByParam(2,user.getFid());
            if(CollectionUtils.isEmpty(privatechatMsgs)){
                return;
            }
            Iterator<PrivatechatMsg> iterator = privatechatMsgs.iterator();
            PrivatechatMsg privatechatMsg = null;
            User user2 = null;
            while (iterator.hasNext()){
                privatechatMsg = iterator.next();
                user2 = this.userService.queryUser(privatechatMsg.getUserId());
                privatechatMsg.setHeadImg(user2.getFheadImgUrl());
                privatechatMsg.setNickName(user2.getFnickName());
                boolean flag = false;
                int count = 0;
                while (!flag){
                    count ++;
                    flag = sendMessage(token,JsonUtils.objectToJson(ResultModel.ok(privatechatMsg)));
                    if(flag){
                        privatechatMsg.setStatus(3);//上线推送成功
                    }
                    if(!flag && count == 3){
                        flag = true;
                        privatechatMsg.setStatus(4);//上线推送失败
                    }
                }
                this.privatechatMsgService.updateMsg(privatechatMsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


