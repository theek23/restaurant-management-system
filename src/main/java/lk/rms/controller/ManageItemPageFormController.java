package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class ManageItemPageFormController {
    public AnchorPane root;
    public JFXButton editItemBtn;
    public JFXButton addItemBtn;

    @SneakyThrows
    public void addItemBtnOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/addNewItemForm.fxml"))));
        stage.setTitle("New Item");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
    }

    public void editItemBtnOnAction(ActionEvent actionEvent) {

    }
}
