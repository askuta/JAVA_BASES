package com.java.reincarnator;

import java.net.URL;
import java.util.ResourceBundle;

import com.java.reincarnator.Embodiment.Clothe;
import com.java.reincarnator.Identity.Gender;

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
		Embodiment embodiment = createEmbodiment(identity);
		drawEmbodiment(embodiment);
	}

	private Embodiment createEmbodiment(Identity identity) {

		Clothe clothe = createClothe(identity);
		return new Embodiment(clothe);
	}

	private Clothe createClothe(Identity identity) {
		if (identity.getGender() == Gender.MALE) {
			return Clothe.WIFEBEATER;
		} else {
			return Clothe.CARDIGAN;
		}
	}

	private void drawEmbodiment(Embodiment embodiment) {
		personBody.setImage(new Image("Enbodiment/Body/Body1.png"));
		personHead.setImage(new Image("Enbodiment/Head/Head1.png"));
		personHand.setImage(new Image("Enbodiment/Hand/Hand1.png"));
		personHair.setImage(new Image("Enbodiment/Hair/HairmStraightBlonde.png"));
		personClothe.setImage(new Image("Enbodiment/Clothe/Clothe.png"));
		personEyes.setImage(new Image("Enbodiment/Eyes/EyesmBlue.png"));
		personNose.setImage(new Image("Enbodiment/Nose/NoseCausoid.png"));
		personMouth.setImage(new Image("Enbodiment/Mouth/MouthNarrow.png"));
	}

}
