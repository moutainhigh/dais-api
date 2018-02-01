package com.dais.service;

import javax.servlet.http.HttpServletRequest;

import com.common.pojo.ResultModel;
import com.dais.model.SysUser;


public interface SystemUserService {

	SysUser getByAccount(String account);

	ResultModel getAdminList(HttpServletRequest request,int start,int limit,String search);

	ResultModel doCheckLogin(SysUser user, HttpServletRequest request);

	ResultModel updatepassword(String newpassword,String oldpassword,int id);

	ResultModel save(SysUser sysUser);
	ResultModel delete(int id);

}
