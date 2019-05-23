package com.filippov.SpringBootWebAppDemo.repository;

import com.filippov.SpringBootWebAppDemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
