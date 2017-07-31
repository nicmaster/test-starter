package com.nic.message.starter.services;

import com.nic.message.starter.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OdinMessageServiceIntegrationTest {
    @Autowired
    private Source source;

    @Autowired
    private MessageService odinMessageService;

    @Autowired
    private MessageCollector messageCollector;

    @Test
    public void when_odinMessageIsSent_expect_messageIsSentToChannelSuccessfully() throws InterruptedException {
        final Message message = new Message();
        message.setApplicationName("test");

        odinMessageService.submitOdinMesssage(message);
        await().atMost(5, TimeUnit.SECONDS).until(() -> messageCollector.forChannel(source.output()).poll() != null);
    }

    @SuppressWarnings("checkstyle:hideutilityclassconstructor")
    @SpringBootApplication
    static class TestSpringBootApplication {

        public static void main(final String[] args) {
            SpringApplication.run(TestSpringBootApplication.class, args);
        }
    }
}
