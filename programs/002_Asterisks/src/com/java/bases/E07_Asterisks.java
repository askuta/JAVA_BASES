package com.java.bases;

public class E07_Asterisks {

	private static int circleMiddleX = 6;
	private static int circleMiddleY = 7;
	private static int circleRadius = 8;
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (isInsideCircle(i, j)) {
					System.out.print("*");
				} else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
	private static boolean isInsideCircle(int i, int j) {
		return Math.pow(j - circleMiddleX, 2) + Math.pow(i - circleMiddleY, 2) <= Math.pow(circleRadius, 2);
	}
	
}
