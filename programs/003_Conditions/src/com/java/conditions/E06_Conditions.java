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
		boolean whileRunning = true;
		while (whileRunning) {
			line = reader.readLine();

			int myNumber = Integer.parseInt(line);
			int ones = myNumber % 10;
			int tens = myNumber % 100 - ones;
			int hundreds = myNumber - tens - ones;
			
			if (myNumber > 0 && myNumber < 1000) {
				System.out.println(calculateHundreds(hundreds)
						+ calculateTens(hundreds, tens, ones)
						+ calculateOnes(hundreds, tens, ones));
			} else {
				System.out.println("Tényleg csak 1 és 999 között kéne, OK?");
				whileRunning = false;
			}
		}
	}
	
	private static String calculateOnes(int hundreds, int tens, int ones) {
		if (tens == 0 && hundreds == 0) {
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
		} else {
			switch (ones) {
			case 1 : return "egy";
			case 2 : return "kettõ";
			case 3 : return "három";
			case 4 : return "négy";
			case 5 : return "öt";
			case 6 : return "hat";
			case 7 : return "hét";
			case 8 : return "nyolc";
			case 9 : return "kilenc";
			default : return "";
			}
		}	
	}
	
	private static String calculateTens(int hundreds, int tens, int ones) {
		if (hundreds == 0) {
			
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
			
		} else {
			
			switch (tens) {
			case 10 : {
				if (ones == 0) {
					return "tíz";
				} else {
					return "tizen";
				}
			}
			case 20 : {
				if (ones == 0) {
					return "húsz";
				} else {
					return "huszon";
				}
			}
			case 30 : return "harminc";
			case 40 : return "negyven";
			case 50 : return "ötven";
			case 60 : return "hatvan";
			case 70 : return "hetven";
			case 80 : return "nyolcvan";
			case 90 : return "kilencven";
			default : return "";
			}
			
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
