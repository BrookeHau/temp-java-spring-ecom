package org.wecancodeit.ecom;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CatalogMvcTest {

	@Resource
	private MockMvc mvc;

	// mockbean is spring testing support, does what mock does
	// but injects bean into testing

	@MockBean
	private CrudRepository<Product, Long> productRepo;

	@Test
	public void shouldFoo() throws Exception {
		mvc.perform(get("/products")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrieveIndividualProduct() throws Exception {
		when(productRepo.findOne(42L)).thenReturn(new Product("some product"));
		mvc.perform(get("/products/42")).andExpect(status().isOk());
	}

	// need to test for 404 (not found), too
	@Test
	public void shouldNotFindProductId() throws Exception {
		mvc.perform(get("/products/42")).andExpect(status().isNotFound());
	}

}
