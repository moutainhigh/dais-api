package com.dais.controller;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.ConstantKeys;
import com.common.utils.JsonUtils;
import com.dais.model.ChatRoomMsg;
import com.dais.model.User;
import com.dais.service.PrivatechatMsgService;
import com.dais.service.UserService;
import com.dais.utils.DateUtils;
import com.dais.utils.JedisClient;
import com.dais.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xxp
 * @version 2017- 09- 25 14:40
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/chat")
public class ChatController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private PrivatechatMsgService privatechatMsgService;
    /**
     * 过滤器验证失败之后的重定向接口
     * @return 响应结果
     */
    @RequestMapping("/relogin")
    @ResponseBody
    public ResultModel reLogin() {
        return ResultModel.build(401, "验证的失败无效的token，请登录");
    }

    @RequestMapping("/getChatRoomList")
    @ResponseBody
    public ResultModel getChatRoomList(String token) {
        List<ChatRoomMsg> list = new ArrayList<>();
        List<String> strings = jedisClient.lrange(ConstantKeys.CHATROOM_MSG_REDIS_KEY,0,-1);
        if(CollectionUtils.isEmpty(strings)){
            return ResultModel.ok(list);
        }
        ChatRoomMsg chatRoomMsg = null;
        ChatRoomMsg last = JsonUtils.jsonToPojo(strings.get(0),ChatRoomMsg.class);
        for (int i=1; i<strings.size(); i++){
            chatRoomMsg = JsonUtils.jsonToPojo(strings.get(i),ChatRoomMsg.class);
            if(DateUtils.getMinute(chatRoomMsg.getCreatetime(),last.getCreatetime()) > 3){
//                last.setTimestr(DateUtils.formatDateChat(chatRoomMsg.getCreatetime()));
                last.setTimestr(DateUtils.formatDateTime(last.getCreatetime()));
            }
            list.add(last);
            last = chatRoomMsg;
        }
        list.add(last);
        return ResultModel.ok(list);
    }

    @RequestMapping("/getUserChat")
    @ResponseBody
    public ResultModel getUserChat(String token) {
        User user = this.userService.queryUser(token);
        List maps = privatechatMsgService.getUserChat(user.getFid());
        return ResultModel.ok(maps);
    }

    @RequestMapping("/getPrivatechatMsg")
    @ResponseBody
    public ResultModel getPrivatechatMsg(String token,int touserId,int currentPage,int pageSize) {
        User user = this.userService.queryUser(token);
        return this.privatechatMsgService.getPrivatechatMsg(user.getFid(),touserId,currentPage,pageSize);
    }

    @RequestMapping("/deleteMsg")
    @ResponseBody
    public ResultModel deleteMsg(String token,String id) {
        return this.privatechatMsgService.deleteMsg(id);
    }

    @RequestMapping("/deleteMsgAll")
    @ResponseBody
    public ResultModel deleteMsgAll(String token,int touserId) {
        User user = this.userService.queryUser(token);
        return this.privatechatMsgService.deleteMsg(user.getFid(),touserId);
    }




}
