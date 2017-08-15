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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ISSCAssistantController implements Initializable {

	@FXML
	private GridPane mainPane;

	@FXML
	private Label text1;

	@FXML
	private DatePicker pickerFirstDay;

	@FXML
	private DatePicker pickerSSPDay;

	@FXML
	private Label text2;

	@FXML
	private TextField textFieldCSP;

	@FXML
	private ImageView pictureSick;

	@FXML
	private Button buttonTwoWeek;

	@FXML
	private Button buttonLinking;

	@FXML
	private Label text4;

	@FXML
	private Label textM;

	@FXML
	private Label textTu;

	@FXML
	private Label textW;

	@FXML
	private Label textTh;

	@FXML
	private Label textF;

	@FXML
	private Label textSa;

	@FXML
	private Label textSu;

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
	private Label textWeekB;

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
	private Line lineBottom;

	@FXML
	private Button buttonCalculate;

	@FXML
	private Label text5;

	@FXML
	private Label textDateCSP;

	@FXML
	private Label text6;

	@FXML
	private Label textDateSSP;

	@FXML
	private Button buttonExit;

	@FXML
	private Rectangle labelBackground;

	@FXML
	private Label textTitle;

	@FXML
	private Label textCreators;

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
		// A "B" work schedule hasonul az "A"-val ki-be kapcsolgat�s sor�n:
		checkMB.setSelected(checkMA.isSelected());
		checkTuB.setSelected(checkTuA.isSelected());
		checkWB.setSelected(checkWA.isSelected());
		checkThB.setSelected(checkThA.isSelected());
		checkFB.setSelected(checkFA.isSelected());
		checkSaB.setSelected(checkSaA.isSelected());
		checkSuB.setSelected(checkSuA.isSelected());
	}

	@FXML
	void onLinkingButtonAction(ActionEvent event) {
		pickerSSPDay.setDisable(!pickerSSPDay.isDisabled());
		pickerSSPDay.setValue(pickerFirstDay.getValue());
	}

	@FXML
	void onCalculateButtonAction(ActionEvent event) {
		// Az els� nap lek�rdez�se a datepicker-t�l:
		LocalDate firstDay = pickerFirstDay.getValue();
		// ha a pickerSSPDay ki van kapcsolva, v�ltozzon a datepicker a norm�l
		// els� napra, �s legyen aszerint a d�tum:
		if (pickerSSPDay.isDisabled()) {
			pickerSSPDay.setValue(pickerFirstDay.getValue());
		}
		LocalDate SSPDay = pickerSSPDay.getValue();

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
		double availableSSPDaysD = (double) availableSSPDays / (double) (workSchedule.length / 7);
		availableSSPDays = (int) (availableSSPDaysD * 28 + 3);

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
			textDateCSP.setText(dayCalculator.calculateLastCSPDay(firstDay, availableCSPDays, workSchedule).toString());
			textDateSSP.setText(
					dayCalculator.calculateLastSSPDay(firstDay, SSPDay, availableSSPDays, workSchedule).toString());
		}
	}

	@FXML
	void onPickerFirstDayAction(ActionEvent event) {
		setWeeks();
	}

	@FXML
	void onExitButtonAction(ActionEvent event) {
		// Ez a met�sud akkor h�v�dik meg, ha az "Exit"
		// gombra kattintasz eg�rrel vagy entert nyomsz r�.

		// �gy z�rsz be egy JavaFX alkalmaz�st:
		Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Be�ll�tom a datepickert m�ra, hogy ne �resen kezdjen. Ha nem tetszik,
		// t�r�lheted,
		// de akkor le kell kezelned a default "null" �rt�k�t a
		// "onCalculateButtonAction" met�dusban.
		// Megjegyz�s: A datepicker csak val�s d�tumot enged bevinni.
		pickerFirstDay.setValue(LocalDate.now());
		pickerSSPDay.setValue(LocalDate.now());

		// Az al�bbi k�t listener nem a UI elemekre vannak r�k�tve, hanem a UI
		// elemek
		// �ltal kezelt sz�vegre. �gy nem kell lekezelni mindenf�le UI
		// esem�nyeket
		// (g�pel�s, eger�sz�s, drag&drop, hanem el�g a kezelt sz�veget
		// figyelni.
		// A SceneBuilderben csak a UI elemekhez tud met�dust rendelni, ez�rt a
		// UI
		// elemen bel�l kezelt sz�veghez nek�nk kell listenert hozz�adni.
		textFieldCSP.textProperty().addListener((observable, oldValue, newValue) -> {
			// Ha az �j sz�veg nem n�z ki "napok sz�m�nak", akkor "megtartjuk" a
			// r�gi �rt�ket.
			if (!isStringValidAsDays(newValue)) {
				textFieldCSP.textProperty().setValue(oldValue);
			}
		});

		setWeeks();

		boolean[] initWorkSchedule = { true, true, true, true, true, false, false };
		textDateCSP.setText(dayCalculator.calculateLastCSPDay(LocalDate.now(), 0, initWorkSchedule).toString());
		textDateSSP.setText(
				dayCalculator.calculateLastSSPDay(LocalDate.now(), LocalDate.now(), 0, initWorkSchedule).toString());
	}

	private boolean isStringValidAsDays(String str) {
		if (str.matches("\\d*") && str.length() < 4) {
			return true;
		}

		return false;
	}

	private void setWeeks() {
		LocalDate firstDateOfSchedule = pickerFirstDay.getValue();
		while (firstDateOfSchedule.getDayOfWeek() != java.time.DayOfWeek.MONDAY) {
			firstDateOfSchedule = firstDateOfSchedule.minusDays(1);
		}
		textWeekA.setText(firstDateOfSchedule.toString() + " to " + firstDateOfSchedule.plusDays(6).toString());
		textWeekB.setText(
				firstDateOfSchedule.plusDays(7).toString() + " to " + firstDateOfSchedule.plusDays(13).toString());
	}
}
