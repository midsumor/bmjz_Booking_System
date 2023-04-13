package com.qian.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"/indexPage","/toIndexPage"})
    public String toIndexPage(){
        return "index";
    }



}
