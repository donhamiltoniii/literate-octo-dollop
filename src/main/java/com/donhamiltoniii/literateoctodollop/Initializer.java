package com.donhamiltoniii.literateoctodollop;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.donhamiltoniii.literateoctodollop.models.Book;
import com.donhamiltoniii.literateoctodollop.repositories.BookRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	BookRepository bookRepo;

	@Override
	public void run(String... args) throws Exception {
		bookRepo.save(new Book("J2EE Development withou EJB", "Rod Johnson", "Tech"));
		bookRepo.save(new Book("Spring Boot In Action", "Craig Walls", "Tech"));
		bookRepo.save(new Book("Head First Design Patterns", "Elisabeth Robson", "Tech"));
	}

}
