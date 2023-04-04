package gov.iti.jets;

import java.io.*;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChatController implements Initializable {

    private String userName;
    private TextController txtCon;
    @FXML
    private TextField txtAreaId;

    @FXML
    private Text name;

    @FXML
    private ScrollPane scroll;

    @FXML
    private VBox vbox;

    @FXML
    private ImageView topImage;

    public ChatController() {

    }

    @FXML
    private void sendMsg() {
        try {
            if (txtAreaId.getText() == null || txtAreaId.getText().trim().equals(""))
                return;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/text.fxml"));
            txtCon = new TextController();

            loader.setController(txtCon);
            vbox.getChildren().add(loader.load());
            txtCon.setName("You");
            txtCon.setMsg(txtAreaId.getText());
            scroll.vvalueProperty().bind(vbox.heightProperty());
            getResponse(txtAreaId.getText());
            txtAreaId.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    void getResponse(String msg) {
        if (msg != null && !msg.trim().equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/text2.fxml"));
            txtCon = new TextController();
            loader.setController(txtCon);
            try {
                vbox.getChildren().add(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            txtCon.setName("Bot");
            txtCon.setMsg(ChatBot.getResponse(msg));
            scroll.vvalueProperty().bind(vbox.heightProperty());
        }

    }
}
