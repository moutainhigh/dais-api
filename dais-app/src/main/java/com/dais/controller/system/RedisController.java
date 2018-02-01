package com.dais.controller.system;

import com.common.pojo.ResultModel;
import com.dais.controller.BaseController;
import com.dais.task.CoinTradeRankTask2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GanZhen
 * @version 2017- 08- 28 21:03
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/redis")
public class RedisController extends BaseController{

    @Autowired
    private CoinTradeRankTask2 coinTradeRankTask2;

    @RequestMapping("delete")
    @ResponseBody
    public ResultModel deleteMessage(){
        this.coinTradeRankTask2.delData();
        return ResultModel.ok();

    }
}
