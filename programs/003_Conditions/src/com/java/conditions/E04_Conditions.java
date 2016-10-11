package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E04_Conditions {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Mondj egy sz�mot 1-t�l 10-ig!");

		String line;
		boolean whileRunning = true;
		while (whileRunning) {
			line = reader.readLine();

			int myNumber = Integer.parseInt(line);
			switch (myNumber) {
			case 1 : System.out.println("Egy"); break;
			case 2 : System.out.println("Kett�"); break;
			case 3 : System.out.println("H�rom"); break;
			case 4 : System.out.println("N�gy"); break;
			case 5 : System.out.println("�t"); break;
			case 6 : System.out.println("Hat"); break;
			case 7 : System.out.println("H�t"); break;
			case 8 : System.out.println("Nyolc"); break;
			case 9 : System.out.println("Kilenc"); break;
			case 10 : System.out.println("T�z"); break;
			default : whileRunning = false; System.out.println("Tanulj meg sz�molni!");
			}
		}
	}

}
