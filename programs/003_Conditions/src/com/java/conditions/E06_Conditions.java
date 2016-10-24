package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E06_Conditions {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Mondj egy számot 1-tõl 999-ig!");

		String line;
		while (true) {
			line = reader.readLine();

			int myNumber = Integer.parseInt(line);
			
			if (myNumber < 1 || myNumber > 999) {
				System.out.println("Tényleg csak 1 és 999 között kéne, OK?");
				break;
			} else if (myNumber == 666) {
				System.out.println("\\m/");
				break;
			}
			
			int ones = myNumber % 10;
			int tens = myNumber % 100 - ones;
			int hundreds = myNumber - tens - ones;
			
			if (hundreds == 0) {
				if (tens == 0) {
					System.out.println(calculateOnes(ones));
				} else {
					System.out.println(calculateTens(tens, ones)
							+ calculateOnes(ones).toLowerCase());
				}
			} else {
				System.out.println(calculateHundreds(hundreds)
						+ calculateTens(tens, ones).toLowerCase()
						+ calculateOnes(ones).toLowerCase());
			}
		}
	}
	
	private static String calculateOnes(int ones) {
			switch (ones) {
			case 1 : return "Egy";
			case 2 : return "Kettõ";
			case 3 : return "Három";
			case 4 : return "Négy";
			case 5 : return "Öt";
			case 6 : return "Hat";
			case 7 : return "Hét";
			case 8 : return "Nyolc";
			case 9 : return "Kilenc";
			default : return "";
			}
	}
	
	private static String calculateTens(int tens, int ones) {
			switch (tens) {
			case 10 : {
				if (ones == 0) {
					return "Tíz";
				} else {
					return "Tizen";
				}
			}
			case 20 : {
				if (ones == 0) {
					return "Húsz";
				} else {
					return "Huszon";
				}
			}
			case 30 : return "Harminc";
			case 40 : return "Negyven";
			case 50 : return "Ötven";
			case 60 : return "Hatvan";
			case 70 : return "Hetven";
			case 80 : return "Nyolcvan";
			case 90 : return "Kilencven";
			default : return "";
			}
	}
	private static String calculateHundreds(int hundreds) {
		switch (hundreds) {
		case 100 : return "Száz";
		case 200 : return "Kétszáz";
		case 300 : return "Háromszáz";
		case 400 : return "Négyszáz";
		case 500 : return "Ötszáz";
		case 600 : return "Hatszáz";
		case 700 : return "Hétszáz";
		case 800 : return "Nyolcszáz";
		case 900 : return "Kilencszáz";
		default : return "";
		}
	}
}
