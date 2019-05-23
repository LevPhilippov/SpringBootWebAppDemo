package com.filippov.SpringBootWebAppDemo.repository;

import com.filippov.SpringBootWebAppDemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
