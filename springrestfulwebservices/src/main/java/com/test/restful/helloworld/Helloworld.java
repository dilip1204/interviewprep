package com.test.restful.helloworld;

public class Helloworld {
	
	String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public Helloworld(String message) {
		super();
		this.message = message;
	}
	
	

}
