package com.gl.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Author;
import com.gl.jpa.model.Book;
import com.gl.jpa.repo.AuthorRepo;
import com.gl.jpa.repo.BookRepo;

@Service
public class AuthorService {
	@Autowired
	AuthorRepo authorRepo;
	@Autowired
	BookRepo bookRepo;
	//insert 
	public Author add(String name) {
		Author author = new Author(name);
		return authorRepo.save(author);		
	}
	public Author assignBook(int bookId,int authorId) {
		Optional<Author> authorOpt = authorRepo.findById(bookId);
		if(authorOpt.isEmpty()) {
			return null;
		}
		Optional<Book> bookOpt = bookRepo.findById(authorId);
		if(bookOpt.isEmpty()) {
			return null;
		}
		Author author = authorOpt.get();
		author.getBook().add(bookOpt.get());
		authorRepo.save(author);
		return author;
	}

}
