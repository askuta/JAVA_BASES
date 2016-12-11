package com.java.inheritance03;

public class DerivedClass extends BaseClass {

	private String stringField = "String field of the derived class";

	@Override
	public void printStringField() {
		System.out.println(stringField);
	}

	public void printBaseAndDerivedStringFields() {
		System.out.println(super.stringField);
		System.out.println(stringField); // You might use the this keyword
	}
}
