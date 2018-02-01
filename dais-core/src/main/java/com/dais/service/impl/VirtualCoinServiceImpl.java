package com.dais.service.impl;

import com.common.Enum.VirtualCapitalOperationOutStatusEnum;
import com.common.Enum.VirtualCapitalOperationTypeEnum;
import com.common.pojo.ResultModel;
import com.common.utils.ConstantKeys;
import com.common.utils.MathUtils;
import com.dais.mapper.*;
import com.dais.model.*;
import com.dais.service.*;
import com.dais.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : xxp
 * Date： 2017/8/10
 */
@Service
public class VirtualCoinServiceImpl implements VirtualCoinService{

    @Autowired
    private FvirtualcointypeMapper fvirtualcointypeMapper;
    @Autowired
    private FvirtualwalletMapper fvirtualwalletMapper;
    @Autowired
    private FeesMapper feesMapper;
    @Autowired
    private FvirtualcaptualoperationMapper fvirtualcaptualoperationMapper;
    @Autowired
    private FmessageMapper fmessageMapper;
    @Autowired
    private CaptualOperationSyncService captualOperationSyncService;
    @Autowired
    private CommonParamsService commonParamsService;
    @Autowired
    private AutoWithdrawAuthMapper autoWithdrawAuthMapper;
    @Autowired
    private FvirtualwalletService fvirtualwalletService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountOperationService accountOperationService;

    @Override
    public List<Fvirtualcointype> findFvirtualCoinTypeByStatus(Integer status) {
        FvirtualcointypeExample example = new FvirtualcointypeExample();
        FvirtualcointypeExample.Criteria criteria = example.createCriteria();
        criteria.andFstatusEqualTo(status);
        return this.selectByExample(example);
    }

    @Override
    public int updateVirtualCoinByExample(Fvirtualcointype fvc,FvirtualcointypeExample example) {
        return fvirtualcointypeMapper.updateByExampleSelective(fvc,example);
    }

    @Override
    public Fvirtualcointype selectByPrimaryKey(Integer fid) {
        return fvirtualcointypeMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Fvirtualcointype> selectByExample(FvirtualcointypeExample example) {
        return fvirtualcointypeMapper.selectByExample(example);
    }

    @Override
    public ResultModel getParams(int start, int limit, String search) {
        FvirtualcointypeExample example = new FvirtualcointypeExample();
        FvirtualcointypeExample.Criteria criteria2 = new FvirtualcointypeExample().createCriteria();
        if(StringUtils.isNotBlank(search)){
            criteria2.andFnameLike("%"+search+"%");
            example.or(criteria2);
            criteria2 = new FvirtualcointypeExample().createCriteria();
            criteria2.andFshortnameLike("%"+search+"%");
            example.or(criteria2);
        }
        PageHelper.startPage(start, limit);
        List<Fvirtualcointype> list = fvirtualcointypeMapper.selectByExample(example);
        PageInfo<Fvirtualcointype> pageInfo = new PageInfo<>(list);
        return ResultModel.build(200, "OK", pageInfo);
    }


    /**
     * 提现
     * @param fvirtualaddressWithdraw
     * @param fvirtualcointype
     * @param fvirtualwallet
     * @param withdrawAmount
     * @param userId
     * @return
     */
    @Override
    public ResultModel updateWithdrawBtc(String fvirtualaddressWithdraw,
                                 Fvirtualcointype fvirtualcointype,
                                 Fvirtualwallet fvirtualwallet ,
                                 double withdrawAmount,
                                 Integer userId,String remarks,
                                 String userAddress,Double fees,boolean flag){
        try {
            FeesExample feesExample = new FeesExample();
            feesExample.createCriteria().andSymbolEqualTo(fvirtualcointype.getFid());
            double feeRate = this.feesMapper.selectByExample(feesExample).get(0).getMinfees();
            if(fees >= feeRate){
                feeRate = fees;
            }
            double balanceTotal = 0;
            double frozen = 0;
            //以太坊代币
            if(fvirtualcointype.getFid() !=4 && fvirtualcointype.getParentid() == 4){
                //查询用户以太坊钱包并且更新余额
                Fvirtualwallet fvirtualwallet2 = fvirtualwalletService.selectFvirtualwallet(userId,fvirtualcointype.getParentid());
                if(fvirtualwallet2.getFtotal() < feeRate){
                    return ResultModel.build(403,"ether余额不足");
                }
                fvirtualwallet2.setFtotal(fvirtualwallet2.getFtotal()-feeRate);
                fvirtualwallet2.setFfrozen(fvirtualwallet2.getFfrozen()+feeRate) ;
                fvirtualwallet2.setFlastupdatetime(Utils.getTimestamp());
                this.fvirtualwalletMapper.updateByPrimaryKeySelective(fvirtualwallet2);

                balanceTotal = MathUtils.subtract(fvirtualwallet.getFtotal(),withdrawAmount);
                frozen = MathUtils.add(fvirtualwallet.getFfrozen(),withdrawAmount);
            }else{
                double temp = MathUtils.add(withdrawAmount,feeRate);
                balanceTotal = MathUtils.subtract(fvirtualwallet.getFtotal(),temp);
                frozen = MathUtils.add(fvirtualwallet.getFfrozen(),temp);
            }
            if(balanceTotal < 0){
                return ResultModel.build(403,"余额不足");
            }
            fvirtualwallet.setFtotal(balanceTotal);
            fvirtualwallet.setFfrozen(frozen) ;
            fvirtualwallet.setFlastupdatetime(Utils.getTimestamp());
            this.fvirtualwalletMapper.updateByPrimaryKeySelective(fvirtualwallet);

            Fvirtualcaptualoperation fvirtualcaptualoperation = new Fvirtualcaptualoperation() ;
            fvirtualcaptualoperation.setFamount(withdrawAmount) ;
            fvirtualcaptualoperation.setFcreatetime(new Date());
            fvirtualcaptualoperation.setFfees(feeRate) ;
            fvirtualcaptualoperation.setFlastupdatetime(Utils.getTimestamp());
            fvirtualcaptualoperation.setFstatus(VirtualCapitalOperationOutStatusEnum.WaitForOperation) ;
            fvirtualcaptualoperation.setFtype(VirtualCapitalOperationTypeEnum.COIN_OUT) ;
            fvirtualcaptualoperation.setFusFid2(userId);
            fvirtualcaptualoperation.setFviFid2(fvirtualcointype.getFid());
            fvirtualcaptualoperation.setWithdrawVirtualAddress(fvirtualaddressWithdraw);
            fvirtualcaptualoperation.setRechargeVirtualAddress(userAddress);
            fvirtualcaptualoperation.setIsSystemAccount(flag);
            int rows = this.fvirtualcaptualoperationMapper.insertSelective(fvirtualcaptualoperation) ;
//            int rows2 = this.addTradeRemark(fvirtualcaptualoperation.getFid()+"",remarks);
            int rows3 = this.captualOperationSyncService.insertByParam(fvirtualcaptualoperation,fvirtualcointype);
            if(!(rows >0 && rows3 >0)){
                return ResultModel.build(500,"数据异常");
            }
            //判断是否需要自动审核提现
            if("2".equals(this.commonParamsService.getValue(ConstantKeys.WITHDRAW_AUTH_TYPE))){
                AutoWithdrawAuth autoWithdrawAuth = new AutoWithdrawAuth();
                autoWithdrawAuth.setWithdrawOprationId(fvirtualcaptualoperation.getFid());
                autoWithdrawAuth.setStatus(1);//等待审核
                autoWithdrawAuth.setSymbol(fvirtualcaptualoperation.getFviFid2());
                int rows4 = autoWithdrawAuthMapper.insertSelective(autoWithdrawAuth);
                if(rows4 < 1){
                    return ResultModel.build(500,"数据异常");
                }
            }
            return ResultModel.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    /**
     * 账户余额提现
     * @param fvirtualaddressWithdraw
     * @param fvirtualcointype
     * @param account
     * @param withdrawAmount
     * @param userId
     * @return
     */
    @Override
    public ResultModel updateWithdraw(String fvirtualaddressWithdraw,
                                         Fvirtualcointype fvirtualcointype,
                                         Account account,
                                         double withdrawAmount,
                                         Integer userId,String remarks,String userAddress,Double fees){
        try {
            FeesExample feesExample = new FeesExample();
            feesExample.createCriteria().andSymbolEqualTo(fvirtualcointype.getFid());
            double feeRate = this.feesMapper.selectByExample(feesExample).get(0).getMinfees();
            if(fees >= feeRate){
                feeRate = fees;
            }
            double balanceTotal = 0;
            //以太坊代币
            int symbol = fvirtualcointype.getParentid();
            if(fvirtualcointype.getFid() !=4 && symbol == 4){
                //查询用户以太坊钱包并且更新余额
                Account ethAccount = accountService.getAccount(userId,symbol);
                if(ethAccount.getTotal().compareTo(Double.valueOf(feeRate)) == -1){
                    return ResultModel.build(403,"ether账户余额不足");
                }
                ethAccount.setTotal(MathUtils.subtract(ethAccount.getTotal(),feeRate));
                ethAccount.setUpdateTime(Utils.getTimestamp());
                this.accountService.updateAccount(ethAccount);
                this.accountOperationService.save(symbol,userId,0,"ether手续费","ether手续费",feeRate,0d,2);
                balanceTotal = MathUtils.subtract(account.getTotal(),withdrawAmount);
            }else{
                double temp = MathUtils.add(withdrawAmount,feeRate);
                balanceTotal = MathUtils.subtract(account.getTotal(),temp);
            }
            if(balanceTotal < 0){
                return ResultModel.build(403,"余额不足");
            }
            account.setTotal(balanceTotal);
            account.setUpdateTime(Utils.getTimestamp());
            this.accountService.updateAccount(account);
            this.accountOperationService.save(symbol,userId,0,"提现",remarks,withdrawAmount,feeRate,2);

            Fvirtualcaptualoperation fvirtualcaptualoperation = new Fvirtualcaptualoperation();
            fvirtualcaptualoperation.setFamount(withdrawAmount) ;
            fvirtualcaptualoperation.setFcreatetime(Utils.getTimestamp());
            fvirtualcaptualoperation.setFfees(feeRate) ;
            fvirtualcaptualoperation.setFlastupdatetime(Utils.getTimestamp());
            fvirtualcaptualoperation.setFstatus(VirtualCapitalOperationOutStatusEnum.WaitForOperation) ;
            fvirtualcaptualoperation.setFtype(VirtualCapitalOperationTypeEnum.COIN_OUT) ;
            fvirtualcaptualoperation.setFusFid2(0);//系统账户提现时，在app端无需给用户展示该记录，后续充值任务会记录
            fvirtualcaptualoperation.setFviFid2(fvirtualcointype.getFid());
            fvirtualcaptualoperation.setWithdrawVirtualAddress(fvirtualaddressWithdraw);
            fvirtualcaptualoperation.setRechargeVirtualAddress(userAddress);
            fvirtualcaptualoperation.setIsSystemAccount(true);
            int rows = this.fvirtualcaptualoperationMapper.insertSelective(fvirtualcaptualoperation) ;
            int rows2 = this.addTradeRemark(fvirtualcaptualoperation.getFid()+"",remarks);
            fvirtualcaptualoperation.setFusFid2(userId);
            int rows3 = this.captualOperationSyncService.insertByParam(fvirtualcaptualoperation,fvirtualcointype);
            if(!(rows >0 && rows2 >0 && rows3 >0)){
                return ResultModel.build(500,"数据异常");
            }
            //判断是否需要自动审核提现
            if("2".equals(this.commonParamsService.getValue(ConstantKeys.WITHDRAW_AUTH_TYPE))){
                AutoWithdrawAuth autoWithdrawAuth = new AutoWithdrawAuth();
                autoWithdrawAuth.setWithdrawOprationId(fvirtualcaptualoperation.getFid());
                autoWithdrawAuth.setStatus(1);//等待审核
                autoWithdrawAuth.setSymbol(fvirtualcaptualoperation.getFviFid2());
                int rows4 = autoWithdrawAuthMapper.insertSelective(autoWithdrawAuth);
                if(rows4 < 1){
                    return ResultModel.build(500,"数据异常");
                }
            }
            return ResultModel.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int addTradeRemark(String operationid,String remark){
        Fmessage fmessage = new Fmessage();
        fmessage.setOperationid(operationid);
        fmessage.setFcreatetime(Utils.getTimestamp());
        fmessage.setFcontent(remark);
        return this.fmessageMapper.insert(fmessage);
    }

}
