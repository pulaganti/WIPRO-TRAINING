package com.gl.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesConsumerApplication.class, args);
	}

}
