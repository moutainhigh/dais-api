package com.dais.controller.user;

import com.common.constant.CommonConstant;
import com.common.model.BTCMessage;
import com.common.utils.BTCUtils;
import com.common.utils.CollectionUtils;
import com.common.utils.HashUtil;
import com.dais.controller.BaseController;
import com.common.pojo.ResultModel;
import com.common.utils.ExceptionUtil;
import com.dais.mapper.WalletUnlockInfoMapper;
import com.dais.model.*;
import com.dais.service.FquestionService;
import com.dais.service.FvirtualaddressService;
import com.dais.service.UserService;
import com.dais.service.VirtualCoinService;
import com.dais.utils.MemWordsUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author GanZhen
 * @version 2017- 03- 07 11:41
 * @description 用户相关的登录注册注销等接口
 * @copyright www.dais.com
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private FquestionService fquestionService;
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private WalletUnlockInfoMapper walletUnlockInfoMapper;
    @Autowired
    private FvirtualaddressService fvirtualaddressService;

    @RequestMapping("/isExistPhone")
    @ResponseBody
    public ResultModel isExistPhone(String phone){
        if (StringUtils.isEmpty(phone)){
            return ResultModel.build(403,"手机号码不能为空");
        }
        UserExample example = new UserExample();
        example.createCriteria().andFloginNameEqualTo(phone);
        User user = this.userService.selectByExampe(example);
        if(user == null){
            return ResultModel.ok();
        }
        return ResultModel.build(403,"手机号码已存在");
    }


   /**
     * 用户注册
     * @param user  注册用户所要的信息
     * @param authCode 验证码
     * @return 响应结果
     */
    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public ResultModel createUser(User user, String authCode) {

//=========参数校验============
//       用户的手机号码不能为空
        if(StringUtils.isBlank(user.getFloginName())){
            return ResultModel.build(403,"手机号码不能为空");
        }
//        手机号码的格式
        if(!user.getFloginName().matches(CommonConstant.PHONE_REGEX)){
            return ResultModel.build(403,"手机号码的格式不正确");
        }
//       用户的密码不能为空
        if(StringUtils.isBlank(user.getFloginPassword())){
            return ResultModel.build(403,"密码不能为空");
        }
//       验证码不能为空
        if(StringUtils.isBlank(authCode)){
            return ResultModel.build(403,"验证码不能为空");
        }
//=========参数校验结束============

        try {
            ResultModel result = userService.createUser(user,authCode);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value="/updateUser", method=RequestMethod.POST)
    @ResponseBody
    public ResultModel uopdateUser(User user,String token) {
        try {
            if(user == null){
                return ResultModel.build(500, "请输入需要修改的参数");
            }
            User user2 = userService.queryUser(token);
            if(StringUtils.isEmpty(user.getAuthStatus()+"")){
                user2.setAuthStatus(user.getAuthStatus());
            }
            if(StringUtils.isEmpty(user.getFidentityStatus()+"")){
                user2.setFidentityStatus(user.getFidentityStatus());
            }
            if(StringUtils.isEmpty(user.getFhasRealValidate()+"")){
                user2.setFhasRealValidate(user.getFhasRealValidate());
            }
            if(StringUtils.isEmpty(user.getFpostRealValidate()+"")){
                user2.setFpostRealValidate(user.getFpostRealValidate());
            }

            ResultModel result = userService.updateUser(user2,token);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    /**
     * 用户登录
     * @param floginName  手机号码
     * @param floginPassword 密码
     * @return 响应结果
     */
    @RequestMapping(value="/login", method=RequestMethod.POST)
    @ResponseBody
    public ResultModel userLogin(String floginName, String floginPassword) {

//=========参数校验============
//       用户的手机号码不能为空
        if(StringUtils.isBlank(floginName)){
            return ResultModel.build(403,"手机号码不能为空");
        }
//        手机号码的格式
        if(!floginName.matches(CommonConstant.PHONE_REGEX)){
            return ResultModel.build(403,"手机号码的格式不正确");
        }
//       用户的密码不能为空
        if(StringUtils.isBlank(floginPassword)){
            return ResultModel.build(403,"密码不能为空");
        }

//=========参数校验结束============

        try {
            ResultModel result = userService.userLogin(floginName, floginPassword);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    /**
     * 用户注销
     * @param token  用户的token
     * @param callback 跨域的callback函数
     * @return  响应结果
     */
    @ResponseBody
    @RequestMapping(value="/logout",method=RequestMethod.POST)
    public Object logout(String token, String callback) {
        ResultModel result = null;
        try {
            result = userService.removeUserByToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            result = ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }

        //判断是否为jsonp调用
        return judgeCallback(result,callback);

    }

    /**
     * 根据用户的token获取用户信息
     * @param token 用户token
     * @return 响应结果
     */
    @RequestMapping("/token")
    @ResponseBody
    public ResultModel getUserByToken(String token) {
        try {
            User user = userService.queryUser(token);
            user.setFloginPassword(null);
            user.setFtradePassword(null);
            user.setMemWords(null);
            return ResultModel.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    /**
     * 过滤器验证失败之后的重定向接口
     * @return 响应结果
     */
    @RequestMapping("/relogin")
    @ResponseBody
    public ResultModel reLogin() {
        return ResultModel.build(401, "验证的失败无效的token，请登录");
    }

    @RequestMapping("/invalidWallet")
    @ResponseBody
    public ResultModel invalidWallet() {
        return ResultModel.build(4012, "钱包未创建或已删除");
    }

    @RequestMapping("/checkWallet")
    @ResponseBody
    public ResultModel checkWallet() {
        return ResultModel.build(402, "钱包被删除或不存在");
    }

    /**
     * 获取用户注册的验证码
     * @param phone 注册的手机号码
     * @return 响应结果
     */
    @RequestMapping("/authCode")
    @ResponseBody
    public ResultModel sendAuthCode(String phone) {

//=========参数校验============
//       用户的手机号码不能为空
        if(StringUtils.isBlank(phone)){
            return ResultModel.build(403,"手机号码不能为空");
        }
//        手机号码的格式
        if(!phone.matches(CommonConstant.PHONE_REGEX)){
            return ResultModel.build(403,"手机号码的格式不正确");
        }
//=========参数校验结束============
        return userService.sendAuthenticationCode(phone);
    }

    /**
     * 根据token获取验证码
     * token
     * @return 响应结果
     */
    @RequestMapping("/authCodeByToken")
    @ResponseBody
    public ResultModel sendAuthCodeByToken(String token) {
        User user = this.userService.queryUser(token);
        if(user == null){
            ResultModel.build(500,"数据异常");
        }
//=========参数校验结束============
        return userService.sendAuthenticationCode(user.getFloginName());
    }


    /**
     * 更换用户密码
     * @param token   用户的token
     * @param oldPassword  旧密码
     * @param newPassword  新密码
     * @return 是否成功
     */
    @RequestMapping(value="/changePassword",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel changePassword(String token,String oldPassword,String newPassword,String authCode){

//=========参数校验============
//       用户的旧密码不能为空
        if(StringUtils.isBlank(oldPassword)){
            return ResultModel.build(403,"旧密码不能为空");
        }
//       用户的新密码不能为空
        if(StringUtils.isBlank(newPassword)){
            return ResultModel.build(403,"新密码不能为空");
        }
//=========参数校验结束============

        return userService.updatePassword(token,oldPassword,newPassword,authCode);
    }

    @RequestMapping(value="/setTradePassword",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel setTradePassword(String token,String tradePassword,String repeatPassword){

//=========参数校验============
        if(StringUtils.isBlank(tradePassword)){
            return ResultModel.build(403,"交易密码不能为空");
        }
        if(!tradePassword.equals(repeatPassword)){
            return ResultModel.build(403,"两次密码不一致");
        }
//=========参数校验结束============

        return userService.setTradePassword(token,tradePassword,null);
    }

    @RequestMapping(value="/vilidateTradePassword",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel vilidateTradePassword(String token,String tradePassword){

        try {
            User user = userService.findByUserId(this.userService.queryUser(token).getFid());
            if (!user.getHasPayPwd() || StringUtils.isEmpty(user.getFtradePassword())){
                return ResultModel.build(403,"未设置支付密码");
            }
            if (!HashUtil.encodePassword(tradePassword).equals(user.getFtradePassword())) {
                return ResultModel.build(403,"密码错误");
            }
            return ResultModel.ok();
        } catch (Exception e) {
            return ResultModel.build(500,"数据异常");
        }

    }

    /**
     * 修改绑定手机号
     * @param token  用户的token
     * @param newPhone  要绑定的手机
     * @param authCode 验证码
     * @return 是否更换成功
     */
    @RequestMapping(value="/updatePhone",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel bindPhone(String token, String newPhone,String authCode){

//=========参数校验============
//       用户的手机号码不能为空
        if(StringUtils.isBlank(newPhone)){
            return ResultModel.build(403,"手机号码不能为空");
        }
//        手机号码的格式
        if(!newPhone.matches(CommonConstant.PHONE_REGEX)){
            return ResultModel.build(403,"手机号码格式不对");
        }
//       验证码不能为空
        if(StringUtils.isBlank(authCode)){
            return ResultModel.build(403,"验证码不能为空");
        }
//=========参数校验结束============

        return userService.updateBindPhone(token,newPhone,authCode);
    }

    /**
     * 忘记密码的重置接口
     * @param phone  要重置的手机号码
     * @param authCode 验证码
     * @param newPassword 新密码
     * @param repeatPassword 确认密码
     * @return 响应结果
     */
    @RequestMapping(value="/resetPassword",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel resetPassword(String phone, String authCode, String newPassword, String repeatPassword){

//=========参数校验============
//       用户的手机号码不能为空
        if(StringUtils.isBlank(phone)){
            return ResultModel.build(403,"手机号码不能为空");
        }
//        手机号码的格式
        if(!phone.matches(CommonConstant.PHONE_REGEX)){
            return ResultModel.build(403,"手机号码的格式不正确");
        }
//       用户的新密码不能为空
        if(StringUtils.isBlank(newPassword)){
            return ResultModel.build(403,"新密码不能为空");
        }
//       用户的确认密码不能为空
        if(StringUtils.isBlank(repeatPassword)){
            return ResultModel.build(403,"确认密码不能为空");
        }
//       验证码不能为空
        if(StringUtils.isBlank(authCode)){
            return ResultModel.build(403,"验证码不能为空");
        }
        if(!newPassword.equals(repeatPassword)){
            return ResultModel.build(403,"两次密码不一致");
        }
//=========参数校验结束============

        return userService.updateResetPassword(phone,authCode,newPassword);
    }

    /**
     * 校验旧的手机以修改新的手机号
     * @param token 用户token
     * @param authCode 验证码
     * @return 响应结果
     */
    @RequestMapping(value="/validatePhone",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel validateOldPhone(String token,String authCode){

//=========参数校验============
//       验证码不能为空
        if(StringUtils.isBlank(authCode)){
            return ResultModel.build(403,"验证码不能为空");
        }
//=========参数校验结束============

        return userService.validateOldPhone(token,authCode);
    }


    /**
     * 查询用户是否绑定了手机
     * @param token 用户的token
     * @return 响应数据
     *//*
    @RequestMapping(value="/hasBindPhone",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel queryHasBindPhone(String token) {
        return userService.queryHasBindPhone(token);
    }*/

    /**
     *
     * @param token
     * @param nickname
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateNickname", method = RequestMethod.POST)
    public ResultModel updateNickname(String token, String nickname){
        if(StringUtils.isEmpty(nickname)){
            return ResultModel.build(403,"昵称不能为空");
        }
        if(nickname.length() > 20){
            return ResultModel.build(403,"昵称名称最长10位");
        }
        return userService.updateNickName(token, nickname);
    }

    /**
     *
     * @param token
     * 备份钱包  获取助记词
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMemWords", method = RequestMethod.POST)
    public ResultModel getMemWords(String token,String tradePassword){
        User user = this.userService.findByUserId(userService.queryUser(token).getFid());
        if (!HashUtil.encodePassword(tradePassword).equals(user.getFtradePassword())) {
            return ResultModel.build(403,"交易密码错误");
        }
        if(user.getWalletStatus() == 2){
            return ResultModel.build(402,"钱包为创建或被删除");
        }
        return ResultModel.ok(user.getMemWords());
    }

    /**
     *
     * @param token
     * 备份钱包  获取助记词
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/dumpPrivkey", method = RequestMethod.POST)
    public ResultModel dumpPrivkey(String token,String tradePassword,int symbol){
        User user = this.userService.findByUserId(userService.queryUser(token).getFid());
        try {
            if (!HashUtil.encodePassword(tradePassword).equals(user.getFtradePassword())) {
                return ResultModel.build(403, "交易密码错误");
            }
            if (user.getWalletStatus() == 2) {
                return ResultModel.build(402, "钱包为创建或被删除");
            }
            Fvirtualcointype fvirtualcointype = this.virtualCoinService.selectByPrimaryKey(symbol);
            if (fvirtualcointype == null) {
                return ResultModel.build(403, "币种不存在");
            }
            Fvirtualaddress fvirtualaddress = fvirtualaddressService.selectFvirtualAddress(user.getFid(),symbol);
            if(fvirtualaddress == null){
                return ResultModel.build(403, "该钱包还未生成地址");
            }
            BTCMessage btcMessage = new BTCMessage();
            btcMessage.setACCESS_KEY(fvirtualcointype.getFaccessKey());
            btcMessage.setIP(fvirtualcointype.getFip());
            btcMessage.setPORT(fvirtualcointype.getFport());
            btcMessage.setSECRET_KEY(fvirtualcointype.getFsecrtKey());
            WalletUnlockInfoExample example = new WalletUnlockInfoExample();
            example.createCriteria().andSymbolEqualTo(fvirtualcointype.getFid());
            List<WalletUnlockInfo> walletUnlockInfos = walletUnlockInfoMapper.selectByExample(example);
            String unlockPassword = null;
            boolean ispass = false;
            if (!CollectionUtils.isEmpty(walletUnlockInfos)) {
                unlockPassword = walletUnlockInfos.get(0).getUnlockPassword();
                ispass = true;
            }
            btcMessage.setPASSWORD(unlockPassword);

            if (btcMessage.getACCESS_KEY() == null
                    || btcMessage.getIP() == null
                    || btcMessage.getPORT() == null
                    || btcMessage.getSECRET_KEY() == null) {
                return ResultModel.build(403, "导出私钥失败，稍后再试");
            }

            BTCUtils btcUtils = new BTCUtils(btcMessage);
            JSONObject json = btcUtils.dumpprivkey(fvirtualaddress.getFadderess(), ispass);
            if (json != null && json.containsKey("result")){
                Map map = new HashMap();
                map.put("address",fvirtualaddress.getFadderess());
                map.put("privkey",json.get("result").toString());
                return ResultModel.ok(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultModel.build(403, "导出私钥失败，稍后再试");
    }

    /**
     *
     * @param token
     * 验证助记词
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vilidateMemWords", method = RequestMethod.POST)
    public ResultModel vilidateMemWords(String token,String menWords){
        User user = this.userService.findByUserId(userService.queryUser(token).getFid());
        if(StringUtils.isEmpty(menWords)){
            return ResultModel.build(403,"助记词为空");
        }
        if(menWords.replaceAll(" +","").equals(user.getMemWords())){
            return ResultModel.ok();
        }
        return ResultModel.build(403,"助记错误");
    }

    /**
     *
     * @param token
     * 验证助记词删除钱包
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteWalletByMemWords", method = RequestMethod.POST)
    public ResultModel deleteWalletByMemWords(String token,String menWords){
        User user = this.userService.findByUserId(userService.queryUser(token).getFid());
        if(StringUtils.isEmpty(menWords)){
            return ResultModel.build(403,"助记词为空");
        }
        if(menWords.trim().equals(user.getMemWords())){
            user.setWalletStatus(2);
            this.userService.updateUser(user,token);
            return ResultModel.ok();
        }
        return ResultModel.build(403,"助记错误");
    }

    /**
     *
     * @param token
     * 根据助记词导入钱包
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/importWalletByMemWords", method = RequestMethod.POST)
    public ResultModel importWalletByMemWords(String token,String menWords,String tradepass){
        if(StringUtils.isEmpty(menWords)){
            return ResultModel.build(403,"助记词为空");
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMemWordsEqualTo(menWords.trim().replaceAll(" +",""));
        User user = this.userService.selectByExampe(example);
        if (user == null){
            return ResultModel.build(403,"助记词错误");
        }
        if(user.getWalletStatus() == 1){
            return ResultModel.build(403,"钱包已存在");
        }
        if(user.getFloginName().equals(this.userService.queryUser(token).getFloginName())){
            user.setWalletStatus(1);
            user.setFtradePassword(HashUtil.encodePassword(tradepass));
            user.setHasPayPwd(true);
            this.userService.updateUser(user,token);
            return ResultModel.ok();
        }
        return ResultModel.build(403,"助记错误");
    }



    /**
     *
     * @param token
     * 根据密码创建钱包
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createWallet", method = RequestMethod.POST)
    public ResultModel createWallet(String token,String tradepass,String tradepass2){
        if(StringUtils.isEmpty(tradepass)){
            return ResultModel.build(403,"密码不能为空");
        }
        if (!tradepass.equals(tradepass2)){
            return ResultModel.build(403,"两次密码不一致");
        }
        User user = this.userService.findByUserId(this.userService.queryUser(token).getFid());
        if(user.getWalletStatus() == 2){
            return ResultModel.build(403,"钱包已经创建");
        }
        user.setFtradePassword(HashUtil.encodePassword(tradepass));
        user.setHasPayPwd(true);
        user.setMemWords(MemWordsUtil.createMemWords());
        String memWords = user.getMemWords();
        this.userService.updateUser(user,token);
        return ResultModel.ok(memWords);
    }
    /**
     *
     * @param token
     * 根据密码创建钱包
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/confirmCreateWallet", method = RequestMethod.POST)
    public ResultModel confirmCreateWallet(String token,String memWords){
        if(StringUtils.isEmpty(memWords)){
            return ResultModel.build(403,"助记词不能为空");
        }
        return this.userService.createWallet(token,memWords);
    }

    /**
     *  提交实名信息
     *
     * @param token
     * @param identityNo
     * @param identityType
     * @param realName
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/auth", method = RequestMethod.POST)
    public ResultModel submitAuthInfo(String token,
                                 @RequestParam(value = "cardId", required=true)String identityNo,
                                 @RequestParam(value = "authType", required=false, defaultValue="0")int identityType,
                                 @RequestParam(required=true)String realName
    ) throws Exception {
        if(StringUtils.isEmpty(realName)){
            return ResultModel.build(403,"真实姓名不能为空");
        }
        if(StringUtils.isEmpty(identityNo)){
            return ResultModel.build(403,"请输入证件号码");
        }

        User user = this.userService.queryUser(token);
        if(user.getFpostRealValidate() || user.getFhasRealValidate()){
            return ResultModel.build(403,"已提交过认证信息");
        }
        realName = HtmlUtils.htmlEscape(realName);
        user.setFidentityNo(identityNo) ;
        user.setFrealName(realName) ;
        user.setFidentityType(identityType) ;
        user.setFhasRealValidate(false);
        user.setAuthStatus(1);
        user.setFlastUpdateTime(new Timestamp(System.currentTimeMillis()));
        return userService.updateUser(user,token) ;
    }

    /**
     * 上传头像
     *
     * 不能大于3MB
     *
     * //@param multipartFile@RequestParam(value = "head_img")
     * @return
     */
    @RequestMapping(value = "/upload_head_img")
    @ResponseBody
    public ResultModel uploadHeadImg(String token, MultipartFile head_img) throws IOException {
        return this.userService.commonUploadHeadImg(token, head_img);
    }


    /**
     * 上传手持证件照
     * @param token
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload_auth_img")
    @ResponseBody
    public ResultModel uploadAuthImage(String token, @RequestParam(value = "img") MultipartFile multipartFile) throws IOException {
        return this.userService.commonUploadAuthImg(token, multipartFile);
    }

    /**
     * 证件上传提交文件名保存数据库
     * @param token
     * @param fidentityPath
     * @param fidentityPath2
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadIdentifyPic", method = RequestMethod.POST)
    public ResultModel uploadIdentifyPic(String token, String fidentityPath, String fidentityPath2){
        if(StringUtils.isEmpty(fidentityPath) || StringUtils.isEmpty(fidentityPath2)){
            return ResultModel.build(403,"证件信息为空");
        }
        User user = this.userService.queryUser(token);
        if(user == null){
            return ResultModel.build(500,"数据异常");
        }
        if(1 == user.getFidentityStatus() || 2 == user.getFidentityStatus()){
            return ResultModel.build(403,"证件信息已经提交过");
        }
        user.setFidentityPath(fidentityPath);
        user.setFidentityPath2(fidentityPath2);
        user.setFidentityStatus(1);//已提交
        user.setFlastUpdateTime(new Timestamp(System.currentTimeMillis()));
        return userService.updateUser(user,token);
    }

    @ResponseBody
    @RequestMapping(value = "/commitQuestion", method = RequestMethod.POST)
    public ResultModel commitQuestion(String token, String ftelephone, String fdesc){
        if(StringUtils.isEmpty(ftelephone)){
            return ResultModel.build(403,"联系电话不能为空");
        }
        if(StringUtils.isEmpty(fdesc)){
            return ResultModel.build(403,"反馈信息不能为空");
        }
        User user = this.userService.queryUser(token);
        FquestionWithBLOBs fquestion = new FquestionWithBLOBs();
        fquestion.setFuid(user.getFid());
        fquestion.setFdesc(fdesc);
        fquestion.setFtelephone(ftelephone);
        fquestion.setFcreatetime(new Timestamp(System.currentTimeMillis()));
        int count = fquestionService.insertFquestion(fquestion);
        if(count > 0){
            return ResultModel.ok();
        }else{
            return ResultModel.build(500,"数据异常");
        }
    }


}
