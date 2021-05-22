package com.cb.diy;

public class DiyPointCut {

    //前置条件
    public void before(){
        System.out.println("口令：");
    }

    //后置条件
    public void returning(){
        System.out.println("请求成功，欢迎");
    }

    //异常条件
    public void throwing(){
        System.out.println("请求失败，拒绝");
    }

    //最终条件
    public void after(){
        System.out.println("输入完成");
    }
}
