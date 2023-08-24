package com.atguigu.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录参数
 */
@Data
public class UserLoginParam {

    // 非null且不为""
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
