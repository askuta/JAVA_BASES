package com.java.reincarnator;

import java.util.ArrayList;
import java.util.List;

public class CountryStat {

	private final List<String> maleFirstNames = new ArrayList<>();
	private final List<String> femaleFirstNames = new ArrayList<>();
	private final List<String> maleFamilyNames = new ArrayList<>();
	private final List<String> femaleFamilyNames = new ArrayList<>();

	private final String name;
	private final int population;
	private final double womanRate;
	private final double urbanRate;
	private final double electricityRural;
	private final double electricityUrban;
	private final double internetAccess;
	private final double hivFemale;
	private final double hivMale;
	private final double femaleGenitalMutilation;
	private final double averageDollarsPerDay;
	private final double giniIndex;
	private final double unemploymentFemale;
	private final double unemploymentMale;
	private final double improvedSanitation;
	private final double improvedWater;
	private final double smokingFemale;
	private final double smokingMale;
	private final double migrantStock;
	private final double literacyFemale;
	private final double literacyMale;
	private final double mortalityInfantFemale;
	private final double mortalityInfantMale;
	private final double mortalityChildFemale;
	private final double mortalityChildMale;
	private final int raceNegIndex;
	private final int raceMonIndex;
	private final int nameInfo;

	public CountryStat(String name, int population, double womanRate, double urbanRate, double electricityRural,
			double electricityUrban, double averageDollarsPerDay, double internetAccess, double hivFemale,
			double hivMale, double femaleGenitalMutilation, double giniIndex, double unemploymentFemale,
			double unemploymentMale, double improvedSanitation, double improvedWater, double smokingFemale,
			double smokingMale, double migrantStock, double literacyFemale, double literacyMale,
			double mortalityInfantFemale, double mortalityInfantMale, double mortalityChildFemale,
			double mortalityChildMale, int raceNegIndex, int raceMonIndex, int nameInfo, List<String> maleFirstNames,
			List<String> femaleFirstNames, List<String> maleFamilyNames, List<String> femaleFamilyNames) {
		this.name = name;
		this.population = population;
		this.womanRate = womanRate;
		this.urbanRate = urbanRate;
		this.electricityRural = electricityRural;
		this.electricityUrban = electricityUrban;
		this.internetAccess = internetAccess;
		this.hivFemale = hivFemale;
		this.hivMale = hivMale;
		this.femaleGenitalMutilation = femaleGenitalMutilation;
		this.averageDollarsPerDay = averageDollarsPerDay;
		this.giniIndex = giniIndex;
		this.unemploymentFemale = unemploymentFemale;
		this.unemploymentMale = unemploymentMale;
		this.improvedSanitation = improvedSanitation;
		this.improvedWater = improvedWater;
		this.smokingFemale = smokingFemale;
		this.smokingMale = smokingMale;
		this.migrantStock = migrantStock;
		this.literacyFemale = literacyFemale;
		this.literacyMale = literacyMale;
		this.mortalityInfantFemale = mortalityInfantFemale;
		this.mortalityInfantMale = mortalityInfantMale;
		this.mortalityChildFemale = mortalityChildFemale;
		this.mortalityChildMale = mortalityChildMale;
		this.raceNegIndex = raceNegIndex;
		this.raceMonIndex = raceMonIndex;
		this.nameInfo = nameInfo;
		if (maleFirstNames != null) {
			this.maleFirstNames.addAll(maleFirstNames);
		}
		if (femaleFirstNames != null) {
			this.femaleFirstNames.addAll(femaleFirstNames);
		}
		if (maleFamilyNames != null) {
			this.maleFamilyNames.addAll(maleFamilyNames);
		}
		if (femaleFamilyNames != null) {
			this.femaleFamilyNames.addAll(femaleFamilyNames);
		}
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public double getWomanRate() {
		return womanRate;
	}

	public double getUrbanRate() {
		return urbanRate;
	}

	public double electricityRural() {
		return electricityRural;
	}

	public double electricityUrban() {
		return electricityUrban;
	}

	public double internetAccess() {
		return internetAccess;
	}

	public double hivFemale() {
		return hivFemale;
	}

	public double hivMale() {
		return hivMale;
	}

	public double femaleGenitalMutilation() {
		return femaleGenitalMutilation;
	}

	public double getAverageDollarsPerDay() {
		return averageDollarsPerDay;
	}

	public double getGiniIndex() {
		return giniIndex;
	}

	public double unemploymentFemale() {
		return unemploymentFemale;
	}

	public double unemploymentMale() {
		return unemploymentMale;
	}

	public double improvedSanitation() {
		return improvedSanitation;
	}

	public double improvedWater() {
		return improvedWater;
	}

	public double smokingFemale() {
		return smokingFemale;
	}

	public double smokingMale() {
		return smokingMale;
	}

	public double migrantStock() {
		return migrantStock;
	}

	public double literacyFemale() {
		return literacyFemale;
	}

	public double literacyMale() {
		return literacyMale;
	}

	public double getMortalityInfantFemale() {
		return mortalityInfantFemale;
	}

	public double getMortalityInfantMale() {
		return mortalityInfantMale;
	}

	public double getMortalityChildFemale() {
		return mortalityChildFemale;
	}

	public double getMortalityChildMale() {
		return mortalityChildMale;
	}

	public int getraceNegIndex() {
		return raceNegIndex;
	}

	public int getraceMonIndex() {
		return raceMonIndex;
	}
	
	public int getNameInfo() {
		return nameInfo;
	}
	
	public List<String> getMaleFirstNames() {
		return maleFirstNames;
	}
	
	public List<String> getFemaleFirstNames() {
		return femaleFirstNames;
	}
	
	public List<String> getMaleFamilyNames() {
		return maleFamilyNames;
	}
	
	public List<String> getFemaleFamilyNames() {
		return femaleFamilyNames;
	}
}
