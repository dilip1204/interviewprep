package com.test.restful.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/getBean")
	public SomeBean retriveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
	
	
	@GetMapping("/getBeanList")
	public List<SomeBean> retriveSomeBeanList() {
		return Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("a1","a2","a3"),
				new SomeBean("b1","b2","b3"));
	}

}
