package com.java.bases;

import java.util.Random;

public class E03_Loops {

	//H�t ez valami�rt nem akarja a j�t. :'(
	
	private static final int ARRAY_SIZE = 10;
	private static final int RANDOM_NUMBER_LIMIT = 100;
	
	public static void main(String[] args) {
		int[] array = new int[ARRAY_SIZE];
		setRandomNumbers(array);
		printArray(array);
		System.out.println(" | A legnagyobb sz�m: " + maxOfArray(array));
		System.out.println(" | A legkisebb sz�m: " + minOfArray(array));
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

	private static int maxOfArray(int[] array) {
		int max = 0;
		for (int number : array) {
			if (number < max) {max = number;}
		}
		return max;
	}
	
	private static int minOfArray(int[] array) {
		int min = RANDOM_NUMBER_LIMIT;
		for (int number : array) {
			if (number > min) {min = number;}
		}
		return min;
	}
}
