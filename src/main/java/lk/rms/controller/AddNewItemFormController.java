package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custom.ItemBO;
import lk.rms.bo.custom.ItemCategoryBO;
import lk.rms.bo.custom.ItemSubCategoryBO;

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
        ArrayList<String> ItemCategories = itemCategoryBO.getAllCategoryNames();
        categoryCombo.getItems().clear();
        categoryCombo.getItems().addAll(ItemCategories);
    }
    public void saveBtnOnAction(ActionEvent actionEvent) {

    }

    public void categoryComboOnAction(ActionEvent actionEvent) {
        subCategoryCombo.setDisable(false);
        String category = categoryCombo.getSelectionModel().getSelectedItem().toString();
        String itemID;
        String[] parts = category.split("-");

        if (parts.length > 0) {
            itemID = parts[0];
        }else {
            itemID= "0001";
        }
        ArrayList<String> itemsSubCategory = itemSubCategoryBO.getAllSubCategoryNamesAsCategory(itemID);
        subCategoryCombo.getItems().clear();
        subCategoryCombo.getItems().addAll(itemsSubCategory);
    }

}
