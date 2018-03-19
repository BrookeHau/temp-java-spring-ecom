package org.wecancodeit.ecom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfigs {

	@Bean
	public String myOneAndOnlyString() {
		return "shazam";
	}

	// if you add another string the resource in Foo.java will not know which
	// string to grab
	//bean allows it to be injected
	@Bean
	public String anotherString() {
		return "another string";
	}
	
	//won't have a failing test now because you named a string beetlebrox which 
	//you call upon in the Foo class; prior to this it wasn't sure of the two strings
	//which one to inject
	@Bean
	public String beetlebrox() {
		return "this is the string you were looking for";
	}
}
