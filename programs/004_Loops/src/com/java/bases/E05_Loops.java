package com.java.bases;

import java.util.Random;

public class E05_Loops {

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[10];
		int[] yarra = new int[10];
		
		for (int index = 0; index < array.length; index++) {
			array[index] = random.nextInt(100);
			yarra[array.length - index - 1] = array[index];
			System.out.println(array[index]);
		}
		
		System.out.println("Miután az elemek sorrendjét fölcseréltük:");
		
		for (int index = 0; index < yarra.length; index++) {
			System.out.println(yarra[index]);
		}
	}

}
