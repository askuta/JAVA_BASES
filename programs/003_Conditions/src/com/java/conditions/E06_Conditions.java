package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E06_Conditions {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Mondj egy sz�mot 1-t�l 999-ig!");

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
				System.out.println("T�nyleg csak 1 �s 999 k�z�tt k�ne, OK?");
				whileRunning = false;
			}
		}
	}
	
	private static String calculateOnes(int hundreds, int tens, int ones) {
		if (tens == 0 && hundreds == 0) {
			switch (ones) {
			case 1 : return "Egy";
			case 2 : return "Kett�";
			case 3 : return "H�rom";
			case 4 : return "N�gy";
			case 5 : return "�t";
			case 6 : return "Hat";
			case 7 : return "H�t";
			case 8 : return "Nyolc";
			case 9 : return "Kilenc";
			default : return "";
			}
		} else {
			switch (ones) {
			case 1 : return "egy";
			case 2 : return "kett�";
			case 3 : return "h�rom";
			case 4 : return "n�gy";
			case 5 : return "�t";
			case 6 : return "hat";
			case 7 : return "h�t";
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
					return "T�z";
				} else {
					return "Tizen";
				}
			}
			case 20 : {
				if (ones == 0) {
					return "H�sz";
				} else {
					return "Huszon";
				}
			}
			case 30 : return "Harminc";
			case 40 : return "Negyven";
			case 50 : return "�tven";
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
					return "t�z";
				} else {
					return "tizen";
				}
			}
			case 20 : {
				if (ones == 0) {
					return "h�sz";
				} else {
					return "huszon";
				}
			}
			case 30 : return "harminc";
			case 40 : return "negyven";
			case 50 : return "�tven";
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
		case 100 : return "Sz�z";
		case 200 : return "K�tsz�z";
		case 300 : return "H�romsz�z";
		case 400 : return "N�gysz�z";
		case 500 : return "�tsz�z";
		case 600 : return "Hatsz�z";
		case 700 : return "H�tsz�z";
		case 800 : return "Nyolcsz�z";
		case 900 : return "Kilencsz�z";
		default : return "";
		}
	}
}
