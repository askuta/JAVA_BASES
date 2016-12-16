package com.java.classes.circle;

public class Circle {

	private final double coordX;
	private final double coordY;
	private final double radius;

	public Circle(double coordX, double coordY, double radius) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.radius = radius;
	}

	public double getCoordX() {
		return coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public double getRadius() {
		return radius;
	}

	public double getPerimeter() {
		return radius * 2 * Math.PI;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

	public boolean checkCollide(Circle circle) {
		return Math.pow(this.coordX - circle.coordX, 2) + Math.pow(this.coordY - circle.coordY, 2) <=
				Math.pow(this.radius + circle.radius, 2);
	}
}
