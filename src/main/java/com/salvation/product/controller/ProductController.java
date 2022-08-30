package com.salvation.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.salvation.product.entity.Products;
import com.salvation.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	//-------Post products to DB---------
	
	@PostMapping("/products/post")
	public ResponseEntity<Products> saveProducts(@RequestBody Products product) {
		return new ResponseEntity<Products>(service.saveProducts(product), HttpStatus.CREATED);
	}

	//---------Get all Products------------
	
	 @GetMapping("/products/get")
	    public List<Products> fetchProducts() {
	        return service.fetchAllProducts();
	    }
	 
	//---------Get Filtered Products--------
	 
	 @GetMapping("/products/filter")
	    public List<Products> fetchProductdata(@RequestParam(defaultValue = "") String productNameFilter) {
	        return service.fetchFilteredProductsData(productNameFilter);
	    }
	//--------Get Filtered products with pagination----------
	 
	 @GetMapping("/products/filter/pagination")
	    public Page<Products> fetchProductData(@RequestParam(defaultValue = "") String productNameFilter,
	                                                          @RequestParam(defaultValue = "0") int page,
	                                                          @RequestParam(defaultValue = "30") int size) {
	        return service.fetchProductFilteredDataWithPagination(productNameFilter, page, size);
	    }
	
	 //--------Update product data----------
	 @PutMapping("/products/put")
	 	public ResponseEntity<Products> updateProduct( @RequestBody Products product){
		 return new ResponseEntity<Products>(service.updateProducts(product), HttpStatus.OK);	 	
		}
	 
	 //   RequestBody passing
		@PutMapping("/updateproductdetails")
		public String updateProductDetails(@RequestBody Products products) {
			return  service.updateProductDetails(products);

}
		// save the Products
		@PostMapping("/saveproductdetails")
		public String saveProductDetails(@RequestBody List<Products> products) {
			service.saveProductDetails(products);
			return "Successfully Saved The SalesDetails";
		}
}
