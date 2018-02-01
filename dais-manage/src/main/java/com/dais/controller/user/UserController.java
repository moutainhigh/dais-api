package com.dais.controller.user;

import com.common.constant.CommonConstant;
import com.common.utils.HashUtil;
import com.dais.controller.BaseController;
import com.common.pojo.ResultModel;
import com.common.utils.ExceptionUtil;
import com.dais.mapper.UserMapper;
import com.dais.model.Fmessage;
import com.dais.model.User;
import com.dais.service.FmessageService;
import com.dais.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GanZhen
 * @version 2017- 03- 07 11:41
 * @description 用户相关的登录注册注销等接口
 * @copyright www.dais.com
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FmessageService fmessageService;

    @RequestMapping("/userlist")
    public String testMethod(){
        return "/user/userlist";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public ResultModel getCoinList(int start,int limit,String search){
        return userService.getUserList(start, limit, search);
    }



    @RequestMapping(value="/auth", method=RequestMethod.POST)
    @ResponseBody
    public ResultModel auth(@RequestBody User user,String errorMsg) {
        try {
            if(user == null){
                return ResultModel.build(500, "请输入需要修改的参数");
            }
            User user2 = this.userService.findByUserId(user.getFid());
            if(user2.getAuthStatus() == 2 && user2.getFidentityStatus() == 2 && user.getAuthStatus() == 2 && user.getFidentityStatus() == 2){
                return ResultModel.build(403, "当前用户已经实名认证完成");
            }
            if(user.getAuthStatus() == 3 || user.getFidentityStatus() == 3){
                fmessageService.insertFmessageByParam(user.getFid(),"实名认证",errorMsg);
            }
            if(user.getAuthStatus() == 2){
                fmessageService.insertFmessageByParam(user.getFid(),"实名认证","恭喜您的实名认证审核通过！");
            }
            if(user.getFidentityStatus() == 2){
                fmessageService.insertFmessageByParam(user.getFid(),"实名认证","恭喜您的手持身份证照片审核通过！");
            }
            user2.setAuthStatus(user.getAuthStatus());
            user2.setFidentityStatus(user.getFidentityStatus());
            return userService.updateUser(user2,user2.getToken());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
    @RequestMapping("/resetPassword")
    @ResponseBody
    public ResultModel resetPassword(int id){
        User user2 = this.userService.findByUserId(id);
        user2.setFloginPassword(HashUtil.encodePassword("123456"));
        return this.userService.updateUser(user2,user2.getToken());
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public ResultModel updateUser(@RequestBody User user){
        User user2 = this.userService.findByUserId(user.getFid());
        user2.setFidentityNo(user.getFidentityNo());
        user2.setFrealName(user.getFrealName());
        user2.setFnickName(user.getFnickName());
        user2.setGagTime(user.getGagTime());
        return this.userService.updateUser(user2,user2.getToken());
    }




    /**
     * 上传头像
     *
     * 不能大于3MB
     *
     * //@param multipartFile@RequestParam(value = "head_img")
     * @return
     */
    @RequestMapping(value = "/upload_head_img")
    @ResponseBody
    public ResultModel uploadHeadImg(String token, MultipartFile head_img) throws IOException {
        return this.userService.commonUploadHeadImg(token, head_img);
    }


    /**
     * 上传手持证件照
     * @param token
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload_auth_img")
    @ResponseBody
    public ResultModel uploadAuthImage(String token, @RequestParam(value = "img") MultipartFile multipartFile) throws IOException {
        return this.userService.commonUploadAuthImg(token, multipartFile);
    }



}
