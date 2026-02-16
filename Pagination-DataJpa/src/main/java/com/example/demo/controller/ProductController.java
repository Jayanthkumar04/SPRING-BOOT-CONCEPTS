package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.APIResponse;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public APIResponse<List<Product>> getProducts() {
		List<Product> allProducts  = service.getAllProducts();
		return new APIResponse<>(allProducts.size(),allProducts);
	} 	
	
	@GetMapping("/f")
	public APIResponse<List<Product>> getProductsWithSort(@RequestParam("field") String field)
	{
		List<Product> allProducts  = service.getProductsWithSorting(field);
		return new APIResponse<>(allProducts.size(),allProducts);
		
	}
	
	@GetMapping("/pagenation/{offset}/{pages}")
	public APIResponse<Page<Product>> getProductsWithPagenation(@PathVariable("offset") int offset,@PathVariable("pages") int pages)
	{
	     Page<Product> productsWithPagenation = service.getAllProductsByPagination(offset, pages);
	     
	     return new APIResponse<>(productsWithPagenation.getSize(),productsWithPagenation);
	}
	
	@GetMapping("/pagenation/{offset}/{pages}/{field}")
	public APIResponse<Page<Product>> getProductsWithPagenationAndSorting(@PathVariable("offset") int offset,@PathVariable("pages") int pages,@PathVariable("field") String field)
	{
	     Page<Product> productsWithPagenation = service.getAllProductsByPaginationAndSorting(offset, pages, field);
	     
	     return new APIResponse<>(productsWithPagenation.getSize(),productsWithPagenation);
	}
	
}
