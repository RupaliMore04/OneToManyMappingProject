package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>, PagingAndSortingRepository<Product,Integer>
{

}
