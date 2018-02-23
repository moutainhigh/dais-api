package com.dais.auto;

import com.common.Enum.VirtualCapitalOperationInStatusEnum;
import com.common.Enum.VirtualCapitalOperationTypeEnum;
import com.common.Enum.VirtualCoinTypeStatusEnum;
import com.common.model.BTCInfo;
import com.common.model.BTCMessage;
import com.common.utils.BTCUtils;
import com.common.utils.CollectionUtils;
import com.dais.mapper.FvirtualcaptualoperationMapper;
import com.dais.model.*;
import com.dais.service.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoReadWithdrawBlocks {
    private static final Logger log = LoggerFactory
            .getLogger(AutoReadWithdrawBlocks.class);
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private FvirtualcaptualoperationMapper fvirtualcaptualoperationMapper;

    public void work() {
        synchronized (this) {
            try{
                List<Fvirtualcointype> fvirtualcointypes = this.virtualCoinService.findFvirtualCoinTypeByStatus(VirtualCoinTypeStatusEnum.Normal);
                //获取钱包中新数据
                for (Fvirtualcointype fvirtualcointype : fvirtualcointypes) {
                    if (fvirtualcointype == null || fvirtualcointype.getFstatus() == VirtualCoinTypeStatusEnum.Abnormal) {
                        continue;
                    }
                    FvirtualcaptualoperationExample fvirtualcaptualoperationExample = new FvirtualcaptualoperationExample();
                    FvirtualcaptualoperationExample.Criteria criteria = fvirtualcaptualoperationExample.createCriteria();
                    criteria.andFviFid2EqualTo(fvirtualcointype.getFid());
                    criteria.andFtypeEqualTo(VirtualCapitalOperationTypeEnum.COIN_OUT);
                    criteria.andFstatusEqualTo(VirtualCapitalOperationInStatusEnum.SUCCESS);
                    criteria.andBlockindexLessThan(fvirtualcointype.getConfirmTimes());
                    List<Fvirtualcaptualoperation> fvirtualcaptualoperations = fvirtualcaptualoperationMapper.selectByExample(fvirtualcaptualoperationExample);
                    if (CollectionUtils.isEmpty(fvirtualcaptualoperations)) {
                        continue;
                    }
                    for (Fvirtualcaptualoperation fvirtualcaptualoperation : fvirtualcaptualoperations) {
                        try {
                            if (StringUtils.isEmpty(fvirtualcaptualoperation.getFtradeuniquenumber())) {
                                continue;
                            }
                            BTCMessage btcMessage = new BTCMessage();
                            btcMessage.setACCESS_KEY(fvirtualcointype.getFaccessKey());
                            btcMessage.setIP(fvirtualcointype.getFip());
                            btcMessage.setPORT(fvirtualcointype.getFport());
                            btcMessage.setSECRET_KEY(fvirtualcointype.getFsecrtKey());

                            BTCUtils btcUtils = new BTCUtils(btcMessage);
                            BTCInfo btcInfo =  btcUtils.gettransactionValue(fvirtualcaptualoperation.getFtradeuniquenumber(),"send");
                            fvirtualcaptualoperation.setFconfirmations(btcInfo.getConfirmations());
                            fvirtualcaptualoperation.setBlockindex(btcInfo.getConfirmations());
                            fvirtualcaptualoperationMapper.updateByPrimaryKeySelective(fvirtualcaptualoperation);
                        } catch (Exception e) {
                            log.error(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
