package com.dais.service;

import com.common.pojo.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * @author xxp
 * @version 2017- 09- 26 10:33
 * @description
 * @copyright www.zhgtrade.com
 */
public interface GoodfriendRelationshipService {

    List<Map> getGoodFriendList(int userid);
    List<Map> getNewGoodFriendList(int userid);
    ResultModel addGoodFriend(int userid, int toUserid) throws Exception;
    ResultModel agreeAddGoodFriend(int userid, int toUserid) throws Exception;
    ResultModel deleteGoodFriend(int userid,int toUserid)throws Exception;
    ResultModel addBlack(int userid,int toUserid)throws Exception;
    ResultModel removeBlack(int userid,int toUserid)throws Exception;
}
