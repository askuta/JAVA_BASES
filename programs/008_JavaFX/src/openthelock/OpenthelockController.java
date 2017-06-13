package openthelock;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class OpenthelockController implements Initializable{

    @FXML
    private Button button;

    @FXML
    private TextField title;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		title.setText("bakfitty, de durván ám!");
	}

}
