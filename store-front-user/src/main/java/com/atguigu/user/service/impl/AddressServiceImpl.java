package com.atguigu.user.service.impl;

import com.atguigu.pojo.Address;
import com.atguigu.user.mapper.AddressMapper;
import com.atguigu.user.service.AddressService;
import com.atguigu.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地址接口实现
 */
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 根据用户id查询 地址列表
     *   1.直接进行数据库查询
     *   2.结果封装
     * @param userId  用户id 已经校验完毕
     * @return 001 004
     */
    @Override
    public R list(Integer userId) {

        //1,封装查询参数
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);


        List<Address> addressList = addressMapper.selectList(queryWrapper);

        //2.结果封装
        R ok = R.ok("查询成功", addressList);
        log.info("AddressServiceImpl.list业务结束，结果:{}",ok);
        return ok;
    }

    /**
     * 插入地址数据,插入成功以后,返回对应用户的所有数据
     * @param address 地址数据已经校验完毕
     * @return
     */
    @Override
    public R save(Address address) {

        //1.插入数据
        int rows = addressMapper.insert(address);
        //2.插入成功
        if (rows == 0){
            log.info("AddressServiceImpl.save业务结束，结果:{}","地址失败!");
            return R.fail("插入地址失败!");
        }
        //复用查询业务
        return list(address.getUserId());
    }

    /**
     * 根据id 删除地址数据
     *
     * @param id 地址id
     * @return 结果 001  004
     */
    @Override
    public R remove(Integer id) {

        int rows = addressMapper.deleteById(id);

        if (rows == 0){
            log.info("AddressServiceImpl.remove业务结束，结果:{}","地址删除失败");
            return R.fail("删除地址数据失败!");
        }

        log.info("AddressServiceImpl.remove业务结束，结果:{}","地址删除成功!");

        return R.ok("地址删除成功!");
    }
}
