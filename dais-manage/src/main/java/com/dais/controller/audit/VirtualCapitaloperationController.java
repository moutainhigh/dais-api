package com.dais.controller.audit;

import com.common.pojo.ResultModel;
import com.dais.controller.BaseController;
import com.dais.service.FvirtualcaptualoperationService;
import com.dais.service.CaptualOperationSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xxp
 * @version 2017- 08- 18 16:15
 * @description
 * @copyright www.zhgtrade.com
 */
@Controller
@RequestMapping("/captualoperation")
public class VirtualCapitaloperationController extends BaseController{

    @Autowired
    private FvirtualcaptualoperationService fvirtualcaptualoperationService;

    @Autowired
    private CaptualOperationSyncService withdrawOperationService;

    @RequestMapping("/captualoperationlist")
    public String index(){
        return "/captualoperation/captualoperationlist";
    }

    @RequestMapping("/rechargelist")
    public String rechargelistIndex(){
        return "/captualoperation/rechargelist";
    }


    @RequestMapping("/getCaptualoperationWithdrawlist")
    @ResponseBody
    public ResultModel getCaptualoperationWithdrawlist(int start,int limit,String search){
        return withdrawOperationService.getWithdrawOperationList(start, limit, search,2);
    }
    @RequestMapping("/getCaptualoperationRechargelist")
    @ResponseBody
    public ResultModel getCaptualoperationRechargelist(int start,int limit,String search){
        return withdrawOperationService.getWithdrawOperationList(start, limit, search,1);
    }

    @RequestMapping("/goVirtualCapitaloperationChangeStatus")
    @ResponseBody
    public ResultModel goVirtualCapitaloperationChangeStatus(
            @RequestParam(required = true) int type,
            @RequestParam(required = true) int uid){
        try {
            return this.fvirtualcaptualoperationService.updateCapitaloperationChangeStatus(type, uid);
        } catch (Exception e) {
            return ResultModel.build(500,e.getMessage());
        }
    }


    @RequestMapping("/virtualCapitalOutAudit")
    @ResponseBody
    public ResultModel virtualCapitalOutAudit(Integer fid,String fpassword) {
        try {
            return this.fvirtualcaptualoperationService.updateCapitalOutAudit(fid, fpassword);
        } catch (Exception e) {
            return ResultModel.build(500,e.getMessage());
        }
    }
}
