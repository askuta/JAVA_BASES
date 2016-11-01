package com.java.bases;

import java.util.Random;

public class E02_Loops {

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[10];
		int sum = 0;

		for (int index = 0; index < array.length; index++) {
			array[index] = random.nextInt(100);
			System.out.println(array[index]);
			sum = sum + array[index];
		}

		System.out.println("összesen: " + sum);
	}
}
