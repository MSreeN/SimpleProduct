package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/prod")
public class ProductController {
  
  @Autowired
  public ProductService productService;

  @GetMapping("/all")
  public ResponseEntity<List<Product>> getAllProduct(){
    try{
      return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    catch(Exception e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/byId/{prodId}")
  public ResponseEntity<Optional<Product>> getProductById(@PathVariable("prodId") String prodId){
    try{
      return new ResponseEntity<>(productService.getByProductId(prodId), HttpStatus.OK);
    }
    catch(Exception E){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/byName/{prodName}")
  public ResponseEntity<Optional<Product>> getProductByName(@PathVariable("prodName") String prodName){
    try{
      return new ResponseEntity<>(productService.getByProductName(prodName),HttpStatus.OK);
    }
    catch(Exception e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/add")
  public ResponseEntity<Product> addProduct(@RequestBody Product prod){
    try{
      return new ResponseEntity<>(productService.addProduct(prod), HttpStatus.CREATED);
    }
    catch(Exception e){
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }

  @PutMapping("/update")
  public ResponseEntity<String> updateProduct(@RequestBody Product prod){
    try{
      return new ResponseEntity<>(productService.updateProduct(prod), HttpStatus.OK);
    }
    catch(Exception e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete/{prodId}")
  public ResponseEntity<String> deleteProduct(@PathVariable("prodId") String prodId){
    try{
      return new ResponseEntity<>(productService.deleteProduct(prodId), HttpStatus.OK);
    }
    catch(Exception e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
