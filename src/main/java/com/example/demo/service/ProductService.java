package com.example.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class ProductService
{
	@Autowired
	ProductRepository prorepo;
	
	@Autowired
	CategoryRepository catrepo;

	
	public Page<Product> getAllProducts(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    return prorepo.findAll(pageable);
	}
	
	 public Optional<Product> getProductById(int id) {
	        return prorepo.findById(id);
	    }

	    public Product createProduct(Product product) 
	    {
	    	
	        return prorepo.save(product);
	    }

	    public Product updateProduct(int id, Product newP) {
	        newP.setProductId(id);
	        return prorepo.save(newP);
	    }

	    public void deleteProduct(int id) {
	    	prorepo.deleteById(id);
	    }

	    public Page<Product> getAllProductsWithPagination(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        return prorepo.findAll(pageable);
	    }

}
