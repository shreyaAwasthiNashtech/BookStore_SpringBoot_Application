package com.techhub.springdatajpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.springdatajpa_demo.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
