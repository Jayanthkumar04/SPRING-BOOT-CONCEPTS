package com.example.demo.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository repo;
	
	
//	@PostConstruct
//	public void initDB() {
//		List<Product> products = IntStream.rangeClosed(1, 200)
//								.mapToObj(i->new Product("product"+i,new Random().nextInt(100), new Random().nextLong(100))).collect(Collectors.toList());
//	
//		repo.saveAll(products);
//		
//	}
	
	
	public List<Product> getAllProducts()
	{
		return repo.findAll();
	}
	
	public List<Product> getProductsWithSorting(String field)
	{
		return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public Page<Product> getAllProductsByPagination(int offset,int pages)
	{
	return repo.findAll(PageRequest.of(offset, pages));
	}
	
	public Page<Product> getAllProductsByPaginationAndSorting(int offset,int pages,String field)
	{
		return repo.findAll(PageRequest.of(offset, pages).withSort(Sort.by(field)));
	}
	
	
}
