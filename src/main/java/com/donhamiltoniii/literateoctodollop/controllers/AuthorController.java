package com.donhamiltoniii.literateoctodollop.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.donhamiltoniii.literateoctodollop.models.Author;
import com.donhamiltoniii.literateoctodollop.repositories.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Resource
	AuthorRepository authorRepo;

	@GetMapping({ "", "/", "/index" })
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/all";
	}

	@GetMapping("/{id}")
	public String getAuthor(@PathVariable Long id, Model model) throws Exception {
		Optional<Author> authorOptional = authorRepo.findById(id);
		if (authorOptional.isPresent()) {
			model.addAttribute("author", authorOptional.get());
		} else {
			throw new Exception("The requested author doesn't exist");
		}
		return "authors/single";
	}

	@PostMapping("/add")
	public String addAuthor(String firstName, String lastName) {
		authorRepo.save(new Author(firstName, lastName));

		return "redirect:/authors";
	}
}
