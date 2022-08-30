package com.salvation.product.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.salvation.product.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

	
	 String query = "select b from Products b where UPPER(b.productName) like CONCAT('%',UPPER(?1),'%')";
	 
	    @Query(query)
	    List<Products> findByProductNameLike(String productNameFilter);
	    
	    @Query(query)
	    Page<Products> findByProductNameLike(String productNameFilter, Pageable pageable);
	    
	    public Products findByProductId(String ProductId);
}
