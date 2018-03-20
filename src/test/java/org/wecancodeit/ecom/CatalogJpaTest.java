package org.wecancodeit.ecom;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CatalogJpaTest {

	@Resource 
	private CrudRepository<Product, Long> productRepo; 
	//use crudrepository to make testing simpler, repository gives you access to 
	//methods such as findAll, findOne, etc
	
	
	
	@Test
	public void shouldInitializeProductRepository() {
	
	}
}
