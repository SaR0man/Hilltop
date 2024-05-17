package com.topacademy.mssql.repository;

import com.topacademy.mssql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}


