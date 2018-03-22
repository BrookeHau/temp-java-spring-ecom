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
	//don't need a generated value if it just reads products; doesn't create 
	//the products, we're just reading them
	//if the API is not generating or making data and is just accessing 
	//the data in the DB then no generated value annotation is needed
	//in this case you wouldn't need a constructor is the DB is already populated with info
	
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
