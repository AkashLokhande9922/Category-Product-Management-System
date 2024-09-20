package com.nimap.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{
	public Optional<Category> findById(int catId);
	public Page<Category> findAll(Pageable pageable);
}
