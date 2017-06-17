package com.java.bakfitty;

public class Base {

	public int number;
	
	public Base() {
		number = 42;
	}
	
	public void doBaseThings() {
		System.out.println("I'm doing some Base things: " + number);
	}
	
	@Override
	public String toString() {
		return "Base class: " + number;
	}
}
