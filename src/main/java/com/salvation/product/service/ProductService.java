package com.salvation.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.salvation.product.entity.Products;
import com.salvation.product.entity.Sales;
import com.salvation.product.repository.ProductRepository;
import com.salvation.product.repository.SalesRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private SalesRepository salseReop;

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
	public String updateProductDetails(Products products) {
		String productId = products.getProductId();
		int quantity = products.getQuantity();
		Products productdetails1 = repository.findByProductId(productId);
		System.out.println(productdetails1);

		int price = productdetails1.getPrice();
		System.out.println(price);
		int excistingquantity = productdetails1.getQuantity();
		if (excistingquantity >= quantity) {
			// Product Table Updation
			int excistingquantity1 = excistingquantity - quantity;
			productdetails1.setQuantity(excistingquantity1);
			repository.save(productdetails1);
			System.out.println("updated");

			// sale table Insertion

			Sales sales = new Sales(productId, quantity, quantity * price);
			System.out.println(sales);
			salseReop.save(sales);
			return "Updated Successfully";
		} else {
			return "Out Of Stock";
		}

	}
	// save the products
	public void saveProductDetails(List<Products> products) {
		repository.saveAll(products);
	}
}
