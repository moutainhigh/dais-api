package com.dais.controller.account;

import com.common.constant.CommonConstant;
import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.HashUtil;
import com.common.utils.MathUtils;
import com.dais.model.*;
import com.dais.service.*;
import com.common.Enum.VirtualCoinTypeStatusEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : xxp
 * Date： 2017/4/26
 */
@Controller
@RequestMapping("/account")
public class AccountCoinController {
    private static Logger logger = Logger.getLogger(AccountCoinController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private FvirtualaddressService fvirtualaddressService;
    @Autowired
    private FvirtualwalletService fvirtualwalletService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PublicBlockAccountService publicBlockAccountService;
    @Autowired
    private AccountOperationService accountOperationService;



    @ResponseBody
    @RequestMapping(value = "/getAccount", method = RequestMethod.POST)
    public ResultModel getAccount(int symbol,String token) {
        try {
            Map map = new HashMap<>();
            User user = userService.queryUser(token);
            Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(symbol);
            if (fvirtualcointype == null){
                return ResultModel.build(403,"没有该币种");
            }
            map.put("symbol",fvirtualcointype.getFid());
            map.put("shortname",fvirtualcointype.getFshortname());
            map.put("url",fvirtualcointype.getFurl());
            Account account = this.accountService.getAccount(user.getFid(),symbol);
            if(account != null){
                map.put("total",account.getTotal());
            }else{
                map.put("total",0);
            }
            return ResultModel.ok(map);
        } catch (Exception e) {
            logger.error("getAccount："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getAccountList", method = RequestMethod.POST)
    public ResultModel getAccountList(String token) {
        try {
            List accountList = new ArrayList<>();
            Map map = new HashMap<>();
            User user = userService.queryUser(token);
            List<Account> accounts = this.accountService.getAccount(user.getFid());
            for (Account account : accounts ) {
                Map data = new HashMap<>();
                if(account != null){
                    data.put("total",account.getTotal());
                    Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(account.getSymbol());
                    data.put("symbol",fvirtualcointype.getFid());
                    data.put("shortName",fvirtualcointype.getFname());
                    data.put("coinName",fvirtualcointype.getFshortname());
                    data.put("url",fvirtualcointype.getFurl());
                    data.put("totalVal","0.0");
                }else{
                    data.put("total","0.0");
                }
                accountList.add(data);
            }
            map.put("totalVal","0.0");
            map.put("accountList",accountList);
            return ResultModel.ok(map);
        } catch (Exception e) {
            logger.error("getAccountList："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getAccountOption", method = RequestMethod.POST)
    public ResultModel getAccountOption(String token,int currentPage,int pageSize) {
        try {
            User user = userService.queryUser(token);
            return this.accountOperationService.getAccountOperation(user.getFid(),currentPage,pageSize);
        } catch (Exception e) {
            logger.error("getAccountOption："+e);
            return ResultModel.build(500,"数据异常");
        }
    }



    /**
     * 余额账户提现申请
     *
     * @param withdrawAmount
     * @param tradePassword
     * @param symbol
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public ResultModel withdrawSubmit(double withdrawAmount, String tradePassword, String fees,
                                      int symbol,String token) throws Exception {
        try{
            User user = userService.queryUser(token);
            //判断用户是否实名认证
            if(user.getAuthStatus() != 2){
                return ResultModel.build(403,"实名认证未完成");
            }
            if(user.getFidentityStatus() != 2){
                return ResultModel.build(403,"手持证件照未认证");
            }
            Account account = this.accountService.getAccount(user.getFid(),symbol);
            if (account == null){
                return ResultModel.build(403,"账户余额不足");
            }
            if (account.getTotal().compareTo(MathUtils.add(Double.valueOf(fees),withdrawAmount)) == -1){
                return ResultModel.build(403,"账户余额不足");
            }

            User user2 = userService.findByUserId(user.getFid());
            if (!HashUtil.encodePassword(tradePassword).equals(user2.getFtradePassword())) {
                return ResultModel.build(403,"交易密码错误");
            }
            Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(account.getSymbol());
            int parentid = fvirtualcointype.getParentid();
            if(fvirtualcointype.getFid() !=4 && parentid == 4){
                Account ethAccount = this.accountService.getAccount(user.getFid(),account.getSymbol());
                if(ethAccount.getTotal().compareTo(Double.valueOf(fees)) == -1){
                    return ResultModel.build(403,"ether账户余额不足");
                }
            }

            Fvirtualaddress fva = this.fvirtualaddressService.selectFvirtualAddress(user.getFid(),parentid);
            String address =  fva.getFadderess();
            List<PublicBlockAccount> publicBlockAccounts = this.publicBlockAccountService.getPublicBlockAccount(parentid);
            String userAddress =  publicBlockAccounts.get(0).getAddress();

            this.virtualCoinService.updateWithdraw(address, fvirtualcointype, account, withdrawAmount, user.getFid(),"DAIS宝余额提现",userAddress,Double.valueOf(fees));
            return ResultModel.ok();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("虚拟币转出错误");
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     *充值虚拟币到系统账户
     * @param withdrawAmount
     * @param tradePassword
     * @param symbol
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public ResultModel recharge(double withdrawAmount,String tradePassword,String fees,int symbol,
            String token) {
        User user = userService.queryUser(token);

        //没有该币种
        Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(symbol);
        if (fvirtualcointype == null || !fvirtualcointype.getFiswithdraw() || fvirtualcointype.getFstatus() == VirtualCoinTypeStatusEnum.Abnormal) {
            return ResultModel.build(403,"没有该币种或者该币种处于禁用状态");
        }
        User user2 = userService.findByUserId(user.getFid());
        if (!HashUtil.encodePassword(tradePassword).equals(user2.getFtradePassword())) {
            return ResultModel.build(403,"交易密码错误");
        }

        Fvirtualwallet fvirtualwallet = fvirtualwalletService.selectFvirtualwallet(user.getFid(),symbol);
        //余额不足
        if (fvirtualwallet.getFtotal() < withdrawAmount) {
            return ResultModel.build(403,"余额不足");
        }
        try {
            Fvirtualaddress fva = this.fvirtualaddressService.selectFvirtualAddress(user.getFid(),fvirtualcointype.getParentid());
            String userAddress =  fva.getFadderess();
            List<PublicBlockAccount> publicBlockAccounts = this.publicBlockAccountService.getPublicBlockAccount(fvirtualcointype.getParentid());
            if(CollectionUtils.isEmpty(publicBlockAccounts)){
                return ResultModel.build(403,"系统暂不支持该币种");
            }
            String address =  publicBlockAccounts.get(0).getAddress();
            this.virtualCoinService.updateWithdrawBtc(address, fvirtualcointype, fvirtualwallet, withdrawAmount, user.getFid(),"充值DAIS宝余额",userAddress,Double.valueOf(fees),true);
            return ResultModel.ok();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("虚拟币转出错误");
            return ResultModel.build(500,"数据异常");
        }

    }

    /**
     * 用户之间转账
     *
     * @param withdrawAmount
     * @param tradePassword
     * @param symbol
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/exchange", method = RequestMethod.POST)
    public ResultModel exchange(double withdrawAmount,String tradePassword, int symbol,
            String token,String remarks,int touserId) {
        try {
            User user = userService.queryUser(token);
            //判断用户是否实名认证
            if(user.getAuthStatus() != 2){
                return ResultModel.build(403,"实名认证未完成");
            }
            if(user.getFidentityStatus() != 2){
                return ResultModel.build(403,"手持证件照未认证");
            }
            if(user.getFid() == touserId){
                return ResultModel.build(403,"不能给自己转账");
            }
            Account account = this.accountService.getAccount(user.getFid(),symbol);
            if (account == null){
                return ResultModel.build(403,"账户余额不足");
            }
            if(account.getTotal().compareTo(withdrawAmount) == -1){
                return ResultModel.build(403,"账户余额不足");
            }
            return this.accountService.updateExchange(withdrawAmount, tradePassword, account, remarks, touserId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("朋友转账出现错误："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

}
