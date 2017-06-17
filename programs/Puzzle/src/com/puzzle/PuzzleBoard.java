package com.puzzle;

import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PuzzleBoard extends GridPane {

	private static final int DEFAULT_NUMBER_OF_COLUMNS = 3;
	private static final int DEFAULT_NUMBER_OF_ROWS = 3;
	private static final int OFFSET = 3;

	private int columns = DEFAULT_NUMBER_OF_COLUMNS;
	private int rows = DEFAULT_NUMBER_OF_ROWS;

	private Image image;
	private PuzzleField[] fields;

	private Random random = new Random();

	public PuzzleBoard(Image image) {
		super.setHgap(OFFSET);
		super.setVgap(OFFSET);
		super.setStyle("-fx-background-color: black;");

		this.image = image;

		createFields();
	}

	public void resetBoard(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;

		createFields();
	}

	public void shuffleBoard() {
		sortBoard();

		fields[fields.length - 1].setColumnAndRow(-1, -1);

		PuzzleField blankField = getBlankField();
		PuzzleField anotherField = null;
		int counter = (int) Math.pow(columns * rows, 2);
		while (0 < counter) {
			anotherField = fields[random.nextInt(columns * rows)];
			
			if (areFieldsNeighbours(blankField, anotherField)) {
				changeFields(blankField, anotherField);
				blankField = anotherField;
				counter--;
			}
		}
	}

	public void sortBoard() {
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				fields[row * rows + column].setColumnAndRow(column, row);
			}
		}
	}

	private void createFields() {
		removeFields();

		fields = new PuzzleField[rows * columns];

		int fieldWidth = (int) image.getWidth() / columns;
		int fieldHeight = (int) image.getHeight() / rows;

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				PuzzleField field = new PuzzleField(image, row * rows + column,
						column, row, fieldWidth, fieldHeight);
				fields[row * rows + column] = field;
				super.add(field, column, row);

				field.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						moveField((PuzzleField) event.getSource());
					}
				});
			}
		}
	}

	private void removeFields() {
		if (fields != null) {
			for (PuzzleField field : fields) {
				super.getChildren().remove(field);
			}
		}
	}

	private void moveField(PuzzleField field) {
		if (!isBoardSorted()) {
			PuzzleField blankField = getBlankField();

			if (areFieldsNeighbours(field, blankField)) {
				changeFields(field, blankField);
			}

			if (isBoardSorted()) {
				fields[fields.length - 1]
						.setColumnAndRow(columns - 1, rows - 1);
			}
		}
	}

	//To arrange a solvable puzzle, need to change neighboring fields with the blank field
	private void changeFields(PuzzleField field1, PuzzleField field2) {
		int tempColumn = field1.getColumn();
		int tempRow = field1.getRow();
		field1.setColumnAndRow(field2.getColumn(), field2.getRow());
		field2.setColumnAndRow(tempColumn, tempRow);
	}

	private boolean isBoardSorted() {
		for (int index = 0; index < fields.length - 1; index++) {
			PuzzleField field = fields[index];
			if (field.getSerialNumber() != field.getRow() * columns
					+ field.getColumn()) {
				return false;
			}
		}

		return true;
	}

	private PuzzleField getBlankField() {
		PuzzleField blankField = null;
		for (PuzzleField field : fields) {
			if (field.getRow() == -1 && field.getColumn() == -1) {
				blankField = field;
				break;
			}
		}

		return blankField;
	}

	private boolean areFieldsNeighbours(PuzzleField field1, PuzzleField field2) {
		if (Math.abs(field1.getSerialNumber() - field2.getSerialNumber()) == columns) {
			return true;
		} else if (Math.abs(field1.getSerialNumber() - field2.getSerialNumber()) == 1
				&& field1.getSerialNumber() / columns == field2.getSerialNumber() / columns) {
			return true;
		}
		
		return false;
	}
}
