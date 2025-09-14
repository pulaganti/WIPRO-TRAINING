package com.gl.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
	Optional<Role> findByName(String name);

}
