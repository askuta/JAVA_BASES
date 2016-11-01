package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomWords {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Hány szóból álló mondatot szeretnél?");
		
		Random random = new Random();

		String line;
		while (true) {
			line = reader.readLine();
			int countWords = Integer.parseInt(line);
			
			if (countWords < 1 || countWords > 10) {
				System.out.println("Azért maradjunk 1 és 10 között!");
				break;
			}
			
			int randomNumber = random.nextInt(1);
			boolean isVowel = true;
			if (randomNumber == 0) {isVowel = false;}
			
			for (int w = countWords; w > 0; w--) {
				int countLetters;
				randomNumber = random.nextInt(16);
				
				switch (randomNumber) {
				case 0 : case 1 : case 2 : countLetters = 1; isVowel = true; break;
				case 3 : case 4 : countLetters = 2; break;
				case 5 : case 6 : countLetters = 3; break;
				case 7 : case 8 : countLetters = 4; break;
				case 9 : case 10 : countLetters = 5; break;
				case 11 : case 12 : countLetters = 6; break;
				case 13 : countLetters = 7; break;
				case 14 : countLetters = 8; break;
				case 15 : countLetters = 9; break;
				default : countLetters = 10; break;
				}
				
				for (int l = countLetters; l > 0; l--) {
					randomNumber = random.nextInt(19);
					System.out.print(randomLetter(isVowel, randomNumber));
					randomNumber = random.nextInt(6);
					if (randomNumber == 0 && countLetters > 1) {
						randomNumber = random.nextInt(19);
						System.out.print(randomLetter(isVowel, randomNumber));
						countLetters--;
					}
					isVowel = !isVowel;
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static String randomLetter(boolean isVowel, int randomNumber) {
		if (isVowel) {
			switch (randomNumber) {
			case 0 : case 1 : case 2 : case 3 : return "a";
			case 4 : case 5 : case 6 : case 7 : return "e";
			case 8 : case 9 : case 10 : case 11 : return "i";
			case 12 : case 13 : case 14 : case 15 : return "o";
			case 16 : case 17 : case 18 : default : return "u";
			}
		} else {
			switch (randomNumber) {
			case 0 : case 17 : return "b";
			case 1 : return "c";
			case 2 : case 18 : return "d";
			case 3 : return "f";
			case 4 : return "g";
			case 5 : return "h";
			case 6 : return "j";
			case 7 : default : return "k";
			case 8 : return "l";
			case 9 : return "m";
			case 10 : return "n";
			case 11 : return "p";
			case 12 : return "r";
			case 13 : return "s";
			case 14 : return "t";
			case 15 : return "v";
			case 16 : return "z";
			}
		}
	}
}
