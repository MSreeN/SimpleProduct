package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
  @Id
  private String productId;
  private String productName;
  private int productPrice;
  private int productQty;
  public String getProductId() {
    return productId;
  }
  public String getProductName() {
    return productName;
  }
  public int getProductPrice() {
    return productPrice;
  }
  public int getProductQty() {
    return productQty;
  }
  public void setProductPrice(int productPrice) {
    this.productPrice = productPrice;
  }
  public void setProductQty(int productQty) {
    this.productQty = productQty;
  }
  public Product(String productId, String productName, int productPrice, int productQty) {
    this.productId = productId;
    this.productName = productName;
    this.productPrice = productPrice;
    this.productQty = productQty;
  }

  
}
