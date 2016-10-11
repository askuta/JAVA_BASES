package com.java.bases;

public class E06_Asterisks_Mod {

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11 - i; j++) {
				
				if (i % 4 == 0 || i % 4 == 3) {
					if (j % 2 == 0) {
						System.out.print("*");
					} else {
						System.out.print("-");
					}	
				} else {
					if (j % 2 == 1) {
						System.out.print("*");
					} else {
						System.out.print("-");
					}	
				}
			}
			System.out.println();
		}
	}
}
