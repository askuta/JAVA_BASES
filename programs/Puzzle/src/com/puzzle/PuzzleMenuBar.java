package com.puzzle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class PuzzleMenuBar extends MenuBar {

	public PuzzleMenuBar(PuzzleBoard puzzleBoard) {
		Menu menu = new Menu("Menu");

		menu.getItems().addAll(createShuffle(puzzleBoard), createSort(puzzleBoard), new SeparatorMenuItem(),
				createSize(puzzleBoard));

		getMenus().add(menu);
	}

	private MenuItem createShuffle(final PuzzleBoard puzzleBoard) {
		MenuItem menuShuffle = new MenuItem("Shuffle");
		menuShuffle.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				puzzleBoard.shuffleBoard();
			}
		});

		return menuShuffle;
	}

	private MenuItem createSort(final PuzzleBoard puzzleBoard) {
		MenuItem menuSort = new MenuItem("Sort");
		menuSort.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				puzzleBoard.sortBoard();
			}
		});

		return menuSort;
	}

	private Menu createSize(final PuzzleBoard puzzleBoard) {
		MenuItem menuItem3x3 = new MenuItem("3 x 3");
		menuItem3x3.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				puzzleBoard.resetBoard(3, 3);
			}
		});

		MenuItem menuItem4x4 = new MenuItem("4 x 4");
		menuItem4x4.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				puzzleBoard.resetBoard(4, 4);
			}
		});

		MenuItem menuItem5x5 = new MenuItem("5 x 5");
		menuItem5x5.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				puzzleBoard.resetBoard(5, 5);
			}
		});

		Menu menuSize = new Menu("Size");
		menuSize.getItems().addAll(menuItem3x3, menuItem4x4, menuItem5x5);

		return menuSize;
	}
}
