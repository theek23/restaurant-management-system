package lk.rms.util.AlertBOX;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.rms.controller.AlertFormController;
import lombok.SneakyThrows;

public class JFXAlertBox {
    @SneakyThrows
    public void show(){
        new AlertFormController().setUi("../../asset/Icons/done.gif","Success","Supplier was saved successfully saved. :)");

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../../view/alertForm.fxml"))));
        stage.setTitle("New Item");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
//        stage.setMaximized(true);
        stage.show();
    }
}
