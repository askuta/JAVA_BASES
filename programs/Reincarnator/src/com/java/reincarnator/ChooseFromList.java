package com.java.reincarnator;

import java.util.List;
import java.util.Random;

public class ChooseFromList {

	private static Random random = new Random();

	public static String chooseFromList(List<String> list) {

		return list.get((int) (Math.pow(((double) random.nextInt(list.size()) / list.size()), 2) * list.size()));
	}

	public static String chooseFromList(List<String> list, int expon) {

		return list.get((int) (Math.pow(((double) random.nextInt(list.size()) / list.size()), expon) * list.size()));
	}
}