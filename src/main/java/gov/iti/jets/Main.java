package gov.iti.jets;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class Main extends Application {
        public static void main(String[] args) {
            Application.launch();
        }

        @Override
        public void start(Stage stage) throws Exception {
            stage.setTitle("Home");
            Parent home = FXMLLoader.load(getClass().getResource("/chat.fxml"));
            Scene scene = new Scene(home);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
}
