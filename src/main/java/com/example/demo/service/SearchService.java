package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SearchDto;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/rest/search")
public class SearchService {

    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    @ResponseBody
    public List<Product> getProductByFilter(@RequestBody SearchDto sdto) {
        return getAllProductListByFilter(sdto) ;//(all fields are necessary)
    }
    
    public List<Product> getAllProductListByFilter(SearchDto sdto){
    	
    	Long min=sdto.getPrice()[0];
    	Long max=sdto.getPrice()[1];
    	
    	QueryBuilder query=QueryBuilders.boolQuery()
    			.must(QueryBuilders.termsQuery("productName",sdto.getName()))
    			.must(QueryBuilders.termsQuery("condition",sdto.getCondition()))
    			.must(QueryBuilders.termsQuery("brand",sdto.getBrand()))
    			.must(QueryBuilders.termsQuery("category",sdto.getCategory()))
    			.must(QueryBuilders.rangeQuery("price").from(min).to(max));
    	
    	
    	NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

    	System.out.println("query is "+query);
        List<Product> products = elasticsearchTemplate.queryForList(build, Product.class);
    	
    	System.out.println("product list is"+products.size());
    	
        return products;
    }
    
    @GetMapping(value = "/name/{text}")
    public List<Product> searchName(@PathVariable final String text) {
    	
        QueryBuilder query = QueryBuilders.boolQuery()
                .must( QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true)
                        .field("productName")
                        );
        
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        System.out.println(query);
        List<Product> products = elasticsearchTemplate.queryForList(build, Product.class);
        return products;
    }

    @GetMapping(value = "/all")
    public List<Product> searchAll() {
        List<Product> productList = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        products.forEach(productList::add);
        return productList;
    }


}