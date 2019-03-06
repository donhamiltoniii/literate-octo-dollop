package com.donhamiltoniii.literateoctodollop.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.donhamiltoniii.literateoctodollop.models.Book;
import com.donhamiltoniii.literateoctodollop.repositories.BookRepository;

@Controller
@RequestMapping("/books")
public class BookController {

	@Resource
	BookRepository bookRepo;

	@GetMapping({ "", "/", "/index" })
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books/all";
	}

	@GetMapping("/{id}")
	public String getBook(@PathVariable Long id, Model model) throws Exception {
		Optional<Book> bookOptional = bookRepo.findById(id);
		if (bookOptional.isPresent()) {
			model.addAttribute("book", bookOptional.get());
		} else {
			throw new Exception("The requested book doesn't exist");
		}
		return "books/single";
	}

	@PostMapping("/add")
	public String addBook(String title, String author, String genre) {
		bookRepo.save(new Book(title, author, genre));
		return "redirect:/books";
	}
}
