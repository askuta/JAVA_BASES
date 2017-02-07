package com.puzzle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Puzzle extends Application {

	private static final String IMAGE_LOCATION = "/funnyImage.jpg";

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image(getClass().getResourceAsStream(IMAGE_LOCATION));

		PuzzleBoard puzzleBoard = new PuzzleBoard(image);
		PuzzleMenuBar puzzleMenuBar = new PuzzleMenuBar(puzzleBoard);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(puzzleBoard);
		borderPane.setTop(puzzleMenuBar);

		Scene scene = new Scene(borderPane);

		stage.setScene(scene);
		stage.setTitle("Puzzle");
		stage.setResizable(false);
		stage.show();
	}
}
