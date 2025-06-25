package com.techhub.springdatajpa_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techhub.springdatajpa_demo.model.Book;
import com.techhub.springdatajpa_demo.repository.AuthorRepository;
import com.techhub.springdatajpa_demo.repository.BookRepository;
import com.techhub.springdatajpa_demo.repository.CategoryRepository;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final CategoryRepository categoryRepo;

    public BookController(BookRepository bookRepo, AuthorRepository authorRepo, CategoryRepository categoryRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        model.addAttribute("authors", authorRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("book", new Book()); // For form
        return "books";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookRepo.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookRepo.findById(id).orElseThrow();
        model.addAttribute("book", book);
        model.addAttribute("books", bookRepo.findAll());
        model.addAttribute("authors", authorRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        return "books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepo.deleteById(id);
        return "redirect:/books";
    }
}