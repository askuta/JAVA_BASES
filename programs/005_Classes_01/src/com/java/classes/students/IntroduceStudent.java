package com.java.classes.students;

public class IntroduceStudent {

	public static void introduceStudent(SchoolClass schoolClass,
			Student student) {

		String personalPronoun = getPersonalPronoun(student);
		boolean averageChap = true;

		System.out.print("Meet " + student.name + ". " + personalPronoun
				+ "'s ");

		if (schoolClass.fattestStudent() == student) {
			System.out.print("the fattest, ");
			averageChap = false;
		} else if (schoolClass.thinestStudent() == student) {
			System.out.print("the thinnest, ");
			averageChap = false;
		} else {
			System.out.print(tagWeight(student));
		}

		if (schoolClass.tallestStudent() == student) {
			System.out.print("the tallest, ");
			averageChap = false;
		} else if (schoolClass.smallestStudent() == student) {
			System.out.print("the smallest, ");
			averageChap = false;
		} else {
			System.out.print(tagHeight(student));
		}

		if (schoolClass.smartestStudent() == student) {
			System.out.print("the geek of the class, ");
			averageChap = false;
		} else if (schoolClass.dumbestStudent() == student) {
			System.out.print("the dumbass of the class, ");
			averageChap = false;
		}

		if (schoolClass.bullyStudent() == student) {
			System.out.print("and " + personalPronoun + "'s bullying "
					+ schoolClass.victimStudent().name);
			averageChap = false;
		} else if (schoolClass.victimStudent() == student) {
			System.out.print("and " + personalPronoun + "'s the victim of "
					+ schoolClass.victimStudent().name + "'s bullying");
			averageChap = false;
		}
		
		if (averageChap) {
			System.out.print("an average chap");
		}
	}

	private static String getPersonalPronoun(Student student) {
		switch (student.getGender()) {
		case MALE:
			return "He";
		case FEMALE:
			return "She";
		default:
			return "They";
		}
	}

	private static String tagWeight(Student student) {

		if (student.getBMIIndex() < 15) {
			return "anorexic, ";
		} else if (student.getBMIIndex() < 20) {
			return "thin, ";
		} else if (student.getBMIIndex() > 30) {
			return "obese, ";
		} else if (student.getBMIIndex() > 25) {
			return "overweight, ";
		} else {
			return "";
		}
	}

	private static String tagHeight(Student student) {

		if (student.height < 150) {
			return "a hobbit, ";
		} else if (student.height < 160) {
			return "small, ";
		} else if (student.height > 185) {
			return "a giant, ";
		} else if (student.height > 175) {
			return "tall, ";
		} else {
			return "";
		}
	}
}
