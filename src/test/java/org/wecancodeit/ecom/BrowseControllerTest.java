package org.wecancodeit.ecom;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.ecom.BrowseController.ProductNotFoundException;

public class BrowseControllerTest {

	@InjectMocks
	private BrowseController underTest;

	@Mock
	private CrudRepository<Product, Long> productRepo;

	@Mock
	private Product product;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGetProducts() {
		/* BrowseController underTest = new BrowseController(); */
		Iterable<Product> result = underTest.findProducts();
		assertThat(result, is(nullValue()));
	}

	@Test
	public void shouldGetProductsFromDb() {
		/* MockitoAnnotations.initMocks(this); */
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));
		Iterable<Product> result = underTest.findProducts();
		assertThat(result, contains(product));
	}

	@Test
	public void shouldGetIndividualProduct() {
		long id = 42L;
		BrowseController underTest = new BrowseController();
		when(productRepo.findOne(id)).thenReturn(product);
		Product result = productRepo.findOne(id);

		assertThat(result, is(product));
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void shouldReturnNotFoundForBadProductId() {
		long invalidProductId = 42L;
		underTest.findProduct(invalidProductId);
	}

	

}
