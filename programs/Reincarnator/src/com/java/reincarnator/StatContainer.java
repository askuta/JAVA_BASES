package com.java.reincarnator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StatContainer {

	private static final String STAT_FILE = "/ReincaStats.csv";

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

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream(STAT_FILE)))) {

			String line;
			String[] splits;
			for (int index = 0; index < NUMBER_OF_STAT_RECORDS; index++) {
				line = reader.readLine();
				splits = line.split(";");

				int population = Integer.parseInt(splits[1]);
				worldPopulation += population;
				double womanRate = Double.parseDouble(splits[2]);
				double urbanRate = Double.parseDouble(splits[3]);
				double electricityRural = Double.parseDouble(splits[4]);
				double electricityUrban = Double.parseDouble(splits[5]);
				double internetAccess = Double.parseDouble(splits[6]);
				double hivFemale = Double.parseDouble(splits[7]);
				double hivMale = Double.parseDouble(splits[8]);
				double femaleGenitalMutilation = Double.parseDouble(splits[9]);
				double averageDollarsPerDay = Double.parseDouble(splits[10]);
				double giniIndex = Double.parseDouble(splits[11]);
				double unemploymentFemale = Double.parseDouble(splits[12]);
				double unemploymentMale = Double.parseDouble(splits[13]);
				double improvedSanitation = Double.parseDouble(splits[14]);
				double improvedWater = Double.parseDouble(splits[15]);
				double smokingFemale = Double.parseDouble(splits[16]);
				double smokingMale = Double.parseDouble(splits[17]);
				double migrantStock = Double.parseDouble(splits[18]);
				double literacyFemale = Double.parseDouble(splits[19]);
				double literacyMale = Double.parseDouble(splits[20]);
				double mortalityInfantFemale = Double.parseDouble(splits[21]);
				double mortalityInfantMale = Double.parseDouble(splits[22]);
				double mortalityChildFemale = Double.parseDouble(splits[23]);
				double mortalityChildMale = Double.parseDouble(splits[24]);
				int raceNegIndex = Integer.parseInt(splits[25]);
				int raceMonIndex = Integer.parseInt(splits[26]);
				int nameInfo = Integer.parseInt(splits[27]);

				int splitIndex = 28;

				List<String> maleFirstNames = new ArrayList<>();
				while ((splits[splitIndex] != "") && (splitIndex < 128)) {
					maleFirstNames.add(splits[splitIndex]);
					splitIndex++;
				}

				List<String> femaleFirstNames = new ArrayList<>();
				while ((splits[splitIndex] != "") && (splitIndex < 228)) {
					femaleFirstNames.add(splits[splitIndex]);
					splitIndex++;
				}

				List<String> maleFamilyNames = new ArrayList<>();
				while ((splits[splitIndex] != "") && (splitIndex < 328)) {
					maleFamilyNames.add(splits[splitIndex]);
					splitIndex++;
				}

				List<String> femaleFamilyNames = new ArrayList<>();
				while ((splits[splitIndex] != "") && (splitIndex < 428)) {
					femaleFamilyNames.add(splits[splitIndex]);
					splitIndex++;
				}

				countryStats[index] = new CountryStat(splits[0], population, womanRate, urbanRate, electricityRural,
						electricityUrban, internetAccess, hivFemale, hivMale, femaleGenitalMutilation,
						averageDollarsPerDay, giniIndex, unemploymentFemale, unemploymentMale, improvedSanitation,
						improvedWater, smokingFemale, smokingMale, migrantStock, literacyFemale, literacyMale,
						mortalityInfantFemale, mortalityInfantMale, mortalityChildFemale, mortalityChildMale,
						raceNegIndex, raceMonIndex, nameInfo, maleFirstNames, femaleFirstNames, maleFamilyNames,
						femaleFamilyNames);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
