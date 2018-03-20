package org.wecancodeit.ecom;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class BrowseControllerTest {

	@Test
	public void shouldGetProducts() {
		BrowseController underTest = new BrowseController();
		Collection<Product> result = underTest.getProducts();
		assertThat(result, is(not(empty())));
	} 
	
	@Test
	public void shouldGetIndividualProduct() {
		BrowseController underTest = new BrowseController();
	
		Product result = underTest.getProduct(2L);
		
		assertThat(result,is(not(nullValue())));
		
	}
}
