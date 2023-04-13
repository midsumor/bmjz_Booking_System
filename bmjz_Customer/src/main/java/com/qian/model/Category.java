package com.qian.model;


import java.util.LinkedList;
import java.util.List;

public class Category {

    private String one = "保洁服务";
    private String two = "纺织物清洗";
    private String three = "家电清洁";
    private String other = "其它";

    public String getCategory(String category){
        switch (category){
            case "one":return one;
            case "two":return two;
            case "three":return three;
            default:return other;
        }
    }


}
