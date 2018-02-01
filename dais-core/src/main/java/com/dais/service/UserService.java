package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.User;
import com.dais.model.UserExample;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author xxp
 * @version 2017- 08- 08 20:51
 * @description
 * @copyright www.zhgtrade.com
 */
public interface UserService {
    ResultModel createUser(User user, String authCode);

    ResultModel updateWallatOrAddress(Integer userid, Integer symbol,String type)throws Exception;

    ResultModel getUserList(int start,int limit,String search);

    ResultModel userLogin(String phone, String password);

    ResultModel getUserByToken(String token);

    ResultModel removeUserByToken(String token);

    ResultModel sendAuthenticationCode(String phone);

    User queryUser(String token);

    User queryUser(int id);

    User queryUserByLoginName(String loginName);

    ResultModel updatePassword(String token, String oldPassword, String newPassword, String authCode);

    ResultModel updateBindPhone(String token, String bindPhone, String authCode);

    ResultModel updateNickName(String token, String nickName);

    ResultModel updateResetPassword(String phone, String authCode, String newPassword);

    ResultModel setTradePassword(String token, String tradePassword, String authCode);

    ResultModel createWallet(String token, String tradePassword);

    ResultModel validateOldPhone(String token, String authCode);

    User findByUserId(int userId);

    ResultModel updateUser(User user, String token);

    ResultModel commonUploadHeadImg(String token, MultipartFile multipartFile)throws IOException;

    ResultModel commonUploadAuthImg(String token, MultipartFile multipartFile) throws IOException;

    User selectByExampe(UserExample example);
}
