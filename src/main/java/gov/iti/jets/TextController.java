package gov.iti.jets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class TextController implements Initializable {

    @FXML
    private Text name;

    @FXML
    private Label msg;

    public TextController() {

    }

    public TextController(String name, String msg, String path) {
        this.name.setText(name);
        this.msg.setText(msg);
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setName(String na) {
        name.setText(na);
    }

    public void setMsg(String ms) {
        msg.setText(ms);
    }

}