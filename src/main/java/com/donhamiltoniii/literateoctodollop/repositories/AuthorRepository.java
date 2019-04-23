package com.donhamiltoniii.literateoctodollop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.donhamiltoniii.literateoctodollop.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Author findByFirstNameAndLastName(String firstName, String lastName);

}
