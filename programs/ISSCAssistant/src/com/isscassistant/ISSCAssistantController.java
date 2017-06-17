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
    	// Ez a metósud akkor hívódik meg, ha a "2 week schedule"
    	// gombra kattintasz egérrel vagy entert nyomsz rá.

    	// A második checkbox sor gombjainak a disabled státuszát
    	// átállítom a jelenlegi státuszuk ellentétére.
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
    	// Ez a metósud akkor hívódik meg, ha a "Calculate"
    	// gombra kattintasz egérrel vagy entert nyomsz rá.

    	// Az elsõ nap lekérdezése a datepicker-tõl:
    	LocalDate firstDay = pickerFirstDay.getValue();

    	// availableCSPDays legyen alapból 0, de ha a megfelelõ textfieldnek van értelmes
    	// értéke, akkor azzal felülírjuk.
    	int availableCSPDays = 0;
    	if (textFieldCSP.getText() != null && textFieldCSP.getText().length() != 0) {
    		availableCSPDays = Integer.valueOf(textFieldCSP.getText());
    	}

    	// availableSSPDays legyen alapból 0, de ha a megfelelõ textfieldnek van értelmes
    	// értéke, akkor azzal felülírjuk.
    	int availableSSPDays = 0;
    	if (textFieldSSP.getText() != null && textFieldSSP.getText().length() != 0) {
    		availableSSPDays = Integer.valueOf(textFieldSSP.getText());
    	}

    	// Külön osztályba, a LastDayCalculator-ba szerveztem a napok számolgatását.
    	// Ezen a ponton minden szükséges változóban valamennyire értelmes érték van:
    	// - firstDay: alapértelmezetten a mai nap, egyébként a datepicker gondoskodik a valós értékrõl
    	// - availableCSPDays: alapértelmezetten 0, egyébként a initialize metódusban lévõ listener gondoskodik a valós értékrõl
    	// - availableSSPDays: alapértelmezetten 0, egyébként a initialize metódusban lévõ listener gondoskodik a valós értékrõl
    	textDateCSP.setText(dayCalculator.calculateLastCSPDay(firstDay, availableCSPDays).toString());
    	textDateSSP.setText(dayCalculator.caclulateLastSSPDay(firstDay, availableSSPDays).toString());
    }

    @FXML
    void onExitButtonAction(ActionEvent event) {
    	// Ez a metósud akkor hívódik meg, ha az "Exit"
    	// gombra kattintasz egérrel vagy entert nyomsz rá.

    	// Így zársz be egy JavaFX alkalmazást:
    	Platform.exit();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Beállítom a datepickert mára, hogy ne üresen kezdjen. Ha nem tetszik, törölheted,
		// de akkor le kell kezelned a default "null" értékét a "onCalculateButtonAction" metódusban.
		// Megjegyzés: A datepicker csak valós dátumot enged bevinni.
		pickerFirstDay.setValue(LocalDate.now());

		// Az alábbi két listener nem a UI elemekre vannak rákötve, hanem a UI elemek
		// által kezelt szövegre. Így nem kell lekezelni mindenféle UI eseményeket
		// (gépelés, egerészés, drag&drop, hanem elég a kezelt szöveget figyelni.
		// A SceneBuilderben csak a UI elemekhez tud metódust rendelni, ezért a UI
		// elemen belül kezelt szöveghez nekünk kell listenert hozzáadni.
		textFieldCSP.textProperty().addListener((observable, oldValue, newValue) -> {
			// Ha az új szöveg nem néz ki "napok számának", akkor "megtartjuk" a régi értéket.
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

	// Külön metódusban vizsgálom meg, hogy az új szöveg "napok számának" néz-e ki.
	private boolean isStringValidAsDays(String str) {
		if (!str.matches("\\d*") || str.length() > 3) {
			return true;
		}

		return false;
	}
}
