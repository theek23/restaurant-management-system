package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custome.SupplierBO;
import lk.rms.controller.tdm.SupplierTM;
import lk.rms.dto.SupplierDTO;
import lk.rms.util.AlertBOX.JFXAlertBox;
import lombok.SneakyThrows;

import java.util.ArrayList;

public class ViewSuppliersFormController {
    public TextField supNameFeild;
    public JFXButton searchBtn;
    public TableView supTable;
    public TableColumn idColumn;
    public TableColumn nameColumn;
    public TableColumn pnoColumn;
    public TableColumn addressColumn;
    public TableColumn typeColumn;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    public void initialize(){
        setUi();
    }
    private void setUi(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("supId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pnoColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("supType"));

        setTable();
    }
    @SneakyThrows
    private void setTable(){
        supTable.getItems().clear();
        try {
            ArrayList<SupplierDTO> allStudents = supplierBO.getAllSupplier();
            for (SupplierDTO s1 : allStudents) {
                supTable.getItems().add(new SupplierTM(s1.getSupId(), s1.getName(), s1.getPhone(), s1.getAddress(), s1.getSupType()));
            }
        } catch (Exception e) {
            new JFXAlertBox().error("ERROR Message - "+e+"");
            e.printStackTrace();
        }
    }
    public void srchBtnOnAction(ActionEvent actionEvent) {

    }

    public void supNameFeildOnAction(KeyEvent actionEvent) {
        ArrayList<SupplierDTO> resultSuppliers = supplierBO.searchByName(supNameFeild.getText());
        supTable.getItems().clear();
        for (SupplierDTO supplier : resultSuppliers) {
            supTable.getItems().add(new SupplierTM(supplier.getSupId(), supplier.getName(), supplier.getPhone(), supplier.getAddress(), supplier.getSupType()));
        }
    }
}
