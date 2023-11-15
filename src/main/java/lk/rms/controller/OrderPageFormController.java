package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class OrderPageFormController {
    public AnchorPane leftPane;
    public AnchorPane rightPane1;
    public AnchorPane rightPane2;
    public AnchorPane root;
    public JFXButton placeOrderBtn;
    public JFXButton editOrderBtn;
    public JFXButton refundOrderBtn;
    public JFXButton calBtn;
    public JFXButton menuBtn;

    @SneakyThrows
    public void initialize(){
        setUI();
    }

    @SneakyThrows
    public void backBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/cashierDashboardForm.fxml"))));
        stage.setTitle("Cashier");
        stage.centerOnScreen();
        stage.show();
    }

    private void setUI(){
        setNavUI("calculatorForm",2, calBtn);
        setNavUI("placeOrderPageForm", 1, placeOrderBtn);
    }
    @SneakyThrows
    private void setNavUI(String fileName, int paneNumber, JFXButton btnId){
        if (paneNumber == 1) {
            leftPane.getChildren().clear();
            leftPane.getChildren().add(FXMLLoader.load(getClass().getResource("../../../view/" + fileName + ".fxml")));
        }else if (paneNumber == 2){
            rightPane1.getChildren().clear();
            rightPane1.getChildren().add(FXMLLoader.load(getClass().getResource("../../../view/" + fileName + ".fxml")));
        }


        JFXButton[] buttonsToClear = {placeOrderBtn, editOrderBtn, refundOrderBtn, calBtn, menuBtn};
        clearBorderOnButtons(buttonsToClear);

        String style = "-fx-border-color: red; -fx-border-width: 2px;";
        btnId.setStyle(style);
    }
    private void clearBorderOnButtons(JFXButton... buttons) {
        for (JFXButton button : buttons) {
            button.setStyle("");
        }
    }
    public void placeOrderBtnOnAction(ActionEvent actionEvent) {
        setNavUI("placeOrderPageForm", 1, placeOrderBtn);
    }

    public void editOrderBtnOnAction(ActionEvent actionEvent) {
        setNavUI("editOrderPageForm", 1, editOrderBtn);
    }

    public void refundOrderBtnOnAction(ActionEvent actionEvent) {

    }
    public void calBtnOnAction(ActionEvent actionEvent) {
        setNavUI("calculatorForm",2, calBtn);
    }
    public void menuBtnOnAction(ActionEvent actionEvent) {

    }
}
