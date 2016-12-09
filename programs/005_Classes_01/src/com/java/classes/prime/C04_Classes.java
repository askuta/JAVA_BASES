package com.java.classes.prime;

public class C04_Classes {

	private static final int MAXIMUM_NUMBER = 100;
	
	public static void main(String[] args) {
		
		System.out.println("The primes from 2 to " + MAXIMUM_NUMBER + " are:");
		
		Prime primeObject = new Prime(MAXIMUM_NUMBER);
		primeObject.printPrimes();
	}
}
