package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custom.ItemBO;
import lk.rms.bo.custom.SupplierBO;
import lk.rms.controller.tdm.ItemTM;
import lk.rms.dto.ItemDTO;
import lk.rms.util.AlertBOX.JFXAlertBox;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddQtyFormController {
    public ComboBox supplierCombo;
    public TextField dateTimeTxt;
    public JFXComboBox paymentStatusCombo;
    public TextField srchTxt;


    public TableView itemTable;
    public TableColumn itemIdCol;
    public TableColumn itmCatCol;
    public TableColumn itmDecCol;
    public TableColumn qtyCol;

    public TextField costTxt;
    public TextField qtyTxt;
    public JFXButton saveBtn;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);
    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);

    public void initialize(){
        setUI();
    }

    private void setUI(){
        ArrayList<String> supplierNames = supplierBO.getAllSupplierNames();
        ArrayList<ItemDTO> items = itemBO.getAllItems();

        supplierCombo.getItems().clear();
        supplierCombo.getItems().addAll(supplierNames);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        dateTimeTxt.setText(formattedDateTime);

        paymentStatusCombo.getItems().add("Not Paid");
        paymentStatusCombo.getItems().add("Half Paid");
        paymentStatusCombo.getItems().add("Fully Paid");

        itemIdCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itmCatCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        itmDecCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        setItemTable(items);
    }
    @SneakyThrows
    private void setItemTable(ArrayList<ItemDTO> items) {
        itemTable.getItems().clear();
        try {
            for (ItemDTO item : items) {
                itemTable.getItems().add(new ItemTM(item.getItemID(), item.getCategory().toString(), item.getDescription(), item.getQtyOnHand()));
            }
        } catch (Exception e) {
            new JFXAlertBox().error("ERROR Message - "+e+"");
            e.printStackTrace();
        }
    }
    public void saveBtnOnAction(ActionEvent actionEvent) {

    }

    public void supplierComboOnAction(ActionEvent actionEvent) {

    }

    public void supplierComboKeyPressed(KeyEvent keyEvent) {

    }
}
