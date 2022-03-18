package com.safedelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SafedeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafedeliveryApplication.class, args);
	}

}
