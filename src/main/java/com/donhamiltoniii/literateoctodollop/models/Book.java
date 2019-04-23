package com.donhamiltoniii.literateoctodollop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String title;

	@ManyToOne
	private Author author;
	private String genre;

	// This is a hook for JPA - We will never call this Constructor
	public Book() {
	}

	public Book(String title, Author author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + "]";
	}

}
