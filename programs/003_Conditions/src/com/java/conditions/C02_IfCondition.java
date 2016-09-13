package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class C02_IfCondition {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Gondoltam egy sz�mot 1-t�l 100-ig. Tal�ld ki. ;)");
		Random random = new Random();
		int randomNumber = random.nextInt(101);

		String line;
		while (true) {
			line = reader.readLine();

			int myNumber = Integer.parseInt(line);
			if (myNumber < randomNumber) {
				System.out.println("Nem tal�lt, nagyobb sz�mra gondoltam. :P");
			} else if (myNumber > randomNumber) {
				System.out.println("Nem tal�lt, kisebb sz�mra gondoltam. -_-");
			} else {
				System.out.println("Gy�zt�l! :O");
				break;
			}
		}
	}

}
