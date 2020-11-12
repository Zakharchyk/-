package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ConvertController {
    @FXML
    private WebView lnk;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button nazad;
    @FXML
    private TextField summ;
    @FXML
    private ComboBox<?> one;
    @FXML
    private ComboBox<?> two;

    public ConvertController() {
    }

    @FXML
    public void initialize() {
        this.nazad.setOnAction((actionEvent) -> {
            this.nazad.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("sample.fxml"));

            try {
                loader.load();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            Parent root = (Parent)loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Обменный пункт валют");
            stage.setResizable(false);
            stage.getIcons().add(new Image(Controller.class.getResourceAsStream("icon.png")));
            stage.setScene(new Scene(root));
            stage.show();
        });
        WebEngine web = this.lnk.getEngine();
        web.load("https://converter.by/nbrb");
    }
}
