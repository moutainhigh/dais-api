package com.dais.controller.coin;

import com.common.pojo.ResultModel;
import com.common.utils.ExceptionUtil;
import com.dais.controller.BaseController;
import com.dais.service.CoinTradeRankService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GanZhen
 * @version 2017- 08- 10 21:33
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/ctr")
public class CoinTradeRankController extends BaseController {
    private static Logger logger = Logger.getLogger(CoinTradeRankController.class);
    @Autowired
   private CoinTradeRankService coinTradeRankService;

    /**
     * 获取最新交易行情列表数据
     * @return
     */
    @RequestMapping(value="/newest", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel getNewestRank() {
        try {
            ResultModel result = coinTradeRankService.getNewestRank();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    /**
     * 获取最新交易行情单条数据
     * @param coinType
     * @return
     */
    @RequestMapping(value="/oneNewest", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel getNewestRankByCoinTtype(String coinType) {
        try {
            ResultModel result = coinTradeRankService.getNewestRankByCoinType(coinType);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }


    @RequestMapping(value="/klineCtr", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel getKlineCtr(String coinType, String timeType) {
        try {
            ResultModel result = coinTradeRankService.getKlineByCoin(coinType,timeType);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value="/getlist", method= RequestMethod.POST)
    @ResponseBody
    public ResultModel getList(Integer pageNo, Integer rows) {
        try {
            ResultModel result = coinTradeRankService.getCoinTradeRank(pageNo,rows);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }



}
