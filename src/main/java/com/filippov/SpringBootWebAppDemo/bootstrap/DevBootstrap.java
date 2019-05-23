package com.filippov.SpringBootWebAppDemo.bootstrap;

import com.filippov.SpringBootWebAppDemo.model.Author;
import com.filippov.SpringBootWebAppDemo.model.Book;
import com.filippov.SpringBootWebAppDemo.model.Publisher;
import com.filippov.SpringBootWebAppDemo.repository.AuthorRepository;
import com.filippov.SpringBootWebAppDemo.repository.BookRepository;
import com.filippov.SpringBootWebAppDemo.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher dddPublisher = new Publisher("Harper Collins", "dddPublisherAddress");
        Book ddd = new Book("Domain Driven Design", "1234", dddPublisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(dddPublisher);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher noEJBPublisher = new Publisher("noEJBPublisherName","hisAddress");
        Book noEJB = new Book("noEJB", "12345", noEJBPublisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(noEJBPublisher);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
