package com.gl.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	
	//create role
	@PostMapping("/create_role")
	public String createRole(String name) {
		if(roleRepo.findByName(name).isEmpty()) {
			Role role = new Role(name);
			roleRepo.save(role);
			return "Role Created";
		}else {
			return "Role name already taken";
		}
		
	}
	//create users
	@PostMapping("/create_user")
	public String createUsername(String username,String password,String roleName) {
		if(roleRepo.findByName(roleName).isEmpty()) {
			return "Invalid role";
			
		}
		Role role = roleRepo.findByName(roleName).get();
		if(userRepo.findByUsername(username).isEmpty()) {
			//creating new user and save it
			User user = new User(username,password);
			user.setPassword(encoder.encode(password));
			Set<Role> myRoles = new HashSet<>();
			myRoles.add(role);
			user.setRoles(myRoles);
			userRepo.save(user);
			
			return "User Created";
		}
		else {
			return "User is already taken";
		}
	}

}
