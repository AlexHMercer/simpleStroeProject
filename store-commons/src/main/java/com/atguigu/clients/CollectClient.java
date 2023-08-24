package com.atguigu.clients;

import com.atguigu.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 收藏服务的调用接口
 */
@FeignClient("collect-service")
public interface CollectClient {

    @PostMapping("/collect/remove/product")
    R remove(@RequestBody Integer productId);

}
