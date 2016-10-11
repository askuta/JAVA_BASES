package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E04_Conditions {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Mondj egy számot 1-tõl 10-ig!");

		String line;
		boolean whileRunning = true;
		while (whileRunning) {
			line = reader.readLine();

			int myNumber = Integer.parseInt(line);
			switch (myNumber) {
			case 1 : System.out.println("Egy"); break;
			case 2 : System.out.println("Kettõ"); break;
			case 3 : System.out.println("Három"); break;
			case 4 : System.out.println("Négy"); break;
			case 5 : System.out.println("Öt"); break;
			case 6 : System.out.println("Hat"); break;
			case 7 : System.out.println("Hét"); break;
			case 8 : System.out.println("Nyolc"); break;
			case 9 : System.out.println("Kilenc"); break;
			case 10 : System.out.println("Tíz"); break;
			default : whileRunning = false; System.out.println("Tanulj meg számolni!");
			}
		}
	}

}
