package com.java.reincarnator;

import java.util.Random;

public class GenerateBias {

	private static Random random = new Random();

	// Ez a met�dus egy exponenci�lisan n�vekv� sorozatb�l ad ki egy v�letlenszer�
	// sz�mot (bias), �s ezzel tolja el a c�lv�ltoz� (target) �rt�k�t,
	// harangg�rbe-szer�
	// sz�r�ssal. Ehhez a sorozat hossz�t (biasSmoothing) �s a legnagyobb v�rhat�
	// sz�mot (maxBias) kell megadni. Az ut�bbi lehet m�nusz is. A c�lv�ltoz�
	// hat�rait a "targetMin" �s "targetMax" jelzi. A "bothDirections"
	// bekapcsol�s�val n�velhetj�k �s cs�kkenthetj�k is a target-et.
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