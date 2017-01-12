package com.java.javafx05;

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

public class C05_JavaFX extends Application {

	private int counter = 0;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Text and button");

		Text text = new Text("Push count on button: " + counter);
		text.setFont(Font.font("Ariel", FontWeight.NORMAL, 20));

		Button button = new Button("Push me");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {
				counter += 1;
				text.setText("Push count on button: " + counter);
			}
		});

		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(text);
		vbox.getChildren().add(button);

		Scene scene = new Scene(vbox, 250, 150);
		primaryStage.setScene(scene);

		primaryStage.show();
	}
}
