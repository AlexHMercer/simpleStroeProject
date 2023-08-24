package com.atguigu.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 商品类别参数
 */
@Data
public class ProductIdsParam  extends PageParam{

    @NotNull
    private List<Integer> categoryID;
}
