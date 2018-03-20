package org.wecancodeit.ecom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//general annotation in spring; telling spring to recognize it as a 
//thing to pull information from 
//configuration is more specific
/*@Component*/
@Entity
public class Product {

	@Id
	@GeneratedValue
	private long id;
	
	@SuppressWarnings("unused")//needed for JSON/JPA
	private Product() {}
	
	private String name;
	
	
	public Product(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
