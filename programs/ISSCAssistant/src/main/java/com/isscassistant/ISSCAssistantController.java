package com.isscassistant;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ISSCAssistantController implements Initializable {

	@FXML
	private GridPane mainPane;

	@FXML
	private DatePicker pickerFirstDay;

	@FXML
	private TextField textFieldCSP;

	@FXML
	private TextField textFieldLinking;

	@FXML
	private Button buttonTwoWeek;

	@FXML
	private Label textWeekB;

	@FXML
	private CheckBox checkMA;

	@FXML
	private CheckBox checkTuA;

	@FXML
	private CheckBox checkWA;

	@FXML
	private CheckBox checkThA;

	@FXML
	private CheckBox checkFA;

	@FXML
	private CheckBox checkSaA;

	@FXML
	private CheckBox checkSuA;

	@FXML
	private Label textWeekA;

	@FXML
	private CheckBox checkMB;

	@FXML
	private CheckBox checkTuB;

	@FXML
	private CheckBox checkWB;

	@FXML
	private CheckBox checkThB;

	@FXML
	private CheckBox checkFB;

	@FXML
	private CheckBox checkSaB;

	@FXML
	private CheckBox checkSuB;

	@FXML
	private Button buttonCalculate;

	@FXML
	private Label textDateCSP;

	@FXML
	private Label textDateSSP;

	@FXML
	private Button buttonExit;

	private LastDayCalculator dayCalculator = new LastDayCalculator();

	@FXML
	void on2WeekScheduleButtonAction(ActionEvent event) {
		// A második checkbox sor gombjainak a disabled státusza
		// átvált a jelenlegi státuszuk ellentétére:
		checkMB.setDisable(!checkMB.isDisabled());
		checkTuB.setDisable(!checkTuB.isDisabled());
		checkWB.setDisable(!checkWB.isDisabled());
		checkThB.setDisable(!checkThB.isDisabled());
		checkFB.setDisable(!checkFB.isDisabled());
		checkSaB.setDisable(!checkSaB.isDisabled());
		checkSuB.setDisable(!checkSuB.isDisabled());

		textWeekA.setVisible(!textWeekA.isVisible());
		textWeekB.setVisible(!textWeekB.isVisible());
	}

	@FXML
	void onCalculateButtonAction(ActionEvent event) {
		// Az elsõ nap lekérdezése a datepicker-tõl:
		LocalDate firstDay = pickerFirstDay.getValue();

		// availableCSPDays legyen alapból 0, de ha a megfelelõ textfieldnek van
		// értelmes értéke, akkor azzal felülírjuk:
		int availableCSPDays = 0;
		if (textFieldCSP.getText() != null && textFieldCSP.getText().length() != 0) {
			availableCSPDays = Integer.valueOf(textFieldCSP.getText());
		}

		// Work Schedule megkreálása a bejelölgetõs imput alapján, egy- vagy
		// kéthetes kiszerelésben:
		boolean[] workSchedule;
		if (checkMB.isDisabled()) {
			workSchedule = new boolean[7];
		} else {
			workSchedule = new boolean[14];
		}

		workSchedule[0] = checkMA.isSelected();
		workSchedule[1] = checkTuA.isSelected();
		workSchedule[2] = checkWA.isSelected();
		workSchedule[3] = checkThA.isSelected();
		workSchedule[4] = checkFA.isSelected();
		workSchedule[5] = checkSaA.isSelected();
		workSchedule[6] = checkSuA.isSelected();

		if (!checkMB.isDisabled()) {
			workSchedule[7] = checkMB.isSelected();
			workSchedule[8] = checkTuB.isSelected();
			workSchedule[9] = checkWB.isSelected();
			workSchedule[10] = checkThB.isSelected();
			workSchedule[11] = checkFB.isSelected();
			workSchedule[12] = checkSaB.isSelected();
			workSchedule[13] = checkSuB.isSelected();
		}

		// availableSSPDays kiszámolása a két work schedule átlaga alapján (egy
		// átmeneti double segítségével a törtek miatt):
		int availableSSPDays = 0;
		for (int index = 0; index < workSchedule.length; index++) {
			if (workSchedule[index]) {
				availableSSPDays += 1;
			}
		}
		double availableSSPDaysD = (double) availableSSPDays / (workSchedule.length / 7);
		availableSSPDays = (int) (availableSSPDaysD * 28);
		if (textFieldLinking.getText() != null && textFieldLinking.getText().length() != 0) {
			availableSSPDays -= Integer.valueOf(textFieldLinking.getText());
		}
		

		// A LastDayCalculator-ba végzi a napok számolgatását:
		// - firstDay: alapértelmezetten a mai nap, egyébként a datepicker
		// gondoskodik a valós értékrõl
		// - availableCSPDays: alapértelmezetten 0, egyébként a initialize
		// metódusban lévõ listener gondoskodik a valós értékrõl
		// - availableSSPDays: alapértelmezetten 0, egyébként a initialize
		// metódusban lévõ listener gondoskodik a valós értékrõl
		// A kalkuláció csak akkor fut le, ha van CSP entitlement, és a work
		// schedule se üres (ha üres lenne, az SSP entitlement is 0 lenne):
		if (availableCSPDays > 0 && (availableSSPDays - 3) > 0) {
			textDateCSP.setText(dayCalculator.calculateLastDay(firstDay, availableCSPDays, workSchedule).toString());
			textDateSSP.setText(dayCalculator.calculateLastDay(firstDay.plusDays(3), availableSSPDays, workSchedule).toString());
		}
	}

	@FXML
	void onPickerFirstDayAction(ActionEvent event) {
		setWeeks();
	}

	@FXML
	void onExitButtonAction(ActionEvent event) {
		// JavaFX alkalmazás bezárása:
		Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Beállítom a datepickereket mára, hogy ne üresen kezdjen:
		pickerFirstDay.setValue(LocalDate.now());

		// Az alábbi két listener nem a UI elemekre vannak rákötve, hanem a UI
		// elemek által kezelt szövegre. Így nem kell lekezelni mindenféle UI
		// eseményeket (gépelés, egerészés, drag&drop, hanem elég a kezelt
		// szöveget figyelni.
		// A SceneBuilderben csak a UI elemekhez tud metódust rendelni, ezért
		// a UI elemen belül kezelt szöveghez nekünk kell listenert hozzáadni.
		textFieldCSP.textProperty().addListener((observable, oldValue, newValue) -> {
			// Ha az új szöveg nem néz ki "napok számának", akkor "megtartjuk" a
			// régi értéket.
			if (!isStringValidAsDays(newValue)) {
				textFieldCSP.textProperty().setValue(oldValue);
			}
		});
		textFieldLinking.textProperty().addListener((observable, oldValue, newValue) -> {
			// Ha az új szöveg nem néz ki "napok számának", akkor "megtartjuk" a
			// régi értéket.
			if (!isStringValidAsDays(newValue)) {
				textFieldLinking.textProperty().setValue(oldValue);
			}
		});

		setWeeks();
	}

	private boolean isStringValidAsDays(String str) {
		if (str.matches("\\d*") && str.length() < 4) {
			return true;
		}

		return false;
	}

	// Az A-hét és B-hét tartományának a szövegének megadása:
	private void setWeeks() {
		LocalDate mondayOfSchedule = pickerFirstDay.getValue()
				.minusDays(pickerFirstDay.getValue().getDayOfWeek().getValue() - 1);
		textWeekA.setText(mondayOfSchedule.toString() + " to " + mondayOfSchedule.plusDays(6).toString());
		textWeekB.setText(mondayOfSchedule.plusDays(7).toString() + " to " + mondayOfSchedule.plusDays(13).toString());
	}
}
