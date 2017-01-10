package com.java.javafx02;

import javafx.application.Application;
import javafx.stage.Stage;

public class C02_JavaFX extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage originalStage) {
		originalStage.setTitle("Original stage");
		originalStage.setX(100);
		originalStage.setY(100);
		originalStage.setWidth(300);
		originalStage.setHeight(200);
		originalStage.show();
		
		Stage anotherStage = new Stage();
		anotherStage.setTitle("Another stage");
		anotherStage.setX(400);
		anotherStage.setY(200);
		anotherStage.setWidth(300);
		anotherStage.setHeight(200);
		anotherStage.show();
	}
}
