package com.atguigu.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 热门商品类别名参数
 */
@Data
public class ProductPromoParam {

    @NotBlank
    private String categoryName;
}
