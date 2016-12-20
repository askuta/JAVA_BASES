package com.java.classes.students;

import com.java.classes.students.Student.Gender;

public class C02_Classes {

	private static final int PEOPLE_NUMBER = 12;

	public static void main(String[] args) {

		Student[] students = new Student[PEOPLE_NUMBER];
		
// Kommenelés visszakommentelés: Ctrl + 7
//		students[0] = new Student("Ödön", 149, 110, new Lectures(5, 5, 3, 2, 5));
//		students[1] = new Student("Rikárdó", 155, 60, new Lectures(1, 2, 2, 4, 1));
//		students[2] = new Student("Bea", 161, 83, new Lectures(3, 4, 2, 3, 4));
//		students[3] = new Student("Kázmér", 167, 64, new Lectures(2, 3, 5, 5, 2));
//		students[4] = new Student("Móricka", 152, 68, new Lectures(3, 4, 3, 4, 1));
//		students[5] = new Student("Töhötöm", 181, 104, new Lectures(3, 4, 3, 5, 4));
//		students[6] = new Student("Immánuel", 175, 77, new Lectures(5, 5, 4, 2, 5));
//		students[7] = new Student("Rozi", 166, 64, new Lectures(2, 5, 5, 2, 5));
//		students[8] = new Student("Szintia", 178, 58, new Lectures(3, 4, 4, 3, 4));
//		students[9] = new Student("Máté", 176, 68, new Lectures(2, 5, 5, 4, 4));

		SchoolClass schoolClass = new SchoolClass(students);
		Student fattestStudent = schoolClass.fattestStudent();
		// A következõ két sor ugyanazt csinálja, ugyanarra a diákra hivatkozik:
		System.out.println(schoolClass.fattestStudent().name);
		System.out.println(fattestStudent.name);
		
		Student bulliestStudent = schoolClass.bulliestStudent();
		
		
		
		fillEmptyStudents(students);
		
		System.out.println("Ödön BMI Indexe: " + students[0].getBMIIndex());
		introduceStudent(schoolClass, students[0]);
//		introduceStudent(students, 1);
//		introduceStudent(students, 2);
//		introduceStudent(students, 3);
//		introduceStudent(students, 11);
		
		
		Student student = new Student("Ödön", Gender.MALE, 149, 110, new Lectures(5, 5, 5, 5, 5));
		System.out.println(student.name);

	}

	private static void fillEmptyStudents(Student[] students) {
		for (int index = 0; index < students.length; index++) {
			if (students[index] == null) {
//				students[index] = new Student("Botond-bot", 180, 70, new Lectures(4, 4, 4, 4, 4));
			}
		}
	}
	

	
	private static void introduceStudent(SchoolClass schoolClass, Student student) {
		
		boolean average = true;
		System.out.print("Meet " + student.name + ". He/she's ");
		
//		if (schoolClass.fattestStudent() == student) {
//			System.out.print("the fattest, ");
//			average = false;
//		} else if (student.getBMIIndex() < 15) {
//			System.out.print("anorexic, ");
//			average = false;
//		} else if (student.getBMIIndex() < 20) {
//			System.out.print("thin, ");
//		} else if (student.getBMIIndex() > 30) {
//			System.out.print("obese, ");
//			average = false;
//		} else if (student.getBMIIndex() > 25) {
//			System.out.print("overweight, ");
//		}
//		
//		if (tallestStudent(students) == student) {
//			System.out.print("the tallest, ");
//			average = false;
//		} else if (students[student].height < 150) {
//			System.out.print("a midget, ");
//			average = false;
//		} else if (students[student].height < 160) {
//			System.out.print("small, ");
//		} else if (students[student].height > 185) {
//			System.out.print("a giant, ");
//			average = false;
//		} else if (students[student].height > 175) {
//			System.out.print("tall, ");
//		}
//	
//		if (average) {
//			if (smartestStudent(students) == student) {
//				System.out.print("the geek of the class. ");
//				average = false;
//			} else if (dumbestStudent(students) == student) {
//				System.out.print("the dumbass of the class. ");
//				average = false;
//			} else {
//				System.out.print("an average chap. ");
//			}
//		} else {
//			if (smartestStudent(students) == student) {
//				System.out.print("and the geek of the class. ");
//				average = false;
//			} else if (dumbestStudent(students) == student) {
//				System.out.print("and the dumbass of the class. ");
//				average = false;
//			} else {
//				System.out.print("\b\b. ");
//			}
//		}
//		
//		if (bulliestStudent(students) == student) {
//			
//			System.out.print("He/she's bullying");
//			for (int index = 0; index < students.length; index++) {
//				if (students[index].jockScore() < 5) {
//					System.out.print(" " + students[index].name + ",");
//				}
//			}
//			System.out.println("\b\b" + ". ");
//			
//		} else if (students[student].jockScore() < 5) {
//			System.out.println("He/she's bullied by " + students[bulliestStudent(students)].name + ".");
//		} else {
//			System.out.println("He/she fits in well");
//		}
	}
}
