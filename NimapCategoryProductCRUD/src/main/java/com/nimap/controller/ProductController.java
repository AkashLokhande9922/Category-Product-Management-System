package com.nimap.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.dto.ProductDto;
import com.nimap.entity.Product;
import com.nimap.services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	@Autowired
	private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue="10") int size)
	{
		Pageable pageable=PageRequest.of(page, size);
		Page<Product> products=productServices.getAllProducts(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product prod=null;
		try 
		{
			prod=this.productServices.saveProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(prod);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{prodId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("prodId")int prodId)
	{
		System.out.println("GetProduct Controller");
		ProductDto product=productServices.getProduct(prodId);
		if(product==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
//		System.out.println(product.getCategory());
		return ResponseEntity.of(Optional.of(product)); 
	}
	
	@PutMapping("/{prodId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("prodId") int prodId)
	{
		Product updatedProd=null;
		try
		{
			updatedProd=productServices.updateProduct(prodId, product);
			return ResponseEntity.status(HttpStatus.OK).body(updatedProd);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{prodId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("prodId") int prodId)
	{
		try 
		{
			productServices.deleteProduct(prodId);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
