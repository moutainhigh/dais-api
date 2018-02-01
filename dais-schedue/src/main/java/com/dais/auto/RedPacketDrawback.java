package com.dais.auto;

import com.dais.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author XXP
 * @version 2017- 10- 18 19:25
 * @description
 * @copyright www.zhgtrade.com
 */
@Component
public class RedPacketDrawback {
    @Autowired
    private RedPacketService redPacketService;

    public synchronized void run(){
        redPacketService.checkExpireRedPacket();
    }

}
