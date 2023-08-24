package com.atguigu.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 接收前端参数的param
 * TODO: 使用jsr 303的注解进行参数校验!
 * @NotBlank 字符串 不能为null 和 空字符串 ""
 * @NotNull  字符串 不能为null
 * @NotEmpty 集合类型 集合长度不能为0
 */
@Data
public class UserCheckParam {

    @NotBlank
    private String userName; // 参数名称要等于前端传递的JSON key的名称!
}
