package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import lombok.SneakyThrows;

public class ManageSupplierFormController {
    public AnchorPane supplierRoot;
    public JFXButton editSupBtn;
    public JFXButton viewSupBtn;
    public JFXButton reportSupBtn;
    public JFXButton historySupBtn;
    public JFXButton newSupBtn;

    public void initialize(){
        setUi();
    }
    public JFXButton getEditSupBtn(){
        return editSupBtn;
    }
    private void setUi(){
        setNavUI("viewSuppliersForm",viewSupBtn);
    }

    @SneakyThrows
    private void setNavUI(String fileName, JFXButton btnId){
        supplierRoot.getChildren().clear();
        supplierRoot.getChildren().add(FXMLLoader.load(getClass().getResource("../../../view/"+fileName+".fxml")));

        JFXButton[] buttonsToClear = {editSupBtn, viewSupBtn, reportSupBtn, historySupBtn, newSupBtn};
        clearBorderOnButtons(buttonsToClear);

        String style = "-fx-border-color: red; -fx-border-width: 2px;";
        btnId.setStyle(style);

    }
    private void clearBorderOnButtons(JFXButton... buttons) {
        for (JFXButton button : buttons) {
            button.setStyle("");
        }
    }
    @SneakyThrows
    public void editSupBtnOnAction(ActionEvent actionEvent) {
        System.out.println("test");
        setNavUI("editSupplierForm",editSupBtn);
    }

    public void viewSupBtnOnAction(ActionEvent actionEvent) {
        setNavUI("viewSuppliersForm",viewSupBtn);
    }

    public void repotSupBtnOnAction(ActionEvent actionEvent) {

    }

    public void historySupBtnOnAction(ActionEvent actionEvent) {

    }

    public void newSupBtnOnAction(ActionEvent actionEvent) {
        setNavUI("addNewSupplierForm",newSupBtn);
    }
}
