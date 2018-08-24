package com.jxd.mvc;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com.jxd.mvc.annotation")
public class RestMvcApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RestMvcApplication.class)
                .run(args);
    }
}
