package com.java.reincarnator;

import java.util.Random;

import com.java.reincarnator.Identity.Death;
import com.java.reincarnator.Identity.Gender;
import com.java.reincarnator.Identity.Urban;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Reincarnator extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	private Random random = new Random();
	private StatContainer statContainer = new StatContainer();
	{
		statContainer.readStats();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Reincatron 1.3");

		Text description = new Text("Who are you in your next life?");
		description.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

		Text identityDescription = new Text("You are a...");
		identityDescription.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
		identityDescription.setWrappingWidth(180);
		identityDescription.setTextAlignment(TextAlignment.CENTER);

		Button reincarnate = new Button("Reincarnate!");
		reincarnate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Identity identity = createIdentity();
				identityDescription.setText(identity.getDescription());
			}
		});

		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(description);
		vbox.getChildren().add(reincarnate);
		vbox.getChildren().add(identityDescription);

		Scene scene = new Scene(vbox, 250, 150);
		stage.setScene(scene);

		stage.show();
	}

	private Identity createIdentity() {
		CountryStat countryStat = statContainer.getRandomCountryStat();

		Gender gender = createGender(countryStat);

		Death death = createDeath(countryStat, gender);

		Urban urban = createUrban(countryStat);

		double dollarsPerDay = createDollarsPerDay(countryStat);

		return new Identity(countryStat.getName(), gender, death, urban, dollarsPerDay);
	}

	private double createDollarsPerDay(CountryStat countryStat) {
		double dollarsPerDay;
		double[] incomeDecimals = new double[12];

		for (int index = 0; index < incomeDecimals.length; index++) {
			incomeDecimals[index] = countryStat.getAverageDollarsPerDay();
		}

		for (int index = 0; index < incomeDecimals.length; index++) {

			for (int subIndex = index + 1; subIndex < incomeDecimals.length; subIndex++) {
				incomeDecimals[index] = incomeDecimals[index]
						+ incomeDecimals[subIndex]
						* (countryStat.getGiniIndex() / 1200 * (incomeDecimals.length
								- index - 1));
				incomeDecimals[subIndex] = incomeDecimals[subIndex]
						- incomeDecimals[subIndex]
						* (countryStat.getGiniIndex() / 1200 * (incomeDecimals.length
								- index - 1));
			}
			incomeDecimals[index] = Math.floor(incomeDecimals[index] * 100) / 100;
		}

		// Ellenõrzés céljából:
		for (int index = 0; index < incomeDecimals.length; index++) {
			System.out.print(incomeDecimals[index] + " | ");
		}
		System.out.println("");
		//Eddig

		int decimal = random.nextInt(12);

		if (random.nextBoolean()) {
			if (decimal == incomeDecimals.length - 1) {
				dollarsPerDay = incomeDecimals[decimal]
						- (incomeDecimals[decimal] * random.nextDouble());
			} else {
				dollarsPerDay = incomeDecimals[decimal]
						- ((incomeDecimals[decimal] - incomeDecimals[decimal + 1]) / 2 * random
								.nextDouble());
			}
		} else {
			if (decimal == 0) {
				dollarsPerDay = incomeDecimals[decimal]
						+ (Math.pow(
								(incomeDecimals[decimal] - incomeDecimals[decimal + 1])
										* random.nextDouble(), 1.7));
			} else {
				dollarsPerDay = incomeDecimals[decimal]
						+ ((incomeDecimals[decimal - 1] - incomeDecimals[decimal]) / 2 * random
								.nextDouble());
			}
		}

		return Math.floor(dollarsPerDay * 100) / 100;
	}

	private Death createDeath(CountryStat countryStat, Gender gender) {
		Death death = Death.ALIVE;
		if (gender == Gender.FEMALE) {
			if (random.nextDouble() * 100 < countryStat.getMortalityInfantFemale()) {
				death = Death.INFANT;
			} else {
				if (random.nextDouble() * 100 < countryStat.getMortalityChildFemale()) {
					death = Death.CHILD;
				}
			}
		} else {
			if (random.nextDouble() * 100 < countryStat.getMortalityInfantMale()) {
				death = Death.INFANT;
			} else {
				if (random.nextDouble() * 100 < countryStat.getMortalityChildMale()) {
					death = Death.CHILD;
				}
			}
		}
		return death;
	}

	private Gender createGender(CountryStat countryStat) {
		if (random.nextDouble() * 100 < countryStat.getWomanRate()) {
			return Gender.FEMALE;
		} else {
			return Gender.MALE;
		}
	}

	private Urban createUrban(CountryStat countryStat) {
		if (random.nextDouble() * 100 < countryStat.getUrbanRate()) {
			return Urban.URBAN;
		} else {
			return Urban.RURAL;
		}
	}
	
}
