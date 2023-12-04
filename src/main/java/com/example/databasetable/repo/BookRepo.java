package com.example.databasetable.repo;

import com.example.databasetable.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookModel, Long> {
    java.lang.Iterable<BookModel> findByNameContainingIgnoreCase(String name);
}

