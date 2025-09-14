package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Autowired
	CustomUserDetailService  customUserDetailService;
	//encrypt
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customUserDetailService);//loading the user from the service
		authProvider.setPasswordEncoder(passwordEncoder());// setting the encrypt algorithm
		return authProvider;
	}
	//authorization
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth
				.requestMatchers("/create_user").permitAll()
				.requestMatchers("/create_role").permitAll()
				.requestMatchers("/admin/**").hasRole("admin")
				.requestMatchers("/student/**").hasRole("student")
				.anyRequest().authenticated()
				).httpBasic();
		return http.build();
	}
	

}
