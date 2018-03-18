package com.java.reincarnator;

public class Embodiment {
 
	public enum Clothe {
		WIFEBEATER, SHIRT, CARDIGAN
	}
	
	private Clothe clothe;
	
	public Embodiment(Clothe clothe) {
		this.clothe = clothe;
	}
	
	public Clothe getClothe() {
		return clothe;
	}
	
}
