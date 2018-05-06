package com.java.reincarnator;

public class HairRacePicker {

	public static int pickHairRace(int negIndex, int monIndex) {
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
				return 8;
			default:
				return 11;
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
				return 9;
			case 6:
				return 12;
			default:
				return 13;
			}
		case 2:
			switch (negIndex) {
			case 0:
				return 4;
			case 1:
				return 4;
			case 2:
				return 5;
			case 3:
				return 7;
			case 4:
				return 7;
			default:
				return 10;
			}
		case 3:
			switch (negIndex) {
			case 0:
				return 5;
			case 1:
				return 5;
			case 2:
				return 5;
			default:
				return 7;
			}
		default:
			return 5;
		}
	}
}
