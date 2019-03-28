package com.practise.microservice;

public class LimitConfiguration {

	private int maximum;
	private int minimum;
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	@Override
	public String toString() {
		return "LimitConfiguration [maximum=" + maximum + ", minimum=" + minimum + "]";
	}
	public LimitConfiguration(int minimum,int maximum) {
		super();
		
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	
	protected LimitConfiguration(){
		
	}
	 	
}
