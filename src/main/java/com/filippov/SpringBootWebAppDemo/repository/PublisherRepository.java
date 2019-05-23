package com.filippov.SpringBootWebAppDemo.repository;

import com.filippov.SpringBootWebAppDemo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
