package com.dais.service.impl;

import com.common.utils.CollectionUtils;
import com.dais.mapper.RongcloudUsertokenMapper;
import com.dais.model.RongcloudUsertoken;
import com.dais.model.RongcloudUsertokenExample;
import com.dais.model.User;
import com.dais.rongcloud.RongCloud;
import com.dais.rongcloud.models.CodeSuccessResult;
import com.dais.rongcloud.models.TokenResult;
import com.dais.service.RongcloudUsertokenService;
import com.dais.service.UserService;
import com.dais.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 09- 25 15:03
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class RongcloudUsertokenServiceImpl implements RongcloudUsertokenService{
    @Autowired
    private RongcloudUsertokenMapper rongcloudUsertokenMapper;
    @Autowired
    private UserService userService;

    @Value("${appKey}")
    private String appKey;
    @Value("${appSecret}")
    private String appSecret;
    private String imgUlr="http://p-dais.oss-cn-hangzhou.aliyuncs.com";

    @Override
    public String getToken(int userid) throws Exception{
        RongcloudUsertokenExample example = new RongcloudUsertokenExample();
        example.createCriteria().andUserIdEqualTo(userid);
        List<RongcloudUsertoken> rongcloudUsertokens = rongcloudUsertokenMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(rongcloudUsertokens)){
            String token = getRongCouldToken(userid);
            RongcloudUsertoken usertoken = new RongcloudUsertoken();
            usertoken.setUserId(userid);
            usertoken.setRefreshtimes(0);
            usertoken.setCreateTime(Utils.getTimestamp());
            usertoken.setToken(token);
            rongcloudUsertokenMapper.insert(usertoken);
          return getNewToken(userid);
        }
        return rongcloudUsertokens.get(0).getToken();
    }

    @Override
    public boolean refreshUserInfo(int userid) throws Exception{
        // 刷新用户信息方法
        User user = userService.findByUserId(userid);
        RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
        CodeSuccessResult userRefreshResult = rongCloud.user.refresh(user.getFid().toString(), user.getFnickName(), imgUlr+"/"+user.getFheadImgUrl());
        if (userRefreshResult != null && userRefreshResult.getCode() == 200){
            return true;
        }
        return false;
    }

    @Override
    public String getNewToken(int userid) throws Exception{
        RongcloudUsertokenExample example = new RongcloudUsertokenExample();
        example.createCriteria().andUserIdEqualTo(userid);
        List<RongcloudUsertoken> rongcloudUsertokens = rongcloudUsertokenMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(rongcloudUsertokens)){
            return null;
        }
        String token = getRongCouldToken(userid);
        RongcloudUsertoken rongcloudUsertoken = rongcloudUsertokens.get(0);
        rongcloudUsertoken.setToken(token);
        rongcloudUsertoken.setUpdateTime(Utils.getTimestamp());
        int times = rongcloudUsertoken.getRefreshtimes()+1;
        rongcloudUsertoken.setRefreshtimes(times);
        int count = rongcloudUsertokenMapper.updateByPrimaryKeySelective(rongcloudUsertoken);
        if(count >0){
            return token;
        }
        return null;
    }

    private String getRongCouldToken(int userid) throws Exception{
        User user = userService.findByUserId(userid);
        RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
        TokenResult userGetTokenResult = rongCloud.user.getToken(user.getFid().toString(), user.getFnickName(), imgUlr+"/"+user.getFheadImgUrl());
        if (userGetTokenResult != null && userGetTokenResult.getCode() == 200){
            return userGetTokenResult.getToken();
        }
        throw new Exception("获取token失败");
    }
}
