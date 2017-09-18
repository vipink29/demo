package com.example.demo.model;


import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product", type = "product", shards = 1)
public class Product {

    private String productName;
    private Long id;
    private String brand;
    private Long price;
    private String condition;
	private String category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String productName, Long id, String brand, Long price, String condition, String category) {
		super();
		this.productName = productName;
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.condition = condition;
		this.category = category;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	
}