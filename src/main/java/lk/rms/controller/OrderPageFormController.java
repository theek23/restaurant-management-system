package lk.rms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class OrderPageFormController {
    public AnchorPane leftPane;
    public AnchorPane rightPane1;
    public AnchorPane root;

    @SneakyThrows
    public void initialize(){
        leftPane.getChildren().clear();
        leftPane.getChildren().add(FXMLLoader.load(getClass().getResource("../../../view/placeOrderPageForm.fxml")));
    }

    @SneakyThrows
    public void backBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/cashierDashboardForm.fxml"))));
        stage.setTitle("Cashier");
        stage.centerOnScreen();
        stage.show();
    }

    @SneakyThrows
    public void calBtnOnAction(ActionEvent actionEvent) {
        rightPane1.getChildren().clear();
        rightPane1.getChildren().add(FXMLLoader.load(getClass().getResource("../../../view/calculatorForm.fxml")));
    }
}
