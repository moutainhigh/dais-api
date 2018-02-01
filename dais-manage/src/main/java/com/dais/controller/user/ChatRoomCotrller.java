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
@RequestMapping("/chatroom")
public class ChatRoomCotrller extends BaseController {

    @Autowired
    private CommonMapper commonMapper;

    @RequestMapping("/msglist")
    public String msglist(){
        return "/chatroom/msglist";
    }

    @RequestMapping("/getMsglist")
    @ResponseBody
    public ResultModel getMsglist(int start,int limit,String search){
        Map map = new HashMap<>();
        String baseSql = "SELECT * from (SELECT c.id,c.userid,c.createtime,c.content," +
                " c.msg_type,u.fnick_name,u.freal_name,u.fhead_img_url,u.flogin_name " +
                " from chatroommsg c , user u where c.userid=u.fid) t ";
        String whereSql = "";
        if(!StringUtils.isEmpty(search)){
            String likeContent = " like '%"+search+"%' ";
            StringBuffer sb = new  StringBuffer();
            sb.append(" where t.freal_name"+likeContent);
            sb.append("or t.flogin_name" +likeContent);
            sb.append("or t.fnick_name"+likeContent);
            sb.append("or t.content"+likeContent);
            whereSql = sb.toString();
        }
        whereSql = whereSql+" order by t.createtime desc";
        int begin = (start-1)*limit;
        String pageSql = " limit "+begin+","+limit;

        List list = this.commonMapper.getList(baseSql+ whereSql + pageSql);
        String countSql = "select count(0) from ("+baseSql+ whereSql+") m";
        int total = this.commonMapper.count(countSql);
        map.put("list",list);
        map.put("total",total);
        return ResultModel.ok(map);
    }


}
