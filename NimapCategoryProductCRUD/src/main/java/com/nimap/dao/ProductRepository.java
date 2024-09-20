package com.nimap.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	public Optional<Product> findById(int prodId);
	public Page<Product> findAll(Pageable pageable);
}
