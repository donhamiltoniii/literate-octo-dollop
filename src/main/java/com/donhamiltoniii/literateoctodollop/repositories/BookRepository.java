package com.donhamiltoniii.literateoctodollop.repositories;

import org.springframework.data.repository.CrudRepository;

import com.donhamiltoniii.literateoctodollop.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
