package com.java.inheritance02;

public class Orange extends BaseFruit {

	private String orangeStuff = "orange stuff";

	protected Orange() {
		super(FruitColor.ORANGE, FruitTaste.SWEET);
	}

	public void doSomeOrangeStuff() {
		System.out.println("\tDo some " + orangeStuff + ".");
	}
}
