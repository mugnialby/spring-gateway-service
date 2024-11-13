package com.alby.spring_gateway_service.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RabbitMQRequestResponse {
    private final RabbitTemplate rabbitTemplate;

    public Map<String, Object> request(
            String routingKey,
            Map<String, Object> request
    ) {
        rabbitTemplate.setReplyTimeout(500);
        return (Map<String, Object>) rabbitTemplate.convertSendAndReceive(
                routingKey,
                request
        );
    }
}
