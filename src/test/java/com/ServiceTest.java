package com;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@SpringBootTest(classes = {ServiceTest.class})
public class ServiceTest {
  @Mock
  ProductRepo productRepo;

  @InjectMocks
  ProductService productService;

  @Test
  public void getAllProductTest(){
    List<Product> prods = new ArrayList<Product>();
    prods.add(new Product("001", "dress", 100, 5));
    prods.add(new Product("002", "phone", 10000, 2));

    when(productService.getAllProducts()).thenReturn(prods);
    assertEquals(2, productService.getAllProducts().size());
  }

}
