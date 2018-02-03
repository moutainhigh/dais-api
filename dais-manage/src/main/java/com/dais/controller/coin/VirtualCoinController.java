package com.dais.controller.coin;

import com.common.constant.FilePathConstant;
import com.common.model.BTCMessage;
import com.common.pojo.ResultModel;
import com.common.utils.BTCUtils;
import com.common.utils.CollectionUtils;
import com.common.utils.Utils;
import com.dais.controller.BaseController;
import com.dais.mapper.CommonMapper;
import com.dais.mapper.FvirtualcointypeMapper;
import com.dais.model.*;
import com.dais.service.AddressPoolService;
import com.dais.service.FeesService;
import com.dais.service.VirtualCoinService;
import com.dais.utils.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xxp
 * @version 2017- 08- 18 21:04
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/virtualCoin")
public class VirtualCoinController extends BaseController {

    private Map processCoinAddressLockMap = new HashMap<>();	// 项目生成地址锁池
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private FvirtualcointypeMapper fvirtualcointypeMapper;
    @Autowired
    private AddressPoolService addressPoolService;
    @Autowired
    private FeesService feesService;
    @Autowired
    private CommonMapper commonMapper;

    @RequestMapping("/coinlist")
    public String index(){
        return "/virtualCoin/coinlist";
    }

    @RequestMapping("/poollist")
    public String poollist(){
        return "/virtualCoin/poollist";
    }

    @RequestMapping("/getCoinList")
    @ResponseBody
    public ResultModel getCoinList(int start,int limit,String search){
        return virtualCoinService.getParams(start, limit, search);
    }



    @RequestMapping(value = "/uploadpic")
    @ResponseBody
    public ResultModel uploadAuthImage(@RequestParam(value = "img") MultipartFile multipartFile) throws IOException {
        if(null == multipartFile){
            // 上传文件不存在
            return ResultModel.build(101,"上传文件不存在");
        }else if(multipartFile.getSize() > 3 * 1024 * 1024){
            // 上传文件过大
            return ResultModel.build(102,"上传文件超过3M");
        }else{
            byte[] bytes = multipartFile.getBytes();
            if(!Utils.isImage(bytes)){
                // 不是有效图片文件
                return ResultModel.build(103,"不是有效图片文件");
            }else{
                String ext = Utils.getFilenameExtension(multipartFile.getOriginalFilename());
                String filePath = FilePathConstant.others + Utils.getRelativeFilePath(ext, bytes, new Random().nextInt(10000));
                boolean flag = Utils.uploadFileToOss(multipartFile.getInputStream(), filePath);
                if(flag){
                    return ResultModel.ok(filePath);
                }else{
                    // 上传失败
                    return ResultModel.build(500,"上传失败");
                }
            }
        }
    }

    @RequestMapping("/saveUpdate")
    @ResponseBody
    public ResultModel saveUpdate(@RequestBody Fvirtualcointype fvirtualcointype){
        int count = 0;
        int parentId = fvirtualcointype.getParentid();
        if(parentId == 0){
            fvirtualcointype.setParentid(fvirtualcointype.getFid());
        }
        if(fvirtualcointype.getFid() == null){
            fvirtualcointype.setFaddtime(com.dais.utils.Utils.getTimestamp());
            count = this.fvirtualcointypeMapper.insertSelective(fvirtualcointype);
            if(parentId == 0){
                fvirtualcointype.setParentid(fvirtualcointype.getFid());
                this.fvirtualcointypeMapper.updateByPrimaryKeySelective(fvirtualcointype);
            }
        }else{
            count = this.fvirtualcointypeMapper.updateByPrimaryKeySelective(fvirtualcointype);
        }
        if(count > 0){
            return ResultModel.ok();
        }else{
            return ResultModel.build(500,"数据异常");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultModel delete(int id){
        int count = this.fvirtualcointypeMapper.deleteByPrimaryKey(id);
        if(count > 0){
            return ResultModel.ok();
        }else{
            return ResultModel.build(500,"数据异常");
        }
    }


    @RequestMapping("/feeslist")
    public ModelAndView FeesIndex(){
        ModelAndView view = new ModelAndView("/virtualCoin/feeslist");
        List<Fees> feess = this.feesService.selectFees();
        List<Integer> list = new ArrayList<>();
        for (Fees fees : feess) {
            list.add(fees.getSymbol());
        }
        FvirtualcointypeExample example = new FvirtualcointypeExample();
        example.createCriteria().andFidNotIn(list);
        List<Fvirtualcointype> fvirtualcointypes = this.virtualCoinService.selectByExample(example);
        if(CollectionUtils.isEmpty(fvirtualcointypes)){
            fvirtualcointypes = null;
        }
        view.addObject("coinList",fvirtualcointypes);
        return view;
    }

    @RequestMapping("/getFeesList")
    @ResponseBody
    public ResultModel getFeesList(int start,int limit,String search){
        return feesService.selectFees(start, limit, search);
    }

    @RequestMapping("/saveFees")
    @ResponseBody
    public ResultModel saveFees(@RequestBody Fees fees){
        int rows = 0;
        if(StringUtils.isEmpty(fees.getId())){
            rows = feesService.insert(fees);
        }else{
            rows = feesService.update(fees) ;
        }
        if(rows > 0){
            return ResultModel.ok();
        }
        return ResultModel.build(500,"数据异常");
    }


    @RequestMapping("/getPoolList")
    @ResponseBody
    public ResultModel getAccountList(int start,int limit,String search){
        Map map = new HashMap<>();
        String baseSql = "SELECT t.*,a.fName,a.fShortName,a.fId,a.furl from \n" +
                "(SELECT v.fName,v.fShortName,v.fId,v.furl from fvirtualcointype v where v.fId=v.parentid and v.FIsWithDraw=1) a LEFT JOIN\n" +
                "(SELECT COUNT(0) as count,fvi_type from \n" +
                "(SELECT fvi_type,fstatus from fpool where fstatus=0) k GROUP BY k.fvi_type) t \n" +
                "on t.fvi_type=a.fid";
        int begin = (start-1)*limit;
        String pageSql = " limit "+begin+","+limit;
        List list = this.commonMapper.getList(baseSql + pageSql);
        String countSql = "select count(0) from ("+baseSql+ pageSql+") m";
        int total = this.commonMapper.count(countSql);
        map.put("list",list);
        map.put("total",total);
        return ResultModel.ok(map);
    }


    @RequestMapping("/createWalletAddress")
    @ResponseBody
    public ResultModel createWalletAddress(Integer uid,String passWord) throws Exception{
        Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(uid);

        if(processCoinAddressLockMap.containsKey(uid)){
            return ResultModel.build(403,"正在生成虚拟地址!");
        }

        if(!fvirtualcointype.getFiswithdraw()){
            return ResultModel.build(403,"不允许充值和提现的虚拟币类型不能生成虚拟地址!");
        }
        BTCMessage btcMessage = new BTCMessage() ;
        btcMessage.setACCESS_KEY(fvirtualcointype.getFaccessKey()) ;
        btcMessage.setIP(fvirtualcointype.getFip()) ;
        btcMessage.setPORT(fvirtualcointype.getFport()) ;
        btcMessage.setSECRET_KEY(fvirtualcointype.getFsecrtKey()) ;
        btcMessage.setPASSWORD(passWord);
        if(btcMessage.getACCESS_KEY()==null
                ||btcMessage.getIP()==null
                ||btcMessage.getPORT()==null
                ||btcMessage.getSECRET_KEY()==null){
            return ResultModel.build(403,"钱包连接失败，请检查配置信息");
        }

        BTCUtils btcUtils = new BTCUtils(btcMessage);
        try {
            btcUtils.getbalanceValue();
        } catch (Exception e) {
            return ResultModel.build(403,"钱包连接失败，请检查配置信息");
        }

        // 生成地址上锁
        processCoinAddressLockMap.put(uid, true);

        new Thread(() -> {
            int count = 5;
            try {
                for(int i=0;i<count;i++){
                    String address = btcUtils.getNewaddressValueForAdmin(UUID.randomUUID().toString());
                    if(address == null || address.trim().length() ==0){
                        System.err.println("链接钱包，获取" + fvirtualcointype.getFname() + "地址受限！");
                        break;
                    }
                    System.out.println(address);
                    AddressPool addressPool = new AddressPool();
                    addressPool.setFaddress(address);
                    System.out.println("address:"+address);
                    addressPool.setFviType(uid);
                    addressPool.setFstatus(0);
                    addressPool.setVersion(0);
                    addressPoolService.insertAddressPool(addressPool);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    btcUtils.walletlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                processCoinAddressLockMap.remove(uid);
            }
        }).start();

        return ResultModel.ok("正在生成虚拟地址!");
    }



    @RequestMapping("/testWalletConnect")
    @ResponseBody
    public ResultModel testWalletConnect(Integer id) throws Exception{
        Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(id);

        if(!fvirtualcointype.getFiswithdraw()){
            return ResultModel.ok("该币种钱包暂时不能测试!");
        }
        BTCMessage btcMessage = new BTCMessage() ;
        btcMessage.setACCESS_KEY(fvirtualcointype.getFaccessKey()) ;
        btcMessage.setIP(fvirtualcointype.getFip()) ;
        btcMessage.setPORT(fvirtualcointype.getFport()) ;
        btcMessage.setSECRET_KEY(fvirtualcointype.getFsecrtKey()) ;
        if(btcMessage.getACCESS_KEY()==null
                ||btcMessage.getIP()==null
                ||btcMessage.getPORT()==null
                ||btcMessage.getSECRET_KEY()==null){
            return ResultModel.build(403,"钱包连接失败，请检查配置信息");
        }

        BTCUtils btcUtils = new BTCUtils(btcMessage);
        try {
            JSONObject jsonObject = btcUtils.getInfo();
            return ResultModel.ok(jsonObject.toString());
        } catch (Exception e) {
            return ResultModel.build(403,"钱包连接失败，请检查配置信息");
        }

    }
}
