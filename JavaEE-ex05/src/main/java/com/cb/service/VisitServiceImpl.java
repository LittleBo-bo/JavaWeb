package com.cb.service;

public class VisitServiceImpl implements VisitService {
    @Override
    public void visit(String msg) throws Exception {
        System.out.println(msg);
        if(!msg.equalsIgnoreCase("agree")){
            throw new Exception("非法访问");
        }
    }
}
