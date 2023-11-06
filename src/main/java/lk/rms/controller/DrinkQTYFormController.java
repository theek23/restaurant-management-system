package lk.rms.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DrinkQTYFormController {
    public TextField qtyTextField;

    public void qtyTxtFieldOnAction(ActionEvent actionEvent) {
        System.out.println(qtyTextField.getText());

        javafx.scene.Node source = (javafx.scene.Node) actionEvent.getSource();

        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
