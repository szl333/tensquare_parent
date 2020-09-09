package com.qw.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Arkay
 * @Date 2020/9/9 19:48
 * @Version 1.0
 */
@Component
public class DeleteCitySender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(String id, String daLayTime) {
        rabbitTemplate.convertAndSend("delCityExchange", "deleteCity", id, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration(daLayTime);
                return message;
            }
        });
    }

}
