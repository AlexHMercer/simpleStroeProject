package com.atguigu.clients;

import com.atguigu.param.CartListParam;
import com.atguigu.param.PageParam;
import com.atguigu.pojo.User;
import com.atguigu.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户的客户端
 * 注意：
 *      Feign中的方法名任意，但是方法路径（即@PostMapping）要和需要调用的Controller路径保持一致，
 *      同时，返回值也保持一致
 */
@FeignClient("user-service")
public interface UserClient {

    @PostMapping("/user/admin/list")
    R adminListPage(@RequestBody PageParam pageParam);

    @PostMapping("/user/admin/remove")
    R adminRemove(@RequestBody CartListParam cartListParam);

    @PostMapping("/user/admin/update")
    R adminUpdate(@RequestBody User user);

    @PostMapping("/user/admin/save")
    R adminSave(@RequestBody User user);
}
