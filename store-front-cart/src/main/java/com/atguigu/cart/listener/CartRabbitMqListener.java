package com.atguigu.cart.listener;

import com.atguigu.cart.service.CartService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * 监听mq消息
 */
@Component
public class CartRabbitMqListener {

    @Autowired
    private CartService cartService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "clear.queue"),
                    exchange = @Exchange(value = "topic.ex"),
                    key = "clear.cart"
            )
    )
    public void clear(Message message, List<Integer> cartIds, Channel channel){

        cartService.clearIds(cartIds);
        // 进行消息的手动确认，需要当前消息的标签，该标签是个数字，且在当前channel里是自增的
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        // boolean参数如果为true，那么是确认所有tag小于等于当前消息tag值的所有消息
        try {
            if (deliveryTag%2 == 0){
                // ack
                channel.basicAck(deliveryTag,false);
            }else {
                // nack 第三个参数为true 则该消息重新发回服务器，为false则直接丢弃
                channel.basicNack(deliveryTag,false,true);
            }

        } catch (IOException e) {
            // 签收时网络不畅
        }
    }

}
