package com.gl.security;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@RestController
public class AuthController {
	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	JWTService jwtService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/open/sign-up-admin")
	public String signupAdmin(@RequestParam String username, @RequestParam String password) {
	if(userRepo.existsByUsername(username)) {
	throw new RuntimeException("Username already used");
	}
	Role adminRole = roleRepo.findByName("ROLE_ADMIN").get();
	User user = new User(username, password);
	user.setPassword(passwordEncoder.encode(password));
	user.setRoles( Set.of(adminRole));
	userRepo.save(user);
	//craete the token for this user
	String token = jwtService.generateToken(username, Map.of("roles", "ROLE_ADMIN") );
	return token;
	}
	@PostMapping("/open/sign-up-used")
	public String signupUser(@RequestParam String username,@RequestParam String password) {
	if(userRepo.existsByUsername(username)) {
	throw new RuntimeException("Username already used");
	}
	Role adminRole = roleRepo.findByName("ROLE_USER").get();
	User user = new User(username, password);
	user.setPassword(passwordEncoder.encode(password));
	user.setRoles( Set.of(adminRole));
	userRepo.save(user);
	//craete the token for this user
	String token = jwtService.generateToken(username, Map.of("roles", "ROLE_USER") );
	return token;
	}
	@PostMapping("/open/login")
	   public String adminLogin( String username, String password) {
        // Authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        //generate jwt token
        String token = jwtService.generateToken(username, Map.of());

        return token;
        
    }
	
	
	@GetMapping("/admin/test")
	public String adminTest() {
		return "Welcome to admin api";
		
	}
	
	

}
