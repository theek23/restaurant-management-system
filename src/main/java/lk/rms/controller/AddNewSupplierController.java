package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custome.AddNewSupplierBO;
import lk.rms.dto.SupplierDTO;
import lk.rms.util.AlertBOX.JFXAlertBox;
import lombok.SneakyThrows;

public class AddNewSupplierController {
    public TextField supIdTxt;
    public ComboBox typeCombo;
    public TextField nameTxt;
    public TextField pNoTxt;
    public TextField addressTxt;
    public JFXButton saveBtn;
    public AnchorPane root;

    AddNewSupplierBO addNewSupplierBO = (AddNewSupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADDNEWSUPPIER);

    public void initialize(){
        setUi();
    }

    private void setUi(){
        ObservableList<String> types = FXCollections.observableArrayList("Food", "Spices", "Shop", "Agencies");
        typeCombo.setItems(types);

        typeCombo.setPromptText("Select Supplier Type");
    }
    @SneakyThrows
    public void saveBtnOnAction(ActionEvent actionEvent) {
        if (isFieldsAreFilled()){
            System.out.println(typeCombo.getSelectionModel().getSelectedItem().toString());
            SupplierDTO dto = new SupplierDTO(
                    supIdTxt.getText(),
                    typeCombo.getSelectionModel().getSelectedItem().toString(),
                    nameTxt.getText(),
                    pNoTxt.getText(),
                    addressTxt.getText());

            boolean isSaved = addNewSupplierBO.saveSupplier(dto);

            if (isSaved){
                System.out.println("Wade hari bozaaaa");
                new JFXAlertBox().show();
            }else {
                System.out.println("awlak");
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Please check again").show();
        }
    }
    private boolean isFieldsAreFilled(){
        if (!nameTxt.getText().isEmpty() && !pNoTxt.getText().isEmpty() && !addressTxt.getText().isEmpty() && !addressTxt.getText().isEmpty() && !typeCombo.getSelectionModel().isEmpty()){
            if (nameTxt.getStyle().equals("") && pNoTxt.getStyle().equals("") && addressTxt.getStyle().equals("")){
                return true;
            }
        }
        return false;
    }

    public void nameTxtOnKeyPressed(KeyEvent keyEvent) {
        if (!nameTxt.getText().isEmpty()){
            if (!nameTxt.getText().matches(".{5,}")) {
                nameTxt.setStyle("-fx-border-color: red;");
            } else {
                nameTxt.setStyle("");
            }
        }

    }

    public void pNoTxtOnKeyPressed(KeyEvent keyEvent) {
        if (!pNoTxt.getText().isEmpty()){
            if (!pNoTxt.getText().matches("^\\d{9,10}$")) {
                pNoTxt.setStyle("-fx-border-color: red;");
            } else {
                pNoTxt.setStyle("");
            }
        }
    }
}