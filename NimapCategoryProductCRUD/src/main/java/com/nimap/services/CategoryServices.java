package com.nimap.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.dao.CategoryRepository;
import com.nimap.entity.Category;

@Service
public class CategoryServices 
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Page<Category> getAllCategories(Pageable pageable)
	{
		return categoryRepository.findAll(pageable);
	}
	
	public Category saveCategory(Category category)
	{
		return categoryRepository.save(category);
	}
	
	public Category getCategory(int catId)
	{
		Optional<Category> op=categoryRepository.findById(catId);
		Category category=op.get();
		return category;
	}
	
	public Category updateCategory(int catId,Category category)
	{
		Optional<Category> op=categoryRepository.findById(catId);
		Category existingCat=op.get();
		existingCat.setCategoryName(category.getCategoryName());
		existingCat=categoryRepository.save(existingCat);
		return existingCat;
	}
	
	public void deleteCategory(int catId)
	{
		Optional<Category> op=categoryRepository.findById(catId);
		Category category=op.get();
		categoryRepository.delete(category);
	}
}
