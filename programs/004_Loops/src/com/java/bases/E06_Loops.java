package com.java.bases;

import java.util.Random;

public class E06_Loops {

	private static final int ARRAY_SIZE = 10;
	private static final int RANDOM_NUMBER_LIMIT = 100;

	public static void main(String[] args) {
		int[] array = new int[ARRAY_SIZE];
		setRandomNumbers(array);
		printArray(array);
		sortIncArray(array);
		System.out.println("Növekvõ sorrendbe rendezve:");
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

	private static void sortIncArray(int[] array) {
		int switcher;
		boolean didSwap = true;
		while (didSwap) {
			didSwap = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					switcher = array[j];
					array[j] = array[j + 1];
					array[j + 1] = switcher;
					didSwap = true;
				}
			}
		}
	}
}
