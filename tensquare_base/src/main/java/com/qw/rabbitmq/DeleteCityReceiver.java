package com.qw.rabbitmq;

import com.qw.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Arkay
 * @Date 2020/9/9 20:00
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "delCityTtlQueue")
public class DeleteCityReceiver {
    private final static Logger LOGGER = LoggerFactory.getLogger(DeleteCityReceiver.class);
    @Autowired
    private CityService cityService;

    @RabbitHandler
    public void handle(String id) {
        LOGGER.info("已接受延时消息...进行删除...");
        cityService.deleteById(id);
    }
}
