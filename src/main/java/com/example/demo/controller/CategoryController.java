package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

import com.example.demo.entity.Category;

import com.example.demo.service.CategoryService;


@RestController
@RequestMapping("api/categories")
public class CategoryController 
{
	@Autowired
	private CategoryService catser;
		
	
	@GetMapping("/get")
	public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "0") int page,
	                                                       @RequestParam(defaultValue = "10") int size) {
	    Page<Category> categories = catser.getAllCategories(page, size);
	    return ResponseEntity.ok(categories);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) 
	{
	    Optional<Category> category = catser.getCategoryById(id);
	    return category.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	 
	 @PostMapping("/post")
	 public Category createCategory(@RequestBody Category category) 
	 {
		 
		 return catser.createCategory(category);
	 }
	 
	 @PutMapping("/update{id}")
	 public Category updateCategory(@PathVariable int id, @RequestBody Category newC)
	 {
		 return catser.updateCategory(id, newC);
	 }

	 @DeleteMapping("/delete{id}")
	 public void deleteCategory(@PathVariable int id)
	 {
		 catser.deleteCategory(id);
	 }

}
