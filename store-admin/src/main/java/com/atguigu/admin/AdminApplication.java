package com.atguigu.admin;

import com.atguigu.clients.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 */
@MapperScan(basePackages = "com.atguigu.admin.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {UserClient.class, CategoryClient.class,
        SearchClient.class, ProductClient.class, OrderClient.class})
@EnableCaching
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }

}
