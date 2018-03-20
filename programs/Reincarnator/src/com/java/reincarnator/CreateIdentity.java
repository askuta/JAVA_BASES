package com.java.reincarnator;

import java.util.Random;

import com.java.reincarnator.Identity.Death;
import com.java.reincarnator.Identity.Gender;
import com.java.reincarnator.Identity.Urban;

public class CreateIdentity {

	private static Random random = new Random();

	public static Identity createIdentity() {

		StatContainer statContainer = new StatContainer();
		statContainer.readStats();
		CountryStat countryStat = statContainer.getRandomCountryStat();
		Identity identity = new Identity();

		identity.setCountryStat(countryStat);
		identity.setGender(createGender(countryStat));
		identity.setDeath(createDeath(countryStat, identity.getGender()));
		identity.setUrban(createUrban(countryStat));
		identity.setDollarsPerDay(createDollarsPerDay(countryStat, identity.getGender(), identity.getUrban()));
		return identity;
	}

	private static double createDollarsPerDay(CountryStat countryStat, Gender gender, Urban urban) {
		double dollarsPerDay;
		double[] incomeDecimals = new double[12];

		for (int index = 0; index < incomeDecimals.length; index++) {
			incomeDecimals[index] = countryStat.getAverageDollarsPerDay();
		}

		for (int index = 0; index < incomeDecimals.length; index++) {

			for (int subIndex = index + 1; subIndex < incomeDecimals.length; subIndex++) {
				incomeDecimals[index] = incomeDecimals[index] + incomeDecimals[subIndex]
						* (countryStat.getGiniIndex() / 1200 * (incomeDecimals.length - index - 1));
				incomeDecimals[subIndex] = incomeDecimals[subIndex] - incomeDecimals[subIndex]
						* (countryStat.getGiniIndex() / 1200 * (incomeDecimals.length - index - 1));
			}
			incomeDecimals[index] = Math.floor(incomeDecimals[index] * 100) / 100;
		}

//		 Ellenõrzés céljából:
		 for (int index = 0; index < incomeDecimals.length; index++) {
		 System.out.print(incomeDecimals[index] + " | ");
		 }
		 System.out.println("");
//		 Eddig

		int decimal = random.nextInt(12);

		// Rögtönzött súlyozás nem és lakhely szerint, nagyjából 20%-os
		// eltéréssel számolva
		
		int bias = generateBias();

		if (gender == Gender.MALE) {
			switch (bias) {
			case 0:
				break;
			case 1:
				if (decimal < 11) {
					decimal++;
					break;
				}
			case 2:
				if (decimal < 10) {
					decimal = decimal + 2;
					break;
				}
			}
		} else {
			switch (bias) {
			case 0:
				break;
			case 1:
				if (decimal > 0) {
					decimal--;
					break;
				}
			case 2:
				if (decimal > 0) {
					decimal = decimal - 2;
					break;
				}
			}
		}

		bias = generateBias();

		if (urban == Urban.URBAN) {
			switch (bias) {
			case 0:
				break;
			case 1:
				if (decimal < 11) {
					decimal++;
					break;
				}
			case 2:
				if (decimal < 10) {
					decimal = decimal + 2;
					break;
				}
			}
		} else {
			switch (bias) {
			case 0:
				break;
			case 1:
				if (decimal > 0) {
					decimal--;
					break;
				}
			case 2:
				if (decimal > 0) {
					decimal = decimal - 2;
					break;
				}
			}
		}
		// eddig

		if (random.nextBoolean()) {
			if (decimal == incomeDecimals.length - 1) {
				dollarsPerDay = incomeDecimals[decimal] - (incomeDecimals[decimal] * random.nextDouble());
			} else {
				dollarsPerDay = incomeDecimals[decimal]
						- ((incomeDecimals[decimal] - incomeDecimals[decimal + 1]) / 2 * random.nextDouble());
			}
		} else {
			if (decimal == 0) {
				dollarsPerDay = incomeDecimals[decimal] + (Math
						.pow((incomeDecimals[decimal] - incomeDecimals[decimal + 1]) * random.nextDouble(), 1.7));
			} else {
				dollarsPerDay = incomeDecimals[decimal]
						+ ((incomeDecimals[decimal - 1] - incomeDecimals[decimal]) / 2 * random.nextDouble());
			}
		}

		return Math.floor(dollarsPerDay * 100) / 100;
	}
	
	private static int generateBias() {
		int bias = random.nextInt(6);
		switch (bias) {
		case 3:
			return 1;
		case 4:
			return 1;
		case 5:
			return 2;
		default:
			return 0;
		}
	}

	private static Death createDeath(CountryStat countryStat, Gender gender) {
		Death death = Death.ALIVE;
		if (gender == Gender.FEMALE) {
			if (random.nextDouble() * 100 < countryStat.getMortalityInfantFemale()) {
				death = Death.INFANT;
			} else {
				if (random.nextDouble() * 100 < countryStat.getMortalityChildFemale()) {
					death = Death.CHILD;
				}
			}
		} else {
			if (random.nextDouble() * 100 < countryStat.getMortalityInfantMale()) {
				death = Death.INFANT;
			} else {
				if (random.nextDouble() * 100 < countryStat.getMortalityChildMale()) {
					death = Death.CHILD;
				}
			}
		}
		return death;
	}

	private static Gender createGender(CountryStat countryStat) {
		if (random.nextDouble() * 100 < countryStat.getWomanRate()) {
			return Gender.FEMALE;
		} else {
			return Gender.MALE;
		}
	}

	private static Urban createUrban(CountryStat countryStat) {
		if (random.nextDouble() * 100 < countryStat.getUrbanRate()) {
			return Urban.URBAN;
		} else {
			return Urban.RURAL;
		}
	}

}
