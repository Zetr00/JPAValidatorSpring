package com.example.databasetable.repo;

import com.example.databasetable.model.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepo extends JpaRepository<ClassModel, Long> {
    ClassModel findByName(String name);
}
