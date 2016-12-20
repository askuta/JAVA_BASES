package com.java.classes.students;

import com.java.classes.students.Student.Gender;

public class C02_Classes {

	private static final int PEOPLE_NUMBER = 12;

	public static void main(String[] args) {
		Student[] students = new Student[PEOPLE_NUMBER];
		students[0] = new Student("Ödön", Gender.MALE, 149, 110, new Lectures(5, 5, 3, 2, 5));
		students[1] = new Student("Rikárdó", Gender.MALE, 155, 60, new Lectures(1, 2, 2, 4, 1));
		students[2] = new Student("Bea", Gender.FEMALE, 161, 83, new Lectures(3, 4, 2, 3, 4));
		students[3] = new Student("Kázmér", Gender.MALE, 167, 64, new Lectures(2, 3, 5, 5, 2));
		students[4] = new Student("Móricka", Gender.MALE, 152, 68, new Lectures(3, 4, 3, 4, 1));
		students[5] = new Student("Töhötöm", Gender.MALE, 181, 104, new Lectures(3, 4, 3, 5, 4));
		students[6] = new Student("Immánuel", Gender.OTHER, 175, 77, new Lectures(5, 5, 4, 2, 5));
		students[7] = new Student("Rozi", Gender.FEMALE, 166, 64, new Lectures(2, 5, 5, 2, 5));
		students[8] = new Student("Szintia", Gender.FEMALE, 178, 58, new Lectures(3, 4, 4, 3, 4));
		students[9] = new Student("Máté", Gender.MALE, 176, 68, new Lectures(2, 5, 5, 4, 4));

		fillEmptyStudents(students);

		SchoolClass schoolClass = new SchoolClass(students);
		
		IntroduceStudent.introduceStudent(schoolClass, students[0]);
		IntroduceStudent.introduceStudent(schoolClass, students[1]);
		IntroduceStudent.introduceStudent(schoolClass, students[2]);
		IntroduceStudent.introduceStudent(schoolClass, students[3]);
		IntroduceStudent.introduceStudent(schoolClass, students[4]);
		IntroduceStudent.introduceStudent(schoolClass, students[5]);
		IntroduceStudent.introduceStudent(schoolClass, students[6]);
		IntroduceStudent.introduceStudent(schoolClass, students[7]);
		IntroduceStudent.introduceStudent(schoolClass, students[8]);
		IntroduceStudent.introduceStudent(schoolClass, students[9]);
		IntroduceStudent.introduceStudent(schoolClass, students[10]);
		IntroduceStudent.introduceStudent(schoolClass, students[11]);

	}

	private static void fillEmptyStudents(Student[] students) {
		for (int index = 0; index < students.length; index++) {
			if (students[index] == null) {
				students[index] = new Student("Botond-bot", Gender.OTHER, 180, 70, new Lectures(4, 4, 4, 4, 4));
			}
		}
	}
}
