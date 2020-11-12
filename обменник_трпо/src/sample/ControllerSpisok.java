package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class ControllerSpisok implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Button ls;
    @FXML
    private TableView<obligation> tb;
    @FXML
    private TableColumn<obligation, String> ob;
    @FXML
    private TableColumn<obligation, Integer> nal;
    public ObservableList<obligation> list = FXCollections.observableArrayList(new obligation("Доллары", 10000), new obligation("Евро", 71000), new obligation("Рубли", 130000), new obligation("Гривны", 52000), new obligation("Франки", 68000), new obligation("Фунты", 75000), new obligation("Лиры", 40240), new obligation("Злотые", 40240), new obligation("Белизский доллар", 0), new obligation("", 0));

    public ControllerSpisok() {
    }
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tb.setItems(this.list);
        this.tb.setEditable(true);
        this.ob.setCellValueFactory(new PropertyValueFactory("ob"));
        this.ob.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nal.setCellValueFactory(new PropertyValueFactory("nal"));
        this.nal.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        this.back.setOnAction((actionEvent) -> {
            this.back.getScene().getWindow().hide();
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
        this.ls.setOnAction((actionEvent) -> {
            try {
                Runtime.getRuntime().exec("notepad Справка о совершенной транзакции.txt");
            } catch (IOException var2) {
                var2.printStackTrace();
            }

        });
    }
}
