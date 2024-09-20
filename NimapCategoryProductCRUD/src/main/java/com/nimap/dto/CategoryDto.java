package com.nimap.dto;

public class CategoryDto 
{
	private int catId;
	private String categoryName;
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryDto(int catId, String categoryName) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
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

	
}
