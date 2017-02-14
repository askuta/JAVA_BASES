package com.java.reincarnator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

public class StatContainer {

	private static final String STAT_FILE = "/ReincaStats4.csv";

	private static final int NUMBER_OF_STAT_RECORDS = 217;

	private final CountryStat[] countryStats;
	private final Random random = new Random();
	private long worldPopulation;

	public StatContainer() {
		countryStats = new CountryStat[NUMBER_OF_STAT_RECORDS];
	}

	public CountryStat[] getCountryStats() {
		return countryStats;
	}

	public CountryStat getRandomCountryStat() {
		long randomHeadcount = Math.abs(random.nextLong()) % worldPopulation;
		
		long counterHeadcount = 0;
		CountryStat chosenCountryStat = null;
		for (CountryStat countryStat : countryStats) {
			counterHeadcount = counterHeadcount + countryStat.getPopulation();

			if (randomHeadcount <= counterHeadcount) {
				chosenCountryStat = countryStat;
				break;
			}
		}

		return chosenCountryStat;
	}

	public void readStats() {
		worldPopulation = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(
				getClass().getResource(STAT_FILE).toURI().getPath()))) {

			String line;
			String[] splits;
			for (int index = 0; index < NUMBER_OF_STAT_RECORDS; index++) {
				line = reader.readLine();
				splits = line.split(";");

				int population = Integer.parseInt(splits[1]);
				worldPopulation += population;
				double womanRate = Double.parseDouble(splits[2]);
				double urbanRate = Double.parseDouble(splits[3]);
				double averageDollarsPerDay = Double.parseDouble(splits[4]);
				double giniIndex = Double.parseDouble(splits[5]);
				double mortalityInfantFemale = Double.parseDouble(splits[8]);
				double mortalityInfantMale = Double.parseDouble(splits[9]);
				double mortalityChildFemale = Double.parseDouble(splits[10]);
				double mortalityChildMale = Double.parseDouble(splits[11]);

				countryStats[index] = new CountryStat(splits[0], population, womanRate, urbanRate, averageDollarsPerDay,
						giniIndex, mortalityInfantFemale, mortalityInfantMale, mortalityChildFemale, mortalityChildMale);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	}
}