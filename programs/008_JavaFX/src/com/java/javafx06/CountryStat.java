package com.java.javafx06;

public class CountryStat {

	private final String name;
	private final int population;
	private final double urbanRate;

	public CountryStat(String name, int population, double urbanRate) {
		this.name = name;
		this.population = population;
		this.urbanRate = urbanRate;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public double getUrbanRate() {
		return urbanRate;
	}
}
