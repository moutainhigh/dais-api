package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.dais.mapper.GoodfriendRelationshipMapper;
import com.dais.model.GoodfriendRelationship;
import com.dais.model.GoodfriendRelationshipExample;
import com.dais.service.GoodfriendRelationshipService;
import com.dais.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xpp
 * @version 2017- 09- 26 10:43
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class GoodfriendRelationshipServiceImpl implements GoodfriendRelationshipService{

    @Autowired
    private GoodfriendRelationshipMapper goodfriendRelationshipMapper;

    @Override
    public List<Map> getGoodFriendList(int userid) {
        String sql = "SELECT t.* from (SELECT gr.touser_id as touserId,gr.user_id as userId,gr.status,gr.create_time as createTime," +
                "gr.update_time as updateTime ,u.fnick_name as nickName,u.freal_name as realName,u.flogin_name as loginName" +
                " from goodfriend_relationship gr ,user u where gr.touser_id=u.fid and gr.status=1 and and gr.user_id=" +userid+
                ") t order by t.nickName ";
        return this.goodfriendRelationshipMapper.getGoodFriendList(sql);
    }

    @Override
    public List<Map> getNewGoodFriendList(int userid) {
        String sql = "SELECT ee.*,u.fhead_img_url as headImg,u.fnick_name as nickName,u.freal_name as realName,u.flogin_name as loginName from  " +
                " (SELECT DISTINCT(e.touser_id) as touserId,e.user_id as userId,e.status,e.create_time as createTime,e.update_time as updateTime  from " +
                " (SELECT gr.* from goodfriend_relationship gr  where  gr.user_id="+userid+" and gr.status<=3 UNION ALL " +
                " SELECT gr.id, gr.touser_id as user_id,gr.user_id as touser_id,gr.status,gr.create_time,gr.update_time " +
                " from goodfriend_relationship gr  where gr.touser_id="+userid+" and gr.status<=3)" +
                " e GROUP BY e.touser_id) ee,user u where ee.touserId=u.fid ";
        return this.goodfriendRelationshipMapper.getGoodFriendList(sql);
    }

    @Override
    public ResultModel addGoodFriend(int userid, int toUserid) throws Exception{
        //1正常，2已删除
        GoodfriendRelationshipExample example = new GoodfriendRelationshipExample();
        GoodfriendRelationshipExample.Criteria criteria = example.createCriteria();
        criteria.andTouserIdEqualTo(toUserid);
        criteria.andUserIdEqualTo(userid);
        List<GoodfriendRelationship> goodfriendRelationships = this.goodfriendRelationshipMapper.selectByExample(example);
        int count  = 0;
        if(CollectionUtils.isEmpty(goodfriendRelationships)){
            GoodfriendRelationship goodfriendRelationship = new GoodfriendRelationship();
            goodfriendRelationship.setStatus(1);
            goodfriendRelationship.setUserId(userid);
            goodfriendRelationship.setTouserId(toUserid);
            goodfriendRelationship.setCreateTime(Utils.getTimestamp());
            count = this.goodfriendRelationshipMapper.insertSelective(goodfriendRelationship);
            if(count > 0){
                return ResultModel.ok();
            }
            return ResultModel.build(500,"数据异常");
        }

        GoodfriendRelationship goodfriendRelationship = goodfriendRelationships.get(0);
        int status = goodfriendRelationship.getStatus();
        if(status == 1 || status == 3){
            return ResultModel.ok();
        }else if(status == 2 || status == 5){
            goodfriendRelationship.setUpdateTime(Utils.getTimestamp());
            goodfriendRelationship.setStatus(1);
            count = this.goodfriendRelationshipMapper.updateByPrimaryKeySelective(goodfriendRelationship);
            if (count >0) {
                return ResultModel.ok();
            }
        }else if(status == 4){
            return ResultModel.build(403,"请先到黑名单移除该用户");
        }
        return ResultModel.build(500,"数据异常");
    }

    @Override
    public ResultModel agreeAddGoodFriend(int userid, int toUserid) throws Exception {
        //1已发送，2已拒绝，3正常，4黑名单，5已删除
        GoodfriendRelationshipExample example = new GoodfriendRelationshipExample();
        GoodfriendRelationshipExample.Criteria criteria = example.createCriteria();
        /**先给对方更新状态*/
        criteria.andTouserIdEqualTo(userid);
        criteria.andUserIdEqualTo(toUserid);
        List<GoodfriendRelationship> toGoodfriendRelationships = this.goodfriendRelationshipMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(toGoodfriendRelationships)){
            return ResultModel.build(500,"数据异常");
        }
        GoodfriendRelationship toGoodfriendRelationship = toGoodfriendRelationships.get(0);
        toGoodfriendRelationship.setStatus(3);
        toGoodfriendRelationship.setUpdateTime(Utils.getTimestamp());
        int toCount = this.goodfriendRelationshipMapper.updateByPrimaryKeySelective(toGoodfriendRelationship);

        criteria = example.createCriteria();
        criteria.andTouserIdEqualTo(toUserid);
        criteria.andUserIdEqualTo(userid);
        List<GoodfriendRelationship> goodfriendRelationships = this.goodfriendRelationshipMapper.selectByExample(example);
        int count  = 0;
        if(CollectionUtils.isEmpty(goodfriendRelationships)){
            GoodfriendRelationship goodfriendRelationship = new GoodfriendRelationship();
            goodfriendRelationship.setStatus(3);
            goodfriendRelationship.setUserId(userid);
            goodfriendRelationship.setTouserId(toUserid);
            goodfriendRelationship.setCreateTime(Utils.getTimestamp());
            count = this.goodfriendRelationshipMapper.insertSelective(goodfriendRelationship);
        }else {
            GoodfriendRelationship goodfriendRelationship = goodfriendRelationships.get(0);
            goodfriendRelationship.setUpdateTime(Utils.getTimestamp());
            goodfriendRelationship.setStatus(3);
            count = this.goodfriendRelationshipMapper.updateByPrimaryKeySelective(goodfriendRelationship);
        }
        if(count >0  && toCount >0){
            return ResultModel.ok();
        }
        return ResultModel.build(500,"数据异常");
    }


    @Override
    public ResultModel deleteGoodFriend(int userid, int toUserid) throws Exception{
        GoodfriendRelationshipExample example = new GoodfriendRelationshipExample();
        GoodfriendRelationshipExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(toUserid);
        criteria.andUserIdEqualTo(userid);
        List<GoodfriendRelationship> goodfriendRelationships = this.goodfriendRelationshipMapper.selectByExample(example);
        int count = 0;
        if (CollectionUtils.isEmpty(goodfriendRelationships)){
            GoodfriendRelationship goodfriendRelationship = new GoodfriendRelationship();
            goodfriendRelationship.setStatus(1);
            goodfriendRelationship.setUserId(userid);
            goodfriendRelationship.setTouserId(toUserid);
            goodfriendRelationship.setCreateTime(Utils.getTimestamp());
            count = this.goodfriendRelationshipMapper.insertSelective(goodfriendRelationship);
            if(count > 0){
                return ResultModel.ok();
            }
        }else{
            GoodfriendRelationship goodfriendRelationship = goodfriendRelationships.get(0);
            goodfriendRelationship.setStatus(4);
            goodfriendRelationship.setUpdateTime(Utils.getTimestamp());
            count = this.goodfriendRelationshipMapper.updateByPrimaryKeySelective(goodfriendRelationship);
            if (count > 0){
                return ResultModel.ok();
            }
        }
        return ResultModel.build(500,"数据异常");
    }

    @Override
    public ResultModel addBlack(int userid, int toUserid) throws Exception{
        GoodfriendRelationshipExample example = new GoodfriendRelationshipExample();
        GoodfriendRelationshipExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(toUserid);
        criteria.andUserIdEqualTo(userid);
        List<GoodfriendRelationship> goodfriendRelationships = this.goodfriendRelationshipMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(goodfriendRelationships)){
            return  ResultModel.build(403,"非好友关系，无需加入黑名单");
        }
        GoodfriendRelationship goodfriendRelationship = goodfriendRelationships.get(0);
        if(goodfriendRelationship.getStatus() != 3 && goodfriendRelationship.getStatus() != 4){
            return  ResultModel.build(403,"非好友关系，无需删除");
        }
        goodfriendRelationship.setStatus(5);
        goodfriendRelationship.setUpdateTime(Utils.getTimestamp());
        int count = this.goodfriendRelationshipMapper.updateByPrimaryKeySelective(goodfriendRelationship);
        if (count > 0){
            return ResultModel.ok();
        }
        return ResultModel.build(500,"数据异常");
    }

    @Override
    public ResultModel removeBlack(int userid, int toUserid)throws Exception {
        GoodfriendRelationshipExample example = new GoodfriendRelationshipExample();
        GoodfriendRelationshipExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(toUserid);
        criteria.andUserIdEqualTo(userid);
        criteria.andStatusEqualTo(4);
        List<GoodfriendRelationship> goodfriendRelationships = this.goodfriendRelationshipMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(goodfriendRelationships)){
            return  ResultModel.build(403,"非黑名单用户，无需移除");
        }
        GoodfriendRelationship goodfriendRelationship = goodfriendRelationships.get(0);
        goodfriendRelationship.setUpdateTime(Utils.getTimestamp());
        goodfriendRelationship.setStatus(4);
        int count = this.goodfriendRelationshipMapper.updateByPrimaryKeySelective(goodfriendRelationship);
        if(count > 0){
            return  ResultModel.ok();
        }
        return  ResultModel.build(500,"数据异常");
    }
}
