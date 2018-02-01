package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.RedPacket;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 10- 12 13:59
 * @description
 * @copyright www.zhgtrade.com
 */
public interface RedPacketService {

    RedPacket updateSendPrivateRedPacket(RedPacket redPacket,int touserid);

    RedPacket updateSendGroupRedPacket(RedPacket redPacket);

    RedPacket updateReceiveRedPacket(RedPacket redPacket,int touserid);
    ResultModel updateGrabRedPacket(int userId, int redPacketId);

    RedPacket grabPrivateRedPacket( int redPacketId);

    ResultModel updateOpenPrivate(int userId, int redPacketId);

    ResultModel updateOpenRedPacket(int userId, int redPacketId);

    RedPacket getRedPacketById(int id);

    List<RedPacket> getRedPacketByParentid(int parentid);

    void checkExpireRedPacket();

}
