package com.java.classes.coins;

public class Coins {

	private static final int[] DENOMS = { 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5 };
	
	private final int price;
	
	public Coins(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void giveCash() {
		System.out.println("The amount of " + price + " would be given as:");
		int tempPrice = price;
		for (int denom : DENOMS) {
			while (tempPrice >= denom) {
				System.out.print(denom + ", ");
				tempPrice = tempPrice - denom;
			}	
		}
		
		if ((DENOMS[DENOMS.length - 1] + 1) / 2 <= tempPrice) {
			System.out.print(DENOMS[DENOMS.length - 1]);
		}
	}
}
