package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 轮播图实体类
 */
@TableName("carousel")
@Data
public class Carousel implements Serializable {

    public static final Long serialVersionUID = 1L;
    // 将属性与数据库和json对应
    @JsonProperty("carousel_id")
    @TableId(value = "carousel_id",type = IdType.AUTO)
    private Integer carouselId;

    @TableField("img_path")
    private String  imgPath;
    private String  describes;
    @JsonProperty("product_id")
    @TableField("product_id")
    private Integer productId;
    private Integer priority;
}
