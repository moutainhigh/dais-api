package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.dais.mapper.CommonMapper;
import com.dais.mapper.PrivatechatMsgMapper;
import com.dais.model.PrivatechatMsg;
import com.dais.model.PrivatechatMsgExample;
import com.dais.service.PrivatechatMsgService;
import com.dais.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxp
 * @version 2017- 09- 27 15:32
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class PrivatechatMsgServiceImpl implements PrivatechatMsgService{

    @Autowired
    private PrivatechatMsgMapper privatechatMsgMapper;
    @Autowired
    private CommonMapper commonMapper;

    @Override
    public PrivatechatMsg insertMsg(PrivatechatMsg privatechatMsg) {
        privatechatMsgMapper.insertSelective(privatechatMsg);
        return privatechatMsg;
    }

    @Override
    public List<Map> getUserChat(int userid) {
        String sql = "SELECT t.userId,t.touserId,t.content,t.msgType,t.create_time as createTime,u.fnick_name as nickName,u.fhead_img_url as headImg from  " +
                " (SELECT * from (SELECT user_id as userId,p.touser_id as touserId,p.create_time,p.content,p.msg_type as msgType from " +
                " privatechat_msg p where p.user_id="+userid+" ORDER BY p.create_time desc) m GROUP BY m.userId,m.touserId ) t," +
                " user u where t.touserId=u.fid ORDER BY t.create_time desc";
        return commonMapper.getList(sql);
    }

    @Override
    public ResultModel getPrivatechatMsg(int userid, int touserid,int start,int limit) {
        PrivatechatMsgExample example = new PrivatechatMsgExample();
        PrivatechatMsgExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid);
        criteria.andTouserIdEqualTo(touserid);
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(start, limit);
        List<PrivatechatMsg> privatechatMsgs = this.privatechatMsgMapper.selectByExampleWithBLOBs(example);
        PageInfo<PrivatechatMsg> pageInfo = new PageInfo<>(privatechatMsgs);
        Map map = new HashMap<>();
        for (int i = 1; i < privatechatMsgs.size(); i++) {
            if(DateUtils.getMinute(privatechatMsgs.get(i).getCreateTime(),privatechatMsgs.get(i-1).getCreateTime()) > 3){
                privatechatMsgs.get(i-1).setTimestr(DateUtils.formatDateTime(privatechatMsgs.get(i-1).getCreateTime()));
            }
        }
        map.put("privatechatMsgs",privatechatMsgs);
        map.put("totalCount",pageInfo.getTotal());
        return ResultModel.ok(map);
    }

    @Override
    public ResultModel deleteMsg(String id) {
       int rows =  this.privatechatMsgMapper.deleteByPrimaryKey(id);
        if (rows > 0){
            return ResultModel.ok();
        }
        return ResultModel.build(500,"数据异常");
    }

    @Override
    public ResultModel deleteMsg(int userid, int touserid) {
        PrivatechatMsgExample example = new PrivatechatMsgExample();
        PrivatechatMsgExample.Criteria criteria = example.createCriteria();
        criteria.andTouserIdEqualTo(touserid);
        criteria.andUserIdEqualTo(userid);
        int rows = this.privatechatMsgMapper.deleteByExample(example);
        if (rows > 0){
            return ResultModel.ok();
        }
        return ResultModel.build(500,"数据异常");
    }

    @Override
    public int updateMsg(PrivatechatMsg privatechatMsg) {
        return this.privatechatMsgMapper.updateByPrimaryKeySelective(privatechatMsg);
    }

    @Override
    public List<PrivatechatMsg> getPrivatechatMsgByParam(int status, int userid) {
        PrivatechatMsgExample example = new PrivatechatMsgExample();
        PrivatechatMsgExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid);
        criteria.andStatusEqualTo(status);
        criteria.andTypeEqualTo(2);
        return this.privatechatMsgMapper.selectByExampleWithBLOBs(example);
    }
}
