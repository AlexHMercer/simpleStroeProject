package com.atguigu.user.controller;

import com.atguigu.param.AddressListParam;
import com.atguigu.param.AddressParam;
import com.atguigu.param.AddressRemoveParam;
import com.atguigu.pojo.Address;
import com.atguigu.user.service.AddressService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 地址controller
 */
@RestController
@RequestMapping("user/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 查询地址列表
     * @param addressListParam
     * @param result
     * @return
     */
    @PostMapping("list")
    public R list(@RequestBody @Validated AddressListParam addressListParam, BindingResult result){

        if (result.hasErrors()){

            return R.fail("参数异常,查询失败!");
        }

        return  addressService.list(addressListParam.getUserId());
    }

    /**
     * 保存新的地址，返回当前用户的所有地址
     * @param {"userId":"","add":{"..."}} addressParam
     * @param result
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody @Validated AddressParam addressParam, BindingResult result){

        if (result.hasErrors()){

            return R.fail("参数异常,保存失败!");
        }

        Address address = addressParam.getAdd();
        address.setUserId(addressParam.getUserId());

        return addressService.save(address);
    }

    /**
     * 根据id删除地址
     * @param addressRemoveParam {"id":""}
     * @param result
     * @return
     */
    @PostMapping("remove")
    public R remove(@RequestBody @Validated AddressRemoveParam addressRemoveParam,BindingResult result){

        if (result.hasErrors()){

            return R.fail("参数异常,删除失败!");
        }

        return addressService.remove(addressRemoveParam.getId());
    }
}

