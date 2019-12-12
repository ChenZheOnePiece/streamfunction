package com.taiji.streamfunction.config;

import com.taiji.streamfunction.bean.Message;
import com.taiji.streamfunction.comtroller.MessageController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class Config {

    private static Logger logger = LoggerFactory.getLogger(Config.class);
//    @Bean(name = "uppercaseFunction")
//    public Function<String, String> uppercaseFunction() {
//        return String::toUpperCase;
//    }
//
//
//    private AtomicBoolean semaphore = new AtomicBoolean(true);
//
//    @Bean
//    public Supplier<String> sendTestData() {
//        return () -> this.semaphore.getAndSet(!this.semaphore.get()) ? "foo" : "bar";
//
//    }
//
//    @Bean
//    public Consumer<String> receive() {
//        return payload -> logger.info("Data received: " + payload);
//    }
}
