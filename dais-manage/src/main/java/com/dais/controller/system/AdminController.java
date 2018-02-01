package com.dais.controller.system;

import com.common.pojo.ResultModel;
import com.dais.controller.BaseController;
import com.dais.model.SysUser;
import com.dais.service.SystemUserService;
import com.dais.utils.StringUtils;
import com.dais.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author xxp
 * @version 2017- 09- 09 10:01
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
public class AdminController extends BaseController {

    @Autowired
    private SystemUserService systemUserService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndexPage() {
        return "/index";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "/login";
    }

    /**
     * 接收ajax登录请求
     * HttpSession
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel Login(HttpServletRequest request, SysUser user) {
        return systemUserService.doCheckLogin(user, request);
    }

    @RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel updatepassword(String newpassword,String oldpassword,int id) {
        return systemUserService.updatepassword(newpassword,oldpassword,id);
    }


    /**
     * 生成验证码
     *
     * @param request
     * @param
     * @throws IOException
     */
    @RequestMapping(value = "/loginout")
    public String logout(HttpServletRequest request) throws IOException {
        // 生成验证码,放入session中
        HttpSession session = request.getSession();
        Enumeration<String> names = session.getAttributeNames();
        while(names != null && names.hasMoreElements()){
            session.removeAttribute(names.nextElement());
        }
        return "/login";
    }

    @RequestMapping(value = "/system/adminlist",method = RequestMethod.GET)
    public String getAdminPage() {
        return "/system/adminlist";
    }



    @RequestMapping("/system/getAdminlist")
    @ResponseBody
    public ResultModel getAdminList(HttpServletRequest request,int start,int limit,String search) {
        return systemUserService.getAdminList(request,start, limit, search);
    }

    @RequestMapping("/system/save")
    @ResponseBody
    public ResultModel save(@RequestBody SysUser sysUser,HttpServletRequest request) {
        SysUser user = (SysUser)request.getSession().getAttribute("user_info");
        if(user == null){
            return ResultModel.build(500,"数据异常");
        }
        int roleid = user.getRoleid();
        if(roleid > sysUser.getRoleid()){
            return ResultModel.build(402,"权限不足");
        }
        sysUser.setLogintime(Utils.getTimestamp());
        if(StringUtils.isEmpty(user.getName())){
            sysUser.setCreateuser(user.getUsername());
        }else{
            sysUser.setCreateuser(user.getName());
        }
        if(sysUser.getRoleid() == 2){
            sysUser.setRolename("管理员");
        }else{
            sysUser.setRolename("普通用户");
        }
        return systemUserService.save(sysUser);
    }

    @RequestMapping("/system/delete")
    @ResponseBody
    public ResultModel delete(int id) {
        return systemUserService.delete(id);
    }



}
