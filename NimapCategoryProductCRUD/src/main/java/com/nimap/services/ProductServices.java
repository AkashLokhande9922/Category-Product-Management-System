package com.nimap.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.dao.ProductRepository;
import com.nimap.dto.CategoryDto;
import com.nimap.dto.ProductDto;
import com.nimap.entity.Product;

@Service
public class ProductServices 
{
	
	@Autowired
	private ProductRepository productRepository; 
	
	public Page<Product> getAllProducts(Pageable pageable)
	{
		return productRepository.findAll(pageable);
	}
	
	public Product saveProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public ProductDto getProduct(int prodId)
	{
		Optional<Product> op=productRepository.findById(prodId);
		Product product=op.get();
		CategoryDto categoryDto=new CategoryDto(product.getCategory().getCatId(),product.getCategory().getCategoryName());
		return new ProductDto(product.getProdId(),product.getProdName(),product.getProdPrice(),categoryDto);
	}
	
//	public Product getProduct(int prodId)
//	{
//		Optional<Product> op=productRepository.findById(prodId);
//		Product product=op.get();
//		return product;
//	}
	
	public Product updateProduct(int prodId,Product product)
	{
		Optional<Product> op=productRepository.findById(prodId);
		Product existingProd=op.get();
		existingProd.setProdName(product.getProdName());
		existingProd.setProdPrice(product.getProdPrice());
		existingProd=productRepository.save(existingProd);
		return existingProd;
	}
	
	public void deleteProduct(int prodId)
	{
		Optional<Product> op=productRepository.findById(prodId);
		Product product=op.get();
		productRepository.delete(product);
	}
	


	
	
	
	  
	
}
