package com.products.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> listProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
}
