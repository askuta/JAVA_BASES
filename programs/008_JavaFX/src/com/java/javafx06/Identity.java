package com.java.javafx06;

public class Identity {

	private static int livesCounter = 0;

	public enum Gender {
		MALE, FEMALE
	}
	
	public enum Urban {
		URBAN, RURAL
	}
	
	private String country;
	private Gender gender;
	private Urban urban;

	public Identity(String country, Gender gender, Urban urban) {
		this.country = country;
		this.gender = gender;
		this.urban = urban;
		livesCounter += 1;
	}
	
	public String getCountry () {
		return country;
	}
	
	public Gender getGender () {
		return gender;
	}
	
	public Urban getUrban () {
		return urban;
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
		
		description += country;
		
		if ("Hungary".equals(country)) {
			description += "! Welcome to Magyaristan! You waited " + livesCounter + " lives.";
			livesCounter = 0;
		}
		
		return description;
	}
}
