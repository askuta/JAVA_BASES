package com.java.javafx04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class C04_JavaFX extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Text and button");
		
		Text text = new Text("Some text.");
		Button button = new Button("Dummy button");
		
		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(text);
		vbox.getChildren().add(button);
		
		Scene scene = new Scene(vbox, 250, 150);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
}

