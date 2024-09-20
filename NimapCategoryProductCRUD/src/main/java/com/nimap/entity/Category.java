package com.nimap.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int catId;
	private String categoryName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Product> products;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int catId, String categoryName, List<Product> products) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		this.products = products;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + ", products=" + products + "]";
	}
	
	
	
}
