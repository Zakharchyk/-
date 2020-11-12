package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class BaseController {
    @FXML
    private Button menu;
    @FXML
    private TextField work;
    @FXML
    private TextField name;

    @FXML
    private TextField sum;
    @FXML
    private TextField sum1;
    @FXML
    private DatePicker date;

    @FXML
    private Button bd1;
    @FXML
    private ComboBox in;
    @FXML
    private ComboBox out;

    public BaseController() {
    }

    @FXML
    public void initialize() throws SQLException {
        System.out.println("База данных открыта");
        this.in.getItems().addAll(new Object[]{"Доллары", "Евро", "Фунты", "Рубли", "Гривны", "Франки", "Лиры"});
        this.out.getItems().addAll(new Object[]{"Доллары", "Евро", "Фунты", "Рубли", "Гривны", "Франки", "Лиры"});




        this.menu.setOnAction((actionEvent) -> {
            this.menu.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("sample.fxml"));

            try {
                loader.load();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            Parent root = (Parent)loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Обменный пункт валют");
            stage.getIcons().add(new Image(Controller.class.getResourceAsStream("icon.png")));
            stage.setScene(new Scene(root));
            stage.show();
        });
        this.bd1.setOnAction((actionEvent) -> {
            File file = new File("Справка о совершенной транзакции.txt");
            PrintWriter printWriter = null;

            try {
                printWriter = new PrintWriter(file);
            } catch (FileNotFoundException var8) {
                var8.printStackTrace();
            }

            String daterussian = ((LocalDate)this.date.getValue()).toString();
            String time = Calendar.getInstance().getTime().toString();
            printWriter.println(" Справка выдана " + this.name.getText() + " о том что он совершил сделку в обменном пункте ИП 'Захарчик'");
            printWriter.println("");
            String var10001 = daterussian.substring(8, 10);
            printWriter.println(" Дата - " + var10001 + "-" + daterussian.substring(5, 7) + "-" + daterussian.substring(0, 4));
            printWriter.println(" Время - " + time.substring(11, 19));
            var10001 = this.sum.getText();
            printWriter.println(" Клиент внес - " + var10001 + " (" + this.in.getValue() + ")");
            var10001 = this.sum1.getText();
            printWriter.println(" Клиент получил - " + var10001 + " (" + this.out.getValue() + ")");
            printWriter.println(" Сотрудник обслуживщий клиента - " + this.work.getText());
            printWriter.println("");
            printWriter.println("");
            printWriter.println("           Подпись сотрудника:                                    Подпись получателя:");
            printWriter.println("           ___________________                                    ___________________");
            printWriter.println("");
            printWriter.println("");
            printWriter.println("                                      Обязательно к ознакомлению:\n\n    1.\tЧек является лишь подтверждением вашей транзакции (не представляет собой никакой стоимости).\n    2.\tCтоимость облигаций рассчитывается исходя из открытых данных «НацБанк РБ».\n");
            printWriter.close();
            System.out.println("Если печать не началась, то проверьте подключение принетера");

            try {
                Runtime.getRuntime().exec("notepad Справка о совершенной транзакции.txt");
            } catch (IOException var7) {
                var7.printStackTrace();
            }

        });
    }
}
