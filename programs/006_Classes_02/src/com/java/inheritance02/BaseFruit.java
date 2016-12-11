package com.java.inheritance02;

public class BaseFruit {

	public enum FruitColor {
		YELLOW, ORANGE, GREEN, BROWN
	}

	public enum FruitTaste {
		SWEET, SOUR, ROTTEN
	}

	private FruitColor color;
	private FruitTaste taste;

	protected BaseFruit(FruitColor color, FruitTaste taste) {
		this.color = color;
		this.taste = taste;
	}

	public FruitColor getFruitColor() {
		return color;
	}

	public FruitTaste getFruitTaste() {
		return taste;
	}

	public void spoilFruit() {
		color = FruitColor.BROWN;
		taste = FruitTaste.ROTTEN;
	}
}
