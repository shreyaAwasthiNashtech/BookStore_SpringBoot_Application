package com.techhub.springdatajpa_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techhub.springdatajpa_demo.model.Author;
import com.techhub.springdatajpa_demo.model.Book;
import com.techhub.springdatajpa_demo.model.Category;
import com.techhub.springdatajpa_demo.repository.AuthorRepository;
import com.techhub.springdatajpa_demo.repository.BookRepository;
import com.techhub.springdatajpa_demo.repository.CategoryRepository;

@Configuration
public class BookstoreDataSeeder {

    @Bean
    public CommandLineRunner seedData(AuthorRepository authorRepo,
                                      CategoryRepository categoryRepo,
                                      BookRepository bookRepo) {
        return args -> {
            if (authorRepo.count() == 0 && categoryRepo.count() == 0 && bookRepo.count() == 0) {
                
                Author rowling = authorRepo.save(new Author("J.K. Rowling"));
                Author orwell = authorRepo.save(new Author("George Orwell"));
                Author sapiens = authorRepo.save(new Author("Yuval Noah Harari"));

                Category fiction = categoryRepo.save(new Category("Fiction"));
                Category sciFi = categoryRepo.save(new Category("Sci-Fi"));
                Category history = categoryRepo.save(new Category("History"));

                bookRepo.save(new Book("Harry Potter and the Sorcerer's Stone", 499.0, rowling, fiction));
                bookRepo.save(new Book("1984", 350.0, orwell, sciFi));
                bookRepo.save(new Book("Sapiens: A Brief History of Humankind", 599.0, sapiens, history));
            }
        };
    }
}
