package com.test.restful.versioning;

public class PersonV2 {
	
	private Names name;

	public Names getName() {
		return name;
	}

	public void setName(Names name) {
		this.name = name;
	}
	
	public PersonV2() {
	}


	public PersonV2(Names name) {
		super();
		this.name = name;
	}
	
	

}
