package com.jxd.micor.services.reactive;

import java.util.concurrent.TimeUnit;

public class ReactiveDemo {
    public final void load(){
        long startTime= System.currentTimeMillis();

        doLoad();

        long costTime=System.currentTimeMillis()-startTime;
        System.out.println("总耗时："+costTime+"毫秒");
    }

    public void doLoad() {
        loadUser();
        loadProduct();
        loadOrders();
    }

    protected void loadProduct() {
        loadMock("loadProduct",1);
    }

    protected void loadOrders() {
        loadMock("loadOrders",2);
    }

    protected void loadUser() {
        loadMock("loadUser",3);
    }

    private void loadMock(String resource, long second) {
        try {
            long startTime=System.currentTimeMillis();
            long millis = TimeUnit.SECONDS.toMillis(second);
            Thread.sleep(millis);
            long cost=System.currentTimeMillis()-startTime;
            System.out.printf(
                    "[线程 : %s] %s 耗时 :  %d 毫秒\n",Thread.currentThread().getName(),resource,cost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ReactiveDemo().load();
    }

}
