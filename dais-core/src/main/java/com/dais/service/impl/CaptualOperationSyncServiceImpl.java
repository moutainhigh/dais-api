package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.dais.mapper.CaptualOperationSyncMapper;
import com.dais.model.*;
import com.dais.service.CaptualOperationSyncService;
import com.dais.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author xxp
 * @version 2017- 09- 07 21:12
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class CaptualOperationSyncServiceImpl implements CaptualOperationSyncService {
    private static Logger logger = Logger.getLogger(CaptualOperationSyncServiceImpl.class);

    @Autowired
    private CaptualOperationSyncMapper captualOperationSyncMapper;

    @Autowired
    private UserService userService;

    @Override
    public ResultModel getWithdrawOperationList(int start, int limit, String search,int type) {
        CaptualOperationSyncExample example = new CaptualOperationSyncExample();
        CaptualOperationSyncExample.Criteria criteria = new CaptualOperationSyncExample().createCriteria();
        if(StringUtils.isNotBlank(search)){
            criteria.andOpertionTypeEqualTo(type);
            criteria.andUserNameLike("%"+search+"%");
            example.or(criteria);
            criteria = new CaptualOperationSyncExample().createCriteria();
            criteria.andOpertionTypeEqualTo(type);
            criteria.andWithdrawVirtualAddressLike("%"+search+"%");
            example.or(criteria);
            criteria = new CaptualOperationSyncExample().createCriteria();
            criteria.andOpertionTypeEqualTo(type);
            criteria.andUserPhoneLike("%"+search+"%");
            example.or(criteria);
            criteria = new CaptualOperationSyncExample().createCriteria();
            criteria.andOpertionTypeEqualTo(type);
            criteria.andCoinNameLike("%"+search+"%");
            example.or(criteria);
        }else {
            example.createCriteria().andOpertionTypeEqualTo(type);
        }
        example.setOrderByClause("createtime desc");
        PageHelper.startPage(start, limit);
        List<CaptualOperationSync> paramList = this.captualOperationSyncMapper.selectByExample(example);
        PageInfo<CaptualOperationSync> pageInfo = new PageInfo<>(paramList);
        return ResultModel.build(200, "OK", pageInfo);
    }

    @Override
    public int insert(CaptualOperationSync captualOperationSync) throws Exception{
        return this.captualOperationSyncMapper.insertSelective(captualOperationSync);
    }

    @Override
    public int updateByParam(CaptualOperationSync captualOperationSync) throws Exception{
        CaptualOperationSyncExample example = new CaptualOperationSyncExample();
        example.createCriteria().andOperationIdEqualTo(captualOperationSync.getOperationId());
        List<CaptualOperationSync> list = this.captualOperationSyncMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            captualOperationSync.setId(list.get(0).getId());
            return this.captualOperationSyncMapper.updateByPrimaryKeySelective(captualOperationSync);
        }
        //此处直接更新，如果失败直接抛出异常，让事务回滚
        return -1;
    }
    @Override
    public int insertByParam(Fvirtualcaptualoperation fvirtualcaptualoperation,
                             Fvirtualcointype fvirtualcointype) throws Exception{
        CaptualOperationSync captualOperationSync = null;
        int rows = 0;
        try {
            captualOperationSync = new CaptualOperationSync();
            captualOperationSync.setStatus(fvirtualcaptualoperation.getFstatus());
            captualOperationSync.setOperationId(fvirtualcaptualoperation.getFid());
            captualOperationSync.setWithdrawVirtualAddress(fvirtualcaptualoperation.getWithdrawVirtualAddress());
            captualOperationSync.setAmount(fvirtualcaptualoperation.getFamount());
            captualOperationSync.setFees(fvirtualcaptualoperation.getFfees());
            captualOperationSync.setCreatetime(fvirtualcaptualoperation.getFcreatetime());
            captualOperationSync.setLastUpdatetime(fvirtualcaptualoperation.getFlastupdatetime());
            captualOperationSync.setOpertionType(fvirtualcaptualoperation.getFtype());
            captualOperationSync.setCoinName(fvirtualcointype.getFname());
            captualOperationSync.setSymbol(fvirtualcointype.getFid());
            captualOperationSync.setFtradeuniquenumber(fvirtualcaptualoperation.getFtradeuniquenumber());
            captualOperationSync.setRechargeVirtualAddress(fvirtualcaptualoperation.getRechargeVirtualAddress());
            captualOperationSync.setUserid(fvirtualcaptualoperation.getFusFid2());
            if(StringUtils.isNotEmpty(fvirtualcaptualoperation.getFusFid2()+"")){
                User user = this.userService.findByUserId(fvirtualcaptualoperation.getFusFid2());
                if(user == null){
                    captualOperationSync.setUserName("dais宝充值");
                }else{
                    captualOperationSync.setUserName(user.getFrealName());
                    captualOperationSync.setUserPhone(user.getFtelePhone());
                }

            }
            rows = this.insert(captualOperationSync);
        } catch (Exception e) {
            logger.error("同步充值数据异常:"+e);
        }
        return rows;
    }
}
