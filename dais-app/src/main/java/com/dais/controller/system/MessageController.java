package com.dais.controller.system;

import com.common.pojo.ResultModel;
import com.dais.controller.BaseController;
import com.dais.model.Fmessage;
import com.dais.model.User;
import com.dais.service.FmessageService;
import com.dais.service.UserService;
import com.dais.task.CoinTradeRankTask2;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxp
 * @version 2017- 08- 21 16:25
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    @Autowired
    private FmessageService fmessageService;

    @Autowired
    private UserService userService;

    @RequestMapping("listMessage")
    @ResponseBody
    public ResultModel getMessageList(String token,int pageSize,int pageNo){
        User user = userService.queryUser(token);
        List<Fmessage> list = this.fmessageService.getFmessageByReceiverid(user.getFid(),pageSize,pageNo);
        PageInfo<Fmessage> pageInfo = new PageInfo<>(list);
        Map dataMap = new HashMap<>();
        dataMap.put("totalCount",pageInfo.getTotal());
        dataMap.put("messageList",list);
        return ResultModel.ok(dataMap);
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultModel deleteMessage(String token,int fid){
        int count = this.fmessageService.deleteFmessage(fid);
        if(count > 0){
            return ResultModel.ok();
        }else{
            return ResultModel.build(500,"数据异常");
        }
    }

}
