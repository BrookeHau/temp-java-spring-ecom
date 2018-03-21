package org.wecancodeit.ecom;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@Resource
	private CrudRepository<Product, Long> productRepo;

	@RequestMapping("/products")
	public Iterable<Product> findProducts() {
		return productRepo.findAll();
	}

	// with rest controller you just return JSON requests, not thymeleaf pages
	@RequestMapping("/products/{id}")
	public Product findProduct(@PathVariable(name = "id") long id) {
/*		return productRepo.findOne(id);
*/		Product selectedProduct = productRepo.findOne(id);
		if (selectedProduct != null) {
		return selectedProduct;
		}
		throw new ProductNotFoundException();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ProductNotFoundException extends RuntimeException{
		
	}
}
