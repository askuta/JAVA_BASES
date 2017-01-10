package com.java.javafx06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

public class StatContainer {

	private static final String STAT_FILE = "/ReincaStats1.csv";

	private static final int NUMBER_OF_STAT_RECORDS = 11;

	private final CountryStat[] countryStats;
	private final Random random = new Random();

	public StatContainer() {
		countryStats = new CountryStat[NUMBER_OF_STAT_RECORDS];
	}

	public CountryStat[] getCountryStats() {
		return countryStats;
	}

	public CountryStat getRandomCountryStat() {
		return countryStats[random.nextInt(NUMBER_OF_STAT_RECORDS)];
	}

	public void readStats() {
		try (BufferedReader reader
				= new BufferedReader(new FileReader(getClass().getResource(STAT_FILE).toURI().getPath()))) {

			String line;
			String[] splits;
			for (int index = 0; index < NUMBER_OF_STAT_RECORDS; index++) {
				line = reader.readLine();
				splits = line.split(";");
				
				int population = Integer.parseInt(splits[1]);
				double urbanRate = Double.parseDouble(splits[2]);

				countryStats[index] = new CountryStat(splits[0], population, urbanRate);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	}
}
