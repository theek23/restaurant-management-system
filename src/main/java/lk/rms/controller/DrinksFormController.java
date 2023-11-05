package lk.rms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class DrinksFormController {
    public void softDrinksBtnsOnAction(ActionEvent actionEvent) {

    }

    @SneakyThrows
    public void hotDrinksBtnsOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/qtyForm.fxml"))));
        stage.setTitle("ADD QTY");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
    }
}
