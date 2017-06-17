package com.java.reincarnator;

public class CountryStat {

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

	public CountryStat(String name, int population, double womanRate,
			double urbanRate, double electricityRural, double electricityUrban,
			double averageDollarsPerDay, double internetAccess,
			double hivFemale, double hivMale, double femaleGenitalMutilation,
			double giniIndex, double unemploymentFemale,
			double unemploymentMale, double improvedSanitation,
			double improvedWater, double smokingFemale, double smokingMale,
			double migrantStock, double literacyFemale, double literacyMale,
			double mortalityInfantFemale, double mortalityInfantMale,
			double mortalityChildFemale, double mortalityChildMale) {
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
}
