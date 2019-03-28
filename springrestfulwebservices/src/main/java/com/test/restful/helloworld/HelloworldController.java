package com.test.restful.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello Dheshna";
	}
	
	@GetMapping(path="/hello-world-bean")
	public Helloworld helloWorldBean() {
		return new Helloworld("Hello Vinoothini");
	}
	
	
	@GetMapping(path="/hello-world/path-variable/{message}")
	public Helloworld helloWorldBean(@PathVariable String message) {
		return new Helloworld(String.format("Hello Vinoothini,%s",message));
	}
	

}
