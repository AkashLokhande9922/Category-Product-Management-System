package com.nimap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.entity.Category;
import com.nimap.entity.Product;
import com.nimap.services.CategoryServices;
import com.nimap.services.ProductServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryServices categoryServices;
	@Autowired
	private ProductServices productServices;

	@GetMapping
	public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Category> categories = categoryServices.getAllCategories(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(categories);
		//return ResponseEntity.ok(categories);
	}

	@PostMapping
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category cat = null;
		try {
			cat = this.categoryServices.saveCategory(category);

			return ResponseEntity.status(HttpStatus.CREATED).body(cat);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/{catId}")
	public ResponseEntity<Category> getCategory(@PathVariable("catId") int catId) {
		Category category = categoryServices.getCategory(catId);
		if (category == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
//		List<Product> prodList=productServices.getAllProductsByCategory(catId);
//		category.setProducts(prodList);
		return ResponseEntity.of(Optional.of(category));
	}

	@PutMapping("/{catId}")
	public ResponseEntity<Category> updateCategory(@PathVariable("catId") int catId, @RequestBody Category category) {
		Category updatedCat = null;
		try {
			updatedCat = categoryServices.updateCategory(catId, category);
			return ResponseEntity.status(HttpStatus.OK).body(updatedCat);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/{catId}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("catId") int catId) {
		try {
			categoryServices.deleteCategory(catId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
