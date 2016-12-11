package com.java.inheritance02;

public class Kiwi extends BaseFruit {

	private String kiwiStuff = "kiwi stuff";

	protected Kiwi() {
		super(FruitColor.GREEN, FruitTaste.SWEET);
	}

	public void doSomeKiwiStuff() {
		System.out.println("\tDo some " + kiwiStuff + ".");
	}
}
