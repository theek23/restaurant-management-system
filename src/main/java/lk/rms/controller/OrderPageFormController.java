package lk.rms.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import lombok.SneakyThrows;

public class OrderPageFormController {
    public AnchorPane leftPane;
    public AnchorPane rightPane;

    @SneakyThrows
    public void initialize(){
        leftPane.getChildren().clear();
        leftPane.getChildren().add(FXMLLoader.load(getClass().getResource("../../../view/placeOrderPageForm.fxml")));
    }
}
