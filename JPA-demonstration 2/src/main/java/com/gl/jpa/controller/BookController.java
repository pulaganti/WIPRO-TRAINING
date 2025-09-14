package com.gl.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.jpa.model.Book;
import com.gl.jpa.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/Book/add")
	public ResponseEntity add(@RequestParam String name) {
		Book book = bookService.add(name);
		if(book == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add book");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Book added");
	}
	@PostMapping("/Book/mapauthor")
	public ResponseEntity mapAuthor(@RequestParam int bookId,@RequestParam int authorId) {
		Book book = bookService.assignAuthor(bookId, authorId);
		if(book == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error in mapping author");
		}
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}

}
