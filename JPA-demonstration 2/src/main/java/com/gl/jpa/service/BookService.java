package com.gl.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Author;
import com.gl.jpa.model.Book;
import com.gl.jpa.repo.AuthorRepo;
import com.gl.jpa.repo.BookRepo;

@Service
public class BookService {
	@Autowired
	AuthorRepo authorRepo;
	@Autowired
	BookRepo bookRepo;
	//insert 
	public Book add(String name) {
		Book book = new Book(name);
		return bookRepo.save(book);		
	}
	public Book assignAuthor(int bookId,int authorId) {
		Optional<Book> bookOpt = bookRepo.findById(authorId);
		if(bookOpt.isEmpty()) {
			return null;
		}
		Optional<Author> authorOpt = authorRepo.findById(bookId);
		if(authorOpt.isEmpty()) {
			return null;
		}
		Book book = bookOpt.get();
		book.getAuthor().add(authorOpt.get());
		bookRepo.save(book);
		return book;
	}

}
