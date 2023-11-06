package lk.rms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class DrinksFormController {
    @SneakyThrows
    public void softDrinksBtnsOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/drinksQtyForm.fxml"))));
        stage.setTitle("ADD QTY");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();

        javafx.scene.Node sourceForClose = (javafx.scene.Node) actionEvent.getSource();
        Stage thisWindowStage = (Stage) sourceForClose.getScene().getWindow();
        thisWindowStage.close();
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

        javafx.scene.Node sourceForClose = (javafx.scene.Node) actionEvent.getSource();
        Stage thisWindowStage = (Stage) sourceForClose.getScene().getWindow();
        thisWindowStage.close();
    }
}
