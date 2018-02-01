package com.dais.controller.user;

import com.common.pojo.ResultModel;
import com.dais.controller.BaseController;
import com.dais.mapper.AccountMapper;
import com.dais.mapper.CommonMapper;
import com.dais.mapper.FvirtualwalletMapper;
import com.dais.model.Account;
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
@RequestMapping("/account")
public class AccountCotrller extends BaseController {

    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("/accountlist")
    public String accountlist(){
        return "/account/accountlist";
    }

    @RequestMapping("/optionlist")
    public String optionlist(){
        return "/account/optionlist";
    }

    @RequestMapping("/getAccountList")
    @ResponseBody
    public ResultModel getAccountList(int start,int limit,String search){
        Map map = new HashMap<>();
        String baseSql = "SELECT t.* from (SELECT f.*,v.fname,v.fshortname  from fvirtualcointype v ," +
                "(SELECT a.id,a.symbol,a.total,a.update_time,u.freal_name,u.flogin_name,u.fnick_name " +
                " from account a,user u where a.userid=u.fid) f where f.symbol=v.fid) t";
        String whereSql = "";
        if(!StringUtils.isEmpty(search)){
            String likeContent = " like '%"+search+"%' ";
            StringBuffer sb = new  StringBuffer();
            sb.append(" where t.freal_name"+likeContent);
            sb.append("or t.flogin_name" +likeContent);
            sb.append("or t.fnick_name"+likeContent);
            sb.append("or t.fname"+likeContent);
            sb.append("or t.fshortname"+likeContent);
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

    @RequestMapping("/getOptionList")
    @ResponseBody
    public ResultModel getOptionList(int start,int limit,String search){
        Map map = new HashMap<>();
        String baseSql = "SELECT tt.* from (SELECT m.*,u.freal_name,u.flogin_name from user u," +
                "(SELECT a.id,a.userid,a.title,a.createTime,a.amount,a.fees,a.type," +
                "a.touserid,a.remarks,f.fname,f.fshortname  " +
                "from accountoperation a,fvirtualcointype f where a.symbol=f.fid) m where m.userid=u.fid) tt";
        String whereSql = "";
        if(!StringUtils.isEmpty(search)){
            String likeContent = " like '%"+search+"%' ";
            StringBuffer sb = new  StringBuffer();
            sb.append(" where tt.freal_name"+likeContent);
            sb.append("or tt.title"+likeContent);
            sb.append("or tt.flogin_name" +likeContent);
            sb.append("or tt.fname"+likeContent);
            sb.append("or tt.fshortname"+likeContent);
            whereSql = sb.toString();
        }
        whereSql = whereSql+" order by tt.createtime desc";
        int begin = (start-1)*limit;
        String pageSql = " limit "+begin+","+limit;

        List list = this.commonMapper.getList(baseSql+ whereSql + pageSql);
        String countSql = "select count(0) from ("+baseSql+ whereSql+") m";
        int total = this.commonMapper.count(countSql);
        map.put("list",list);
        map.put("total",total);
        return ResultModel.ok(map);
    }

    @RequestMapping("/updateAccount")
    @ResponseBody
    public ResultModel updateAccount(@RequestBody Account account){
        int rows = this.accountMapper.updateByPrimaryKeySelective(account);
        if(rows >0){
            return ResultModel.ok();
        }else{
            return ResultModel.build(500,"数据也异常");
        }
    }


}
