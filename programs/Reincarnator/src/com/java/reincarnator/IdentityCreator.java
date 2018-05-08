package com.java.reincarnator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.java.reincarnator.Identity.Death;
import com.java.reincarnator.Identity.Gender;
import com.java.reincarnator.Identity.Urban;

public class IdentityCreator {

	private Random random = new Random();
	private StatContainer statContainer;

	public IdentityCreator() {
		statContainer = new StatContainer();
		this.statContainer.readStats();
	}

	public Identity createIdentity() {

		CountryStat countryStat = statContainer.getRandomCountryStat();
		Identity identity = new Identity();

		identity.setCountryStat(countryStat);
		identity.setGender(createGender(countryStat));
		identity.setDeath(createDeath(countryStat, identity.getGender()));
		identity.setUrban(createUrban(countryStat));
		identity.setDollarsPerDay(createDollarsPerDay(countryStat, identity.getGender(), identity.getUrban()));
		identity.setPersonName(createPersonName(countryStat, identity.getGender()));
		return identity;
	}

	private double createDollarsPerDay(CountryStat countryStat, Gender gender, Urban urban) {
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

		// Ellenõrzés céljából:
		// for (int index = 0; index < incomeDecimals.length; index++) {
		// System.out.print(incomeDecimals[index] + " | ");
		// }
		// System.out.println("");
		// Eddig

		int decimal = random.nextInt(12);

		// Rögtönzött súlyozás nem és lakhely szerint, nagyjából 20%-os
		// eltéréssel számolva
		if (gender == Gender.MALE) {
			decimal = GenerateBias.generateBias(decimal, 11, 0, 6, 2, false);
		} else {
			decimal = GenerateBias.generateBias(decimal, 11, 0, 6, -2, false);
		}

		if (urban == Urban.URBAN) {
			decimal = GenerateBias.generateBias(decimal, 11, 0, 6, 2, false);
		} else {
			decimal = GenerateBias.generateBias(decimal, 11, 0, 6, -2, false);
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

	private Death createDeath(CountryStat countryStat, Gender gender) {
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

	private Gender createGender(CountryStat countryStat) {
		if (random.nextDouble() * 100 < countryStat.getWomanRate()) {
			return Gender.FEMALE;
		} else {
			return Gender.MALE;
		}
	}

	private Urban createUrban(CountryStat countryStat) {
		if (random.nextDouble() * 100 < countryStat.getUrbanRate()) {
			return Urban.URBAN;
		} else {
			return Urban.RURAL;
		}
	}

	private String createPersonName(CountryStat countryStat, Gender gender) {

		List<String> allFamilyNames = new ArrayList<>();
		allFamilyNames.addAll(countryStat.getMaleFamilyNames());
		allFamilyNames.addAll(countryStat.getFemaleFamilyNames());

		switch (countryStat.getNameInfo()) {
		case 1:
			// First names are not in order of popularity:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames(), 1) + " "
						+ ChooseFromList.chooseFromList(allFamilyNames));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames(), 1) + " "
						+ ChooseFromList.chooseFromList(allFamilyNames));
			}
		case 2:
			// Surnames are separated by gender:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFamilyNames()));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFamilyNames()));
			}
		case 3:
			// There are usually 2 or 3 surnames:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFamilyNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFamilyNames()));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFamilyNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFamilyNames()));
			}
		case 4:
			// Has a middle name which is patronymic; genders are separated:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFamilyNames()));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFamilyNames()));
			}
		case 5:
			// Surname comes first; Many girls receive names including a doubled pair of
			// characters:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(allFamilyNames) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			} else {
				return (ChooseFromList.chooseFromList(allFamilyNames) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()));
			}
		case 6:
			// First names are used as surnames:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			}
		case 7:
			// First names are used as surnames, 2-3 times:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			}
		case 8:
			// Surname comes first:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(allFamilyNames) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			} else {
				return (ChooseFromList.chooseFromList(allFamilyNames) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()));
			}
		case 9:
			// First names are used as surnames, 3-4 times:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			}
		case 10:
			// 2 first names and 2 surnames:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFamilyNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFamilyNames()));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFamilyNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFamilyNames()));
			}
		case 11:
			// 1 surname then 2 first names:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFamilyNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFamilyNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()));
			}
		default:
			if (gender == Gender.MALE) {
				return (ChooseFromList.chooseFromList(countryStat.getMaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(allFamilyNames));
			} else {
				return (ChooseFromList.chooseFromList(countryStat.getFemaleFirstNames()) + " "
						+ ChooseFromList.chooseFromList(allFamilyNames));
			}
		}
	}
}
