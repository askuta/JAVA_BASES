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
		
		//Itt most hozzáadtunk 10 emberkét
		
		System.out.println("név: " + names[4]);
		System.out.println("magasság: " + heights[4]);
		System.out.println("súly: " + weights[4]);
		System.out.println("év végi átlag: " + ((double)(maths[4] + english[4] + drawing[4] + dodgeball[4] + behavior[4]) / 5));
	}

}
