package com.java.reincarnator;

public class MouthRacePicker {

	public static String pickMouthRace(int negIndex) {
		switch (negIndex) {
		case 0:
			return "Narrow";
		case 1:
			return "Narrow";
		case 2:
			return "Medium1";
		case 3:
			return "Medium1";
		case 4:
			return "Medium2";
		case 5:
			return "Medium2";
		case 6:
			return "Thick1";
		case 7:
			return "Thick1";
		default:
			return "Thick2";
		}
	}
}
