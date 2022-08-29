package com.salvation.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.salvation.product.entity.Products;
import com.salvation.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	// -------Post Data---------
	public Products saveProducts(Products product) {
		return repository.save(product);
	}

	// -------Get All products------
	public List<Products> fetchAllProducts() {
		return repository.findAll();
	}

	// ---------Get Filtered Products--------
	public List<Products> fetchFilteredProductsData(String productNameFilter) {
		return repository.findByProductNameLike(productNameFilter);
	}

	// --------Get Filtered products with pagination----------
	public Page<Products> fetchProductFilteredDataWithPagination(String productNameFilter, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findByProductNameLike(productNameFilter, pageable);
	}

	// -------Update product---------
	public Products updateProducts(Products product) {
		return repository.save(product);
	}
}
