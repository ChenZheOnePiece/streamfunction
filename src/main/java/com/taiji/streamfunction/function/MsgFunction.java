package com.taiji.streamfunction.function;

import com.taiji.streamfunction.bean.Email;
import com.taiji.streamfunction.bean.Message;
import com.taiji.streamfunction.operator.Consume;
import com.taiji.streamfunction.service.impl.ReceiveEmailService;
import com.taiji.streamfunction.service.impl.ReceiveMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;
@Configuration
public class MsgFunction {
    private static Logger logger = LoggerFactory.getLogger(EmailFunction.class);

    @Autowired
    private Consume consume;
    @Bean
    public Function<String, String> sendMsg() {
        return data -> data;
    }


    @Bean
    public Consumer<String> receiveMsg() {
        return s -> {
            logger.info("email function"+ s);
            consume.setReceive( new ReceiveMsgService());
            consume.receive("123");
        };

    }
}
