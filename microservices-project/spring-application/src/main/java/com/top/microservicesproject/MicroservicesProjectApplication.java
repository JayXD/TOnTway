package com.top.microservicesproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MicroservicesProjectApplication {

	public static void main(String[] args) {
//		SpringApplication.run(MicroservicesProjectApplication.class, args);
		new SpringApplicationBuilder(MicroservicesProjectApplication.class)
				.properties("server.prot=0")
				.run(args);
	}

}
