package com.example.demo.repository;


import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
	
    List<Product> findByProductName(String name);
    List<Product> findByBrand(String brand);
}