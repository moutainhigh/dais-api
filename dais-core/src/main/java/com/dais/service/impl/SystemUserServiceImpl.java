package com.dais.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.dais.mapper.SysUserMapper;
import com.dais.model.SysUser;
import com.dais.model.SysUserExample;
import com.dais.service.SystemUserService;
import com.dais.utils.IpUtil;
import com.dais.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SystemUserServiceImpl implements SystemUserService {
	protected static Logger logger = LoggerFactory.getLogger(SystemUserServiceImpl.class);


	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser getByAccount(String account) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(account);
		List<SysUser> users = sysUserMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(users)){
			return null;
		}
		return users.get(0);
	}

	@Override
	public ResultModel getAdminList(HttpServletRequest request,int start, int limit, String search) {
		PageInfo<SysUser> pageInfo = null;
		try {
			SysUser user = (SysUser)request.getSession().getAttribute("user_info");
			SysUserExample example = new SysUserExample();
			SysUserExample.Criteria critera = setParam(user);
			if(StringUtils.isNotEmpty(search)){
				search = "%"+search+"%";
				critera.andUsernameLike(search);
				example.or(critera);
				critera = setParam(user);
				critera.andNameLike(search);
				example.or(critera);
				critera = setParam(user);
				critera.andRolenameLike(search);
				example.or(critera);
				critera = setParam(user);
				critera.andCreateuserLike(search);
				example.or(critera);
			}else{
				example.or( setParam(user));
			}
			PageHelper.startPage(start, limit);
			List<SysUser> paramList = sysUserMapper.selectByExample(example);
			pageInfo = new PageInfo<>(paramList);
		} catch (Exception e) {
			logger.error("获取管理员用户信息失败"+e);
			return ResultModel.build(500,"获取管理员用户信息失败" );
		}
		return ResultModel.build(200, "OK", pageInfo);
	}

	private SysUserExample.Criteria setParam(SysUser user){
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		if(user != null){
			int roleid = user.getRoleid();
			if(user.getId() != 1){
				criteria.andIdNotEqualTo(1);
			}
			if(roleid == 1){
				criteria.andIdNotEqualTo(user.getId());
			}else if(roleid == 2){
				criteria.andRoleidGreaterThan(roleid);
			}else{
				criteria.andRoleidGreaterThanOrEqualTo(roleid);
			}
		}
		return criteria;
	}



	@Override
	public ResultModel doCheckLogin(SysUser user, HttpServletRequest request) {
		SysUser sysUser = getByAccount( user.getUsername());
		try {
			if(sysUser == null){
				return ResultModel.build(403,"用户名不存在");
			}
			if(!Utils.MD5(user.getPassword()).equals(sysUser.getPassword())){
				return ResultModel.build(403,"密码错误");
			}
		} catch (Exception e) {
			return ResultModel.build(500,"系统异常");
		}
		sysUser.setIp(IpUtil.getIp(request));
		sysUser.setLogintime(new Date());
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
		HttpSession session = request.getSession();
		session.setAttribute("user_info",sysUser);
		session.setMaxInactiveInterval(30 * 60);
		return ResultModel.ok();
	}

	@Override
	 public  ResultModel updatepassword(String newpassword,String oldpassword,int id){
		SysUser user = this.sysUserMapper.selectByPrimaryKey(id);
		if(user == null){
			return ResultModel.build(500,"数据异常");
		}
		if(!Utils.MD5(oldpassword).equals(user.getPassword())){
			return ResultModel.build(403,"原始密码错误");
		}
		user.setPassword(Utils.MD5(newpassword));
		int rows = this.sysUserMapper.updateByPrimaryKey(user);
		if(rows > 0){
			return ResultModel.ok();
		}else{
			return ResultModel.build(500,"数据异常");
		}
	 }

	@Override
	public ResultModel save(SysUser sysUser) {
		if(sysUser == null){
			return ResultModel.build(500,"数据异常");
		}
		int rows = 0;
		if(sysUser.getId() == null){
			if(getByAccount(sysUser.getUsername()) != null){
				return ResultModel.build(403,"该登录名已存在");
			}
			rows = this.sysUserMapper.insert(sysUser);
		}else{
			rows = this.sysUserMapper.updateByPrimaryKeySelective(sysUser);
		}
		if(rows > 0){
			return ResultModel.ok();
		}
		return ResultModel.build(500,"数据异常");
	}

	@Override
	public ResultModel delete(int id) {
		int rows = sysUserMapper.deleteByPrimaryKey(id);
		if(rows > 0){
			return ResultModel.ok();
		}
		return ResultModel.build(500,"数据异常");
	}
}
