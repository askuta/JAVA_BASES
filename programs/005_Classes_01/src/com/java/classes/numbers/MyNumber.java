package com.java.classes.numbers;

public class MyNumber {

	private final int number;

	public MyNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public MyNumber add(MyNumber otherNumber) {
		return new MyNumber(this.number + otherNumber.number);
	}

	public MyNumber substract(MyNumber otherNumber) {
		return new MyNumber(this.number - otherNumber.number);
	}
}
