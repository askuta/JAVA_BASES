package com.java.javafx06;

public class Identity {

	public enum Gender {
		MALE, FEMALE
	}
	
	public enum Urban {
		URBAN, RURAL
	}
	
	private Gender gender;
	private String country;
	private Urban urban;
	
	public Identity(Gender gender, String country, Urban urban) {
		this.gender = gender;
		this.country = country;
		this.urban = urban;
	}
	
	public Gender getGender () {
		return gender;
	}
	
	public String getCountry () {
		return country;
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
		
		description += "in " + country;
		
		return description;
	}
}
