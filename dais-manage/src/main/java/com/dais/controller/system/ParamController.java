package com.dais.controller.system;

import com.common.pojo.ResultModel;
import com.dais.controller.BaseController;
import com.dais.model.CommonParams;
import com.dais.service.CommonParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GanZhen
 * @version 2017- 09- 04 17:21
 * @description
 * @copyright www.zhgtrade.com
 */
@RequestMapping("/param")
@Controller
public class ParamController extends BaseController{

    @RequestMapping("/paramlist")
    public String index(){
        return "/system/paramlist";
    }

    @Autowired
    private CommonParamsService commonParamsService;

    @RequestMapping("/getParam")
    @ResponseBody
    public ResultModel getParam(int start,int limit,String search){
        return commonParamsService.getParams(start, limit, search);
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResultModel save(@RequestBody CommonParams commonParams){
        if(commonParams == null){
            return ResultModel.build(403,"数据异常");
        }
        if(commonParams.getId() == null){
          return commonParamsService.insert(commonParams);
        }else{
            return commonParamsService.update(commonParams);
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultModel delete(Integer id){
        if(id == null){
            return ResultModel.build(403,"数据异常");
        }
      return commonParamsService.delete(id);
    }


}
