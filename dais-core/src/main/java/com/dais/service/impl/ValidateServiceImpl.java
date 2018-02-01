package com.dais.service.impl;

import com.common.Enum.CountLimitTypeEnum;
import com.common.utils.Constants;
import com.common.utils.Utils;
import com.dais.mapper.FcountlimitMapper;
import com.dais.model.Fcountlimit;
import com.dais.model.FcountlimitExample;
import com.dais.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/11
 */
@Service
public class ValidateServiceImpl  implements ValidateService {
    @Autowired
    FcountlimitMapper fcountlimitMapper;


    //是否可以重试
    public int getLimitCount(String ip,int type){
        int maxLimit = Constants.ErrorCountLimit ;
        if(type== CountLimitTypeEnum.AdminLogin){
            maxLimit = Constants.ErrorCountAdminLimit ;
        }
        FcountlimitExample example=new FcountlimitExample();
        example.createCriteria().andFipEqualTo(ip).andFtypeEqualTo(type);

        List<Fcountlimit> list = this.fcountlimitMapper.selectByExample(example) ;
        if(list.size()==0){
            return maxLimit ;
        }else{
            Fcountlimit fcountlimit = list.get(0) ;
            if(Utils.getTimestamp().getTime()- fcountlimit.getFcreatetime().getTime()<2L*60*60*1000){
                return maxLimit - fcountlimit.getFcount() ;
            }else{
                return maxLimit ;
            }
        }
    }

    //记录一次错误记录
    public void updateLimitCount(String ip,int type){
        if(Constants.closeLimit){return;}
        FcountlimitExample example=new FcountlimitExample();
        example.createCriteria().andFipEqualTo(ip).andFtypeEqualTo(type);
        List<Fcountlimit> list = this.fcountlimitMapper.selectByExample(example) ;
        if(list.size()==0){
            Fcountlimit fcountlimit = new Fcountlimit() ;
            fcountlimit.setFcount(1) ;
            fcountlimit.setFcreatetime(Utils.getTimestamp()); ;
            fcountlimit.setFip(ip) ;
            fcountlimit.setFtype(type) ;
            this.fcountlimitMapper.insertSelective(fcountlimit) ;
        }else{
            Fcountlimit fcountlimit = list.get(0) ;
            if(Utils.getTimestamp().getTime()- fcountlimit.getFcreatetime().getTime()<2*60*60*1000L){
                fcountlimit.setFcount(fcountlimit.getFcount()+1) ;
                fcountlimit.setFcreatetime(Utils.getTimestamp()); ;
                this.fcountlimitMapper.updateByPrimaryKeySelective(fcountlimit) ;
            }else{
                fcountlimit.setFcount(1) ;
                fcountlimit.setFcreatetime(Utils.getTimestamp()); ;
                this.fcountlimitMapper.updateByPrimaryKeySelective(fcountlimit) ;
            }
        }
    }

    public void deleteCountLimite(String ip,int type){
        FcountlimitExample example=new FcountlimitExample();
        example.createCriteria().andFipEqualTo(ip).andFtypeEqualTo(type);
        List<Fcountlimit> list = this.fcountlimitMapper.selectByExample(example) ;
        for(int i=0;i<list.size();i++){
            this.fcountlimitMapper.deleteByPrimaryKey(list.get(i).getFid()) ;
        }
    }
}
