package com.atguigu.user.controller;

import com.atguigu.param.UserCheckParam;
import com.atguigu.param.UserLoginParam;
import com.atguigu.pojo.User;
import com.atguigu.user.service.UserService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户模块的Controller
 * 网关中请求路径前缀为/user的才会被转发到该服务，所以在类名上加了@RequestMapping("/user")
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userservice;

    /**
     * 检查账号是否可以注册
     * @param userCheckParam 格式为{"userName":"账号"} 接收要检查的账号 +参数校验注解
     * @param result 获取校验结果
     * @return 结果用R封装
     *
     */
    @PostMapping("check")
    public R check(@RequestBody @Validated UserCheckParam userCheckParam, BindingResult result){

        //检查是否符合检验注解的规则  符合 false  不符合 true
        boolean b = result.hasErrors();

        if (b){
            return R.fail("账号为null,不可使用!");
        }

        return userservice.check(userCheckParam);
    }

    /**
     * 账号注册
     * @param user {"userName":"","password":"","userPhonenumber":""}
     * @param result
     * @return
     */
    @PostMapping("register")
    public R register(@RequestBody @Validated User user,BindingResult result){

        if (result.hasErrors()){
            //如果存在异常,证明请求参数不符合注解要求
            return  R.fail("参数异常,不可注册!");
        }

        return userservice.register(user);
    }

    /**
     * 账号登录
     * @param userLoginParam {"userName":"","password":""}
     * @param result
     * @return
     */
    @PostMapping("login")
    public R login(@RequestBody @Validated UserLoginParam userLoginParam,BindingResult result){

        if (result.hasErrors()){
            //如果存在异常,证明请求参数不符合注解要求
            return  R.fail("参数异常,不可登录!");
        }

        return userservice.login(userLoginParam);
    }


}
