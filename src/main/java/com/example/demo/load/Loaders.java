package com.example.demo.load;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Product.class);
        System.out.println("Loading Data");
        
        productRepository.save(getData());
        System.out.printf("Loading Completed");

    }

    
    //(String productName, Long id, String brand, Long price, String condition, String category)
    private List<Product> getData() {
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product("sonytv",123L,"sony", 80000L,"new","television"));
        productsList.add(new Product("samsungtv",124L,"samsung", 72000L,"new","television"));
        productsList.add(new Product("lgtv",125L,"lg", 42000L,"new","television"));
        productsList.add(new Product("sonytv",126L,"sony", 42000L,"used","television"));
        productsList.add(new Product("samsungtv",127L,"samsung", 32000L,"used","television"));
        productsList.add(new Product("lgtv",128L,"lg", 22000L,"used","television"));
        productsList.add(new Product("sofa",129L,"sofa", 22000L,"used","furniture"));
        productsList.add(new Product("sofa",130L,"sofa", 62000L,"new","furniture"));
        productsList.add(new Product("bed",131L,"bed", 55000L,"new","furniture"));
        productsList.add(new Product("bed",132L,"bed", 22000L,"used","furniture"));
        productsList.add(new Product("chair",128L,"chair", 18000L,"used","furniture"));
        productsList.add(new Product("chair",128L,"chair", 42000L,"new","furniture"));
        


        return productsList;
    }
}