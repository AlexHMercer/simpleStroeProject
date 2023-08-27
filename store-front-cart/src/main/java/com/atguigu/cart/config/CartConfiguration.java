package com.atguigu.cart.config;

import com.atguigu.config.RabbitConfiguration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 购物车配置类
 */
@Configuration
public class CartConfiguration extends RabbitConfiguration {

    /**
     * mq序列化方式，选择json！
     * @return
     */
//    @Bean
//    public MessageConverter messageConverter(){
//
//        return new Jackson2JsonMessageConverter();
//    }
}
