package com.jxd.micor.services.reactive;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelReactive extends ReactiveDemo{
    public void doLoad(){
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        CompletionService completionService=new ExecutorCompletionService(executorService);

        completionService.submit(super::loadUser,null);
        completionService.submit(super::loadOrders,null);
        completionService.submit(super::loadProduct,null);

        int count = 0;
        while (count<3){
            System.out.println("2");
            if (completionService.poll()!=null)
            {
                count++;
            }
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new ParallelReactive().load();
    }
}
