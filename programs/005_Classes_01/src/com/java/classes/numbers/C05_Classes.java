package com.java.classes.numbers;

public class C05_Classes {

	public static void main(String[] args) {
		
		MyNumber number1 = new MyNumber(30);
		MyNumber number2 = new MyNumber(6);
		
		MyNumber addition = number1.add(number2);
		MyNumber substraction = number1.substract(number2);
		
		System.out.println(number1.getNumber() + " + " + number2.getNumber() + " = " + addition.getNumber());
		System.out.println(number1.getNumber() + " - " + number2.getNumber() + " = " + substraction.getNumber());
		
		System.out.println(number1.add(number2).add(number1).add(number2).substract(addition).getNumber());
	}

}
