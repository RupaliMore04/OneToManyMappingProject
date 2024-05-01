package com.example.demo.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class CategoryService 
{
	@Autowired
	CategoryRepository catrepo;
	
	
	public Page<Category> getAllCategories(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    return catrepo.findAll(pageable);
	}
	
	public Optional<Category> getCategoryById(int id) 
	{
        return catrepo.findById(id);
    }

	public Category createCategory(Category category) 
	{
        return catrepo.save(category);
    }
	
	public Category updateCategory(int id, Category newC)
	{
        newC.setCategoryId(id);
        return catrepo.save(newC);
    }
	
	public void deleteCategory(int id) 
	{
		catrepo.deleteById(id);
	}
	
	
	
	public Page<Category> getAllPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return catrepo.findAll(pageable);
    }
	
	
}
