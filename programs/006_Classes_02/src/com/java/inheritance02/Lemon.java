package com.java.inheritance02;

public class Lemon extends BaseFruit {

	private String lemonStuff = "lemon stuff";

	protected Lemon() {
		super(FruitColor.YELLOW, FruitTaste.SOUR);
	}

	public void doSomeLemonStuff() {
		System.out.println("\tDo some " + lemonStuff + ".");
	}
}
