package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductService {
  
  @Autowired
  public ProductRepo productRepo;

  //This method returns all the products
  //that are saved in the database
  public List<Product> getAllProducts(){
    return productRepo.findAll();
  }

  public Optional<Product> getByProductId(String productId){
    return productRepo.findById(productId);
  }

  public Optional<Product> getByProductName(String name){
    return productRepo.findByProductName(name);
  }

  public Product addProduct(Product product){
    return productRepo.save(product);
  }

  public String deleteProduct(String productId){
    Optional<Product> productOptional = productRepo.findById(productId);
    if(productOptional.isPresent()){
      productRepo.deleteById(productId);
      return "Product with id"+ productId +
      " is successfully deleted";
    }
    else{
      return "No product with id"+productId+
      "found";
    }
  }

  public String updateProduct(Product product, String prodId){
    Optional<Product> optionalProduct = productRepo.findById(prodId);
    if(optionalProduct.isPresent()){
      Product prod = optionalProduct.get();
      prod.setProductPrice(product.getProductPrice());
      prod.setProductQty(product.getProductQty());
      productRepo.save(prod);
      return "Product details updated "
      +prod.toString();
    }
    else{
      return "No such product";
    }
  }
}
