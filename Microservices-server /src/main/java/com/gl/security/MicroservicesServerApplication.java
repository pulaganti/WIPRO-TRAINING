package com.gl.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class MicroservicesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesServerApplication.class, args);
	}

}
