package com.example1.demo2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example1.demo2.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
    
}
