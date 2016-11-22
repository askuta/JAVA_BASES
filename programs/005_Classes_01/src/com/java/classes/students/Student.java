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

	//az al�bbi met�dus nagyon nem akarja azt csin�lni, amit k�ne. Mindenhol double-t kell haszn�lnom, �s
	//kerek�teni is illene az �rt�keket
	public double getBMIIndex() {
		return (double) weight / ((((double) height / 100) * ((double) height / 100)));
	}
	
	public double jockScore() {
		return (double) (lectures.dodgeball * getBMIIndex() / (lectures.behavior * lectures.getAverage()));
	}
}
