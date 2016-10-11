package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E05_Conditions {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Mondj egy számot 1-tõl 99-ig!");

		String line;
		while (true) {
			line = reader.readLine();

			int myNumber = Integer.parseInt(line);
			
			if (myNumber < 1 || myNumber > 99) {
				System.out.println("Tényleg csak 1 és 99 között kéne, OK?");
				break;
			}
			
			int ones = myNumber % 10;
			int tens = myNumber - ones;
			
			if (tens == 0) {
				System.out.println(calculateOnes(ones));
			} else {
				System.out.println(calculateTens(tens, ones) + calculateOnes(ones).toLowerCase());
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

}
