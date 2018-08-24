package com.jxd.micor.services.reactive;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class FluxDemo {
    public static void main(String[] args) throws InterruptedException {
        Flux.just(0,1,2,3,4,5,6,7,8,9)
                .filter(v->v%2==1)
                .map(v->v+1)
                .reduce(Integer::sum)
//                .subscribeOn(Schedulers.immediate())
//                .subscribeOn(Schedulers.elastic())
                .subscribeOn(Schedulers.parallel())
                .subscribe(FluxDemo::println)
                ;
        Thread.sleep(1000);

                ;
    }
    public static void println(Object  message){
        System.out.printf( "[线程 : %s] 输出：%s \n",Thread.currentThread().getName(),message);
    }
}
