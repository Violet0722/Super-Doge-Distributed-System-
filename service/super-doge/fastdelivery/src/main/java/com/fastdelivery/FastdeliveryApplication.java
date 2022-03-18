package com.fastdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FastdeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastdeliveryApplication.class, args);
	}

}
