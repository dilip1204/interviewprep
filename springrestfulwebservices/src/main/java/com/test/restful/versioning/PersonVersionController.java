package com.test.restful.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
	
	
	//Request parameter versioning
	@GetMapping(value ="/person/header", params="version=1")
	public PersonV1 header() {
		return new PersonV1("Dilip kumar");
	}
	
	@GetMapping(value ="/person/header", params="version=2")
	public PersonV2 header2() {
		return new PersonV2(new Names("Dilip","kumar"));
	}
	
	
	//HEADER PARAM VERSIONING
	@GetMapping(value ="/person/param", headers="X-API-VERSION=1")
	public PersonV1 getName1() {
		return new PersonV1("Dilip kumar");
	}
	
	@GetMapping(value ="/person/param", headers="X-API-VERSION=2")
	public PersonV2 param2() {
		return new PersonV2(new Names("Dilip","kumar"));
	}
	
	//PRODUCES PARAM VERSIONING(mime type versioning)
	@GetMapping(value ="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 getName2() {
		return new PersonV1("Dilip kumar");
	}
	
	@GetMapping(value ="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 param3() {
		return new PersonV2(new Names("Dilip","kumar"));
	}
	
	
}
