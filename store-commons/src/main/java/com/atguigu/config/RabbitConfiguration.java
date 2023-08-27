package com.atguigu.config;


import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import javax.annotation.PostConstruct;

@Slf4j
public class RabbitConfiguration extends RabbitMessageConverterConfiguration {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * "@PostConstruct" "该注解表示对应方法应该在构造器完成后在创建，即在属性注入后执行"
     */
    @PostConstruct
    public void initRabbitTemplate(){
        RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
            /**
             * 只要消息抵达服务器，ack就是true
             * @param correlationData 当前数据的唯一关联数据，即唯一id
             * @param ack 消息是否成功收到
             * @param cause 失败的原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("当前信息id为{},是否成功：{}，失败原因：{}",correlationData.toString()
                        ,ack,cause);
            }
        };

        RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
            /**
             * 消息没有投递到队列，就触发这个回调
             * @param message
             * @param replyCode
             * @param replyText
             * @param exchange
             * @param routingKey
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("消息{}未成功投递，replyCode：{}，replyText：{}，交换机：{}，路由键：{}"
                        ,message.getBody().toString(),replyCode,replyText,exchange,routingKey);
            }
        };

        // 设置消息抵达服务器时的回调
        rabbitTemplate.setConfirmCallback(confirmCallback);
        // 设置消息未被投递到队列的回调
        rabbitTemplate.setReturnCallback(returnCallback);
    }
}
