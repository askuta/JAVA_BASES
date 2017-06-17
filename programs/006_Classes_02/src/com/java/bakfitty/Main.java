package com.java.bakfitty;

public class Main {

	public static void main(String[] args) {
		Base base1 = new Base();
		Base base2 = new Base();
		Derived derived = new Derived();

		base1.doBaseThings();
		derived.doBaseThings();

		System.out.println(base1.toString());
		System.out.println(base2.toString());
		System.out.println(derived.toString());
		
		System.out.println("derived.number: " + derived.number);
		derived.printNumberFromBase();
		derived.doDerivedThings();
	}

}
