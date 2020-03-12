package com.kk.springapp.bootstrap;

import com.kk.springapp.domain.Author;
import com.kk.springapp.domain.Book;
import com.kk.springapp.domain.Publisher;
import com.kk.springapp.repositories.AuthorRepository;
import com.kk.springapp.repositories.BookRepository;
import com.kk.springapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");

        Book ddd =  new Book("Domain Driven Design", "123123");

        Publisher pub1 = new Publisher();
        pub1.setName("SFG Publishing");
        pub1.setCity("Bialystok");

        publisherRepository.save(pub1);


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric); //saving into H2 database
        bookRepository.save(ddd); //saving into H2 database

        Author rod = new Author("Rod", "Johnson");
        Book noEJB =  new Book("J2EE Developement without EJB", "12352346521");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}