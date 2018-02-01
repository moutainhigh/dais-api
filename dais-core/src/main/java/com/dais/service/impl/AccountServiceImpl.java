package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.MathUtils;
import com.dais.mapper.AccountMapper;
import com.dais.model.Account;
import com.dais.model.AccountExample;
import com.dais.model.User;
import com.dais.service.AccountOperationService;
import com.dais.service.AccountService;
import com.dais.service.UserService;
import com.dais.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 10- 10 19:00
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountOperationService accountOperationService;

    @Override
    public List getAccount(int userid) {
        AccountExample example = new AccountExample();
        example.createCriteria().andUseridEqualTo(userid);
        return this.accountMapper.selectByExample(example);
    }

    @Override
    public Account getAccount(int userid, int symbol) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andSymbolEqualTo(symbol);
        List<Account> list = this.accountMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public Account getAccountByKey(int id) {
        return this.accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertAccount(Account account) {
        return this.accountMapper.insertSelective(account);
    }

    @Override
    public int updateAccount(Account account) {
        return this.accountMapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public ResultModel updateExchange(double withdrawAmount, String tradePassword, Account account,
                                      String remarks, int touserId) throws Exception {
        try {
            User user = this.userService.findByUserId(touserId);
            if (user == null){
                return ResultModel.build(403,"对方用户不存在");
            }
            //操作用户自身账户
            account.setTotal(MathUtils.subtract(account.getTotal(),withdrawAmount));
            account.setUpdateTime(Utils.getTimestamp());
            this.updateAccount(account);
            this.accountOperationService.save(account.getSymbol(),account.getUserid(),touserId,"转账",remarks,withdrawAmount,0d,2);

            //操作收款方账户
            Account touserAccount = this.getAccount(user.getFid(),account.getSymbol());
            if(touserAccount == null){
                touserAccount = new Account();
                touserAccount.setUserid(user.getFid());
                touserAccount.setSymbol(account.getSymbol());
                touserAccount.setCreateTime(Utils.getTimestamp());
                touserAccount.setUpdateTime(Utils.getTimestamp());
                touserAccount.setTotal(withdrawAmount);
                this.insertAccount(touserAccount);
            }else{
                touserAccount.setTotal(MathUtils.add(touserAccount.getTotal(),withdrawAmount));
                touserAccount.setUpdateTime(Utils.getTimestamp());
                this.updateAccount(touserAccount);
            }
            this.accountOperationService.save(account.getSymbol(),touserId,account.getUserid(),"收款",remarks,withdrawAmount,0d,1);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return ResultModel.ok();
    }
}
