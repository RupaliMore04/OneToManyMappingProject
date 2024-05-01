package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	@Autowired
	ProductService proser;
	
	@Autowired
	ProductRepository prorepo;
	
	@GetMapping("/get")
	public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,
	                                                    @RequestParam(defaultValue = "10") int size) {
	    Page<Product> products = proser.getAllProducts(page, size);
	    return ResponseEntity.ok(products);
	}


	 @GetMapping("/get{id}")
	 public Product getProductById(@PathVariable int id)
	 {
		 return proser.getProductById(id).orElse(null);
	 }
	 
	 @PostMapping("/post")
	 public Product createProduct(@RequestBody Product product)
	 {
		 return proser.createProduct(product);
	 }

	 @PutMapping("/update{id}")
	 public Product updateProduct(@PathVariable int id, @RequestBody Product newP) 
	 {
		 return proser.updateProduct(id, newP);
	 }
	 
	 @DeleteMapping("/delete{id}")
	 public void deleteProduct(@PathVariable int id)
	 {
		 proser.deleteProduct(id);
	 }

}
