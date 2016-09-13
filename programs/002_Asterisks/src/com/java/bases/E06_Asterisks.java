package com.java.bases;

public class E06_Asterisks {

	public static void main(String[] args) {
		int counter = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = i; j < 11; j++) {
				if (counter % 2 == 0) {
					System.out.print("*");
				} else {
					System.out.print("-");
				}
				counter++;	
			}
			System.out.println();
		}
	}
}
