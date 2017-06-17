package com.isscassistant;

import java.net.URL;
import java.util.ResourceBundle;

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
    private DatePicker pickerFirstDay;

    @FXML
    private Label text1;

    @FXML
    private TextField textFieldCSP;

    @FXML
    void onTextFieldCSPChanged(ActionEvent event) {
    	System.out.println("Bakfitty!");
    }
    
    @FXML
    private TextField textFieldSSP;

    @FXML
    private Label text2;

    @FXML
    private Label text3;

    @FXML
    private ImageView pictureSick;

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
    private Button buttonTwoWeek;

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
    private CheckBox checkSaA;

    @FXML
    private CheckBox checkSuA;

    @FXML
    private CheckBox checkSaB;

    @FXML
    private CheckBox checkSuB;

    @FXML
    private Label textWeekB;

    @FXML
    private Label textWeekA;

    @FXML
    private Button buttonCalculate;

    @FXML
    private Line lineBottom;

    @FXML
    private Label text5;

    @FXML
    private Label text6;

    @FXML
    private Label textDateCSP;

    @FXML
    private Label textDateSSP;

    @FXML
    private Button buttonExit;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		textFieldCSP.textProperty().addListener((observable, oldValue, newValue) -> {
//			if (!newValue.matches("\\d*") || newValue.length() > 3) {
//				textFieldCSP.textProperty().setValue(oldValue);
//			}
//		});
	}

}
