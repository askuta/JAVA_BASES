package com.java.bases;

public class E04_Asterisks {

	public static void main(String[] args) {
		boolean character = true;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (character) {
					System.out.print("*");
				} else {
					System.out.print("-");
				}
				character = !character;
			}
			System.out.println();
		}
	}
}
