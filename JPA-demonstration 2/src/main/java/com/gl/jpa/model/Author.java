package com.gl.jpa.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToMany
	@JoinTable( name="Book_Author", joinColumns = @JoinColumn(name="author_Id"),
	inverseJoinColumns=@JoinColumn(name="book_Id"))
	 @JsonIgnoreProperties("authors")   
    private Set<Book> books;

	
		public Author() {
			
		}
		public Author (String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Set<Book> getBook() {
			return books;
		}
		public void setBook(Set<Book> book) {
			this.books = book;
		}
}
