package com.dais.storage;

import com.common.pojo.ResultModel;
import com.common.utils.ConstantKeys;
import com.common.utils.JsonUtils;
import com.common.utils.SpringContextUtils;
import com.common.utils.Utils;
import com.dais.bean.MsgBean;
import com.dais.mapper.ChatRoomMsgMapper;
import com.dais.model.ChatRoomMsg;
import com.dais.model.User;
import com.dais.service.UserService;
import com.dais.utils.DateUtils;
import com.dais.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author xxp
 * @version 2017- 09- 26 19:12
 * @description
 * @copyright www.zhgtrade.com
 */
public class ChatRoomMsgStorage {

    private static Queue<ChatRoomMsg> queues = new ConcurrentLinkedQueue<>();
    private static int counter = 0;
    private static Date lastTime = null;
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private  ChatRoomMsgMapper chatRoomMsgMapper;

    public void work(){
        for (int i = 0; i < 8; i++) {
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        ChatRoomMsg chatRoomMsg = null;
                        while (true){
                            if((chatRoomMsg = queues.poll()) != null){
                                saveMsg(chatRoomMsg);
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

    public static ResultModel ckeckMsg(String token,String msg){
        MsgBean msgBean = JsonUtils.jsonToPojo(msg,MsgBean.class);
        ChatRoomMsg chatRoomMsg = new ChatRoomMsg();
        User user = SpringContextUtils.getBean(UserService.class).queryUser(token);
        if(user == null){
            return ResultModel.build(401,"token无效");
        }
        Date date = user.getGagTime();
        if(date != null && date.getTime() > Utils.getTimeLong()){
            return ResultModel.build(444,"您已被系统禁言，请稍后再试");
        }
        chatRoomMsg.setContent(msgBean.getMsgContent());
        chatRoomMsg.setUserid(user.getFid());
        chatRoomMsg.setCreatetime(Utils.getTimestamp());
        chatRoomMsg.setNickname(user.getFnickName());
        chatRoomMsg.setHeadimg(user.getFheadImgUrl());
        chatRoomMsg.setMsgType(msgBean.getType());
        if(lastTime == null || DateUtils.getMinute(lastTime,chatRoomMsg.getCreatetime()) > 3){
            chatRoomMsg.setTimestr(DateUtils.formatDate(chatRoomMsg.getCreatetime(),"HH:mm"));
        }
        queues.add(chatRoomMsg);
        lastTime = chatRoomMsg.getCreatetime();
        return ResultModel.ok(chatRoomMsg);
    }

    private void saveMsg(ChatRoomMsg chatRoomMsg){
        chatRoomMsg.setTimestr(null);
        chatRoomMsgMapper.insertSelective(chatRoomMsg);

        jedisClient.lpush(ConstantKeys.CHATROOM_MSG_REDIS_KEY, JsonUtils.objectToJson(chatRoomMsg));
        counter ++;
        if(counter > 100){
            jedisClient.ltrim(ConstantKeys.CHATROOM_MSG_REDIS_KEY,0,1000);
            counter = 0;
        }
    }

}


