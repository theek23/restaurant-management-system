package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custome.ItemCategoryBO;

public class AddNewItemFormController {

    public JFXButton saveBtn;

    ItemCategoryBO itemCategoryBO = (ItemCategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEMCATEGORY);


    public void initialize(){

    }
    public void saveBtnOnAction(ActionEvent actionEvent) {

    }
}
