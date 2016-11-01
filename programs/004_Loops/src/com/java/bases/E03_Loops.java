package com.java.bases;

import java.util.Random;

public class E03_Loops {

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[10];
		int max = 0;
		int min = 100;

		for (int index = 0; index < array.length; index++) {
			array[index] = random.nextInt(100);
			System.out.println(array[index]);
			if (array[index] > max) {max = array[index];}
			else if (array[index] < min) {min = array[index];}
		}

		System.out.println("A legnagyobb szám: " + max);
		System.out.println("A legkisebb szám: " + min);
	}
}
