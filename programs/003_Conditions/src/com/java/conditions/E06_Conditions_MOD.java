package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E06_Conditions_MOD {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("�rj le egy sz�mot egyt�l kilencsz�zkilencvenkilencig!");

		String line;
		while (true) {
			line = reader.readLine();
			line = line.toLowerCase();
			
			int outputNumber = 0;
			
			if (line.startsWith("sz�z")){outputNumber += 100;
			line = line.replace("sz�z", "");}
			else if (line.startsWith("k�tsz�z")){outputNumber += 200;
			line = line.replace("k�tsz�z", "");}
			else if (line.startsWith("h�romsz�z")){outputNumber += 300;
			line = line.replace("h�romsz�z", "");}
			else if (line.startsWith("n�gysz�z")){outputNumber += 400;
			line = line.replace("n�gysz�z", "");}
			else if (line.startsWith("�tsz�z")){outputNumber += 500;
			line = line.replace("�tsz�z", "");}
			else if (line.startsWith("hatsz�z")){outputNumber += 600;
			line = line.replace("hatsz�z", "");}
			else if (line.startsWith("h�tsz�z")){outputNumber += 700;
			line = line.replace("h�tsz�z", "");}
			else if (line.startsWith("nyolcsz�z")){outputNumber += 800;
			line = line.replace("nyolcsz�z", "");}
			else if (line.startsWith("kilencsz�z")){outputNumber += 900;
			line = line.replace("kilencsz�z", "");}
			
			if (line.startsWith("t�z")){outputNumber += 10;
			line = line.replace("t�z", "");}
			else if (line.startsWith("tizen")){outputNumber += 10;
			line = line.replace("tizen", "");}
			else if (line.startsWith("h�sz")){outputNumber += 20;
			line = line.replace("h�sz", "");}
			else if (line.startsWith("huszon")){outputNumber += 20;
			line = line.replace("huszon", "");}
			else if (line.startsWith("harminc")){outputNumber += 30;
			line = line.replace("harminc", "");}
			else if (line.startsWith("negyven")){outputNumber += 40;
			line = line.replace("negyven", "");}
			else if (line.startsWith("�tven")){outputNumber += 50;
			line = line.replace("�tven", "");}
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
			else if (line.startsWith("kett�")){outputNumber += 2;
			line = line.replace("kett�", "");}
			else if (line.startsWith("h�rom")){outputNumber += 3;
			line = line.replace("h�rom", "");}
			else if (line.startsWith("n�gy")){outputNumber += 4;
			line = line.replace("n�gy", "");}
			else if (line.startsWith("�t")){outputNumber += 5;
			line = line.replace("�t", "");}
			else if (line.startsWith("hat")){outputNumber += 6;
			line = line.replace("hat", "");}
			else if (line.startsWith("h�t")){outputNumber += 7;
			line = line.replace("h�t", "");}
			else if (line.startsWith("nyolc")){outputNumber += 8;
			line = line.replace("nyolc", "");}
			else if (line.startsWith("kilenc")){outputNumber += 9;
			line = line.replace("kilenc", "");}
			
			if (outputNumber < 1 || outputNumber > 999) {
				System.out.println("Ez m�r minden hat�ron t�lmegy!");
				break;
			} else if (outputNumber == 666) {
				System.out.println("\\m/");
				break;
			}
			
			System.out.println(outputNumber);
		}
	}
}
