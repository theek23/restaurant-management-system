package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custom.SupplierBO;
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

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    public void initialize(){
        setUi();
    }

    private void setUi(){
        ObservableList<String> types = FXCollections.observableArrayList("Food", "Spices", "Shop", "Agencies");
        typeCombo.setItems(types);

        typeCombo.setPromptText("Select Supplier Type");
        supIdTxt.setText(supplierBO.generateNewId());
    }
    @SneakyThrows
    public void saveBtnOnAction(ActionEvent actionEvent) {
        if (isFieldsAreFilled()){
            System.out.println(typeCombo.getSelectionModel().getSelectedItem().toString());
            SupplierDTO dto = new SupplierDTO(
                    supIdTxt.getText(),
                    typeCombo.getSelectionModel().getSelectedItem().toString(),
                    nameTxt.getText(),
                    addressTxt.getText(),
                    pNoTxt.getText());

            boolean isSaved = supplierBO.saveSupplier(dto);

            if (isSaved){
                new JFXAlertBox().success("Supplier Saved Successfully.");
                clear();
            }else {
                new JFXAlertBox().error("Something wrong please check log files");
                System.out.println("awlak");
            }
        }else {
            new JFXAlertBox().warning("Check inserted data again");
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
    private void clear(){
        supIdTxt.setText(supplierBO.generateNewId());
        nameTxt.setText("");
        pNoTxt.setText("");
        addressTxt.setText("");
        typeCombo.setValue(null);
    }
}
