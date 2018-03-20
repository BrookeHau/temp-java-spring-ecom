package org.wecancodeit.ecom;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

//testing serialization
@RunWith(SpringRunner.class)
@JsonTest
public class CatalogJsonTest {

	@Resource
	private JacksonTester<Product> productJson;
	
	//when this method is called it may throw this specific exception
	//your code may throw an exception but still compile the code and run it
	//serialization converts object to a string
	@Test
	public void shouldSerialize() throws IOException {
		Product product = new Product("product name");
		
		JsonContent<Product> content = productJson.write(product);
		
		Assertions.assertThat(content).extractingJsonPathValue("@.name").isEqualTo("product name");
	}
	
	//deserialization converts string to object
	@Test
	public void shouldDeserialize() throws IOException {
		String jsonContent = "{\"name\": \"product name\"}";
		
		Product parsed = productJson.parseObject(jsonContent);
		
		Assertions.assertThat(parsed.getName()).isEqualTo("product name");
		
	}
}
