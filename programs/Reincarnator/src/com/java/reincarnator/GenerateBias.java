package com.java.reincarnator;

import java.util.Random;

public class GenerateBias {

	private static Random random = new Random();

	// Ez a metódus egy exponenciálisan növekvõ sorozatból ad ki egy véletlenszerû
	// számot (bias), és ezzel tolja el a célváltozó (target) értékét,
	// haranggörbe-szerû
	// szórással. Ehhez a sorozat hosszát (biasSmoothing) és a legnagyobb várható
	// számot (maxBias) kell megadni. Az utóbbi lehet mínusz is. A célváltozó
	// határait a "targetMin" és "targetMax" jelzi. A "bothDirections"
	// bekapcsolásával növelhetjük és csökkenthetjük is a target-et.
	public static int generateBias(int target, int targetMin, int targetMax, int biasSmoothing, int maxBias,
			boolean bothDirections) {
		
		int biasedTarget = target;
		int bias = (int) Math
				.round(Math.pow(((double) random.nextInt(biasSmoothing) / (double) (biasSmoothing - 1)), 2) * maxBias);

		if (bothDirections) {
			if (random.nextBoolean()) {
				bias = -bias;
			}
		}
		
		if (bias > 0) {
			for (int index = bias; (biasedTarget < targetMax) && (index > 0); index--) {
				biasedTarget++;
			}
		} else {
			for (int index = bias; (biasedTarget > targetMin) && (index < 0); index++) {
				biasedTarget--;
			}
		}
		return biasedTarget;
	}
}