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
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/addNewItemForm.fxml"))));
        stage.setTitle("New Item");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();


        javafx.scene.Node source = (javafx.scene.Node) actionEvent.getSource();

        Stage currentStage = (Stage) source.getScene().getWindow();
        currentStage.close();    }
}
