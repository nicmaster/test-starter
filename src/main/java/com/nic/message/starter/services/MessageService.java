package com.nic.message.starter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.nic.message.starter.domain.Message;

@Service
@EnableBinding(Source.class)
public class MessageService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private Source odinSource;

    @Async
    public void submitOdinMesssage(final Message meessage) {
        odinSource.output().send(MessageBuilder.withPayload(meessage).build());
        LOG.info("Odin Message sent [{}]", meessage.getApplicationName());
    }
}
