package com.Task.LowLevelTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Task.LowLevelTask.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
