package com.gl.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	//the username,password,role
	@Bean
	public UserDetailsService userDetailService() {
		// create new user for this spring booy in memory authentication
		UserDetails user1 =User.withUsername("admin").password("12345").roles("admin").build();
		UserDetails user2 =User.withUsername("student").password("12345").roles("student").build();
		//added the users to the spring boot memory
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	// protection-on the api-url we create in the controller
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http )throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/admin/**").hasRole("admin")
				.requestMatchers("/student/**").hasRole("student")
				.anyRequest().authenticated()
				).httpBasic();
		return http.build();
	}

}
