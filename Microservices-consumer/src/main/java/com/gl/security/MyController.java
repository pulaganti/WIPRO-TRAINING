package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
	@Autowired
	LoadBalancerClient  loadBalancerClient;
	
	public String serverCommunication(String serverName) {
		//we are LB to  connect to the Micro services with the given name
		ServiceInstance serviceInstance = loadBalancerClient.choose(serverName);
		return serviceInstance.getUri().toString();
		
	}
	//controller for adding new course
	@PostMapping("/course/add")
	public String addCourse(String name,Double fee) {
		RestTemplate rt = new RestTemplate();
		String serviceName = "Course-Micro-Service";//imp and case sentisitive
		String serviceUrl =serverCommunication(serviceName);//connectivity to microservices
		//hit the micro server url :/course/add
		Course course = new Course(name,fee,null);
		rt.postForEntity( serviceUrl + "/course/add", course, Course.class);
		return "Course added";			
	}

}
