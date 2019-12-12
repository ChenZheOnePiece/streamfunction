package com.taiji.streamfunction.comtroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MessageController {
    private static Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    @Lazy
    @Qualifier("sendMsg-out-0")
    private MessageChannel outputMsg;

    @Autowired
    @Lazy
    @Qualifier("sendEmail-out-0")
    private MessageChannel outputEmail;

    @Autowired
    private ObjectMapper jsonMapper;

    private final EmitterProcessor<Message<?>> processor = EmitterProcessor.create();

    @RequestMapping(value = "/email")
    public void email(@RequestBody String msg) {
        outputEmail.send(new GenericMessage<>(msg));
    }

    @RequestMapping(value = "/msg")
    public void msg(@RequestBody String msg) {

        outputMsg.send(new GenericMessage<>(msg));
    }


    @Bean
    public Supplier<Flux<Message<?>>> supplier() {
        return () -> processor;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "/", method = POST, consumes = "*/*")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void handleRequest(@RequestBody String body, @RequestHeader(HttpHeaders.CONTENT_TYPE) Object contentType) throws Exception {
        Map<String, String> payload = jsonMapper.readValue(body, Map.class);
        String destinationName = payload.get("id");
        Message<?> message = MessageBuilder.withPayload(payload)
                .setHeader("spring.cloud.stream.sendto.destination", destinationName).build();
        processor.onNext(message);
    }

}
