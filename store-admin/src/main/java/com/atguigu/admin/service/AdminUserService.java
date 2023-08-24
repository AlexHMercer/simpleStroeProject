package com.atguigu.admin.service;

import com.atguigu.admin.param.AdminUserParam;
import com.atguigu.admin.pojo.AdminUser;


public interface AdminUserService {

    /**
     * 登录业务方法
     * @param adminUserParam
     * @return
     */
    AdminUser login(AdminUserParam adminUserParam);


}
