package com.gl.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
	
	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);

}
