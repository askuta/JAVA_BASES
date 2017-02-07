package com.puzzle;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PuzzleField extends ImageView {

	private final int serialNumber;

	private int row;
	private int column;

	private final int width;
	private final int height;

	public PuzzleField(Image image, int serialNumber, int column, int row, int fieldWidth, int fieldHeight) {
		super(image);

		this.serialNumber = serialNumber;

		this.column = column;
		this.row = row;

		this.width = fieldWidth;
		this.height = fieldHeight;

		setViewportRectangle();
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumnAndRow(int column, int row) {
		this.column = column;
		this.row = row;

		setViewportRectangle();
	}

	private void setViewportRectangle() {
		Rectangle2D viewportRectangle = new Rectangle2D(column * width, row * height, width, height);
		super.setViewport(viewportRectangle);
	}
}
