package com.products.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Products")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	@ApiOperation(value="Return a list of products")
	public List<Product> listProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value="Return one product specified")
	public Product getProduct(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	@ApiOperation(value="Save one product")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/product/{id}")
	@ApiOperation(value="Delete one product specified")
	public void deleteProduct(@PathVariable(value="id") long id) {
		boolean product = productRepository.existsById(id);
		
		if (product) {
			productRepository.deleteById(id);
		}
	}
	
	@PutMapping("/product")
	@ApiOperation(value="Update one product specified")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
}
