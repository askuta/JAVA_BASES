package com.java.reincarnator;

public class EyesRacePicker {

	public static int pickEyesRace(int negIndex, int monIndex) {
		switch (monIndex) {
		case 0:
			switch (negIndex) {
			case 0:
				return 1;
			case 1:
				return 2;
			case 2:
				return 3;
			case 3:
				return 6;
			case 4:
				return 6;
			case 5:
				return 6;
			default:
				return 7;
			}
		case 1:
			switch (negIndex) {
			case 0:
				return 2;
			case 1:
				return 2;
			case 2:
				return 3;
			case 3:
				return 6;
			case 4:
				return 6;
			case 5:
				return 6;
			case 6:
				return 7;
			default:
				return 4;
			}
		case 2:
			return 4;
		case 3:
			return 5;
		default:
			return 5;
		}
	}
}
