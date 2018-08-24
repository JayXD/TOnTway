package com.jxd.mvc.sevice;

import com.jxd.mvc.annotation.ServiceTransaction;

@ServiceTransaction(value = "serviceTestABC",transactionManager="ljlj")
public class ServiceTransTest {

    public void echo(){
        System.err.println("Hello World");
    }
}
