package com.java.javafx01;

import javafx.application.Application;
import javafx.stage.Stage;

public class C01_JavaFX extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Nice title");
		stage.show();
	}
}
