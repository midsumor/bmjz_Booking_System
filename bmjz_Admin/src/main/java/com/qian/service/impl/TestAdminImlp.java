package com.qian.service.impl;

import com.qian.model.Goods;
import com.qian.service.AdminService;
import com.qian.service.GoodsService;

public class TestAdminImlp {
    public static void main(String[] args) {

        AdminService adminService = new AdminServiceImpl();
//        System.out.println("查找管理员账号"+adminService.findAdmin("admin","123456"));// ok






        GoodsService goodsService = new GoodsServiceImpl();
//        System.out.println("findAllGoods test:"+goodsService.findAllGoods().get(1));// ok
//        System.out.println("removeGoodsByGoodsId result:"+goodsService.removeGoodsByGoodsId(2));//ok

        /**OK
         * 测试updateGoodsInfo()
         *
         * 注意，如果控制台一直打印日志，检查serviceimpl中的方法是不是递归调用了 自己
         */
        Goods goods = new Goods();

        goods.setGoods_id(3);goods.setGoods_name("testname");goods.setGoods_price("19.9");
        goods.setGoods_descript("tset");goods.setGoods_status("0");goods.setCategory("test");
        goods.setCategory("test");
        System.out.println("测试添加商品:"+goodsService.addGoods(goods));//ok
//        int updateResult = goodsService.editGoodsInfo(goods);
//
//        System.out.println("updateResult="+updateResult);// ok

    }
}
