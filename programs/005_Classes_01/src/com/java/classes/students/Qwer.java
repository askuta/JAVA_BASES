package com.java.classes.students;

import com.java.classes.students.Student.Gender;

public class Qwer {

	public static void main(String[] args) {
		System.out.print("bakfitty, ");
		System.out.print("\b\bológia");
		System.out.println();
		System.out.println();

		Lectures lectures = new Lectures(5, 5, 5, 5, 5);
		System.out.println(lectures);
		
		Student student = new Student("Ödön", Gender.MALE, 149, 110, new Lectures(5, 5, 5, 5, 5));
		System.out.println(student);
	}

// http://stackoverflow.com/questions/3095986/how-to-get-backspace-b-to-work-in-eclipses-console
}
