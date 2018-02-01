package com.dais.service.impl;

import com.common.Enum.CapitalOperationOutStatus;
import com.common.Enum.VirtualCapitalOperationInStatusEnum;
import com.common.Enum.VirtualCapitalOperationOutStatusEnum;
import com.common.Enum.VirtualCapitalOperationTypeEnum;
import com.common.model.BTCMessage;
import com.common.pojo.ResultModel;
import com.common.utils.BTCUtils;
import com.common.utils.CollectionUtils;
import com.common.utils.MathUtils;
import com.dais.mapper.CaptualoperationpushMapper;
import com.dais.mapper.FvirtualcaptualoperationMapper;
import com.dais.mapper.WalletUnlockInfoMapper;
import com.dais.model.*;
import com.dais.service.*;
import com.dais.utils.StringUtils;
import com.dais.utils.Utils;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/11
 */
@Service
public class FvirtualcaptualoperationServiceImpl implements FvirtualcaptualoperationService {
    private static Logger logger = Logger.getLogger(FvirtualcaptualoperationServiceImpl.class);
    @Autowired
    private FvirtualcaptualoperationMapper fvirtualcaptualoperationMapper;
    @Autowired
    private FvirtualwalletService fvirtualwalletService;
    @Autowired
    private CaptualOperationSyncService captualOperationSyncService;
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private FvirtualaddressService fvirtualaddressService;
    @Autowired
    private CaptualoperationpushMapper captualoperationpushMapper;
    @Autowired
    private WalletUnlockInfoMapper walletUnlockInfoMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountOperationService accountOperationService;


    /**
     * status = -1查询所有状态
     * @param userId
     * @param status
     * @param symbol
     * @param typeList
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Fvirtualcaptualoperation> selectByExample(Integer userId, Integer status,Integer symbol,
                                                          List<Integer> typeList,boolean ishomeshow,int currentPage,int pageSize) {
        FvirtualcaptualoperationExample example = new FvirtualcaptualoperationExample();
        FvirtualcaptualoperationExample.Criteria criteria = example.createCriteria();
        criteria.andFusFid2EqualTo(userId);
        criteria.andFtypeIn(typeList);
        if(status != -1){
            criteria.andFstatusEqualTo(status);
        }
        if(!ishomeshow){
            criteria.andIshomeshowEqualTo(true);
        }
        example.setOrderByClause("fCreateTime desc");
        PageHelper.startPage(currentPage, pageSize);
        if(symbol != null){
            criteria.andFviFid2EqualTo(symbol);
        }
        return fvirtualcaptualoperationMapper.selectByExample(example);
    }

    @Override
    public Fvirtualcaptualoperation selectByPrimaryKey(Integer fid) {
        return fvirtualcaptualoperationMapper.selectByPrimaryKey(fid);
    }

    @Override
    public Fvirtualcaptualoperation selectByExample(FvirtualcaptualoperationExample example) {
        List<Fvirtualcaptualoperation> list =  fvirtualcaptualoperationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public int updateByPrimaryKey(Fvirtualcaptualoperation record) {
        return fvirtualcaptualoperationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insert(Fvirtualcaptualoperation record) {
        return fvirtualcaptualoperationMapper.insert(record);
    }

    @Override
    public int countByExample(FvirtualcaptualoperationExample example) {
        return fvirtualcaptualoperationMapper.countByExample(example);
    }

    @Override
    public int getTodayVirtualCoinWithdrawTimes(int userId) {
        FvirtualcaptualoperationExample example = new FvirtualcaptualoperationExample();
        example.createCriteria().andFusFid2EqualTo(userId)
                .andFtypeEqualTo(VirtualCapitalOperationTypeEnum.COIN_OUT)
                .andFstatusNotEqualTo(VirtualCapitalOperationOutStatusEnum.Cancel)
                .andFcreatetimeGreaterThan(new Timestamp(Utils.getTimesmorning()));
        return fvirtualcaptualoperationMapper.countByExample(example);
    }

    @Override
    public List<Fvirtualcaptualoperation> selectByTypeAndTradeUniqueNumber(Integer ftype, String ftradeUniqueNumber) {
        FvirtualcaptualoperationExample example = new FvirtualcaptualoperationExample();
        FvirtualcaptualoperationExample.Criteria criteria = example.createCriteria();
        criteria.andFtypeEqualTo(ftype);
        criteria.andFtradeuniquenumberEqualTo(ftradeUniqueNumber);
        return this.fvirtualcaptualoperationMapper.selectByExample(example);
    }

    @Override
    public List<Fvirtualcaptualoperation> findFvirtualcaptualoperation(Integer type, Integer userId, List<Integer> statusList, Integer symbol) {
        FvirtualcaptualoperationExample example = new FvirtualcaptualoperationExample();
        FvirtualcaptualoperationExample.Criteria criteria = example.createCriteria();
        criteria.andFtypeEqualTo(type);
        if(!StringUtils.isEmpty(userId)){
            criteria.andFusFid2EqualTo(userId);
        }
        criteria.andFviFid2EqualTo(symbol);
        criteria.andFstatusIn(statusList);
        return this.fvirtualcaptualoperationMapper.selectByExample(example);
    }


    @Override
    public ResultModel updateCapitaloperationChangeStatus(int type,int uid) throws Exception {
        Fvirtualcaptualoperation fvirtualcaptualoperation = this.selectByPrimaryKey(uid);
        fvirtualcaptualoperation.setFlastupdatetime(Utils.getTimestamp());
        int userId = fvirtualcaptualoperation.getFusFid2();
        int coinTypeId = fvirtualcaptualoperation.getFviFid2();
        Fvirtualwallet virtualWallet = this.fvirtualwalletService.selectFvirtualwallet(userId,coinTypeId);
        if (virtualWallet == null) {
            return ResultModel.build(500,"审核失败，会员虚拟币钱包信息异常!");
        }
        int status = fvirtualcaptualoperation.getFstatus();
        String tips = "";
        switch (type) {
            case 1:
                tips = "锁定";
                if (status != CapitalOperationOutStatus.WaitForOperation) {
                    String status_s = CapitalOperationOutStatus
                            .getEnumString(CapitalOperationOutStatus.WaitForOperation);
                    return ResultModel.build(500,"锁定失败,只有状态为:‘" + status_s
                            + "’的充值记录才允许锁定!");
                }
                fvirtualcaptualoperation
                        .setFstatus(VirtualCapitalOperationOutStatusEnum.OperationLock);
                break;
            case 2:
                tips = "取消锁定";
                if (status != CapitalOperationOutStatus.OperationLock) {
                    String status_s = CapitalOperationOutStatus
                            .getEnumString(CapitalOperationOutStatus.OperationLock);
                    return ResultModel.build(500,"取消锁定,只有状态为:‘" + status_s
                            + "’的充值记录才允许取消锁定!");
                }
                fvirtualcaptualoperation
                        .setFstatus(VirtualCapitalOperationOutStatusEnum.WaitForOperation);
                break;
            case 3:
                tips = "取消提现";
                if (status == CapitalOperationOutStatus.Cancel) {
                    return ResultModel.build(500,"取消提现失败,该记录已处于取消状态!");
                }
                double fee = fvirtualcaptualoperation.getFfees();
                double famount = fvirtualcaptualoperation.getFamount();
                fvirtualcaptualoperation
                        .setFstatus(VirtualCapitalOperationOutStatusEnum.Cancel);
                virtualWallet.setFfrozen(MathUtils.subtract(MathUtils.subtract(virtualWallet.getFfrozen(), fee), famount));
                virtualWallet.setFtotal(MathUtils.add(MathUtils.add(virtualWallet.getFtotal(), fee), famount));
                virtualWallet.setFlastupdatetime(Utils.getTimestamp());
                break;
        }
        try {
            int count = this.updateByPrimaryKey(fvirtualcaptualoperation);
            int count2 = this.fvirtualwalletService.updateFvirtualwallet(virtualWallet);
            CaptualOperationSync captualOperationSync = new CaptualOperationSync();
            captualOperationSync.setOperationId(fvirtualcaptualoperation.getFid());
            captualOperationSync.setStatus(fvirtualcaptualoperation.getFstatus());
            int count3 = this.captualOperationSyncService.updateByParam(captualOperationSync);
            if(count >0 && count2 >0 & count3 >0){
                return ResultModel.ok(tips+"成功");
            }else{
                throw new RuntimeException(tips+"失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ResultModel updateCapitalOutAudit(Integer fid,String fpassword) throws Exception {
        Fvirtualcaptualoperation fvirtualcaptualoperation = this.selectByPrimaryKey(fid);
        int status = fvirtualcaptualoperation.getFstatus();
        if (status != VirtualCapitalOperationOutStatusEnum.OperationLock) {
            String status_s = VirtualCapitalOperationOutStatusEnum
                    .getEnumString(VirtualCapitalOperationOutStatusEnum.OperationLock);
            return ResultModel.build(500,"审核失败,只有状态为:" + status_s
                    + "的提现记录才允许审核!");
        }
        int userId = fvirtualcaptualoperation.getFusFid2();
        int coinTypeId = fvirtualcaptualoperation.getFviFid2();
        Fvirtualwallet virtualWallet = this.fvirtualwalletService.selectFvirtualwallet(userId,coinTypeId);
        if (virtualWallet == null) {
            return ResultModel.build(500,"审核失败，会员虚拟币钱包信息异常!");
        }
        Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(fvirtualcaptualoperation.getFviFid2());

        double fee = fvirtualcaptualoperation.getFfees();
        double amount = fvirtualcaptualoperation.getFamount() + fee;
        //如果是以太坊代币，需要先查询以太坊钱包余额
        if(fvirtualcointype.getParentid() == 4){
            Fvirtualcointype fvirtualcointype2 = this.virtualCoinService.selectByPrimaryKey(fvirtualcointype.getParentid());
            BTCMessage btcMsg = new BTCMessage();
            btcMsg.setACCESS_KEY(fvirtualcointype2.getFaccessKey());
            btcMsg.setSECRET_KEY(fvirtualcointype2.getFsecrtKey());
            btcMsg.setIP(fvirtualcointype2.getFip());
            btcMsg.setPASSWORD(fpassword);
            btcMsg.setPORT(fvirtualcointype2.getFport());
            BTCUtils btcUtils = new BTCUtils(btcMsg);
            try {
                double balance = btcUtils.getbalanceValue(btcUtils.getaccountValue(fvirtualcaptualoperation.getRechargeVirtualAddress()));
                if (balance < fee) {
                    return ResultModel.build(500,"审核失败，ether余额：" + balance + "小于"
                            + fee);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                throw new RuntimeException("审核失败，钱包连接失败");
            }
            amount = fvirtualcaptualoperation.getFamount();
        }
        BTCMessage btcMsg = new BTCMessage();
        btcMsg.setACCESS_KEY(fvirtualcointype.getFaccessKey());
        btcMsg.setSECRET_KEY(fvirtualcointype.getFsecrtKey());
        btcMsg.setIP(fvirtualcointype.getFip());
        btcMsg.setPASSWORD(fpassword);
        btcMsg.setPORT(fvirtualcointype.getFport());
        BTCUtils btcUtils = new BTCUtils(btcMsg);

        try {
            //提现时生成订单处已经做了处理，rechargeVirtualAddress为用户自己的钱包地址
            double balance = btcUtils.getbalanceValue(btcUtils.getaccountValue(fvirtualcaptualoperation.getRechargeVirtualAddress()));
            if (balance < amount) {
                return ResultModel.build(500,"审核失败，钱包余额：" + balance + "小于"
                        + amount);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new RuntimeException("审核失败，钱包连接失败");
        }

        fvirtualcaptualoperation
                .setFstatus(VirtualCapitalOperationOutStatusEnum.OperationSuccess);
        fvirtualcaptualoperation.setFlastupdatetime(Utils.getTimestamp());

        // 钱包操作
        virtualWallet.setFlastupdatetime(Utils.getTimestamp());
        virtualWallet.setFfrozen(MathUtils.subtract(virtualWallet.getFfrozen(), amount));
        try {
            this.updateCapital(
                    fvirtualcaptualoperation, virtualWallet, btcUtils,fvirtualcointype);
            return ResultModel.ok("审核成功");
        } catch (Exception e) {
            System.out.println("error " + e);
            throw new RuntimeException("审核失败"+e.getMessage());
        }
    }


    @Override
    public void updateCapital(Fvirtualcaptualoperation virtualcaptualoperation,
                              Fvirtualwallet virtualwallet, BTCUtils btcUtils,Fvirtualcointype fvirtualcointype) throws Exception {

        try {
            int count = this.fvirtualcaptualoperationMapper.updateByPrimaryKeySelective(virtualcaptualoperation);
            int count2 = this.fvirtualwalletService.updateFvirtualwallet(virtualwallet);
            CaptualOperationSync captualOperationSync = new CaptualOperationSync();
            captualOperationSync.setOperationId(virtualcaptualoperation.getFid());
            captualOperationSync.setStatus(virtualcaptualoperation.getFstatus());
            captualOperationSync.setLastUpdatetime(virtualcaptualoperation.getFlastupdatetime());
            int count3 = this.captualOperationSyncService.updateByParam(captualOperationSync);
            // 优先更新数据库，再转账，保证最终一致性问题
            String fromAddress = virtualcaptualoperation.getRechargeVirtualAddress();
            if(count > 0 && count2 > 0 && count3 > 0){
                //eth,etc直接在交易参数中传入手续费，btc类的钱包需要先设置手续费
                String comment = "";
                if(fvirtualcointype.getParentid() == 4 || fvirtualcointype.getParentid() == 5){
                    comment += virtualcaptualoperation.getFfees();
                }else{
                    JSONObject jsonObject = btcUtils.settxfee(virtualcaptualoperation.getFfees()/226 *1024);//每kb交易费
                    if(!jsonObject.containsKey("result") || StringUtils.isEmpty(jsonObject.get("result").toString())
                            || !"true".equals(jsonObject.get("result").toString())){
                        throw new RuntimeException("提现失败，设置手续费出错");
                    }
                    fromAddress = btcUtils.getaccountValue(fromAddress);//比特币钱包需要的账号
                }
                String toAddress = virtualcaptualoperation.getWithdrawVirtualAddress();
                double amount = virtualcaptualoperation.getFamount();
                String tradeuniquenumber = btcUtils.sendfromValue(fromAddress,toAddress,amount,comment);
                if(StringUtils.hasText(tradeuniquenumber)){
                    try{
                        virtualcaptualoperation = this.selectByPrimaryKey(virtualcaptualoperation.getFid());
                        virtualcaptualoperation.setFtradeuniquenumber(tradeuniquenumber);
                        this.fvirtualcaptualoperationMapper.updateByPrimaryKeySelective(virtualcaptualoperation);

                        captualOperationSync.setFtradeuniquenumber(tradeuniquenumber);
                        captualOperationSync.setOperationId(virtualcaptualoperation.getFid());
                        captualOperationSync.setLastUpdatetime(virtualcaptualoperation.getFlastupdatetime());
                        this.captualOperationSyncService.updateByParam(captualOperationSync);
                        //加入推送列表
//                        this.addPushMsg(virtualcaptualoperation);
                    }catch (Exception e){
                        e.printStackTrace();
                        logger.error("虚拟币id为:"+virtualcaptualoperation.getFviFid2() + "提现订单:" + virtualcaptualoperation.getFid() + "更新交易号" + tradeuniquenumber + "失败", e);
                    }
                }else{
                    throw new RuntimeException("提现失败");
                }
            }else{
                throw new RuntimeException("提现失败");
            }
        } catch (Exception e) {
            logger.error("系统繁忙:"+e);
            e.printStackTrace();
            String msg = e.getMessage();
            if (StringUtils.isEmpty(msg)) {
                msg = "系统繁忙";
            }
            throw new RuntimeException(msg);
        }
    }

    //比特币自动充值并加币
    @Override
    public void updateFvirtualcaptualoperationCoinIn(Fvirtualcaptualoperation fvirtualcaptualoperation) throws Exception{
        try {
            Fvirtualcaptualoperation real = this.fvirtualcaptualoperationMapper.selectByPrimaryKey(fvirtualcaptualoperation.getFid()) ;
            if(real!=null && real.getFstatus()!= VirtualCapitalOperationInStatusEnum.SUCCESS){
                real.setFstatus(fvirtualcaptualoperation.getFstatus());
                real.setFconfirmations(fvirtualcaptualoperation.getFconfirmations());
                real.setFlastupdatetime(Utils.getTimestamp());
                real.setFfees(fvirtualcaptualoperation.getFfees());
                real.setBlockindex(fvirtualcaptualoperation.getBlockindex());
                this.fvirtualcaptualoperationMapper.updateByPrimaryKeySelective(real);

                CaptualOperationSync captualOperationSync = new CaptualOperationSync();
                captualOperationSync.setOperationId(real.getFid());
                captualOperationSync.setStatus(real.getFstatus());
                captualOperationSync.setLastUpdatetime(real.getFlastupdatetime());
                captualOperationSync.setFees(fvirtualcaptualoperation.getFfees());
                this.captualOperationSyncService.updateByParam(captualOperationSync);

                //更新一下转出方的区块信息
                FvirtualcaptualoperationExample example = new FvirtualcaptualoperationExample();
                String tradeuniquenumber = real.getFtradeuniquenumber();
                example.createCriteria().andFtradeuniquenumberEqualTo(tradeuniquenumber.substring(0,tradeuniquenumber.indexOf("-")));
                List<Fvirtualcaptualoperation> fvirtualcaptualoperations = this.fvirtualcaptualoperationMapper.selectByExample(example);
                if(!CollectionUtils.isEmpty(fvirtualcaptualoperations)){
                    Fvirtualcaptualoperation withDraw = fvirtualcaptualoperations.get(0);
                    withDraw.setFstatus(fvirtualcaptualoperation.getFstatus());
                    withDraw.setFconfirmations(fvirtualcaptualoperation.getFconfirmations());
                    withDraw.setFlastupdatetime(Utils.getTimestamp());
                    withDraw.setFfees(fvirtualcaptualoperation.getFfees());
                    withDraw.setBlockindex(fvirtualcaptualoperation.getBlockindex());
                    this.fvirtualcaptualoperationMapper.updateByPrimaryKeySelective(withDraw);
                }

                if(real.getFstatus()==VirtualCapitalOperationInStatusEnum.SUCCESS && real.getFhasowner()){
                    if(!real.getIsSystemAccount()){
                        Fvirtualwallet fvirtualwallet = this.fvirtualwalletService.selectFvirtualwallet(real.getFusFid2(), real.getFviFid2());
                        if (fvirtualwallet == null){
                            fvirtualwallet = fvirtualwalletService.insertFvirtualwallet(real.getFusFid2(),real.getFviFid2());
                        }
//
                        Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(real.getFviFid2());
                        BTCMessage btcMsg = new BTCMessage();
                        btcMsg.setACCESS_KEY(fvirtualcointype.getFaccessKey());
                        btcMsg.setSECRET_KEY(fvirtualcointype.getFsecrtKey());
                        btcMsg.setIP(fvirtualcointype.getFip());
                        WalletUnlockInfoExample walletUnlockInfoExample = new WalletUnlockInfoExample();
                        walletUnlockInfoExample.createCriteria().andSymbolEqualTo(fvirtualcaptualoperation.getFviFid2());
                        List<WalletUnlockInfo> walletUnlockInfos = walletUnlockInfoMapper.selectByExample(walletUnlockInfoExample);
                        if(!CollectionUtils.isEmpty(walletUnlockInfos)) {
                            btcMsg.setPASSWORD(walletUnlockInfos.get(0).getUnlockPassword());
                        }
                        btcMsg.setPORT(fvirtualcointype.getFport());
                        BTCUtils btcUtils = new BTCUtils(btcMsg);
                        try {
                            double balance = btcUtils.getbalanceValue(btcUtils.getaccountValue(fvirtualcaptualoperation.getRechargeVirtualAddress()));
                            fvirtualwallet.setFtotal(balance) ;
                            fvirtualwallet.setFlastupdatetime(Utils.getTimestamp());
                            this.fvirtualwalletService.updateFvirtualwallet(fvirtualwallet);
                        } catch (Exception e) {
                            logger.error("获取钱包余额失败"+e);
                            e.printStackTrace();
                        }
                    }else{
                        this.updateAccount(real);
                    }
                    //加入推送列表
                    this.addPushMsg(real);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        String a = "0x60a5a09776fd1d912f24ae6b8d4c4ad0566a8f89bd9b05f2c716eaff83ffed3e-0x71a7d1efccfa77c4cfafe5c6105cb251fb08e5a5-0x71a7d1efccfa77c4cfafe5c6105cb251fb08e5a5";
        System.out.println(a.length());
        System.out.println(a.substring(0,a.indexOf("-")));
    }

    private void addPushMsg(Fvirtualcaptualoperation real){
        try {
            Captualoperationpush captualoperationpush = new Captualoperationpush();
            captualoperationpush.setRetryTimes(0);
            captualoperationpush.setStatus(1);
            captualoperationpush.setCreateTime(Utils.getTimestamp());
            captualoperationpush.setOperationid(real.getFid());
            captualoperationpush.setUserid(real.getFusFid2());
            this.captualoperationpushMapper.insertSelective(captualoperationpush);
        } catch (Exception e) {
            logger.error("添加推送列表失败"+e);
        }
    }

    private void updateAccount(Fvirtualcaptualoperation real){
        FvirtualcaptualoperationExample example = new FvirtualcaptualoperationExample();
        String tradeuniquenumber = real.getFtradeuniquenumber();
        example.createCriteria().andFtradeuniquenumberEqualTo(tradeuniquenumber.substring(0,tradeuniquenumber.indexOf("-")));
        List<Fvirtualcaptualoperation> fvirtualcaptualoperations = this.fvirtualcaptualoperationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(fvirtualcaptualoperations)){
            return;//非平台内的充值，暂不做任何操作
        }
        int userid = fvirtualcaptualoperations.get(0).getFusFid2();
        int symbol = real.getFviFid2();
        Account account = this.accountService.getAccount(userid,symbol);
        if(account == null){
            account = new Account();
            account.setUserid(fvirtualcaptualoperations.get(0).getFusFid2());
            account.setSymbol(real.getFviFid2());
            account.setCreateTime(Utils.getTimestamp());
            account.setUpdateTime(Utils.getTimestamp());
            account.setTotal(real.getFamount());
            this.accountService.insertAccount(account);
        }else{
            account.setTotal(MathUtils.add(account.getTotal(),real.getFamount()));
            account.setUpdateTime(Utils.getTimestamp());
            this.accountService.updateAccount(account);
        }
        this.accountOperationService.save(account.getSymbol(),account.getUserid(),0,"充值","系统充值",real.getFamount(),real.getFfees(),1);
    }

    @Override
    public String getTradeAddress(Fvirtualcaptualoperation fvco){
        //如果是充值，则充值地址一定是自己的
        String address = "";
        if(fvco.getFtype() == 1){
            address = fvco.getRechargeVirtualAddress();
        }else{
            address = fvco.getRechargeVirtualAddress();
            if(StringUtils.isEmpty(address)){
                List<Fvirtualaddress> list = this.fvirtualaddressService.listFvirtualAddress(fvco.getFusFid2(),fvco.getFviFid2());
                if(CollectionUtils.isEmpty(list)){
                    address = "";
                }else{
                    address = list.get(0).getFadderess();
                }
            }
        }
        return address;
    }

    @Override
    public String getTradeToAddress(Fvirtualcaptualoperation fvco){
        //如果是充值，对方地址一分两种情况，1区块交易，直接取fvco.getWithdrawVirtualAddress();
        //2,如果是客户端用户之间转账，这需要查询fvirtualaddress表
        String toaddress = "";
        if(fvco.getFtype() == 1){
            toaddress = fvco.getWithdrawVirtualAddress();
            if(StringUtils.isEmpty(toaddress)){//没有区块确认
                List<Fvirtualaddress> list = this.fvirtualaddressService.listFvirtualAddress(fvco.getFusFid2(),fvco.getFviFid2());
                if(CollectionUtils.isEmpty(list)){
                    toaddress = "";
                }else{
                    toaddress = list.get(0).getFadderess();
                }
            }
        }else{
            toaddress = fvco.getWithdrawVirtualAddress();
        }
        return toaddress;
    }
}
