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

	private static final String BACKGROUND_FILE = "/Background.png";

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

		stage.setTitle("Reincatron");

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
		vbox.setAlignment(Pos.TOP_LEFT);
		vbox.getChildren().add(description);
		vbox.getChildren().add(reincarnate);
		vbox.getChildren().add(identityDescription);

		Scene scene = new Scene(vbox, 800, 600);
		stage.setScene(scene);
		stage.setResizable(false);

		String background = Reincarnator.class.getResource(BACKGROUND_FILE)
				.toExternalForm();
		vbox.setStyle("-fx-background-image: url('" + background + "'); "
				+ "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch;");

		stage.show();
	}

	private Identity createIdentity() {
		CountryStat countryStat = statContainer.getRandomCountryStat();

		Gender gender = createGender(countryStat);

		Death death = createDeath(countryStat, gender);

		Urban urban = createUrban(countryStat);

		double dollarsPerDay = createDollarsPerDay(countryStat, gender, urban);

		return new Identity(countryStat.getName(), gender, death, urban,
				dollarsPerDay);
	}

	private double createDollarsPerDay(CountryStat countryStat, Gender gender,
			Urban urban) {
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
		// Eddig

		int decimal = random.nextInt(12);

		// Rögtönzött súlyozás nem és lakhely szerint, nagyjából 20%-os
		// eltéréssel számolva
		int bias = random.nextInt(6);
		switch (bias) {
		case 0:
			bias = 0;
			break;
		case 1:
			bias = 0;
			break;
		case 2:
			bias = 0;
			break;
		case 3:
			bias = 1;
			break;
		case 4:
			bias = 1;
			break;
		case 5:
			bias = 2;
			break;
		default:
			bias = 0;
		}

		if (gender == Gender.MALE) {
			switch (bias) {
			case 0:
				break;
			case 1:
				if (decimal < 11) {
					decimal++;
					break;
				}
			case 2:
				if (decimal < 10) {
					decimal = decimal + 2;
					break;
				}
			}
		} else {
			switch (bias) {
			case 0:
				break;
			case 1:
				if (decimal > 0) {
					decimal--;
					break;
				}
			case 2:
				if (decimal > 0) {
					decimal = decimal - 2;
					break;
				}
			}
		}

		bias = random.nextInt(6);
		switch (bias) {
		case 0:
			bias = 0;
			break;
		case 1:
			bias = 0;
			break;
		case 2:
			bias = 0;
			break;
		case 3:
			bias = 1;
			break;
		case 4:
			bias = 1;
			break;
		case 5:
			bias = 2;
			break;
		default:
			bias = 0;
		}

		if (urban == Urban.URBAN) {
			switch (bias) {
			case 0:
				break;
			case 1:
				if (decimal < 11) {
					decimal++;
					break;
				}
			case 2:
				if (decimal < 10) {
					decimal = decimal + 2;
					break;
				}
			}
		} else {
			switch (bias) {
			case 0:
				break;
			case 1:
				if (decimal > 0) {
					decimal--;
					break;
				}
			case 2:
				if (decimal > 0) {
					decimal = decimal - 2;
					break;
				}
			}
		}
		// eddig

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
			if (random.nextDouble() * 100 < countryStat
					.getMortalityInfantFemale()) {
				death = Death.INFANT;
			} else {
				if (random.nextDouble() * 100 < countryStat
						.getMortalityChildFemale()) {
					death = Death.CHILD;
				}
			}
		} else {
			if (random.nextDouble() * 100 < countryStat
					.getMortalityInfantMale()) {
				death = Death.INFANT;
			} else {
				if (random.nextDouble() * 100 < countryStat
						.getMortalityChildMale()) {
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
