package com.java.classes.students;

public class Lectures {

	int math;
	int english;
	int drawing;
	int dodgeball;
	int behavior;

	public Lectures(int math, int english, int drawing, int dodgeball, int behavior) {
		this.math = math;
		this.english = english;
		this.drawing = drawing;
		this.dodgeball = dodgeball;
		this.behavior = behavior;
	}

	public double getAverage() {
		return (double) (math + english + drawing + dodgeball + behavior) / 5;
	}
}
