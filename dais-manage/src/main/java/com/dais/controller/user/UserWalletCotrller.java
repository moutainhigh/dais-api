package com.dais.controller.user;

import com.common.pojo.ResultModel;
import com.dais.controller.BaseController;
import com.dais.mapper.CommonMapper;
import com.dais.mapper.FvirtualwalletMapper;
import com.dais.model.Fvirtualwallet;
import com.dais.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxp
 * @version 2017- 09- 20 14:52
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/wallet")
public class UserWalletCotrller extends BaseController {

    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private FvirtualwalletMapper fvirtualwalletMapper;

    @RequestMapping("/walletlist")
    public String walletlist(){
        return "/wallet/walletlist";
    }

    @RequestMapping("/getWalletList")
    @ResponseBody
    public ResultModel getWalletList(int start,int limit,String search){
        Map map = new HashMap<>();
        String baseSql = "SELECT tt.* from (SELECT t.*,u.freal_name,u.flogin_name,u.fnick_name from  " +
                "(SELECT w.fid,w.fVi_fId,w.fTotal,w.fuid,w.fLastUpdateTime,w.fFrozen ,c.fname,c.fshortname " +
                "from fvirtualwallet w ,fvirtualcointype c where w.fVi_fId=c.fid) t,  user u " +
                "where t.fuid=u.fid) tt ";
        String whereSql = "";
        if(!StringUtils.isEmpty(search)){
            String likeContent = " like '%"+search+"%' ";
            StringBuffer sb = new  StringBuffer();
            sb.append(" where tt.freal_name"+likeContent);
            sb.append("or tt.flogin_name" +likeContent);
            sb.append("or tt.fnick_name"+likeContent);
            sb.append("or tt.fname"+likeContent);
            sb.append("or tt.fshortname"+likeContent);
            whereSql = sb.toString();
        }
        int begin = (start-1)*limit;
        String pageSql = " limit "+begin+","+limit;

        List list = this.commonMapper.getList(baseSql+ whereSql + pageSql);
        String countSql = "select count(0) from ("+baseSql+ whereSql+") m";
        int total = this.commonMapper.count(countSql);
        map.put("list",list);
        map.put("total",total);
        return ResultModel.ok(map);
    }

    @RequestMapping("/updateWallet")
    @ResponseBody
    public ResultModel updateWallet(@RequestBody Fvirtualwallet fvirtualwallet){
        int rows = this.fvirtualwalletMapper.updateByPrimaryKeySelective(fvirtualwallet);
        if(rows >0){
            return ResultModel.ok();
        }else{
            return ResultModel.build(500,"数据也异常");
        }
    }


}
