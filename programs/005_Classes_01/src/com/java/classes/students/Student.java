package com.java.classes.students;

public class Student {

	public enum Gender {
		MALE, FEMALE, OTHER
	}

	String name;
	Gender gender;
	int height;
	int weight;
	Lectures lectures;

	public Student(String name, Gender gender, int height, int weight,
			Lectures lectures) {
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.lectures = lectures;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public Lectures getLectures() {
		return lectures;
	}

	public double getBMIIndex() {
		return (double) weight / Math.pow((double) height / 100, 2.0);
	}

	public double bullyScore() {
		return (double) (lectures.dodgeball * getBMIIndex() / (lectures.behavior * lectures
				.getAverage()));
	}
}
