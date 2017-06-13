package com.java.bakfitty;

public class Derived extends Base {

	public int number;
	
	public Derived() {
		number = 3;
	}

	public void doDerivedThings() {
		super.doBaseThings();
		System.out.println("I'm doing some Derived things: " + number);
	}
	
	public void printNumberFromBase() {
		System.out.println("" + super.number);
	}
	
	@Override
	public String toString() {
		return "Derived class: " + number;
	}
}
