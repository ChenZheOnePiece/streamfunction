package com.taiji.streamfunction.service.impl;

import com.taiji.streamfunction.function.EmailFunction;
import com.taiji.streamfunction.service.IReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiveEmailService implements IReceive {

    private static Logger logger = LoggerFactory.getLogger(ReceiveEmailService.class);
    @Override
    public boolean receive(String  o) {
        logger.info("receive email"+ o.toString());
        return true;
    }
}
