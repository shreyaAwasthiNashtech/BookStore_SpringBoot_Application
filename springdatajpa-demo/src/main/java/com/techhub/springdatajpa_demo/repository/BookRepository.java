package com.techhub.springdatajpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.springdatajpa_demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
