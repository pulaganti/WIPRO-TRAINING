package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Passport;

public interface PassportRepo extends JpaRepository<Passport, Integer> {

}
