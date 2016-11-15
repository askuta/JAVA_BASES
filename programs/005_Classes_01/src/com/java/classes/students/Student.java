package com.java.classes.students;

public class Student {

	String name;
	int height;
	int weight;
	Lectures lectures;

	public Student(String name, int height, int weight, Lectures lectures) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.lectures = lectures;
	}

	//az alábbi metódus nagyon nem akarja azt csinálni, amit kéne. Mindenhol double-t kell használnom, és
	//kerekíteni is illene az értékeket
	public double getBMIIndex() {
		return (double) weight / ((((double) height / 100) * ((double) height / 100)));
	}
	
	public double jockScore() {
		return (double) (lectures.dodgeball * getBMIIndex() / (lectures.behavior * lectures.getAverage()));
	}
}
