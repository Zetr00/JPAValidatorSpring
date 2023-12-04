package com.example.databasetable.repo;

import com.example.databasetable.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductModel, Long> {
    ProductModel findByName(String name);
}
