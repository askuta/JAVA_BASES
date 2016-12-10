package com.java.classes.students;

public class C02_Classes {

	private static final int PEOPLE_NUMBER = 12;
	private static String b;

	public static void main(String[] args) {

		Student[] students = new Student[PEOPLE_NUMBER];
		students[0] = new Student("Ödön", 149, 110, new Lectures(5, 5, 3, 2, 5));
		students[1] = new Student("Rikárdó", 155, 60, new Lectures(1, 2, 2, 4, 1));
		students[2] = new Student("Bea", 161, 83, new Lectures(3, 4, 2, 3, 4));
		students[3] = new Student("Kázmér", 167, 64, new Lectures(2, 3, 5, 5, 2));
		students[4] = new Student("Móricka", 152, 68, new Lectures(3, 4, 3, 4, 1));
		students[5] = new Student("Töhötöm", 181, 104, new Lectures(3, 4, 3, 5, 4));
		students[6] = new Student("Immánuel", 175, 77, new Lectures(5, 5, 4, 2, 5));
		students[7] = new Student("Rozi", 166, 64, new Lectures(2, 5, 5, 2, 5));
		students[8] = new Student("Szintia", 178, 58, new Lectures(3, 4, 4, 3, 4));
		students[9] = new Student("Máté", 176, 68, new Lectures(2, 5, 5, 4, 4));

		fillEmptyStudents(students);
		
		introduceStudent(students, 5);
		introduceStudent(students, 6);
		introduceStudent(students, 7);
		introduceStudent(students, 8);
		introduceStudent(students, 10);
	}

	private static void fillEmptyStudents(Student[] students) {
		for (int index = 0; index < students.length; index++) {
			if (students[index] == null) {
				students[index] = new Student("Botond-bot", 180, 70, new Lectures(4, 4, 4, 4, 4));
			}
		}
	}
	
	private static int fattestStudent(Student[] students) {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].getBMIIndex() > students[value].getBMIIndex()) {
				value = index;
			}
		}
		return value;
	}
	
	private static int tallestStudent(Student[] students) {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].height > students[value].height) {
				value = index;
			}
		}
		return value;
	}
	
	private static int smartestStudent(Student[] students) {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].lectures.getAverage() > students[value].lectures.getAverage()) {
				value = index;
			}
		}
		return value;
	}
	
	private static int dumbestStudent(Student[] students) {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].lectures.getAverage() < students[value].lectures.getAverage()) {
				value = index;
			}
		}
		return value;
	}
	
	private static int bulliestStudent(Student[] students) {
		int value = 0;
		for (int index = 0; index < students.length; index++) {
			if (students[index].jockScore() > students[value].jockScore()) {
				value = index;
			}
		}
		return value;
	}
	
	private static void introduceStudent(Student[] students, int which) {
		
		boolean average = true;
		System.out.print("Meet " + students[which].name + ". He/she's ");
		
		if (fattestStudent(students) == which) {
			System.out.print("the fattest, ");
			average = false;
		} else if (students[which].getBMIIndex() < 15) {
			System.out.print("anorexic, ");
			average = false;
		} else if (students[which].getBMIIndex() < 20) {
			System.out.print("thin, ");
		} else if (students[which].getBMIIndex() > 30) {
			System.out.print("obese, ");
			average = false;
		} else if (students[which].getBMIIndex() > 25) {
			System.out.print("overweight, ");
		}
		
		if (tallestStudent(students) == which) {
			System.out.print("the tallest, ");
			average = false;
		} else if (students[which].height < 150) {
			System.out.print("a midget, ");
			average = false;
		} else if (students[which].height < 160) {
			System.out.print("small, ");
		} else if (students[which].height > 185) {
			System.out.print("a giant, ");
			average = false;
		} else if (students[which].height > 175) {
			System.out.print("tall, ");
		}
	
		if (average) {
			if (smartestStudent(students) == which) {
				System.out.print("the geek of the class. ");
				average = false;
			} else if (dumbestStudent(students) == which) {
				System.out.print("the dumbass of the class. ");
				average = false;
			} else {
				System.out.print("an average chap. ");
			}
		} else {
			if (smartestStudent(students) == which) {
				System.out.print("and the geek of the class. ");
				average = false;
			} else if (dumbestStudent(students) == which) {
				System.out.print("and the dumbass of the class. ");
				average = false;
			} else {
				System.out.print("\b\b. ");
			}
		}
		
		if (bulliestStudent(students) == which) {
			
			System.out.print("He/she's bullying");
			for (int index = 0; index < students.length; index++) {
				if (students[index].jockScore() < 5) {
					System.out.print(" " + students[index].name + ",");
				}
			}
			System.out.println("\b\b" + ". ");
			
		} else if (students[which].jockScore() < 5) {
			System.out.println("He/she's bullied by " + students[bulliestStudent(students)].name + ".");
		} else {
			System.out.println("He/she fits in well");
		}
	}
}
