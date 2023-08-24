package com.atguigu.param;

import com.atguigu.pojo.Product;
import lombok.Data;

/**
 * 商品数据增加param
 */
@Data
public class ProductSaveParam extends Product {

    /**
     * 保存商品详情的图片地址 图片地址之间使用 + 拼接
     */
    private String pictures;
}
