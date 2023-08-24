package com.atguigu.clients;

import com.atguigu.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 调用购物车服务的接口
 */
@FeignClient("cart-service")
public interface CartClient {

    @PostMapping("/cart/remove/check")
    R check(@RequestBody Integer productId);
}
