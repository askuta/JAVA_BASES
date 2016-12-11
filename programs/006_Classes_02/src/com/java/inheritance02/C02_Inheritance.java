package com.java.inheritance02;

public class C02_Inheritance {

	public static void main(String[] args) {
		// Print general stuff of lemon:
		System.out.println("Create a lemon...");
		Lemon lemon = new Lemon();
		System.out.println("\tLemon's color is: " + lemon.getFruitColor());
		System.out.println("\tLemon's taste is: " + lemon.getFruitTaste());

		// Spoil lemon and print again:
		System.out.println("\nSpoil lemon...");
		lemon.spoilFruit();
		System.out.println("\tLemon's color is: " + lemon.getFruitColor());
		System.out.println("\tLemon's taste is: " + lemon.getFruitTaste());

		// Create kiwi and orange and print some specific stuff:
		Kiwi kiwi = new Kiwi();
		Orange orange = new Orange();

		System.out.println("\nCall kiwi and orange specific methods:");
		kiwi.doSomeKiwiStuff();
		orange.doSomeOrangeStuff();
	}
}
