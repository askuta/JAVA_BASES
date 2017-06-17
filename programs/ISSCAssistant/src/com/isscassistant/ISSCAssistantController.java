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

public class ISSCAssistantController implements Initializable {

    @FXML
    private GridPane mainPane;

    @FXML
    private Label text1;

    @FXML
    private DatePicker pickerFirstDay;

    @FXML
    private Label text2;

    @FXML
    private TextField textFieldCSP;

    @FXML
    private Label text3;

    @FXML
    private TextField textFieldSSP;

    @FXML
    private ImageView pictureSick;

    @FXML
    private Button buttonTwoWeek;

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

    private LastDayCalculator dayCalculator = new LastDayCalculator();

    @FXML
    void on2WeekScheduleButtonAction(ActionEvent event) {
    	// Ez a met�sud akkor h�v�dik meg, ha a "2 week schedule"
    	// gombra kattintasz eg�rrel vagy entert nyomsz r�.

    	// A m�sodik checkbox sor gombjainak a disabled st�tusz�t
    	// �t�ll�tom a jelenlegi st�tuszuk ellent�t�re.
    	checkMB.setDisable(!checkMB.isDisabled());
    	checkTuB.setDisable(!checkTuB.isDisabled());
    	checkWB.setDisable(!checkWB.isDisabled());
    	checkThB.setDisable(!checkThB.isDisabled());
    	checkFB.setDisable(!checkFB.isDisabled());
    	checkSaB.setDisable(!checkSaB.isDisabled());
    	checkSuB.setDisable(!checkSuB.isDisabled());
    }

    @FXML
    void onCalculateButtonAction(ActionEvent event) {
    	// Ez a met�sud akkor h�v�dik meg, ha a "Calculate"
    	// gombra kattintasz eg�rrel vagy entert nyomsz r�.

    	// Az els� nap lek�rdez�se a datepicker-t�l:
    	LocalDate firstDay = pickerFirstDay.getValue();

    	// availableCSPDays legyen alapb�l 0, de ha a megfelel� textfieldnek van �rtelmes
    	// �rt�ke, akkor azzal fel�l�rjuk.
    	int availableCSPDays = 0;
    	if (textFieldCSP.getText() != null && textFieldCSP.getText().length() != 0) {
    		availableCSPDays = Integer.valueOf(textFieldCSP.getText());
    	}

    	// availableSSPDays legyen alapb�l 0, de ha a megfelel� textfieldnek van �rtelmes
    	// �rt�ke, akkor azzal fel�l�rjuk.
    	int availableSSPDays = 0;
    	if (textFieldSSP.getText() != null && textFieldSSP.getText().length() != 0) {
    		availableSSPDays = Integer.valueOf(textFieldSSP.getText());
    	}

    	// K�l�n oszt�lyba, a LastDayCalculator-ba szerveztem a napok sz�molgat�s�t.
    	// Ezen a ponton minden sz�ks�ges v�ltoz�ban valamennyire �rtelmes �rt�k van:
    	// - firstDay: alap�rtelmezetten a mai nap, egy�bk�nt a datepicker gondoskodik a val�s �rt�kr�l
    	// - availableCSPDays: alap�rtelmezetten 0, egy�bk�nt a initialize met�dusban l�v� listener gondoskodik a val�s �rt�kr�l
    	// - availableSSPDays: alap�rtelmezetten 0, egy�bk�nt a initialize met�dusban l�v� listener gondoskodik a val�s �rt�kr�l
    	textDateCSP.setText(dayCalculator.calculateLastCSPDay(firstDay, availableCSPDays).toString());
    	textDateSSP.setText(dayCalculator.caclulateLastSSPDay(firstDay, availableSSPDays).toString());
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
		// Be�ll�tom a datepickert m�ra, hogy ne �resen kezdjen. Ha nem tetszik, t�r�lheted,
		// de akkor le kell kezelned a default "null" �rt�k�t a "onCalculateButtonAction" met�dusban.
		// Megjegyz�s: A datepicker csak val�s d�tumot enged bevinni.
		pickerFirstDay.setValue(LocalDate.now());

		// Az al�bbi k�t listener nem a UI elemekre vannak r�k�tve, hanem a UI elemek
		// �ltal kezelt sz�vegre. �gy nem kell lekezelni mindenf�le UI esem�nyeket
		// (g�pel�s, eger�sz�s, drag&drop, hanem el�g a kezelt sz�veget figyelni.
		// A SceneBuilderben csak a UI elemekhez tud met�dust rendelni, ez�rt a UI
		// elemen bel�l kezelt sz�veghez nek�nk kell listenert hozz�adni.
		textFieldCSP.textProperty().addListener((observable, oldValue, newValue) -> {
			// Ha az �j sz�veg nem n�z ki "napok sz�m�nak", akkor "megtartjuk" a r�gi �rt�ket.
			if (isStringValidAsDays(newValue)) {
				textFieldCSP.textProperty().setValue(oldValue);
			}
		});

		textFieldSSP.textProperty().addListener((observable, oldValue, newValue) -> {
			if (isStringValidAsDays(newValue)) {
				textFieldSSP.textProperty().setValue(oldValue);
			}
		});
	}

	// K�l�n met�dusban vizsg�lom meg, hogy az �j sz�veg "napok sz�m�nak" n�z-e ki.
	private boolean isStringValidAsDays(String str) {
		if (!str.matches("\\d*") || str.length() > 3) {
			return true;
		}

		return false;
	}
}
