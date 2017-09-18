package com.example.demo;

public class SearchDto {

	private String[] name;
	private String[] brand;
	private String[] category;
	private String[] condition;
	private Long[] price;
	
	
	public SearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String[] getName() {
		return name;
	}


	public void setName(String[] name) {
		this.name = name;
	}


	public String[] getBrand() {
		return brand;
	}


	public void setBrand(String[] brand) {
		this.brand = brand;
	}


	public String[] getCategory() {
		return category;
	}


	public void setCategory(String[] category) {
		this.category = category;
	}


	public String[] getCondition() {
		return condition;
	}


	public void setCondition(String[] condition) {
		this.condition = condition;
	}


	public Long[] getPrice() {
		return price;
	}


	public void setPrice(Long[] price) {
		this.price = price;
	}
	
}
