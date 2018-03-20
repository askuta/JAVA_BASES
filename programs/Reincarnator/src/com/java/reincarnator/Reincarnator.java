package com.java.reincarnator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Reincarnator extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		GridPane mainPane = FXMLLoader.load(getClass().getResource("/Reincarnator.fxml"));
		
		Scene scene = new Scene(mainPane);
		scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Reincarnator");
		stage.getIcons().add(new Image("/ReincarnatorIcon.png"));

		stage.show();
	}

}
