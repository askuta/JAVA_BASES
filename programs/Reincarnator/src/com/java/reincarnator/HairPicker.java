package com.java.reincarnator;

import java.util.Random;

public class HairPicker {

	private static Random random = new Random();

	public static String pickHair(int type) {
		switch (type) {
		case 1:
			// Nordic
			switch (random.nextInt(35)) {
			case 0:
				return "StraightMedium";
			case 1:
				return "StraightMedium";
			case 2:
				return "WavyMedium";
			case 3:
				return "WavyMedium";
			case 4:
				return "CurlyMedium";
			case 5:
				return "StraightLight";
			case 6:
				return "StraightLight";
			case 7:
				return "StraightLight";
			case 8:
				return "StraightLight";
			case 9:
				return "WavyLight";
			case 10:
				return "WavyLight";
			case 11:
				return "WavyLight";
			case 12:
				return "WavyLight";
			case 13:
				return "CurlyLight";
			case 14:
				return "CurlyLight";
			case 15:
				return "StraightRed";
			case 16:
				return "StraightRed";
			case 17:
				return "WavyRed";
			case 18:
				return "WavyRed";
			case 19:
				return "CurlyRed";
			case 20:
				return "StraightBlonde";
			case 21:
				return "StraightBlonde";
			case 22:
				return "StraightBlonde";
			case 23:
				return "StraightBlonde";
			case 24:
				return "WavyBlonde";
			case 25:
				return "WavyBlonde";
			case 26:
				return "WavyBlonde";
			case 27:
				return "WavyBlonde";
			case 28:
				return "CurlyBlonde";
			case 29:
				return "CurlyBlonde";
			case 30:
				return "StraightGold";
			case 31:
				return "StraightGold";
			case 32:
				return "WavyGold";
			case 33:
				return "WavyGold";
			default:
				return "CurlyGold";
			}
		case 2:
			// Europid
			switch (random.nextInt(35)) {
			case 0:
				return "StraightDark";
			case 1:
				return "StraightDark";
			case 2:
				return "WavyDark";
			case 3:
				return "WavyDark";
			case 4:
				return "CurlyDark";
			case 5:
				return "StraightMedium";
			case 6:
				return "StraightMedium";
			case 7:
				return "StraightMedium";
			case 8:
				return "StraightMedium";
			case 9:
				return "WavyMedium";
			case 10:
				return "WavyMedium";
			case 11:
				return "WavyMedium";
			case 12:
				return "WavyMedium";
			case 13:
				return "CurlyMedium";
			case 14:
				return "CurlyMedium";
			case 15:
				return "StraightRed";
			case 16:
				return "StraightRed";
			case 17:
				return "WavyRed";
			case 18:
				return "WavyRed";
			case 19:
				return "CurlyRed";
			case 20:
				return "StraightLight";
			case 21:
				return "StraightLight";
			case 22:
				return "StraightLight";
			case 23:
				return "StraightLight";
			case 24:
				return "WavyLight";
			case 25:
				return "WavyLight";
			case 26:
				return "WavyLight";
			case 27:
				return "WavyLight";
			case 28:
				return "CurlyLight";
			case 29:
				return "CurlyLight";
			case 30:
				return "StraightBlonde";
			case 31:
				return "StraightBlonde";
			case 32:
				return "WavyBlonde";
			case 33:
				return "WavyBlonde";
			default:
				return "CurlyBlonde";
			}
		case 3:
			switch (random.nextInt(25)) {
			// South European
			case 0:
				return "StraightBlack";
			case 1:
				return "StraightBlack";
			case 2:
				return "WavyBlack";
			case 3:
				return "WavyBlack";
			case 4:
				return "CurlyBlack";
			case 5:
				return "StraightDark";
			case 6:
				return "StraightDark";
			case 7:
				return "StraightDark";
			case 8:
				return "StraightDark";
			case 9:
				return "WavyDark";
			case 10:
				return "WavyDark";
			case 11:
				return "WavyDark";
			case 12:
				return "WavyDark";
			case 13:
				return "CurlyDark";
			case 14:
				return "CurlyDark";
			case 15:
				return "StraightMedium";
			case 16:
				return "StraightMedium";
			case 17:
				return "WavyMedium";
			case 18:
				return "WavyMedium";
			case 19:
				return "CurlyMedium";
			case 20:
				return "StraightLight";
			case 21:
				return "StraightLight";
			case 22:
				return "WavyLight";
			case 23:
				return "WavyLight";
			default:
				return "CurlyLight";
			}
		case 4:
			switch (random.nextInt(9)) {
			// Turanid
			case 0:
				return "StraightBlack";
			case 1:
				return "StraightBlack";
			case 2:
				return "StraightBlack";
			case 3:
				return "StraightBlack";
			case 4:
				return "WavyBlack";
			case 5:
				return "WavyBlack";
			case 6:
				return "StraightDark";
			case 7:
				return "StraightDark";
			default:
				return "WavyDark";
			}
		case 5:
			// Mongoloid
			return "StraightBlack";
		case 6:
			switch (random.nextInt(20)) {
			// Middle eastern
			case 0:
				return "StraightBlack";
			case 1:
				return "StraightBlack";
			case 2:
				return "WavyBlack";
			case 3:
				return "WavyBlack";
			case 4:
				return "WavyBlack";
			case 5:
				return "WavyBlack";
			case 6:
				return "CurlyBlack";
			case 7:
				return "CurlyBlack";
			case 8:
				return "StraightDark";
			case 9:
				return "StraightDark";
			case 10:
				return "WavyDark";
			case 11:
				return "WavyDark";
			case 12:
				return "WavyDark";
			case 13:
				return "WavyDark";
			case 14:
				return "CurlyDark";
			case 15:
				return "CurlyDark";
			case 16:
				return "StraightMedium";
			case 17:
				return "WavyMedium";
			case 18:
				return "WavyMedium";
			default:
				return "CurlyMedium";
			}
		case 7:
			switch (random.nextInt(6)) {
			// Mestizo
			case 0:
				return "StraightBlack";
			case 1:
				return "StraightBlack";
			case 2:
				return "WavyBlack";
			case 3:
				return "WavyBlack";
			case 4:
				return "StraightDark";
			default:
				return "WavyDark";
			}
		case 8:
			switch (random.nextInt(7)) {
			// Mulatto
			case 0:
				return "WavyBlack";
			case 1:
				return "CurlyBlack";
			case 2:
				return "CurlyBlack";
			case 3:
				return "KinkyBlack";
			case 4:
				return "KinkyBlack";
			case 5:
				return "CurlyDark";
			default:
				return "KinkyDark";
			}
		case 9:
			switch (random.nextInt(12)) {
			// Ethiopian
			case 0:
				return "WavyBlack";
			case 1:
				return "WavyBlack";
			case 2:
				return "CurlyBlack";
			case 3:
				return "CurlyBlack";
			case 4:
				return "CurlyBlack";
			case 5:
				return "CurlyBlack";
			case 6:
				return "KinkyBlack";
			case 7:
				return "KinkyBlack";
			case 8:
				return "WavyDark";
			case 9:
				return "CurlyDark";
			case 10:
				return "CurlyDark";
			default:
				return "KinkyDark";
			}
		case 10:
			switch (random.nextInt(15)) {
			// Indian
			case 0:
				return "StraightBlack";
			case 1:
				return "StraightBlack";
			case 2:
				return "WavyBlack";
			case 3:
				return "WavyBlack";
			case 4:
				return "WavyBlack";
			case 5:
				return "WavyBlack";
			case 6:
				return "StraightDark";
			case 7:
				return "StraightDark";
			case 8:
				return "WavyDark";
			case 9:
				return "WavyDark";
			case 10:
				return "WavyDark";
			case 11:
				return "WavyDark";
			case 12:
				return "StraightMedium";
			case 13:
				return "WavyMedium";
			default:
				return "WavyMedium";
			}
		case 11:
			// Negroid
			return "KinkyBlack";
		case 12:
			switch (random.nextInt(20)) {
			// Australoid
			case 0:
				return "WavyBlack";
			case 1:
				return "WavyBlack";
			case 2:
				return "CurlyBlack";
			case 3:
				return "CurlyBlack";
			case 4:
				return "CurlyBlack";
			case 5:
				return "CurlyBlack";
			case 6:
				return "KinkyBlack";
			case 7:
				return "KinkyBlack";
			case 8:
				return "WavyDark";
			case 9:
				return "WavyDark";
			case 10:
				return "CurlyDark";
			case 11:
				return "CurlyDark";
			case 12:
				return "CurlyDark";
			case 13:
				return "CurlyDark";
			case 14:
				return "KinkyDark";
			case 15:
				return "KinkyDark";
			case 16:
				return "WavyMedium";
			case 17:
				return "CurlyMedium";
			case 18:
				return "CurlyMedium";
			default:
				return "KinkyMedium";
			}
		default:
			switch (random.nextInt(9)) {
			// Capoid
			case 0:
				return "CurlyBlack";
			case 1:
				return "CurlyBlack";
			case 2:
				return "KinkyBlack";
			case 3:
				return "KinkyBlack";
			case 4:
				return "KinkyBlack";
			case 5:
				return "KinkyBlack";
			case 6:
				return "CurlyDark";
			case 7:
				return "KinkyDark";
			default:
				return "KinkyDark";
			}
		}
	}

}
