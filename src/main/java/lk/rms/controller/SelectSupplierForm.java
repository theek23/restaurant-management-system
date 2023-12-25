package lk.rms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class SelectSupplierForm {
    @SneakyThrows
    public void nextBtnOnAction(ActionEvent actionEvent) {
        javafx.scene.Node source = (javafx.scene.Node) actionEvent.getSource();

        Stage currentStage = (Stage) source.getScene().getWindow();
        currentStage.close();
    }
}
