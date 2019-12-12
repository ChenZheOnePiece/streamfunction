package com.taiji.streamfunction.service.impl;

import com.taiji.streamfunction.service.IReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiveMsgService  implements IReceive {

    private static Logger logger = LoggerFactory.getLogger(ReceiveMsgService.class);
    @Override
    public boolean receive(String o) {
        logger.info("receive msg"+ o.toString());
        return true;
    }
}
