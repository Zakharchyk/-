package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button con;
    @FXML
    private Button bd;
    @FXML
    private Button nl;

    public Controller() {
    }

    @FXML
    void initialize() throws IOException {
        this.con.setOnAction((actionEvent) -> {
            System.out.println("Конвертация открыта");
            this.con.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/sample/date.fxml"));

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
        this.bd.setOnAction((actionEvent) -> {
            System.out.println("База данных открыта");
            this.bd.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/sample/Base.fxml"));

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
        this.nl.setOnAction((actionEvent) -> {
            this.nl.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/sample/spisok.fxml"));

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
    }
}
