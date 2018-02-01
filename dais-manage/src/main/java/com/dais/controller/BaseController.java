package com.dais.controller;

import com.common.pojo.ResultModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;

/**
 * @author GanZhen
 * @version 2017- 03- 08 15:02
 * @description Controller的基类，提供一些通用的功能
 * @copyright www.dais.com
 */
@Controller
public class BaseController {

    @Autowired
    protected MessageSource messageSource;

    /**
     * 判断是否为jsonp调用
     * @param result
     * @param callback
     * @return
     */
    protected Object judgeCallback(ResultModel result , String callback){
        if (StringUtils.isBlank(callback)) {
            return result;
        } else {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
    }

}
