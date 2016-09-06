package com.java.bases;

public class E04_AsterisksMode {

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if ((i + j) % 2 == 0 ) {
					System.out.print("*");
				} else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
