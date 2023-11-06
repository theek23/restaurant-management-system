package lk.rms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class ManageOrderFormController {
    public AnchorPane root;

    @SneakyThrows
    public void manageOrderOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/orderPageForm.fxml"))));
        stage.setTitle("Cashier");
        stage.centerOnScreen();
//        stage.setMaximized(true);
        stage.show();
    }
}
