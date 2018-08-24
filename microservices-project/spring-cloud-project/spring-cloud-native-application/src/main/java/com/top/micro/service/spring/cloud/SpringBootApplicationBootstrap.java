package com.top.micro.service.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableAutoConfiguration
public class SpringBootApplicationBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.refresh();

        new SpringApplicationBuilder(SpringBootApplicationBootstrap.class)
                .parent(context)
                .run();


//        SpringApplication.run(SpringBootApplicationBootstrap.class,args);
    }
}
