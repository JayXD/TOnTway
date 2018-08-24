package com.jxd.micor.services.reactive;

import java.util.concurrent.*;

public class FutureReactive extends ReactiveDemo{
    public void doLoad(){
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        runCompletely(executorService.submit(super::loadUser));
        runCompletely(executorService.submit(super::loadOrders));
        runCompletely(executorService.submit(super::loadProduct));
    }
    private void runCompletely(Future future){
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FutureReactive().load();
    }
}
