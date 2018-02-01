package com.dais.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author GanZhen
 * @version 2017- 06- 28 9:42
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
public class IndexController extends BaseController{

    private final static Logger logger = Logger.getLogger(IndexController.class);


    @RequestMapping("/virtualCoin")
    public String index(){
        return "/virtualCoin";
    }

}
