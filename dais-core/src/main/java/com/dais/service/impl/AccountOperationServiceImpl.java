package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.dais.mapper.AccountOperationMapper;
import com.dais.model.*;
import com.dais.service.AccountOperationService;
import com.dais.service.VirtualCoinService;
import com.dais.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author xxp
 * @version 2017- 10- 12 10:40
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class AccountOperationServiceImpl implements AccountOperationService{

    @Autowired
    private AccountOperationMapper accountOperationMapper;
    @Autowired
    private VirtualCoinService virtualCoinService;

    @Override
    public int insert(AccountOperation accountOperation) {
        return this.accountOperationMapper.insertSelective(accountOperation);
    }

    @Override
    public int save(int symbol,int userid,int touserId,String title,
                    String remarks,Double withdrawAmount,double fees,int type){
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setSymbol(symbol);
        accountOperation.setAmount(withdrawAmount);
        accountOperation.setStatus(3);
        accountOperation.setFees(fees);
        accountOperation.setRemarks(remarks);
        accountOperation.setIshomeshow(true);
        accountOperation.setCreatetime(Utils.getTimestamp());
        accountOperation.setUserid(userid);
        accountOperation.setTouserid(touserId);
        accountOperation.setType(type);
        accountOperation.setTitle(title);
        return this.insert(accountOperation);
    }

    @Override
    public ResultModel getAccountOperation(int userid,int start,int limit) throws Exception{
        Map map = new HashMap<>();
        List accountList = new ArrayList<>();
        AccountOperationExample example = new AccountOperationExample();
        example.createCriteria().andUseridEqualTo(userid);
        example.setOrderByClause(" createtime desc");
        PageHelper.startPage(start, limit);
        List<AccountOperation> accountOperations = this.accountOperationMapper.selectByExample(example);
        PageInfo<AccountOperation> pageInfo = new PageInfo<>(accountOperations);
        map.put("totalCount",pageInfo.getTotal());
        for (AccountOperation accountOperation : accountOperations ) {
            Map data = new HashMap<>();
            data.put("id",accountOperation.getId());
            data.put("amount",accountOperation.getAmount());
            data.put("type",accountOperation.getType());
            data.put("createtime",accountOperation.getCreatetime());
            data.put("title",accountOperation.getTitle());
            Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(accountOperation.getSymbol());
            data.put("shortname",fvirtualcointype.getFshortname());
            accountList.add(data);
        }
        map.put("accountList",accountList);
        return ResultModel.ok(map);
    }

}
