package com.dais.auto;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.JsonUtils;
import com.dais.mapper.WalletUnlockInfoMapper;
import com.dais.model.*;
import com.dais.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * @author xxp
 * @version 2017- 09- 13 19:18
 * @description
 * @copyright www.zhgtrade.com
 */
@Component
public class AutoWithdrawVirtualCoin {
    private static final Logger log = LoggerFactory.getLogger(AutoWithdrawVirtualCoin.class);
    @Autowired
    private FvirtualcaptualoperationService fvirtualcaptualoperationService;
    @Autowired
    private AutoWithdrawAuthService autoWithdrawAuthService;
    @Autowired
    private WalletUnlockInfoMapper walletUnlockInfoMapper;

    public synchronized void work() {
        try {
            List<AutoWithdrawAuth> autoWithdrawAuths = this.autoWithdrawAuthService.selectAutoWithdrawAuth();
            //获取钱包中新数据
            for (AutoWithdrawAuth autoWithdrawAuth : autoWithdrawAuths) {
                Fvirtualcaptualoperation fvirtualcaptualoperation = fvirtualcaptualoperationService.selectByPrimaryKey(autoWithdrawAuth.getWithdrawOprationId());
                int status = fvirtualcaptualoperation.getFstatus();
                if(StringUtils.isNotEmpty(fvirtualcaptualoperation.getFtradeuniquenumber())){
                    continue;
                }
                ResultModel resultModel = new ResultModel();
                try {
                    if(status ==1){//先锁定
                        resultModel = fvirtualcaptualoperationService.updateCapitaloperationChangeStatus(1,fvirtualcaptualoperation.getFid());
                    }else if (status == 2){
                        resultModel.setStatus(200);
                    }else{
                        continue;
                    }
                    if(resultModel.getStatus() == 200){
                        autoWithdrawAuth.setStatus(2);
                        this.autoWithdrawAuthService.updateWithdrawAuth(autoWithdrawAuth);
                        WalletUnlockInfoExample example = new WalletUnlockInfoExample();
                        example.createCriteria().andSymbolEqualTo(fvirtualcaptualoperation.getFviFid2());
                        List<WalletUnlockInfo> walletUnlockInfos = walletUnlockInfoMapper.selectByExample(example);
                        String unlockPassword = null;
                        if(!CollectionUtils.isEmpty(walletUnlockInfos)) {
                            unlockPassword = walletUnlockInfos.get(0).getUnlockPassword();
                        }
                        ResultModel result = fvirtualcaptualoperationService.updateCapitalOutAudit(fvirtualcaptualoperation.getFid(),unlockPassword);
                      log.info(JsonUtils.objectToJson(result));
                    }else{
                        log.error("提现记录锁定失败,id:"+fvirtualcaptualoperation.getFid());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    log.error("自动审核提现失败："+e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
           log.error(e.getMessage());
        }
    }
}
