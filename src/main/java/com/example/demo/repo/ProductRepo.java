package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Product;

public interface ProductRepo extends MongoRepository<Product, String>{
  
  Optional<Product> findByProductName(String name);
}
