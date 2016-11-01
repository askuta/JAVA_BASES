package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E06_Conditions_MOD {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Írj le egy számot egytõl kilencszázkilencvenkilencig!");

		String line;
		while (true) {
			line = reader.readLine();
			line = line.toLowerCase();
			
			int outputNumber = 0;
			
			if (line.startsWith("száz")){outputNumber += 100;
			line = line.replace("száz", "");}
			else if (line.startsWith("kétszáz")){outputNumber += 200;
			line = line.replace("kétszáz", "");}
			else if (line.startsWith("háromszáz")){outputNumber += 300;
			line = line.replace("háromszáz", "");}
			else if (line.startsWith("négyszáz")){outputNumber += 400;
			line = line.replace("négyszáz", "");}
			else if (line.startsWith("ötszáz")){outputNumber += 500;
			line = line.replace("ötszáz", "");}
			else if (line.startsWith("hatszáz")){outputNumber += 600;
			line = line.replace("hatszáz", "");}
			else if (line.startsWith("hétszáz")){outputNumber += 700;
			line = line.replace("hétszáz", "");}
			else if (line.startsWith("nyolcszáz")){outputNumber += 800;
			line = line.replace("nyolcszáz", "");}
			else if (line.startsWith("kilencszáz")){outputNumber += 900;
			line = line.replace("kilencszáz", "");}
			
			if (line.startsWith("tíz")){outputNumber += 10;
			line = line.replace("tíz", "");}
			else if (line.startsWith("tizen")){outputNumber += 10;
			line = line.replace("tizen", "");}
			else if (line.startsWith("húsz")){outputNumber += 20;
			line = line.replace("húsz", "");}
			else if (line.startsWith("huszon")){outputNumber += 20;
			line = line.replace("huszon", "");}
			else if (line.startsWith("harminc")){outputNumber += 30;
			line = line.replace("harminc", "");}
			else if (line.startsWith("negyven")){outputNumber += 40;
			line = line.replace("negyven", "");}
			else if (line.startsWith("ötven")){outputNumber += 50;
			line = line.replace("ötven", "");}
			else if (line.startsWith("hatvan")){outputNumber += 60;
			line = line.replace("hatvan", "");}
			else if (line.startsWith("hetven")){outputNumber += 70;
			line = line.replace("hetven", "");}
			else if (line.startsWith("nyolcvan")){outputNumber += 80;
			line = line.replace("nyolcvan", "");}
			else if (line.startsWith("kilencven")){outputNumber += 90;
			line = line.replace("kilencven", "");}
			
			if (line.startsWith("egy")){outputNumber += 1;
			line = line.replace("egy", "");}
			else if (line.startsWith("kettõ")){outputNumber += 2;
			line = line.replace("kettõ", "");}
			else if (line.startsWith("három")){outputNumber += 3;
			line = line.replace("három", "");}
			else if (line.startsWith("négy")){outputNumber += 4;
			line = line.replace("négy", "");}
			else if (line.startsWith("öt")){outputNumber += 5;
			line = line.replace("öt", "");}
			else if (line.startsWith("hat")){outputNumber += 6;
			line = line.replace("hat", "");}
			else if (line.startsWith("hét")){outputNumber += 7;
			line = line.replace("hét", "");}
			else if (line.startsWith("nyolc")){outputNumber += 8;
			line = line.replace("nyolc", "");}
			else if (line.startsWith("kilenc")){outputNumber += 9;
			line = line.replace("kilenc", "");}
			
			if (outputNumber < 1 || outputNumber > 999) {
				System.out.println("Ez már minden határon túlmegy!");
				break;
			} else if (outputNumber == 666) {
				System.out.println("\\m/");
				break;
			}
			
			System.out.println(outputNumber);
		}
	}
}
