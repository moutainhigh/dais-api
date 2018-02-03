package com.dais.controller.coin;

import com.common.Enum.VirtualCoinTypeStatusEnum;
import com.common.constant.CommonConstant;
import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.ConstantKeys;
import com.common.utils.HashUtil;
import com.common.utils.MathUtils;
import com.dais.mapper.FmessageMapper;
import com.dais.model.*;
import com.dais.service.*;
import com.dais.utils.StringUtils;
import com.dais.vo.Fvirtualaddress_withdrawVo;
import com.dais.vo.FvitualCoinTradeRankVo;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

import static com.common.utils.MathUtils.convert2;
import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : xxp
 * Date： 2017/4/26
 */
@Controller
@RequestMapping("/virtualCoin")
public class VirtualCoinController {
    private static Logger logger = Logger.getLogger(VirtualCoinController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private FvirtualaddressService fvirtualaddressService;
    @Autowired
    private FvirtualwalletService fvirtualwalletService;
    @Autowired
    private Fvirtualaddress_withdrawService fvirtualaddress_withdrawService;
    @Autowired
    private FvirtualcaptualoperationService fvirtualcaptualoperationService;
    @Autowired
    private CoinTradeRankService coinTradeRankService;
    @Autowired
    private FmessageMapper fmessageMapper;
    @Autowired
    private CommonParamsService commonParamsService;
    @Autowired
    private FeesService feesService;

    @ResponseBody
    @RequestMapping(value = "/getfees")
    public ResultModel getfees(int symbol) {
        Fees fees = this.feesService.selectFees(symbol);
        if(fees == null){
            return  ResultModel.build(500,"数据异常");
        }
        Map data = new HashMap<>();
        data.put("symbol",fees.getSymbol());
        data.put("minfees",fees.getMinfees());
        data.put("maxfees",fees.getMaxfees());
        return ResultModel.ok(data);
    }


    @ResponseBody
    @RequestMapping(value = "/getuser4coin")
    public ResultModel getUser4Coin(int fid,int symbol) {
        //获取地址
        User user = userService.findByUserId(fid);
        if(user == null){
            return  ResultModel.build(500,"数据异常");
        }
        Fvirtualcointype fvc = this.virtualCoinService.selectByPrimaryKey(symbol);
        if(fvc == null){
            return  ResultModel.build(500,"数据异常");
        }
        Map data = new HashMap<>();
        data.put("fname",fvc.getFname());
        data.put("fnickName",user.getFnickName());
        data.put("frealName",user.getFrealName());
        return ResultModel.ok(data);
    }

    /**
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCoinType", method = RequestMethod.POST)
    public ResultModel getCoinType(String token) {
        //获取地址
        User user = this.userService.queryUser(token);
        Map data = null;
        List<Map> coinList = new ArrayList<>();
        FvirtualcointypeExample example = new FvirtualcointypeExample();
        example.createCriteria().andFiswithdrawEqualTo(true);
        List<Fvirtualcointype> fvcList = this.virtualCoinService.selectByExample(example);
        Fvirtualcointype fvc = null;
        Fvirtualwallet fvirtualwallet = null;
        for (int i = 0; i < fvcList.size(); i++) {
            fvc = fvcList.get(i);
            fvirtualwallet = this.fvirtualwalletService.selectFvirtualwallet(user.getFid(),fvc.getFid(),true);
            if(fvirtualwallet == null){
                continue;
            }
            data = new HashMap<>();
            data.put("symbol",fvc.getFid());
            data.put("fshortname",fvc.getFshortname());
            data.put("fname",fvc.getFname());
            data.put("furl",fvc.getFurl());
//            data.put("fopenprice",fvc.getFopenprice());
            coinList.add(data);
        }
        return ResultModel.ok(coinList);
    }


    /**
     * 查询虚拟币接口，用于用户增加钱包，显示隐藏钱包
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getWalletCoinType", method = RequestMethod.POST)
    public ResultModel getWalletCoinType(String token) {
        //获取地址
        User user = this.userService.queryUser(token);
        Map data = null;
        List<Map> coinList = new ArrayList<>();
        List<Map> openList = new ArrayList<>();
        List<Map> offList = new ArrayList<>();
        FvirtualcointypeExample example = new FvirtualcointypeExample();
        example.createCriteria().andFiswithdrawEqualTo(true);
        List<Fvirtualcointype> fvcList = this.virtualCoinService.selectByExample(example);
        Fvirtualcointype fvc = null;
        Fvirtualwallet fvirtualwallet = null;
        for (int i = 0; i < fvcList.size(); i++) {
            fvc = fvcList.get(i);
            fvirtualwallet = this.fvirtualwalletService.selectFvirtualwallet(user.getFid(),fvc.getFid());
            data = new HashMap<>();
            data.put("symbol",fvc.getFid());
            data.put("fshortname",fvc.getFshortname());
            data.put("fshortname",fvc.getFshortname());
            data.put("fname",fvc.getFname());
            data.put("furl",fvc.getFurl());
            data.put("fopenprice",fvc.getFopenprice());
            if("BTC".equals(fvc.getFshortname()) || "ETH".equals(fvc.getFshortname())){
                data.put("swithflag","no");
                coinList.add(data);
                continue;
            }
            if(fvirtualwallet != null && fvirtualwallet.getIshow()){
                data.put("swithflag","open");
                openList.add(data);
                continue;
            }
            data.put("swithflag","off");
            offList.add(data);
        }
        coinList.addAll(openList);
        coinList.addAll(offList);
        return ResultModel.ok(coinList);
    }

    @ResponseBody
    @RequestMapping(value = "/updateWallatOrAddress", method = RequestMethod.POST)
    public ResultModel updateWallatOrAddress(String token, int symbol, String type){
        User user = this.userService.queryUser(token);
        try {
            return this.userService.updateWallatOrAddress(user.getFid(),symbol,type);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     * 查询虚拟币24小时价格
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get24HourPrice", method = RequestMethod.POST)
    public ResultModel get24HourPrice(int symbol) {
        //查询币种24小时价格
        Map map = new HashMap<>();
        Fvirtualcointype fvct = this.virtualCoinService.selectByPrimaryKey(symbol);
        if(fvct.getFopenprice().compareTo(new BigDecimal(0)) == 1){
            List<Object> hourPriceArr = this.coinTradeRankService.getPriceByCoin(fvct.getFshortname());
            ResultModel r = coinTradeRankService.getNewestRankByCoinType(fvct.getFshortname());
            FvitualCoinTradeRankVo fvcrv = (FvitualCoinTradeRankVo)r.getData();
            map.put("coinName",fvct.getFname());
            map.put("fopenprice",fvct.getFopenprice());
            map.put("sourceWeb","bter");
            map.put("quotevolume",fvcrv.getQuotevolume());
            Collections.reverse(hourPriceArr);
            map.put("lineData",hourPriceArr);
        }
        return ResultModel.ok(map);
    }



    /**
     * 充币接口
     *
     * @param symbol
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public ResultModel rechargeBtc(@RequestParam("symbol") int symbol, String token) {
        User user = userService.queryUser(token);
        Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(symbol);
        Fvirtualaddress fvirtualaddress = this.fvirtualaddressService.selectFvirtualAddress(user.getFid(),fvirtualcointype.getParentid());
        if(fvirtualaddress == null){
            return ResultModel.build(500,"数据异常，获取钱包地址失败");
        }
        return ResultModel.ok(fvirtualaddress.getFadderess());
    }

    /**
     * 添加联系人地址
     * @param fvaw
     * @param token
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addAddress")
    public ResultModel addAddress(Fvirtualaddress_withdraw fvaw , String token){
        User user = userService.queryUser(token);
        if(fvaw == null){
            return ResultModel.build(500,"请传入参数");
        }
        if(fvaw.getFviFid() == null){
            return ResultModel.build(403,"请选择虚拟币");
        }
        return this.fvirtualaddress_withdrawService.insertFvirtualaddressWithdraw(fvaw,user.getFid());
    }

    /**
     * 删除联系地址人接口
     * @param fId
     * @param token
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAddress")
    public ResultModel deleteAddress(Integer fId,String token){
        //token 用作拦截器校验使用，此处不在判断信息
        int count = fvirtualaddress_withdrawService.deleteByPrimaryKey(fId);
        if (count > 0){
            return ResultModel.ok();
        }
        return ResultModel.build(500,"数据异常");
    }

    /**
     * 更新联系人地址
     * @param fvaw
     * @param token
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateAddress")
    public ResultModel updateAddress(Fvirtualaddress_withdraw fvaw , String token){
        User user = userService.queryUser(token);
        if(fvaw == null){
            return ResultModel.build(500,"请传入参数");
        }
        if(fvaw.getFviFid() == null){
            return ResultModel.build(403,"请选择虚拟币");
        }
        fvaw.setFuid(user.getFid());
        int count = fvirtualaddress_withdrawService.updateByPrimaryKey(fvaw);
        if(count > 0){
            return ResultModel.ok();
        }else{
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     * 查询联系地址人接口
     * @param token
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAddress")
    public ResultModel getAddress(@RequestParam("symbol") int symbol,String token){
        //token 用作拦截器校验使用，此处不在判断信息
        User user = this.userService.queryUser(token);
        List<Fvirtualaddress_withdraw> fvawList = fvirtualaddress_withdrawService.selectFvirtualaddressWithdraw(user.getFid(),symbol);
        Fvirtualaddress_withdrawVo fvawv = null;
        List<Fvirtualaddress_withdrawVo> dataList = new ArrayList<>();
        for(Fvirtualaddress_withdraw fvaw : fvawList){
            if(StringUtils.isEmpty(fvaw.getFviFid())){
                return ResultModel.build(500,"数据异常");
            }
            Fvirtualcointype fvct = this.virtualCoinService.selectByPrimaryKey(fvaw.getFviFid());
            fvawv = new Fvirtualaddress_withdrawVo();
            fvawv.setCoinName(fvct.getFname());
            fvawv.setCoinLogo(fvct.getFurl());
            fvawv.setFviFid(fvct.getFid());
            fvawv.setFuid(fvaw.getFuid());
            fvawv.setFid(fvaw.getFid());
            fvawv.setFadderess(fvaw.getFadderess());
            fvawv.setFlabel(fvaw.getFlabel());
            dataList.add(fvawv);
        }
        return ResultModel.ok(dataList);
    }


    /**
     * 用户虚拟资金，同时返回最高价，最低价，买卖价
     *
     * @param symbol
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/restMoney", method = RequestMethod.POST)
    public ResultModel restMoney(@RequestParam("symbol") int symbol, String token) {
        Map data = new HashMap();
        try {
            User user = userService.queryUser(token);
            Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(symbol);
            //用户虚拟资金
            Fvirtualwallet fvirtualwallet = fvirtualwalletService.selectFvirtualwallet(user.getFid(),symbol);
            if (fvirtualwallet == null) {
                data.put("total", 0);
                data.put("frozen", 0);
            } else {
                data.put("total", fvirtualwallet == null ? 0 : fvirtualwallet.getFtotal());
                data.put("frozen", fvirtualwallet == null ? 0 : fvirtualwallet.getFfrozen());
            }
            data.put("coinName",fvirtualcointype.getFname());
            data.put("shortName",fvirtualcointype.getFshortname());
            data.put("logo",fvirtualcointype.getFurl());
            return ResultModel.ok(data);
        } catch (Exception e) {
            logger.error("获取用户虚拟资金出错："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     * 用户虚拟资金，同时返回最高价，最低价，买卖价
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getWallet", method = RequestMethod.POST)
    public ResultModel getWallet(String token) {
        Map data = new HashMap<>();
        try {
            User user = userService.queryUser(token);
            List<Map> list = new ArrayList<>();
            Map map = null;
            //用户虚拟资金
           List<Fvirtualwallet> fvirtualwallet = fvirtualwalletService.listFvirtualwallet(user.getFid());
            if (CollectionUtils.isEmpty(fvirtualwallet)) {
                data.put("total", 0);
                data.put("frozen", 0);
            } else {
                double total = 0.0;
                double frozen = 0.0;
                Fvirtualcointype favct = null;
                List<Fvirtualcointype> favctList = null;
                for (Fvirtualwallet fvw : fvirtualwallet) {
                    FvirtualcointypeExample example = new FvirtualcointypeExample();
                    example.createCriteria().andFiswithdrawEqualTo(true).andFidEqualTo(fvw.getFviFid());
                    favctList = this.virtualCoinService.selectByExample(example);
                    if(CollectionUtils.isEmpty(favctList)){
                        continue;
                    }
                    favct = favctList.get(0);
                    map = new HashMap<>();
                    map.put("fid",favct.getFid());
                    map.put("furl",favct.getFurl());
                    map.put("fname",favct.getFname());
                    map.put("fshortname",favct.getFshortname());
                    map.put("ftotal", convert2(fvw.getFtotal(),4));
                    map.put("ftotalVal", MathUtils.multiply2(fvw.getFtotal(),Double.valueOf(favct.getFopenprice()+"")));
                        if(fvw != null){
                            total += MathUtils.multiply(fvw.getFtotal(),Double.valueOf(favct.getFopenprice()+""));
                            frozen += fvw.getFfrozen();
                        }
                    list.add(map);
                }
                data.put("total", convert2(total,4));
                data.put("rmbTotal", 0.0);
            }
            data.put("walletList",list);
            return ResultModel.ok(data);
        } catch (Exception e) {
            logger.error("获取用户虚拟资金出错："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     * 删除首页消息列表，但是此操作只是修改状态不可见
     *
     * @param fid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteHomeOperateRecord", method = RequestMethod.POST)
    public ResultModel deleteHomeOperateRecord(int fid, String token) {
        //token层拦截器已经检验，此处不再检验
        Map data = new HashMap();
        try {
            Fvirtualcaptualoperation fvirtualcaptualoperation = new Fvirtualcaptualoperation();
            fvirtualcaptualoperation.setFid(fid);
            fvirtualcaptualoperation.setIshomeshow(false);
            int rows = this.fvirtualcaptualoperationService.updateByPrimaryKey(fvirtualcaptualoperation);
            if(rows < 1){
                return ResultModel.build(500,"数据异常");
            }
            return ResultModel.ok(data);
        } catch (Exception e) {
            logger.error("跟更新app首页操作记录失败："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCoinOperateHomeList", method = RequestMethod.POST)
    public ResultModel getCoinOperateHomeList(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            Integer status,
            Integer type,
            String token) {
        Map map = null;
        List<Map> responseList = new ArrayList<>();
        Map data = new HashMap<>();
        List<Integer> typeList = new ArrayList();
        try {
            if(type == 0){
                typeList.add(1);
                typeList.add(2);
            }else{
                typeList.add(type);
            }
            User user = userService.queryUser(token);
            List<Fvirtualcaptualoperation> fvirtualcaptualoperations = fvirtualcaptualoperationService.selectByExample(user.getFid(),status,null,typeList,false,currentPage,pageSize);
            PageInfo<Fvirtualcaptualoperation> pageInfo = new PageInfo<>(fvirtualcaptualoperations);
            data.put("totalCount",pageInfo.getTotal());
            Fvirtualcointype fvct = null;
            for(Fvirtualcaptualoperation fvco : fvirtualcaptualoperations){
                fvct = this.virtualCoinService.selectByPrimaryKey(fvco.getFviFid2());
                map = new HashMap();
                map.put("fid",fvco.getFid());
                map.put("famount",convert2(fvco.getFamount(),8));
                map.put("ftype",fvco.getFtype());
                map.put("fstatus",fvco.getFstatus());
                map.put("fcreatetime",fvco.getFcreatetime());
                map.put("ffees",fvco.getFfees());
                map.put("coinName",fvct.getFshortname());
                map.put("tradeuniquenumber",fvco.getFtradeuniquenumber());
                map.put("blocknumber",fvco.getBlockindex());
                map.put("fconfirmations",fvco.getFconfirmations()+"项确认");
                if(fvco.getFtype() == 1){//此时自己为收款方
                    map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvco));
                    map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvco));
                }else{
                    map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvco));
                    map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvco));
                }
                responseList.add(map);
            }
            data.put("responseList",responseList);
            return ResultModel.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取用户充提币操作记录错误："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCoinOperateList", method = RequestMethod.POST)
    public ResultModel getCoinOperateList(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            Integer status,
            Integer type,
            String token) {
        Map map = null;
        List<Map> responseList = new ArrayList<>();
        Map data = new HashMap<>();
        List<Integer> typeList = new ArrayList();
        try {
            if(type == 0){
                typeList.add(1);
                typeList.add(2);
            }else{
                typeList.add(type);
            }
            User user = userService.queryUser(token);
            List<Fvirtualcaptualoperation> fvirtualcaptualoperations = fvirtualcaptualoperationService.selectByExample(user.getFid(),status,null,typeList,true,currentPage,pageSize);
            PageInfo<Fvirtualcaptualoperation> pageInfo = new PageInfo<>(fvirtualcaptualoperations);
            data.put("totalCount",pageInfo.getTotal());
            Fvirtualcointype fvct = null;
            for(Fvirtualcaptualoperation fvco : fvirtualcaptualoperations){
                fvct = this.virtualCoinService.selectByPrimaryKey(fvco.getFviFid2());
                map = new HashMap();
                map.put("fid",fvco.getFid());
                map.put("famount",convert2(fvco.getFamount(),8));
                map.put("ftype",fvco.getFtype());
                map.put("fstatus",fvco.getFstatus());
                map.put("fcreatetime",fvco.getFcreatetime());
                map.put("ffees",fvco.getFfees());
                map.put("coinName",fvct.getFshortname());
                map.put("tradeuniquenumber",fvco.getFtradeuniquenumber());
                map.put("fconfirmations",fvco.getFconfirmations()+"项确认");
                map.put("blocknumber","");
                if(fvco.getFtype() == 1){//此时自己为收款方
                    map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvco));
                    map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvco));
                }else{
                    map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvco));
                    map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvco));
                }
                responseList.add(map);
            }
            data.put("responseList",responseList);
            return ResultModel.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取用户充提币操作记录错误："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     * 用户充提币操作记录 0 所有 1 充值 2提现
     *
     * @param symbol
     * symbol = 表示查询所有币种
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCoinOperateDetail", method = RequestMethod.POST)
    public ResultModel getCoinOperateDetail(
            @RequestParam("symbol") Integer symbol,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            Integer status,
            String token) {
        Map map = null;
        List<Map> responseList = new ArrayList<>();
        Map dataMap = new HashMap<>();
        List<Integer> typeList = new ArrayList();
        try {
            typeList.add(1);
            typeList.add(2);
            User user = userService.queryUser(token);
            List<Fvirtualcaptualoperation> fvirtualcaptualoperations = fvirtualcaptualoperationService.selectByExample(user.getFid(),status,symbol,typeList,true,currentPage,pageSize);
            PageInfo<Fvirtualcaptualoperation> pageInfo = new PageInfo<>(fvirtualcaptualoperations);
            dataMap.put("totalCount",pageInfo.getTotal());
            for(Fvirtualcaptualoperation fvco : fvirtualcaptualoperations){
                map = new HashMap();
                map.put("fid",fvco.getFid());
                map.put("famount",convert2(fvco.getFamount(),8));
                map.put("ftype",fvco.getFtype());
                map.put("fstatus",fvco.getFstatus());
                map.put("fcreatetime",fvco.getFcreatetime());
                map.put("ffees",fvco.getFfees());
                map.put("fconfirmations",fvco.getFconfirmations()+"项确认");
                String tradeuniquenumber = fvco.getFtradeuniquenumber();
                if(!StringUtils.isEmpty(tradeuniquenumber) && tradeuniquenumber.indexOf("-") > -1){
                    tradeuniquenumber = tradeuniquenumber.substring(0,tradeuniquenumber.indexOf("-"));
                }
                map.put("tradeuniquenumber",tradeuniquenumber);
                map.put("blocknumber",fvco.getBlockindex());
                if(fvco.getFtype() == 1){//此时自己为收款方
                    map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvco));
                    map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvco));
                }else{
                    map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvco));
                    map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvco));
                }
                responseList.add(map);
            }
            dataMap.put("tradeList",responseList);
            Fvirtualcointype fvct = this.virtualCoinService.selectByPrimaryKey(symbol);
            dataMap.put("walletName",fvct.getFshortname());
            Fvirtualwallet fvirtualwallet = fvirtualwalletService.selectFvirtualwallet(user.getFid(),symbol);
            dataMap.put("ftotal", convert2(fvirtualwallet.getFtotal(),8));
            dataMap.put("ftotalVal", MathUtils.multiply2(fvirtualwallet.getFtotal(),Double.valueOf(fvct.getFopenprice()+"")));
            dataMap.put("coinLogo",fvct.getFurl());
            return ResultModel.ok(dataMap);
        } catch (Exception e) {
            logger.error("获取用户充提币操作记录错误："+e);
            return ResultModel.build(500,"数据异常");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/findCoinOperateDetailById", method = RequestMethod.POST)
    public ResultModel getCoinOperateDetailById(Integer fid,String token) {
        Map map = new HashMap<>();
        try {
            Fvirtualcaptualoperation fvco = this.fvirtualcaptualoperationService.selectByPrimaryKey(fid);
            map.put("fid",fvco.getFid());
            map.put("famount",convert2(fvco.getFamount(),8));
            map.put("ftype",fvco.getFtype());
            map.put("fstatus",fvco.getFstatus());
            map.put("fcreatetime",fvco.getFcreatetime());
            map.put("ffees",fvco.getFfees());
            map.put("fconfirmations",fvco.getFconfirmations()+"项确认");
            map.put("isSystemAccount",fvco.getIsSystemAccount() ? 1 : 2);
            String tradeuniquenumber = fvco.getFtradeuniquenumber();
            if(!StringUtils.isEmpty(tradeuniquenumber) && tradeuniquenumber.indexOf("-") > -1){
                tradeuniquenumber = tradeuniquenumber.substring(0,tradeuniquenumber.indexOf("-"));
            }
            Fvirtualcointype fvct = this.virtualCoinService.selectByPrimaryKey(fvco.getFviFid2());
            map.put("tradeuniquenumber",tradeuniquenumber);
            map.put("findTradeDetailUrl",fvct.getFintrourl()+tradeuniquenumber);
            map.put("blocknumber",fvco.getBlockindex());

            if(fvco.getFtype() == 1){//此时自己为收款方
                map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvco));
                map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvco));
            }else{
                map.put("receiveaddress",this.fvirtualcaptualoperationService.getTradeToAddress(fvco));
                map.put("sendtoaddress",this.fvirtualcaptualoperationService.getTradeAddress(fvco));
            }

            if(fvct != null){
                map.put("fshortname",fvct.getFshortname());
            }else{
                map.put("fshortname","");
            }
            return ResultModel.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取交易记录错误："+e);
            return ResultModel.build(500,"数据异常");
        }
    }


    /**
     * 虚拟币提现接口，返回提钱包金额
     *
     * @param symbol
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getOutBtcAddress", method = RequestMethod.POST)
    public ResultModel getOutBtcAddress(@RequestParam("symbol") int symbol, String token) {
        Map data = new HashMap<>();
        try {
            User user = userService.queryUser(token);
            Fvirtualwallet fvirtualwallet = this.fvirtualwalletService.selectFvirtualwallet(user.getFid(),symbol);
            data.put("total", fvirtualwallet == null ? 0 : fvirtualwallet.getFtotal());
            data.put("frozen", fvirtualwallet == null ? 0 : fvirtualwallet.getFfrozen());
            Fvirtualcointype fvct = this.virtualCoinService.selectByPrimaryKey(symbol);
            data.put("fopenprice",fvct.getFopenprice());
            Fees fees = this.feesService.selectFees(symbol);
            if(fees == null){
                return  ResultModel.build(500,"数据异常");
            }
            data.put("symbol",fees.getSymbol());
            data.put("minfees",fees.getMinfees());
            data.put("maxfees",fees.getMaxfees());
            data.put("unit",fees.getUnit());
            data.put("rate",fees.getRate());
            return ResultModel.ok(data);
        } catch (Exception e) {
            logger.error("返回虚拟币提现地址出错："+e);
            return ResultModel.build(500,"数据异常");
        }
    }

    /**
     * 提现申请
     *
     * @param address
     * @param withdrawAmount
     * @param tradePassword
     * @param symbol
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/withdrawBtc", method = RequestMethod.POST)
    public ResultModel withdrawBtcSubmit(@RequestParam(value = "address", required = true) String address,
                                         @RequestParam(value = "withdrawAmount", required = true) double withdrawAmount,
                                         @RequestParam(value = "tradePassword", required = false, defaultValue = "0") String tradePassword,
                                         @RequestParam(value = "fees", required = false, defaultValue = "0") String fees,
                                         @RequestParam(value = "symbol", required = true) int symbol,
                                         @RequestParam(value = "remarks", required = false, defaultValue = "null")String remarks ,
                                        String token) throws Exception {
        try {
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
            Double minbtcWithdraw = Double.parseDouble(this.commonParamsService.getValue(ConstantKeys.MIN_VIRTUAL_WITHDRAW));
            Double maxbtcWithdraw = Double.parseDouble(this.commonParamsService.getValue(ConstantKeys.MAX_VIRTUAL_WITHDRAW));
            //最少提现0.1
            if (withdrawAmount < minbtcWithdraw) {
                return ResultModel.build(403,"不能小于最小值"+minbtcWithdraw);
            }
            if (withdrawAmount > maxbtcWithdraw) {
                return ResultModel.build(403,"不能大于最大值"+maxbtcWithdraw);
            }
            Fvirtualwallet fvirtualwallet = fvirtualwalletService.selectFvirtualwallet(user.getFid(),symbol);
            //余额不足
            if (Double.valueOf(fvirtualwallet.getFtotal().toString()) < withdrawAmount) {
                return ResultModel.build(403,"余额不足");
            }
            int time = this.fvirtualcaptualoperationService.getTodayVirtualCoinWithdrawTimes(user.getFid());
            String times = commonParamsService.getValue(ConstantKeys.DAY_DRAW_COIN_TIMES);
            if (StringUtils.hasText(times) && time >= Integer.valueOf(times)) {
                return ResultModel.build(403,"超出了当天提现次数"+times);
            }
            Fvirtualaddress fva = this.fvirtualaddressService.selectFvirtualAddress(user.getFid(),fvirtualcointype.getParentid());
            String userAddress =  fva.getFadderess();
            this.virtualCoinService.updateWithdrawBtc(address, fvirtualcointype, fvirtualwallet, withdrawAmount, user.getFid(),remarks,userAddress,Double.valueOf(fees),false);
            return ResultModel.ok();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("虚拟币转出错误");
            return ResultModel.build(500,"数据异常");
        }
    }


}
