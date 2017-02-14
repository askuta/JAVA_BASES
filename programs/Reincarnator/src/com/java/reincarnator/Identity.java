package com.java.reincarnator;

public class Identity {

	private static int livesCounter = 0;

	public enum Gender {
		MALE, FEMALE
	}
	
	public enum Death {
		INFANT, CHILD, ALIVE
	}
	
	public enum Urban {
		URBAN, RURAL
	}
	
	private String country;
	private Gender gender;
	private Death death;
	private Urban urban;
	private double dollarsPerDay;

	public Identity(String country, Gender gender, Death death, Urban urban, double dollarsPerDay) {
		this.country = country;
		this.gender = gender;
		this.death = death;
		this.urban = urban;
		this.dollarsPerDay = dollarsPerDay;
		livesCounter += 1;
	}
	
	public String getCountry () {
		return country;
	}
	
	public Gender getGender () {
		return gender;
	}
	
	public Death getDeath () {
		return death;
	}
	
	public Urban getUrban () {
		return urban;
	}
	
	public double getDollarsPerDay () {
		return dollarsPerDay;
	}
	
	public String getDescription() {
		String description = "You are a ";
		
		if (gender == Gender.MALE) {
			description += "boy ";
		} else {
			description += "girl ";
		}
		
		description += "in ";
		
		if (urban == Urban.URBAN) {
			description += "urban ";
		} else {
			description += "rural ";
		}
		
		description += country + ". ";
		
		if (dollarsPerDay <= 1.9) {
			description += "You live in extreme poverty. ";
		} else {
			description += "You live by " + dollarsPerDay + " intern. dollars per day. ";
		}
		
		if ("Hungary".equals(country)) {
			description += "! Welcome to Magyaristan! You waited " + livesCounter + " lives.";
			livesCounter = 0;
		}
		
		return description;
	}
}
