package com.java.classes.students;

public class SchoolClass {

	private Student[] students;

	public SchoolClass(Student[] students) {
		this.students = students;
	}

	public Student[] getStudents() {
		return students;
	}

	public Student fattestStudent() {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].getBMIIndex() > students[value].getBMIIndex()) {
				value = index;
			}
		}
		return students[value];
	}
	
	public Student thinestStudent() {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].getBMIIndex() < students[value].getBMIIndex()) {
				value = index;
			}
		}
		return students[value];
	}

	public Student tallestStudent() {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].height > students[value].height) {
				value = index;
			}
		}
		return students[value];
	}
	
	public Student smallestStudent() {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].height < students[value].height) {
				value = index;
			}
		}
		return students[value];
	}

	public Student smartestStudent() {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].lectures.getAverage() > students[value].lectures.getAverage()) {
				value = index;
			}
		}
		return students[value];
	}

	public Student dumbestStudent() {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].lectures.getAverage() < students[value].lectures.getAverage()) {
				value = index;
			}
		}
		return students[value];
	}

	public Student bullyStudent() {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].bullyScore() > students[value].bullyScore()) {
				value = index;
			}
		}
		return students[value];
	}
	
	public Student victimStudent() {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].bullyScore() < students[value].bullyScore()) {
				value = index;
			}
		}
		return students[value];
	}

}
