package com.java.bases;

import java.util.Random;

public class E04_Loops {

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[10];
		int switcher;
		
		for (int index = 0; index < array.length; index++) {
			array[index] = random.nextInt(100);
			System.out.println(array[index]);
		}
		
		switcher = array[0]; array[0] = array[9]; array[9] = switcher;
		System.out.println("Miután az elsõ és utolsó elemet kicseréltük:");
		
		for (int index = 0; index < array.length; index++) {
			System.out.println(array[index]);
		}
	}

}
