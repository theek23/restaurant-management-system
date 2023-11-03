package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import lombok.SneakyThrows;

public class AddItemsToOrderPageForm {
    public AnchorPane categoryPane;
    public JFXButton breakfastBtn;
    public JFXButton lunchBtn;
    public JFXButton dinnerBtn;
    public JFXButton seateBtn;
    public JFXButton drinksBtn;
    public JFXButton dessertsBtn;
    public JFXButton otherBtn;

    @SneakyThrows
    public void initialize(){
        setUi();
    }

    @SneakyThrows
    private void setUi(){
        setNavUI("breakfastForm",breakfastBtn);
    }
    @SneakyThrows
    private void setNavUI(String fileName, JFXButton btnId){
        categoryPane.getChildren().clear();
        categoryPane.getChildren().add(FXMLLoader.load(getClass().getResource("../../../view/"+fileName+".fxml")));

        JFXButton[] buttonsToClear = {breakfastBtn, lunchBtn, dinnerBtn, seateBtn, drinksBtn, dessertsBtn, otherBtn};
        clearBorderOnButtons(buttonsToClear);

        String style = "-fx-border-color: red; -fx-border-width: 2px;";
        btnId.setStyle(style);

    }
    //to clear current border
    private void clearBorderOnButtons(JFXButton... buttons) {
        for (JFXButton button : buttons) {
            button.setStyle("");
        }
    }
    public void breakfastBtnOnAction(ActionEvent actionEvent) {
        setNavUI("breakfastForm",breakfastBtn);
    }

    public void lunchBtnOnAction(ActionEvent actionEvent) {
        setNavUI("lunchForm",lunchBtn);
    }

    public void dinnerBtnOnAction(ActionEvent actionEvent) {
        setNavUI("dinnerForm",dinnerBtn);
    }

    public void seateBtnOnAction(ActionEvent actionEvent) {
        setNavUI("shortEatsForm",seateBtn);
    }

    public void drinksBtnOnAction(ActionEvent actionEvent) {
        setNavUI("drinksFrom",drinksBtn);
    }

    public void dessertsBtnOnAction(ActionEvent actionEvent) {
        setNavUI("dessertsForm",dessertsBtn);
    }

    public void otherBtnOnAction(ActionEvent actionEvent) {
        setNavUI("otherItemsForm",otherBtn);
    }
}
