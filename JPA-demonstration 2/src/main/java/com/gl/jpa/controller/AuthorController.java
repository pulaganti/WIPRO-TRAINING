package com.gl.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.jpa.model.Author;
import com.gl.jpa.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	@PostMapping("/Author/add")
	public ResponseEntity add(@RequestParam String name) {
		Author author = authorService.add(name);
		if(author == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add author");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Author added");
	}

}
