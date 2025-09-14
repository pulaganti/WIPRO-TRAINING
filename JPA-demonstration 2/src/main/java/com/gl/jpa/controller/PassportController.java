package com.gl.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.gl.jpa.model.Passport;
import com.gl.jpa.service.PassportService;


@RestController
public class PassportController {
	@Autowired
	PassportService passportService;
	  @PostMapping("/passport/add")
	    public ResponseEntity add(
	             String passportNumber, int personId) {

	        Passport passport = passportService.add(passportNumber, personId);
	        if (passport == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passport not found!!");
	        }

	        return ResponseEntity.status(HttpStatus.OK).body("Passport added successfully");
	  }	
	
	@GetMapping("/passport/getbyid")
	public ResponseEntity getById(@RequestParam int id) {
		Passport passport = passportService.getById(id);
		if(passport == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid passport");	
		}
		return ResponseEntity.status(HttpStatus.OK).body(passport);
		
	}
	@GetMapping("/passport/getall")
	public ResponseEntity<List<Passport>> getAll(){
		List<Passport> passports = passportService.getAll();
		System.out.println("persons : " + passports.size());
		return ResponseEntity.status(HttpStatus.OK).body( passports);
	}

}



























