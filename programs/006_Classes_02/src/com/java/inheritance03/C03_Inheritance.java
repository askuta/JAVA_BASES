package com.java.inheritance03;

public class C03_Inheritance {

	public static void main(String[] args) {
		DerivedClass derived = new DerivedClass();

		System.out.println("Call the printStringField method of the derived class");
		derived.printStringField();

		System.out.println();
		derived.printBaseAndDerivedStringFields();
	}
}
