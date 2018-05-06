package com.java.reincarnator;

public class NoseRacePicker {

	public static String pickNoseRace(int negIndex, int monIndex) {
		switch (monIndex) {
		case 0:
			switch (negIndex) {
			case 0:
				return "Causoid";
			case 1:
				return "Causoid";
			case 2:
				return "Causoid";
			case 3:
				return "Sturdy";
			case 4:
				return "Sturdy";
			case 5:
				return "Sturdy";
			default:
				return "Stubby";
			}
		case 1:
			switch (negIndex) {
			case 0:
				return "Causoid";
			case 1:
				return "Causoid";
			case 2:
				return "Causoid";
			case 3:
				return "Sturdy";
			case 4:
				return "Sturdy";
			case 5:
				return "Sturdy";
			default:
				return "Stubby";
			}
		case 2:
			switch (negIndex) {
			case 0:
				return "Causoid";
			case 1:
				return "Causoid";
			case 2:
				return "Causoid";
			default:
				return "Sturdy";
			}
		default:
			return "Snub";
		}
	}
}
