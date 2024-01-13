package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custom.ItemBO;
import lk.rms.bo.custom.ItemCategoryBO;
import lk.rms.bo.custom.ItemSubCategoryBO;
import lk.rms.dto.ItemCategoryDTO;
import lk.rms.dto.ItemDTO;
import lk.rms.util.AlertBOX.JFXAlertBox;
import lombok.SneakyThrows;

import java.util.ArrayList;

public class AddNewItemFormController {

    public JFXButton saveBtn;
    public TextField itmIdTxt;
    public JFXComboBox categoryCombo;
    public TextField descriptionTxt;
    public TextField sellingPrcTXT;
    public JFXComboBox subCategoryCombo;
    public TextField qtyOnHandTxt;

    ItemCategoryBO itemCategoryBO = (ItemCategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEMCATEGORY);
    ItemSubCategoryBO itemSubCategoryBO = (ItemSubCategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEMSUBCATEGORY);
    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);

    public void initialize(){
       setUi();

    }
    private void setUi(){
        ArrayList<String> ItemCategories = itemCategoryBO.getAllCategoryNames();
        categoryCombo.getItems().clear();
        categoryCombo.getItems().addAll(ItemCategories);

        itmIdTxt.setText(itemBO.generateNewId());
        qtyOnHandTxt.setText("0");
    }
    @SneakyThrows
    public void saveBtnOnAction(ActionEvent actionEvent) {
        clearStyles();
        if (validations()){

            String catId = splitCategory()[0];
            String catName = splitCategory()[1];
            ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO(catId, catName);

            ItemDTO dto = new ItemDTO(
                    itmIdTxt.getText(),
                    itemCategoryDTO,
                    subCategoryCombo.getSelectionModel().getSelectedItem().toString(),
                    descriptionTxt.getText(),
                    Double.valueOf(sellingPrcTXT.getText()),
                    Integer.valueOf(qtyOnHandTxt.getText()));

            boolean isSaved = itemBO.saveItem(dto);

            if (isSaved){
                new JFXAlertBox().success("Supplier Saved Successfully.");
                clear();
            }else {
                new JFXAlertBox().error("Something wrong please check log files");
                System.out.println("awlak");
            }
        }else {
            new JFXAlertBox().error("Please Fill all fields");
        }
    }
    @SneakyThrows
    private void clear() {
        itmIdTxt.setText(itemBO.generateNewId());
        categoryCombo.setSelectionModel(null);
        subCategoryCombo.setSelectionModel(null);
        descriptionTxt.setText("");
        sellingPrcTXT.setText("");
        qtyOnHandTxt.setText("");
        clearStyles();
    }

    @SneakyThrows
    private boolean validations() {
        if (categoryCombo.getSelectionModel().isEmpty()){
            categoryCombo.setStyle("-fx-border-color : red");
            return false;
        }else if (subCategoryCombo.getSelectionModel().isEmpty()){
            subCategoryCombo.setStyle("-fx-border-color : red");
            return false;
        }else if (descriptionTxt.getText().isEmpty()){
            descriptionTxt.setStyle("-fx-border-color : red");
            return false;
        }else if (sellingPrcTXT.getText().isEmpty()){
            sellingPrcTXT.setStyle("-fx-border-color : red");
            return false;
        }else if (qtyOnHandTxt.getText().isEmpty()){
            qtyOnHandTxt.setStyle("-fx-border-color : red");
            return false;
        }else {
            clearStyles();
            return true;
        }
    }
    private void clearStyles(){
        categoryCombo.setStyle("");
        subCategoryCombo.setStyle("");
        descriptionTxt.setStyle("");
        sellingPrcTXT.setStyle("");
        sellingPrcTXT.setStyle("");
    }

    public void categoryComboOnAction(ActionEvent actionEvent) {
        String itemID = splitCategory()[0];
        subCategoryCombo.setDisable(false);

        ArrayList<String> itemsSubCategory = itemSubCategoryBO.getAllSubCategoryNamesAsCategory(itemID);
        subCategoryCombo.getItems().clear();
        subCategoryCombo.getItems().addAll(itemsSubCategory);
    }
    @SneakyThrows
    private String[] splitCategory(){
        String category = categoryCombo.getSelectionModel().getSelectedItem().toString();
        String[] categoryArr = new String[2];
        String[] parts = category.split("-");

        if (parts.length > 0) {
            categoryArr[0] = parts[0];
            categoryArr[1] = parts[1];
        }
        return categoryArr;
    }

    public void sellingPrcTXTOnAction(KeyEvent actionEvent) {
        if (!sellingPrcTXT.getText().isEmpty()){
            if (!sellingPrcTXT.getText().matches("^\\d+$")) {
                sellingPrcTXT.setStyle("-fx-border-color: red;");
            } else {
                sellingPrcTXT.setStyle("");
            }
        }
    }

    public void qtyOnHandTxtOnAction(KeyEvent keyEvent) {
        if (!qtyOnHandTxt.getText().isEmpty()){
            if (!qtyOnHandTxt.getText().matches("^\\d+$")) {
                qtyOnHandTxt.setStyle("-fx-border-color: red;");
            } else {
                qtyOnHandTxt.setStyle("");
            }
        }
    }
}
