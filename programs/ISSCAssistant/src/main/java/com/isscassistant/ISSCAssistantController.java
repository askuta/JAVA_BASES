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
		// A m�sodik checkbox sor gombjainak a disabled st�tusza
		// �tv�lt a jelenlegi st�tuszuk ellent�t�re:
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
		// Az els� nap lek�rdez�se a datepicker-t�l:
		LocalDate firstDay = pickerFirstDay.getValue();

		// availableCSPDays legyen alapb�l 0, de ha a megfelel� textfieldnek van
		// �rtelmes �rt�ke, akkor azzal fel�l�rjuk:
		int availableCSPDays = 0;
		if (textFieldCSP.getText() != null && textFieldCSP.getText().length() != 0) {
			availableCSPDays = Integer.valueOf(textFieldCSP.getText());
		}

		// Work Schedule megkre�l�sa a bejel�lget�s imput alapj�n, egy- vagy
		// k�thetes kiszerel�sben:
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

		// availableSSPDays kisz�mol�sa a k�t work schedule �tlaga alapj�n (egy
		// �tmeneti double seg�ts�g�vel a t�rtek miatt):
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
		

		// A LastDayCalculator-ba v�gzi a napok sz�molgat�s�t:
		// - firstDay: alap�rtelmezetten a mai nap, egy�bk�nt a datepicker
		// gondoskodik a val�s �rt�kr�l
		// - availableCSPDays: alap�rtelmezetten 0, egy�bk�nt a initialize
		// met�dusban l�v� listener gondoskodik a val�s �rt�kr�l
		// - availableSSPDays: alap�rtelmezetten 0, egy�bk�nt a initialize
		// met�dusban l�v� listener gondoskodik a val�s �rt�kr�l
		// A kalkul�ci� csak akkor fut le, ha van CSP entitlement, �s a work
		// schedule se �res (ha �res lenne, az SSP entitlement is 0 lenne):
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
		// JavaFX alkalmaz�s bez�r�sa:
		Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Be�ll�tom a datepickereket m�ra, hogy ne �resen kezdjen:
		pickerFirstDay.setValue(LocalDate.now());

		// Az al�bbi k�t listener nem a UI elemekre vannak r�k�tve, hanem a UI
		// elemek �ltal kezelt sz�vegre. �gy nem kell lekezelni mindenf�le UI
		// esem�nyeket (g�pel�s, eger�sz�s, drag&drop, hanem el�g a kezelt
		// sz�veget figyelni.
		// A SceneBuilderben csak a UI elemekhez tud met�dust rendelni, ez�rt
		// a UI elemen bel�l kezelt sz�veghez nek�nk kell listenert hozz�adni.
		textFieldCSP.textProperty().addListener((observable, oldValue, newValue) -> {
			// Ha az �j sz�veg nem n�z ki "napok sz�m�nak", akkor "megtartjuk" a
			// r�gi �rt�ket.
			if (!isStringValidAsDays(newValue)) {
				textFieldCSP.textProperty().setValue(oldValue);
			}
		});
		textFieldLinking.textProperty().addListener((observable, oldValue, newValue) -> {
			// Ha az �j sz�veg nem n�z ki "napok sz�m�nak", akkor "megtartjuk" a
			// r�gi �rt�ket.
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

	// Az A-h�t �s B-h�t tartom�ny�nak a sz�veg�nek megad�sa:
	private void setWeeks() {
		LocalDate mondayOfSchedule = pickerFirstDay.getValue()
				.minusDays(pickerFirstDay.getValue().getDayOfWeek().getValue() - 1);
		textWeekA.setText(mondayOfSchedule.toString() + " to " + mondayOfSchedule.plusDays(6).toString());
		textWeekB.setText(mondayOfSchedule.plusDays(7).toString() + " to " + mondayOfSchedule.plusDays(13).toString());
	}
}
