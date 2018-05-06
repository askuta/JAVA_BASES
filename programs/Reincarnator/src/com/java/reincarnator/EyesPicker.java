package com.java.reincarnator;

import java.util.Random;

public class EyesPicker {

	private static Random random = new Random();

	public static String pickEyes(int type) {
		switch (type) {
		case 1:
			// Nordic
			switch (random.nextInt(5)) {
			case 0:
				return "Amber";
			case 1:
				return "Drab";
			case 2:
				return "Green";
			case 3:
				return "Blue";
			default:
				return "Blue";
			}
		case 2:
			// Europid
			switch (random.nextInt(6)) {
			case 0:
				return "Dark";
			case 1:
				return "Amber";
			case 2:
				return "Amber";
			case 3:
				return "Drab";
			case 4:
				return "Green";
			default:
				return "Blue";
			}
		case 3:
			// South European
			switch (random.nextInt(6)) {
			case 0:
				return "Dark";
			case 1:
				return "Dark";
			case 2:
				return "Amber";
			case 3:
				return "Amber";
			case 4:
				return "Drab";
			default:
				return "Green";
			}
		case 4:
			// Mixed
			switch (random.nextInt(3)) {
			case 0:
				return "SquintDark";
			case 1:
				return "SquintDark";
			default:
				return "SquintAmber";
			}
		case 5:
			// Mongoloid
			return "Asian";
		case 6:
			// Brown
			switch (random.nextInt(3)) {
			case 0:
				return "Dark";
			case 1:
				return "Dark";
			default:
				return "Amber";
			}
		default:
			// Black
			return "Dark";
		}
	}

}
