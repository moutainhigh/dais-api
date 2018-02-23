package com.dais.service.impl;

import com.common.constant.FilePathConstant;
import com.common.pojo.ResultModel;
import com.common.utils.*;
import com.common.utils.Utils;
import com.dais.mapper.FvirtualcointypeMapper;
import com.dais.mapper.UserMapper;
import com.dais.model.*;
import com.dais.service.CommonParamsService;
import com.dais.service.FvirtualaddressService;
import com.dais.service.FvirtualwalletService;
import com.dais.service.UserService;
import com.dais.utils.*;
import com.dais.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

import static com.common.utils.HashUtil.encodePassword;

/**
 * @author xxp
 * @version 2017- 08- 08 20:54
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private CommonParamsService commonParamsService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private FvirtualaddressService fvirtualaddressService;

    @Autowired
    private FvirtualcointypeMapper fvirtualcointypeMapper;

    @Autowired
    private FvirtualwalletService fvirtualwalletService;

    @Value("${REGISTER_CODE_KEY}")
    private String REGISTER_CODE_KEY;
    @Value("${REGISTER_CODE_EXPIRE}")
    private Integer REGISTER_CODE_EXPIRE;

    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;
    @Value("${SSO_SESSION_EXPIRE}")
    private Integer SSO_SESSION_EXPIRE;


    @Override
    public ResultModel createUser(User user, String authCode) {
        String loginName = user.getFloginName();
        String md5Password = encodePassword(user.getFloginPassword());

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andFloginNameEqualTo(loginName);
        List<User> users = userMapper.selectByExample(example);
        if(users != null && users.size() > 0){
            return ResultModel.build(403,"手机号码已被注册");
        }
        String serverCode = jedisClient.get(REGISTER_CODE_KEY + ":" + user.getFloginName());
        if(authCode != null && !authCode.equals(serverCode)){
            return ResultModel.build(403,"验证码错误");
        }

        if(user.getFnickName() == null){
            user.setFnickName("d_"+user.getFloginName().substring(7));
        }
        user.setFtelePhone(loginName);
        user.setFregisterTime(new Date());
        //md5加密
        user.setFloginPassword(md5Password);
        user.setHasPayPwd(false);
        user.setFpostRealValidate(false);
        user.setFisMailValidate(false);
        user.setFisTelephoneBind(true);
        user.setFhasRealValidate(false);
        user.setMemWords(MemWordsUtil.createMemWords());
        userMapper.insertSelective(user);


        users = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(users)){
            return ResultModel.build(500,"数据异常");
        }
        /*//为用户生成比特币钱包和以太坊钱包
        List<Fvirtualcointype> fcctList = fvirtualcointypeMapper.selectByExample(new FvirtualcointypeExample());
        for(Fvirtualcointype fvirtualcointype : fcctList) {
            if(!"ETH".equals(fvirtualcointype.getFshortname()) && !"BTC".equals(fvirtualcointype.getFshortname()))
                continue;
            try {
                fvirtualaddressService.updateAssignWalletAddress(users.get(0).getFid(),fvirtualcointype.getFid());
                fvirtualwalletService.insertFvirtualwallet(users.get(0).getFid(),fvirtualcointype.getFid());
            } catch (Exception e) {
                e.printStackTrace();
                return ResultModel.build(500,"数据异常");
            }
        }*/

        return ResultModel.ok();
    }


    @Override
    public ResultModel updateWallatOrAddress(Integer userid, Integer symbol,String type) throws Exception {
        //type is open or off
        try {
            Fvirtualwallet fvirtualwallet = fvirtualwalletService.selectFvirtualwallet(userid,symbol);
            if("off".equals(type)){//钱包存在时的关闭开关
                if(fvirtualwallet != null && fvirtualwallet.getIshow()){
                    fvirtualwallet.setIshow(false);
                    fvirtualwalletService.updateFvirtualwallet(fvirtualwallet);
                    return ResultModel.ok();
                }
                return ResultModel.build(403,"无效的操作");
            }

            if("open".equals(type)){
                if(fvirtualwallet != null){
                    if(!fvirtualwallet.getIshow()){
                        fvirtualwallet.setIshow(true);
                        fvirtualwalletService.updateFvirtualwallet(fvirtualwallet);
                        return ResultModel.ok();
                    }
                    return ResultModel.build(403,"无效的操作");
                }
                //下面情况说明用户还没有创建钱包
                Fvirtualcointype fvirtualcointype = this.fvirtualcointypeMapper.selectByPrimaryKey(symbol);
                Fvirtualaddress fvirtualaddress = fvirtualaddressService.selectFvirtualAddress(userid,fvirtualcointype.getParentid());
                if(fvirtualaddress == null){
                    fvirtualaddressService.updateAssignWalletAddress(userid,symbol);
                }
                fvirtualwalletService.insertFvirtualwallet(userid,symbol);
                return ResultModel.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return ResultModel.build(403,"无效的操作");
    }


    @Override
    public ResultModel getUserList(int start, int limit, String search) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = new UserExample().createCriteria();
        if(org.apache.commons.lang.StringUtils.isNotBlank(search)){
            criteria.andFnickNameLike("%"+search+"%");
            example.or(criteria);
            criteria = new UserExample().createCriteria();
            criteria.andFloginNameLike("%"+search+"%");
            example.or(criteria);
            criteria = new UserExample().createCriteria();
            criteria.andFrealNameLike("%"+search+"%");
            example.or(criteria);
        }
        PageHelper.startPage(start, limit);
        example.setOrderByClause(" fregister_time desc");
        List<User> paramList = this.userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<>(paramList);
        return ResultModel.build(200, "OK", pageInfo);
    }

    @Override
    public ResultModel userLogin(String phone, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andFloginNameEqualTo(phone);
        List<User> list = userMapper.selectByExample(example);
        //如果没有此用户名
        if (CollectionUtils.isEmpty(list)) {
            return ResultModel.build(400, "用户名不存在");
        }
        User user = list.get(0);
        for (User nowUser : list) {
            if (nowUser.getWalletStatus() == 1){
                user = nowUser;
                break;
            }
        }
        //说明所有钱包已禁用
        if (user == null){
            user = list.get(0);
        }

        //比对密码
        if (!encodePassword(password).equals(user.getFloginPassword())){
            return ResultModel.build(400, "手机号或密码错误");
        }

        //清除原来的token，保证mysql中的token和redis中的一直，并且只能同时存在一个用户登录
        this.removeUserByToken(user.getToken());
        //生成token
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        this.updateUser(user,token);
        return ResultModel.ok(token);
    }

    @Override
    public ResultModel getUserByToken(String token) {
        //根据token从redis中查询用户信息
        String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
        //判断是否为空
        if (StringUtils.isBlank(json)) {
            return ResultModel.build(400, "此session已经过期，请重新登录");
        }
        //更新过期时间
        jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);

//        拼接前端需要的信息
        User user = JsonUtils.jsonToPojo(json, User.class);

        //返回用户信息
        return ResultModel.ok(user);
    }

    @Override
    public ResultModel removeUserByToken(String token) {
        //根据token从redis中查询用户信息
        jedisClient.del(REDIS_USER_SESSION_KEY + ":" + token);
        return ResultModel.build(200, "OK");
    }

    @Override
    public ResultModel sendAuthenticationCode(String phone) {

        if(phone != null){
            int authenticationCode = (int)((Math.random()*9+1)*100000);
            logger.info(phone + "的验证码为:" + authenticationCode);
            String messageName = this.commonParamsService.getValue(ConstantKeys.MESSAGE_NAME);
            String messagePassword = this.commonParamsService.getValue(ConstantKeys.MESSAGE_PASSWORD);
            int ret = MessagesUtils.send(messageName,messagePassword,phone,"尊敬的客户，您的验证码为: " + authenticationCode + ",请勿泄漏给他人。");
            if(ret == 1){
                //把用户登录的验证码写入redis
                jedisClient.set(REGISTER_CODE_KEY + ":" + phone, authenticationCode + "");
                //设置验证码的过期时间
                jedisClient.expire(REGISTER_CODE_KEY + ":" + phone, REGISTER_CODE_EXPIRE);
                logger.debug("短信验证码："+authenticationCode);
                return ResultModel.ok(authenticationCode);
            }else{
                return ResultModel.build(500,"短信发送失败!");
            }
        }
        return ResultModel.build(403,"手机号码不能为空!");
    }

    @Override
    public User queryUser(String token) {
        //根据token从redis中查询用户信息
        String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);

        if(json == null){
            return null;
        }
        User user = JsonUtils.jsonToPojo(json, User.class);
        return user;
    }

    @Override
    public User queryUser(int id) {
        //根据token从redis中查询用户信息
        String json = jedisClient.get(id + "_" + id);
        if(json == null){
            return null;
        }
        User user = JsonUtils.jsonToPojo(json, User.class);
        return user;
    }

    @Override
    public User queryUserByLoginName(String loginName) {
        UserExample example = new UserExample();
        example.createCriteria().andFloginNameEqualTo(loginName);
        return this.userMapper.selectByExample(example).get(0);
    }

    @Override
    public ResultModel updatePassword(String token, String oldPassword, String newPassword,String authCode) {
        User user = this.queryUser(token);
        String serverCode = jedisClient.get(REGISTER_CODE_KEY + ":" + user.getFloginName());
        if(authCode != null && !authCode.equals(serverCode)){
            return ResultModel.build(403,"验证码错误");
        }
        User user2 = userMapper.selectByPrimaryKey(user.getFid());
        String password = user2.getFloginPassword();

        if(password != null && password.equals(encodePassword((oldPassword)))){
            user.setFloginPassword(encodePassword(newPassword));
            int count = userMapper.updateByPrimaryKeySelective(user);
            if(count < 1){
                return ResultModel.build(500,"数据异常");
            }
        }else{
            return ResultModel.build(403,"原始密码错误");
        }
        user.setFloginPassword(null);
        this.freshRedisUserInfo(token,user);
        return ResultModel.ok();
    }

    @Override
    public ResultModel updateBindPhone(String token, String newPhone, String authCode) {
        UserExample example = new UserExample();
        example.createCriteria().andFloginNameEqualTo(newPhone);
        List<User> users = userMapper.selectByExample(example);
        if(users != null && users.size() > 0){
            return ResultModel.build(403,"手机号码已被使用");
        }
        User user = this.queryUser(token);
        String serverAuthCode = jedisClient.get(REGISTER_CODE_KEY + ":" + newPhone);
        if(authCode != null && !authCode.equals(serverAuthCode)){
            return ResultModel.build(403,"验证码错误");
        }

        user.setFoldLoginName(user.getFloginName());
        user.setFloginName(newPhone);
        user.setFtelePhone(newPhone);
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count == 0){
            return ResultModel.build(500,"数据异常");
        }
//        刷新redis中缓存的用户
        this.freshRedisUserInfo(token,user);
        return ResultModel.ok();
    }

    @Override
    public ResultModel updateNickName(String token, String nickName) {
        User user = this.queryUser(token);
        user.setFnickName(nickName);
        //只修改当前提交字段
        User user2 = new User();
        user2.setFid(user.getFid());
        user2.setFnickName(user.getFnickName());
        int count = userMapper.updateByPrimaryKeySelective(user2);
        if(count == 0){
            return ResultModel.build(500,"数据异常");
        }
        this.freshRedisUserInfo(token,user);
        return ResultModel.ok(nickName);
    }

    /**
     * 用户找回密码
     * @param phone
     * @param authCode
     * @param newPassword
     * @return
     */
    @Override
    public ResultModel updateResetPassword(String phone, String authCode, String newPassword) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andFloginNameEqualTo(phone);
        //后续需要考虑用户系统
        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)){
            return ResultModel.build(403,"该手机号没有注册");
        }
        String serverCode = jedisClient.get(REGISTER_CODE_KEY + ":" + phone);
        if(authCode != null && !authCode.equals(serverCode)){
            return ResultModel.build(403,"验证码错误");
        }
        User user = userList.get(0);
        user.setFloginPassword(encodePassword(newPassword));
        userMapper.updateByPrimaryKeySelective(user);
        return ResultModel.ok();
    }

    @Override
    public ResultModel setTradePassword(String token,String tradePassword,String authCode) {
        User user = this.queryUser(token);
        User user2 = userMapper.selectByPrimaryKey(user.getFid());
        String md5Password = HashUtil.encodePassword(tradePassword);
        if(user2.getFloginPassword().equals(md5Password)){
            return ResultModel.build(403,"交易密码不能登录密码相同");
        }
        user.setFtradePassword(md5Password);
        user.setHasPayPwd(true);
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count < 1){
            return ResultModel.build(500,"数据异常");
        }
        user.setFtradePassword(null);
        this.freshRedisUserInfo(token,user);
        return ResultModel.ok();
    }

    @Override
    public ResultModel createWallet(String token, String memWords) {
        User user = this.queryUser(token);
        User user2 = userMapper.selectByPrimaryKey(user.getFid());
        if(user.getWalletStatus() == 1){
            return ResultModel.build(403,"已经存在钱包，不能再次创建");
        }
        String temp = jedisClient.get("mem:"+user.getFid() + ":key");
        if(!memWords.trim().equals(temp)){
            return ResultModel.build(403,"助记词不正确");
        }
        user2.setHasPayPwd(true);
        List<Fvirtualwallet> fvirtualwallets = this.fvirtualwalletService.listFvirtualwallet(user.getFid());
        if(CollectionUtils.isEmpty(fvirtualwallets)){
            user2.setWalletStatus(1);
            userMapper.updateByPrimaryKeySelective(user2);
            //为用户生成比特币钱包和以太坊钱包
            creteWallet(user);
        }else {
            //钱包处于删除状态，此时用户创建钱包需要copy一条用户信息
            if(user2.getWalletStatus() == 2){
                user.setToken(com.dais.utils.Utils.getMD5_32(new Date().getTime()+""));
                this.userMapper.updateByPrimaryKeySelective(user);
                user2.setFid(null);
                user2.setWalletStatus(1);
                user2.setMemWords(temp);
                user2.setFtradePassword(jedisClient.get("password:"+user.getFid() + ":key"));
                this.userMapper.insertSelective(user2);
                creteWallet(user2);
            }
        }
        user.setFtradePassword(null);
        this.freshRedisUserInfo(user2.getToken(),user2);
        return ResultModel.ok();
    }

    private void creteWallet(User user){
        List<Fvirtualcointype> fcctList = fvirtualcointypeMapper.selectByExample(new FvirtualcointypeExample());
        for(Fvirtualcointype fvirtualcointype : fcctList) {
            if(!"ETH".equals(fvirtualcointype.getFshortname()) && !"BTC".equals(fvirtualcointype.getFshortname()))
                continue;
            try {
                fvirtualaddressService.updateAssignWalletAddress(user.getFid(),fvirtualcointype.getFid());
                fvirtualwalletService.insertFvirtualwallet(user.getFid(),fvirtualcointype.getFid());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ResultModel validateOldPhone(String token, String authCode) {
        User user = this.queryUser(token);
        if(user == null){
            return ResultModel.build(401,"验证失败！");
        }
        String serverAuthCode = jedisClient.get(REGISTER_CODE_KEY + ":" +  user.getFloginName());
        if(serverAuthCode == null){
            return ResultModel.build(403,"验证码超时!");
        }
        if(!serverAuthCode.equals(authCode)){
            return ResultModel.build(403,"验证码错误!");
        }
        return ResultModel.ok();
    }

    @Override
    public User findByUserId(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }


    @Override
    public ResultModel updateUser(User user,String token) {
        if(user == null){
            return ResultModel.build(500,"数据异常");
        }
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count == 0){
            return ResultModel.build(500,"数据异常");
        }
//        刷新redis中缓存的用户
        this.freshRedisUserInfo(token,user);
        return ResultModel.ok();
    }

    @Override
    public ResultModel commonUploadHeadImg(String token, MultipartFile multipartFile) throws IOException{
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
                String filePath = FilePathConstant.HeadImgDirectory + Utils.getRelativeFilePath(ext, bytes);
                boolean flag = Utils.uploadFileToOss(multipartFile.getInputStream(), filePath);
                if(flag){
                    User user = this.queryUser(token);
                    if(user == null){
                        return ResultModel.build(500,"数据异常");
                    }
                    user.setFheadImgUrl(filePath);
                    user.setFlastUpdateTime(new Timestamp(System.currentTimeMillis()));
                    int count = userMapper.updateByPrimaryKeySelective(user);
                    if(count == 0){
                        return ResultModel.build(500,"数据异常");
                    }
                    this.freshRedisUserInfo(token,user);
                    return ResultModel.ok(filePath);
                }else{
                    // 上传失败
                    return ResultModel.build(500,"上传失败");
                }
            }
        }
    }

    @Override
    public ResultModel commonUploadAuthImg(String token, MultipartFile multipartFile) throws IOException {
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
                User user = this.queryUser(token);
                String ext = Utils.getFilenameExtension(multipartFile.getOriginalFilename());
                String filePath = FilePathConstant.IdentityPicDirectory + Utils.getRelativeFilePath(ext, bytes, user.getFid());
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

    @Override
    public User selectByExampe(UserExample example) {
        List<User> list = this.userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    private void freshRedisUserInfo(String token,User user){
        user.setFloginPassword(null);
        user.setFtradePassword(null);
        user.setMemWords(null);
//        刷新redis中缓存的用户
        jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
        //设置session的过期时间
        jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
        jedisClient.set(user.getFid()+"_"+user.getFid(),JsonUtils.objectToJson(user));
    }
}
