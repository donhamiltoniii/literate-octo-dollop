package com.donhamiltoniii.literateoctodollop;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.donhamiltoniii.literateoctodollop.models.Author;
import com.donhamiltoniii.literateoctodollop.models.Book;
import com.donhamiltoniii.literateoctodollop.repositories.AuthorRepository;
import com.donhamiltoniii.literateoctodollop.repositories.BookRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	AuthorRepository authorRepo;

	@Resource
	BookRepository bookRepo;

	@Override
	public void run(String... args) throws Exception {
		Author rodJohnson = authorRepo.save(new Author("Rod", "Johnson"));
		Author juergenHoeller = authorRepo.save(new Author("Juergen", "Hoeller"));

		Author craigWalls = authorRepo.save(new Author("Craig", "Walls"));

		Author ericFreeman = authorRepo.save(new Author("Eric", "Freeman"));
		Author bertBates = authorRepo.save(new Author("Bert", "Bates"));
		Author kathySierra = authorRepo.save(new Author("Kathy", "Sierra"));
		Author elisabethRobson = authorRepo.save(new Author("Elisabeth", "Robson"));

		bookRepo.save(new Book("J2EE Development without EJB", "Tech", rodJohnson, juergenHoeller));
		bookRepo.save(new Book("Spring Boot In Action", "Tech", craigWalls));
		bookRepo.save(
				new Book("Head First Design Patterns", "Tech", ericFreeman, bertBates, kathySierra, elisabethRobson));
	}

}
