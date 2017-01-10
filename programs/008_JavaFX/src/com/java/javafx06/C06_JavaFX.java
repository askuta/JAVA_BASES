package com.java.javafx06;

import java.util.Random;

import com.java.javafx06.Identity.Gender;
import com.java.javafx06.Identity.Urban;

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
import javafx.stage.Stage;

public class C06_JavaFX extends Application {

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
		stage.setTitle("Reincatron 1.0");
		
		Text description = new Text("Who are you in your next life?");
		description.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
		
		Text identityDescription = new Text("You are a...");
		identityDescription.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
		
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
		Gender gender;
		if (random.nextBoolean()) {
			gender = Gender.MALE;
		} else {
			gender = Gender.FEMALE;
		}
		
		CountryStat countryStat = statContainer.getRandomCountryStat();
		
		Urban urban;
		if (random.nextDouble() * 100 < countryStat.getUrbanRate()) {
			urban = Urban.URBAN;
		} else {
			urban = Urban.RURAL;
		}
		
		return new Identity(gender, countryStat.getName(), urban);
	}
}
