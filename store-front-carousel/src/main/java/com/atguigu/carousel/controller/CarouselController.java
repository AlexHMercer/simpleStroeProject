package com.atguigu.carousel.controller;

import com.atguigu.carousel.service.CarouselService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 轮播图
 */
@RestController
@RequestMapping("carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    /**
     * 查询轮播图所需数据,按照优先级排序，取前6个
     * @return
     */
    @PostMapping("list")
    public R list(){

        return carouselService.list();
    }

}
