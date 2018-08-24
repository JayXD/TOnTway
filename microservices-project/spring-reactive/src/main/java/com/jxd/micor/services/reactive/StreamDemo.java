package com.jxd.micor.services.reactive;

import java.util.HashMap;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream.of(0,1,2,3,4,5,6,7,8,9)
                .filter(v->v%2==1)
                .reduce(Integer::sum)
//                .forEach(System.out::println)
                .ifPresent(System.out::println);
                ;

    }
}
