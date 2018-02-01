package com.dais.controller;

import com.common.pojo.ResultModel;
import com.dais.model.User;
import com.dais.service.RongcloudUsertokenService;
import com.dais.service.UserService;
import com.dais.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xxp
 * @version 2017- 09- 25 14:40
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/rongCloud")
public class RongCloudController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private RongcloudUsertokenService rongcloudUsertokenService;
    /**
     * 过滤器验证失败之后的重定向接口
     * @return 响应结果
     */
    @RequestMapping("/relogin")
    @ResponseBody
    public ResultModel reLogin() {
        return ResultModel.build(401, "验证的失败无效的token，请登录");
    }

    /**
     * 根据用户token兑换容云通讯token
     * @param token
     * @return
     */
    @RequestMapping(value="/getRongCloudToken", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel getToken(String token) {
        try {
            User user = userService.queryUser(token);
            String rongCloudToken = rongcloudUsertokenService.getToken(user.getFid());
            if(!StringUtils.isEmpty(rongCloudToken)){
                return ResultModel.ok(rongCloudToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500,"数据异常");
        }
        return ResultModel.build(500,"数据异常");
    }

    /**
     * 根据用户token兑换容云通讯用户信息
     * @param token
     * @return
     */
    @RequestMapping(value="/refreshUserInfo", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel refreshUserInfo(String token) {
        try {
            User user = userService.queryUser(token);
            boolean flag = rongcloudUsertokenService.refreshUserInfo(user.getFid());
            if (flag){
                return ResultModel.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500,"数据异常");
        }
        return ResultModel.build(500,"数据异常");
    }

    /**
     * 根据用户token兑换容云通讯用户信息
     * @param token
     * @return
     */
    @RequestMapping(value="/getNewRongCloudToken", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel getNewToken(String token) {
        try {
            User user = userService.queryUser(token);
            String rongcloudToken = rongcloudUsertokenService.getNewToken(user.getFid());
            if (!StringUtils.isEmpty(rongcloudToken)){
                return ResultModel.ok(rongcloudToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500,"数据异常");
        }
        return ResultModel.build(500,"数据异常");
    }
}
