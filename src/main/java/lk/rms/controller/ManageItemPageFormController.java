package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import lk.rms.bo.BOFactory;
import lk.rms.bo.custom.ItemBO;
import lk.rms.bo.custom.ItemCategoryBO;
import lk.rms.dto.ItemCategoryDTO;
import lk.rms.dto.ItemDTO;
import lombok.SneakyThrows;

import java.util.ArrayList;

public class ManageItemPageFormController {
    public AnchorPane root;
    public JFXButton editItemBtn;
    public JFXButton addItemBtn;
    public JFXButton addQtyBtn;

    public JFXTreeTableView<ItemDTO> itemTable;
    public TreeTableColumn<ItemDTO, String> itemIdCol;
    public TreeTableColumn<ItemDTO, String> decCol;
    public TreeTableColumn<ItemDTO, String> catCol;
    public TreeTableColumn<ItemDTO, Double> priceCol;
    public TreeTableColumn<ItemDTO, Integer> qtyCol;
    public JFXComboBox categoryCombo;
    public JFXComboBox searchItmCombo;

    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);
    ItemCategoryBO itemCategoryBO = (ItemCategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEMCATEGORY);


    public void initialize(){
        setUi();
    }
    private void setUi(){
        setupCellValueFactories();
        ArrayList<ItemDTO> items = itemBO.getAllItems();
        loadItems(items);

        ArrayList<String> ItemCategories = itemCategoryBO.getAllCategoryNames();
        categoryCombo.getItems().clear();
        categoryCombo.getItems().addAll(ItemCategories);
    }
    private void loadItems(ArrayList<ItemDTO> items) {
        // Convert the ArrayList to an ObservableList
        ObservableList<ItemDTO> observableItems = FXCollections.observableArrayList(items);

        // Create a root TreeItem using the observable list
        TreeItem<ItemDTO> root = new RecursiveTreeItem<>(observableItems, RecursiveTreeObject::getChildren);

        // Set the root to the JFXTreeTableView and do not show the root item
        itemTable.setRoot(root);
        itemTable.setShowRoot(false);
    }


    private void setupCellValueFactories() {
        itemIdCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemDTO, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getItemID());
            }
        });

        catCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemDTO, String> param) {
                ItemCategoryDTO category = param.getValue().getValue().getCategory();
                return new SimpleStringProperty(category != null ? category.getCateName() : ""); // Assuming toString() method in ItemCategoryDTO is overridden
            }
        });

        decCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ItemDTO, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getDescription());
            }
        });

        priceCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemDTO, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TreeTableColumn.CellDataFeatures<ItemDTO, Double> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getSellingPrice());
            }
        });

        qtyCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemDTO, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TreeTableColumn.CellDataFeatures<ItemDTO, Integer> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getQtyOnHand());
            }
        });
    }
    @SneakyThrows
    public void addItemBtnOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/addNewItemForm.fxml"))));
        stage.setTitle("New Item");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
    }

    public void editItemBtnOnAction(ActionEvent actionEvent) {

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
    @SneakyThrows
    public void addQtyBtnOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/addQtyForm.fxml"))));
        stage.setTitle("New Item");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
    }

    public void categoryComboOnAction(ActionEvent actionEvent) {
        ArrayList<ItemDTO> items =itemBO.getItemsByCategory(splitCategory()[0]);
        loadItems(items);
    }
}
