package com.nic.message.starter.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import com.nic.message.starter.services.MessageService;

@EnableAsync
@Configuration
@EnableBinding(Source.class)
public class MessageAutoConfiguration {

    @Bean
    public MessageService messageService() {
        return new MessageService();
    }
}
