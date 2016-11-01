package com.java.bases;

import java.util.Random;

public class E06_Loops {

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[10];
		int switcher;
		boolean didSwap = true;
		
		for (int index = 0; index < array.length; index++) {
			array[index] = random.nextInt(100);
			System.out.println(array[index]);
		}
		
		while (didSwap){
			didSwap= false;
			for(int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					switcher = array[j]; array[j] = array[j+1];	array[j+1] = switcher;
					didSwap = true;
				}
			}
		}
		
		System.out.println("Növekvõ sorrendbe rendezve:");
		
		for (int index = 0; index < array.length; index++) {
			System.out.println(array[index]);
		}
	}

}
