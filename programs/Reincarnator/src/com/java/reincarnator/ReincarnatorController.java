package com.java.reincarnator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;

public class ReincarnatorController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	private Identity identity;
	private Embodiment embodiment;
	
	@FXML
	private Text identityDescription;

	@FXML
	private Button reincarnate;

	@FXML
	private ImageView personBody;

	@FXML
	private ImageView personHead;

	@FXML
	private ImageView personHand;

	@FXML
	private ImageView personHair;

	@FXML
	private ImageView personClothe;

	@FXML
	private ImageView personEyes;

	@FXML
	private ImageView personNose;

	@FXML
	private ImageView personMouth;

	@FXML
	void onReincarnateAction(ActionEvent event) {
		
		identity = CreateIdentity.createIdentity();
		identityDescription.setText(identity.getDescription());
		embodiment = CreateEmbodiment.createEmbodiment(identity);
		drawEmbodiment(embodiment);
	}

	private void drawEmbodiment(Embodiment embodiment) {
		personBody.setImage(new Image(embodiment.body));
		personHead.setImage(new Image(embodiment.head));
		personHand.setImage(new Image(embodiment.hand));
		personHair.setImage(new Image(embodiment.hair));
		personClothe.setImage(new Image(embodiment.clothe));
		personEyes.setImage(new Image(embodiment.eyes));
		personNose.setImage(new Image(embodiment.nose));
		personMouth.setImage(new Image(embodiment.mouth));
	}

}
