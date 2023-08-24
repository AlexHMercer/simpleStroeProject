package com.atguigu.param;

import lombok.Data;

/**
 * 搜索关键字和分页参数
 * 将分页查询的属性单独构造一个类
 */
@Data
public class ProductSearchParam extends PageParam{

    private String search;

}
