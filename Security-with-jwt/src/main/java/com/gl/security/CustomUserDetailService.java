package com.gl.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepo.findByUsername(username).get();
		 return new org.springframework.security.core.userdetails.User(
	                user.getUsername(),
	                user.getPassword(),
         user.getRoles().stream().map(temp -> new SimpleGrantedAuthority(temp.getName()))
                        .collect(Collectors.toList()));
	}

}
