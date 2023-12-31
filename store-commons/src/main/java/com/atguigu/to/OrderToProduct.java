package com.atguigu.to;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单发送商品服务的消息参数
 */

@Data
public class OrderToProduct implements Serializable {

    public static final Long serialVersionUID = 1L;


    private Integer productId;
    private Integer num;

}
