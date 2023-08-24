package com.atguigu.doc;

import com.atguigu.pojo.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用来存储商品搜索数据的实体类，继承product并加入一个all字段
 */
@Data
@NoArgsConstructor
public class ProductDoc extends Product {

    /**
     * 商品名称和商品标题和商品描述的综合值
     */
    private String all;

    /**
     * 搜索服务需要从商品服务中获取所有商品信息，而商品服务的返回为List<Product>,需要把Product类转换为ProductDoc
     * 然后再放入es中，所以需要一个构造函数
     * @param product
     */
    public ProductDoc(Product product) {
        // 先调用父类的有参构造
       super(product.getProductId(),product.getProductName(),product.getCategoryId(),
               product.getProductTitle(),product.getProductIntro(),product.getProductPicture(),
               product.getProductPrice(),product.getProductSellingPrice(),product.getProductNum(),
               product.getProductSales());

       this.all = product.getProductName()+product.getProductTitle()+product.getProductIntro();
    }
}
