package com.java.classes;

public class C01_Classes {

	private static final int PEOPLE_NUMBER = 10;
	
	public static void main(String[] args) {
		
		String[] names = new String [PEOPLE_NUMBER];
		int[] heights = new int [PEOPLE_NUMBER];
		int[] weights = new int [PEOPLE_NUMBER];
		int[] maths = new int [PEOPLE_NUMBER];
		int[] english = new int [PEOPLE_NUMBER];
		int[] drawing = new int [PEOPLE_NUMBER];
		int[] dodgeball = new int [PEOPLE_NUMBER];
		int[] behavior = new int [PEOPLE_NUMBER];
		
		//Itt most hozz�adtunk 10 emberk�t
		
		System.out.println("n�v: " + names[4]);
		System.out.println("magass�g: " + heights[4]);
		System.out.println("s�ly: " + weights[4]);
		System.out.println("�v v�gi �tlag: " + ((double)(maths[4] + english[4] + drawing[4] + dodgeball[4] + behavior[4]) / 5));
	}

}
