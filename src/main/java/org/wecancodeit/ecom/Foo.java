package org.wecancodeit.ecom;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Foo {

	//spring I want you to inject something here: what @resource means; 
	//looks for a string with that name
	@Resource
	private String beetlebrox;
	
	@Override
	public String toString() {
		return "Foo + beetlebrox";
	}
	
}
