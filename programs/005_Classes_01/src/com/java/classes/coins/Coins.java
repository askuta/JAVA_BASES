package com.java.classes.coins;

public class Coins {

	private final double price;
	
	public Coins(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void giveCash() {
		System.out.println("The amount of " + price + " would be given as:");
		for (double index = price; index >= 5; ) {
			if (index >= 20000) {
				System.out.print("20000, ");
				index = index - 20000;
			} else if (index >= 10000) {
				System.out.print("10000, ");
				index = index - 10000;
			} else if (index >= 5000) {
				System.out.print("5000, ");
				index = index - 5000;
			} else if (index >= 2000) {
				System.out.print("2000, ");
				index = index - 2000;
			} else if (index >= 1000) {
				System.out.print("1000, ");
				index = index - 1000;
			} else if (index >= 500) {
				System.out.print("500, ");
				index = index - 500;
			} else if (index >= 200) {
				System.out.print("200, ");
				index = index - 200;
			} else if (index >= 100) {
				System.out.print("100, ");
				index = index - 100;
			} else if (index >= 50) {
				System.out.print("50, ");
				index = index - 50;
			} else if (index >= 20) {
				System.out.print("20, ");
				index = index - 20;
			} else if (index >= 10) {
				System.out.print("10, ");
				index = index - 10;
			} else if (index >= 5) {
				System.out.print("5, ");
				index = index - 5;
			}
		}
	}
}
