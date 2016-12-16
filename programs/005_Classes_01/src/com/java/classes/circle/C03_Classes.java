package com.java.classes.circle;

public class C03_Classes {

	public static void main(String[] args) {
		Circle circle1 = new Circle(30, 30, 20);
		Circle circle2 = new Circle(29, 29, 20);

		System.out.println(circle1.getPerimeter());
		System.out.println(circle1.getArea());
		System.out.println(circle2.getPerimeter());
		System.out.println(circle2.getArea());
		
		System.out.println(circle1.checkCollide(circle2));
	}

}
