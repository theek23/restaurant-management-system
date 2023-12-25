package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custome.SupplierBO;
import lk.rms.controller.tdm.SupplierTM;
import lk.rms.dto.SupplierDTO;
import lk.rms.util.AlertBOX.JFXAlertBox;
import lombok.SneakyThrows;

public class EditSupplierController {
    public TextField searchField;
    public JFXButton searchBtn;
    public ComboBox typeCombo;
    public TextField nameTxt;
    public TextField pNoTxt;
    public TextField addressTxt;
    public JFXButton saveBtn;
    public Label supIdTxt;
    public JFXButton deleteBtn;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    SupplierDTO gotSupplierDTO = null;

    public void initialize(){
        setUi();
    }
    private void setUi(){
        ObservableList<String> types = FXCollections.observableArrayList("Food", "Spices", "Shop", "Agencies");
        typeCombo.setItems(types);

        typeCombo.setPromptText("Select Supplier Type");

        disableEdit();

        searchField.setText("SUP00-0001");
        searchBtn.setDisable(false);
        searchBtn.fire();
        searchBtn.setDisable(true);
    }

    private boolean validateEditedValues(){
        if (gotSupplierDTO != null){
            if (!gotSupplierDTO.getName().equals(nameTxt.getText()) ||
                    !gotSupplierDTO.getSupType().equals(typeCombo.getValue()) ||
                    !gotSupplierDTO.getPhone().equals(pNoTxt.getText() )||
                    !gotSupplierDTO.getAddress().equals(addressTxt.getText())) {
                saveBtn.setDisable(false);
                return true;
            }else{
                saveBtn.setDisable(true);
                return false;
            }
        }
        return false;
    }
    private void validateId(){
        String typedId = searchField.getText();
        String regexPattern = "SUP\\d{2}-\\d{4}";

        if (typedId.matches(regexPattern)) {
            searchBtn.setDisable(false);
        } else {
            searchBtn.setDisable(true);
        }
    }
    private void disableEdit(){
        searchBtn.setDisable(true);
        deleteBtn.setDisable(true);
        nameTxt.setDisable(true);
        typeCombo.setDisable(true);
        pNoTxt.setDisable(true);
        addressTxt.setDisable(true);
        saveBtn.setDisable(true);
        deleteBtn.setDisable(true);
    }
    private void enableEdit(){
        searchBtn.setDisable(false);
        deleteBtn.setDisable(false);
        nameTxt.setDisable(false);
        typeCombo.setDisable(false);
        pNoTxt.setDisable(false);
        addressTxt.setDisable(false);
        saveBtn.setDisable(false);
        deleteBtn.setDisable(false);
    }
    private void clear(){
        supIdTxt.setText("SUPID");
        nameTxt.setText("");
        typeCombo.setValue("");
        pNoTxt.setText("");
        addressTxt.setText("");
        searchField.setText("");
    }
    @SneakyThrows
    public void searchFieldOnAction(ActionEvent actionEvent) {
        validateId();

        SupplierDTO dto = supplierBO.searchSupplier(searchField.getText());
        gotSupplierDTO = dto;

        if (dto != null){
            String id = dto.getSupId();
            String name = dto.getName();
            String type = dto.getSupType();
            String pNo = dto.getPhone();
            String address = dto.getAddress();

            supIdTxt.setText(id);
            nameTxt.setText(name);
            typeCombo.setValue(type);
            pNoTxt.setText(pNo);
            addressTxt.setText(address);

            enableEdit();
            saveBtn.setDisable(true);
        }else {
            new JFXAlertBox().error("There is no supplier to this ID");
            clear();
            disableEdit();
        }


    }

    @SneakyThrows
    public void saveBtnOnAction(ActionEvent actionEvent) {
        if (validateEditedValues()){
            SupplierDTO dto = new SupplierDTO(supIdTxt.getText(), typeCombo.getValue().toString(), nameTxt.getText(), addressTxt.getText(), pNoTxt.getText());

            boolean isUpdated = supplierBO.updateSupplier(dto);

            if (isUpdated){
                new JFXAlertBox().success("Supplier UPDATED");
                clear();
            }else {
                new JFXAlertBox().error("Something went wrong");
            }
        }
    }

    @SneakyThrows
    public void deleteBtnOnAction(ActionEvent actionEvent) {
        if (gotSupplierDTO != null){
            boolean isDeleted = supplierBO.deleteSupplier(supIdTxt.getText());

            if (isDeleted){
                new JFXAlertBox().success("Supplier Deleted!");
                clear();
            }else {
                new JFXAlertBox().success("Something went wrong");

            }
        }
    }


    public void searchFieldOnKeyTyped(KeyEvent keyEvent) {
        validateId();
    }

    public void typeComboOnAction(ActionEvent actionEvent) {
        validateEditedValues();
    }

    public void OnKeyTyped(KeyEvent keyEvent) {
        validateEditedValues();
    }

    public void initializeData(SupplierTM selectedSupplier) {
        gotSupplierDTO = new SupplierDTO(selectedSupplier.getSupId(),selectedSupplier.getSupType(),selectedSupplier.getName(),selectedSupplier.getPhone(),selectedSupplier.getAddress());

        supIdTxt.setText(selectedSupplier.getSupId());
        nameTxt.setText(selectedSupplier.getName());
        typeCombo.setValue(selectedSupplier.getSupType());
        pNoTxt.setText(selectedSupplier.getPhone());
        addressTxt.setText(selectedSupplier.getAddress());
        enableEdit();
        validateEditedValues();
    }
}
