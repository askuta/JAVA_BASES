package com.java.javafx03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class C03_JavaFX extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Nice title");
		
		Button button = new Button("Lazy button");
		
		Scene scene = new Scene(button, 250, 150);
		stage.setScene(scene);
		
		stage.show();
	}
}
