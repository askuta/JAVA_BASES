package com.java.bases;

import java.util.Random;

public class E01_Loops {

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[10];
		for (int index = 0; index < array.length; index++) {
			array[index] = random.nextInt(100);
			System.out.println(array[index]);
		}
	}

}
