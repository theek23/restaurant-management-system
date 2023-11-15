package lk.rms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class EditOrderPageFormController {
    @SneakyThrows
    public void addItmBtnOnAcrion(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/addItemsToOrderPageForm.fxml"))));
        stage.setTitle("ADD Items");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
    }
}
