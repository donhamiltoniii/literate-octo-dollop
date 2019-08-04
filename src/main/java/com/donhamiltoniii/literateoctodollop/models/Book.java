package com.donhamiltoniii.literateoctodollop.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String title;

	@ManyToMany
	private Collection<Author> authors;
	private String genre;

	// This is a hook for JPA - We will never call this Constructor
	public Book() {
	}

	public Book(String title, String genre, Author... authors) {
		this.title = title;
		this.authors = new ArrayList<>();
		this.genre = genre;

		for (Author author : authors) {
			this.addAuthor(author);
		}
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public String getGenre() {
		return genre;
	}

	public void addAuthor(Author author) {
		this.authors.add(author);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", genre=" + genre + "]";
	}

}
