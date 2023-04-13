package com.qian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddGoodsController {

    @RequestMapping(value = {"/addGoodsPage","/add_goods_page"})
    public String addGoodsPage(){
        return "add_goods_page";
    }

}
