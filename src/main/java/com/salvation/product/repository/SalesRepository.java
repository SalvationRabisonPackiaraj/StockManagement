package com.salvation.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.salvation.product.entity.Sales;


@Repository
public interface SalesRepository extends JpaRepository<Sales,Integer>{
        
}