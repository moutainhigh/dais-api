package com.dais.controller;

import com.common.pojo.ResultModel;
import com.dais.model.User;
import com.dais.service.GoodfriendRelationshipService;
import com.dais.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author xxp
 * @version 2017- 09- 26 16:58
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
public class GoodFriendController extends BaseController{
    @Autowired
    private GoodfriendRelationshipService goodfriendRelationshipService;
    @Autowired
    private UserService userService;

    @RequestMapping(value="/getGoodFriendList", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel getGoodFriendList(String token){
        try {
            User user = this.userService.queryUser(token);
            List<Map> maps = this.goodfriendRelationshipService.getGoodFriendList(user.getFid());
            return ResultModel.ok(maps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500,"数据异常");
        }
    }

    @RequestMapping(value="/getNewGoodFriendList", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel getNewGoodFriendList(String token){
        try {
            User user = this.userService.queryUser(token);
            List<Map> maps = this.goodfriendRelationshipService.getNewGoodFriendList(user.getFid());
            return ResultModel.ok(maps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500,"数据异常");
        }
    }

    @RequestMapping(value="/addGoodFriend", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel addGoodFriend(String token,int touserId){
        return null;
    }

    @RequestMapping(value="/agreeAddGoodFriend", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel agreeAddGoodFriend(String token,int touserId){
        return null;
    }
    @RequestMapping(value="/deleteGoodFriend", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel deleteGoodFriend(String token,int touserId){
        return null;
    }

    @RequestMapping(value="/addBlack", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel addBlack(String token,int touserId){
        return null;
    }
    @RequestMapping(value="/removeBlack", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel removeBlack(String token,int touserId){
        return null;
    }


}
