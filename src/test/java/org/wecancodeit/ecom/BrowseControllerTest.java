package org.wecancodeit.ecom;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
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
	/*	BrowseController underTest = new BrowseController();*/
		Iterable<Product> result = underTest.getProducts();
		assertThat(result, is(nullValue()));
	}

	@Test
	public void shouldGetProductsFromDb() {
		/*MockitoAnnotations.initMocks(this);*/
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));
		Iterable<Product> result = underTest.getProducts();
		assertThat(result, contains(product));
	}

	@Test
	public void shouldGetIndividualProduct() {
		BrowseController underTest = new BrowseController();

		Product result = underTest.getProduct(2L);

		assertThat(result, is(not(nullValue())));
	}

}
