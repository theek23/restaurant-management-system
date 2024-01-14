package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class PlaceOrderPageController {
    public TextField orderIdTxt;
    public TextField dateTxt;
    public TextField customerNameTxt;
    public TextField phoneTxt;

    public Label totalTxt;
    public TextField cashTxt;
    public Label balanceTxt;

    public TableView itemTable;
    public TableColumn itemIdCol;
    public TableColumn itemNameCol;
    public TableColumn qtyCol;
    public TableColumn priceCol;

    public JFXButton pwpBtn;
    public JFXButton closeOrderBtn;
    public JFXButton cashInBtn;
    public JFXButton placeOrderBtn;

    @SneakyThrows
    public void addItmBtnOnAcrion(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/addItemsToOrderPageForm.fxml"))));
        stage.setTitle("ADD Items");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
    }

    public void closeOrderBtnOnAction(ActionEvent actionEvent) {

    }

    public void cashInBtnOnAction(ActionEvent actionEvent) {

    }

    public void placeOrderBtnOnAction(ActionEvent actionEvent) {

    }

    public void pwpBtnOnAction(ActionEvent actionEvent) {

    }
}
