package com.dais.controller.coin;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.dais.controller.BaseController;
import com.dais.mapper.FvirtualcointypeMapper;
import com.dais.model.Fees;
import com.dais.model.Fvirtualcointype;
import com.dais.model.FvirtualcointypeExample;
import com.dais.service.FeesService;
import com.dais.service.VirtualCoinService;
import com.dais.utils.StringUtils;
import com.dais.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author xxp
 * @version 2017- 09- 18 13:52
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
public class EthTokenController extends BaseController{

    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private FvirtualcointypeMapper fvirtualcointypeMapper;
    @Autowired
    private FeesService feesService;

    @RequestMapping("/ethToken/receiveToken")
    public ResultModel receiveToken(HttpServletRequest request){
        String contractAddress = request.getParameter("contractAddress");
        String accessPassword = request.getParameter("accessPassword");
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortName");
        String fee = request.getParameter("fee");
        FvirtualcointypeExample example = new FvirtualcointypeExample();
        example.createCriteria().andContractAddressEqualTo(contractAddress);
        List<Fvirtualcointype>  fvirtualcointypes = virtualCoinService.selectByExample(example);
        Fvirtualcointype fvirtualcointype = null;
        if(CollectionUtils.isEmpty(fvirtualcointypes)){
            fvirtualcointype = new Fvirtualcointype();
            fvirtualcointype.setConfirmTimes(12);
            fvirtualcointype.setContractAddress(contractAddress);
            fvirtualcointype.setFname(name);
            fvirtualcointype.setFshortname(name);
            fvirtualcointype.setFaccessKey(contractAddress);
            fvirtualcointype.setFsecrtKey(accessPassword);
            fvirtualcointype.setFip("118.190.132.141");
            fvirtualcointype.setFport("6969");
            fvirtualcointype.setFshortname(shortName);
            fvirtualcointype.setFiswithdraw(true);
            fvirtualcointype.setFurl("/upload/others/eth_default.png");
            fvirtualcointype.setParentid(4);
            fvirtualcointype.setFaddtime(Utils.getTimestamp());
            fvirtualcointype.setEquitytype(true);
            fvirtualcointype.setFstatus(1);
            fvirtualcointype.setFintrourl("https://etherscan.io/tx/");
            fvirtualcointypeMapper.insertSelective(fvirtualcointype);
        }else{
            fvirtualcointype = fvirtualcointypes.get(0);
            if(StringUtils.isEmpty(fvirtualcointype.getFname())){
                fvirtualcointype.setFname(name);
            }
            if(StringUtils.isEmpty(fvirtualcointype.getFshortname())){
                fvirtualcointype.setFshortname(name);
            }
            fvirtualcointype.setContractAddress(contractAddress);
            fvirtualcointype.setFaccessKey(contractAddress);
            fvirtualcointype.setFsecrtKey(accessPassword);
            fvirtualcointype.setFip("118.190.132.141");
            fvirtualcointype.setFport("6969");
            fvirtualcointype.setParentid(4);
            fvirtualcointype.setFstatus(1);
            fvirtualcointypeMapper.updateByPrimaryKeySelective(fvirtualcointype);
        }
        Fees fees = this.feesService.selectFees(fvirtualcointype.getFid());
        if(fees == null){
            fees = new Fees();
            fees.setCoinname(name);
            fees.setSymbol(fvirtualcointype.getFid());
            fees.setMinfees(Double.valueOf(fee));
            fees.setMaxfees(Double.valueOf(fee) * 100);
            fees.setUnit("eth");
            fees.setRate("0.3");
            feesService.insert(fees);
        }else {
            if(StringUtils.isEmpty(fees.getCoinname())){
                fees.setCoinname(name);
            }
            fees.setSymbol(fvirtualcointype.getFid());
            fees.setMinfees(Double.valueOf(fee));
            fees.setMaxfees(Double.valueOf(fee) * 100);
            feesService.update(fees);
        }
        return ResultModel.ok();
    }


}
