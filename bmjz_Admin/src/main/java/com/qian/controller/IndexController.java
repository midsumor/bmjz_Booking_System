package com.qian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 页面 index.html
     */
    @RequestMapping(value = {"/index","/indexPage"})
    public String indexPage(){
        return "index";
    }

}
