package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class DinnerFormController {
    public JFXButton itemBtn1,itemBtn2,itemBtn3,itemBtn4,itemBtn5,itemBtn6,itemBtn7,itemBtn8,itemBtn9,itemBtn10,itemBtn11,
            itemBtn12,itemBtn13,itemBtn14,itemBtn15,itemBtn16,itemBtn17,itemBtn18,itemBtn19,itemBtn20,itemBtn21,itemBtn22,
            itemBtn23,itemBtn24,itemBtn25,itemBtn26,itemBtn27,itemBtn28,itemBtn29,itemBtn30,itemBtn31,itemBtn32,itemBtn33,
            itemBtn34,itemBtn35,itemBtn36,itemBtn37,itemBtn38,itemBtn39,itemBtn40,itemBtn41,itemBtn42;

    @SneakyThrows
    public void itemsBtnsOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/qtyForm.fxml"))));
        stage.setTitle("ADD QTY");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
    }
}
