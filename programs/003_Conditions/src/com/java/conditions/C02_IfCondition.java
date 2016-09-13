package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class C02_IfCondition {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Gondoltam egy számot 1-tõl 100-ig. Találd ki. ;)");
		Random random = new Random();
		int randomNumber = random.nextInt(101);

		String line;
		while (true) {
			line = reader.readLine();

			int myNumber = Integer.parseInt(line);
			if (myNumber < randomNumber) {
				System.out.println("Nem talált, nagyobb számra gondoltam. :P");
			} else if (myNumber > randomNumber) {
				System.out.println("Nem talált, kisebb számra gondoltam. -_-");
			} else {
				System.out.println("Gyõztél! :O");
				break;
			}
		}
	}

}
