package com.qw.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Author Arkay
 * @Date 2020/9/9 17:56
 * @Version 1.0
 */
@Configuration
public class RabbitmqConfig {

    //延时队列 延时10S
    @Bean("delCityQueue")
    public Queue delCityQueue() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "delCityTtlExchange");
        args.put("x-dead-letter-routing-key", "deleteCityTtl");
        args.put("x-message-ttl", 10000);
        return QueueBuilder.durable("delCityQueue")
                .withArguments(args)
                .build();
    }

    //死信队列 用于接收延时队列延时消息
    @Bean("delCityTtlQueue")
    public Queue delCityTtlQueue() {
        return new Queue("delCityTtlQueue");
    }

    //延时交换机
    @Bean("delCityExchange")
    public DirectExchange delCityExchange() {
        return new DirectExchange("delCityExchange");
    }

    //死信交换机
    @Bean("delCityTtlExchange")
    public DirectExchange delCityTtlExchange() {
        return new DirectExchange("delCityTtlExchange");
    }

    //延时队列与延时交换机绑定
    @Bean
    public Binding bindingDelCityExchange() {
        return BindingBuilder.bind(delCityQueue())
                .to(delCityExchange())
                .with("deleteCity");
    }

    //死信交换机与死信队列绑定
    @Bean
    public Binding bindingDelCityTtlExchange() {
        return BindingBuilder.bind(delCityTtlQueue())
                .to(delCityTtlExchange())
                .with("deleteCityTtl");
    }
}
