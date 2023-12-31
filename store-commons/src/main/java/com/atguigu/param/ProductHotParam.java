package com.atguigu.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 热门商品名s参数
 */
@Data
public class ProductHotParam {

    @NotEmpty
    private List<String> categoryName;
}
