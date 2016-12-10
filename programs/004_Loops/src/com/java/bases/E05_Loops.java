package com.java.bases;

import java.util.Random;

public class E05_Loops {

	private static final int ARRAY_SIZE = 10;
	private static final int RANDOM_NUMBER_LIMIT = 100;
	
	public static void main(String[] args) {
		int[] array = new int[ARRAY_SIZE];
		setRandomNumbers(array);
		printArray(array);
		reverseArray(array);
		System.out.println("Miután az elemek sorrendjét fölcseréltük:");
		printArray(array);
	}

	private static void setRandomNumbers(int[] array) {
		Random random = new Random();
		for (int index = 0; index < array.length; index++) {
			array[index] = random.nextInt(RANDOM_NUMBER_LIMIT);
		}
	}
	
	private static void printArray(int[] array) {
		System.out.print(" | ");
		for (int number : array) {
			System.out.print(number + " | ");
		}
		System.out.println();
	}
	
	private static void reverseArray(int[] array) {
		int temp;
		for (int index = 0; index < array.length / 2; index++) {
			temp = array[index];
			array[index] = array[array.length - index - 1];
			array[array.length - index - 1] = temp;
		}
	}
}
