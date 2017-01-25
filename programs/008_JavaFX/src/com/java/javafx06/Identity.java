package com.java.javafx06;

public class Identity {
	
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
	}
	
	public int livesCounter;
	
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
		
		if (country == "Hungary") {
			description += "! Welcome to Magyaristan! You waited " + livesCounter + " lives.";
		}
		
		return description;
	}
}
