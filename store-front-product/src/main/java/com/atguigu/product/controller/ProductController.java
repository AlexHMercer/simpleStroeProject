package com.atguigu.product.controller;

import com.atguigu.param.*;
import com.atguigu.pojo.Product;
import com.atguigu.product.service.ProductService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品模块controller
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查询单类别热门商品
     * @param productPromoParam
     * @param result
     * @return
     */
    @PostMapping("/promo")
    public R promo(@RequestBody @Validated ProductPromoParam productPromoParam, BindingResult result){

        if (result.hasErrors()){
            return R.fail("数据查询失败!");
        }

        return  productService.promo(productPromoParam.getCategoryName());
    }

    /**
     * 查询多个类别的热门商品
     * @param productHotParam
     * @param result
     * @return
     */
    @PostMapping("hots")
    public R hots(@RequestBody @Validated ProductHotParam productHotParam,BindingResult result){

        if (result.hasErrors()){
            return R.fail("数据查询失败!");
        }

        return productService.hots(productHotParam);
    }

    /**
     * 查询所有的商品类别
     * @return
     */
    @PostMapping("category/list")
    public R clist(){

        return productService.clist();
    }

    /**
     * 根据类别查找商品信息
     * @param productIdsParam
     * @param result
     * @return
     */
    @PostMapping("bycategory")
    public R byCategory(@RequestBody @Validated ProductIdsParam productIdsParam,BindingResult result){

        if (result.hasErrors()){
            return R.fail("类别商品查询失败!");
        }

        return productService.byCategory(productIdsParam);
    }

    /**
     * 根据类别查找商品信息，类别为空时检索所有商品信息
     * @param productIdsParam
     * @param result
     * @return
     */
    @PostMapping("all")
    public R all(@RequestBody @Validated ProductIdsParam productIdsParam,BindingResult result){

        if (result.hasErrors()){
            return R.fail("类别商品查询失败!");
        }

        return productService.byCategory(productIdsParam);
    }

    /**
     * 根据商品id获取详情
     * @param productIdParam
     * @param result
     * @return
     */
    @PostMapping("detail")
    public R detail(@RequestBody @Validated ProductIdParam productIdParam,BindingResult result){

        if (result.hasErrors()) {
            return R.fail("商品详情查询失败");
        }
        return productService.detail(productIdParam.getProductID());
    }

    /**
     * 根据商品id获取图片
     * @param productIdParam
     * @param result
     * @return
     */
    @PostMapping("pictures")
    public R pictures(@RequestBody @Validated ProductIdParam productIdParam,BindingResult result){

        if (result.hasErrors()) {
            return R.fail("商品图片详情查询失败");
        }
        return productService.pictures(productIdParam.getProductID());
    }

    @PostMapping("search")
    public R search(@RequestBody ProductSearchParam productSearchParam){

        return productService.search(productSearchParam);
    }

}
