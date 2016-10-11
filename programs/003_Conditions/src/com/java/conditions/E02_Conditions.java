package com.java.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02_Conditions {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Mondj egy sz�mot 1-t�l 10-ig!");

		String line;
		while (true) {
			line = reader.readLine();

			int myNumber = Integer.parseInt(line);
			if (myNumber == 1) {
				System.out.println("Egy");
			} else if (myNumber == 2) {
				System.out.println("Kett�");
			} else if (myNumber == 3) {
				System.out.println("H�rom");
			} else if (myNumber == 4) {
				System.out.println("N�gy");
			} else if (myNumber == 5) {
				System.out.println("�t");
			} else if (myNumber == 6) {
				System.out.println("Hat");
			} else if (myNumber == 7) {
				System.out.println("H�t");
			} else if (myNumber == 8) {
				System.out.println("Nyolc");
			} else if (myNumber == 9) {
				System.out.println("Kilenc");
			} else if (myNumber == 10) {
				System.out.println("T�z");
			} else {
				System.out.println("Tanulj meg sz�molni!");
				break;
			}
		}
	}

}
