package com.cb.diy;

import org.aspectj.lang.annotation.*;

@Aspect  //定义一个平面
public class AnnotationPointCut {
    @Before("execution(* com.cb.service.VisitServiceImpl.*(..))")
    public void before(){
        System.out.println("口令：");
    }
    @AfterReturning("execution(* com.cb.service.VisitServiceImpl.*(..))")
    //后置条件
    public void returning(){
        System.out.println("请求成功，欢迎");
    }
    @AfterThrowing("execution(* com.cb.service.VisitServiceImpl.*(..))")
    //异常条件
    public void throwing(){
        System.out.println("请求失败，拒绝");
    }
    @After("execution(* com.cb.service.VisitServiceImpl.*(..))")
    //最终条件
    public void after(){
        System.out.println("输入完成");
    }
}
