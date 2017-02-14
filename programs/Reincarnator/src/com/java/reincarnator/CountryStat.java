package com.java.reincarnator;

public class CountryStat {

	private final String name;
	private final int population;
	private final double womanRate;
	private final double urbanRate;
	private final double averageDollarsPerDay;
	private final double giniIndex;
	private final double mortalityInfantFemale;
	private final double mortalityInfantMale;
	private final double mortalityChildFemale;
	private final double mortalityChildMale;

	public CountryStat(String name, int population, double womanRate, double urbanRate, double averageDollarsPerDay,
			 double giniIndex, double mortalityInfantFemale, double mortalityInfantMale, double mortalityChildFemale,
			 double mortalityChildMale) {
		this.name = name;
		this.population = population;
		this.urbanRate = urbanRate;
		this.womanRate = womanRate;
		this.averageDollarsPerDay = averageDollarsPerDay;
		this.giniIndex = giniIndex;
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
	public double getAverageDollarsPerDay() {
		return averageDollarsPerDay;
	}
	public double getGiniIndex() {
		return giniIndex;
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
