package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CashierDashboardFormController {
    public AnchorPane root;
    public Text time;
    public Text date;
    public JFXButton homeBtn;
    public JFXButton orderBtn;
    public JFXButton inventoryBtn;
    public JFXButton reportBtn;
    public JFXButton settingsBtn;
    public JFXButton profileBtn;

    public void initialize(){
        setUi();
    }

    private void setUi(){
        timeDate();
        profileBtn.setFocusTraversable(false);
    }
    private void timeDate(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        event -> {
                            LocalDate currentDate = LocalDate.now();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                            date.setText(dateFormatter.format(currentDate));

                            LocalTime currentTime = LocalTime.now();
                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
                            time.setText(timeFormatter.format(currentTime));
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void homeBtnOnAction(ActionEvent actionEvent) {

    }

    public void orderBtnOnAction(ActionEvent actionEvent) {

    }

    public void inventoryBtnOnAction(ActionEvent actionEvent) {

    }

    public void reportBtnOnAction(ActionEvent actionEvent) {

    }

    public void settingsBtnOnAction(ActionEvent actionEvent) {


        //Test only

        if (homeBtn.getContentDisplay() == ContentDisplay.LEFT &&
            orderBtn.getContentDisplay() == ContentDisplay.LEFT &&
            inventoryBtn.getContentDisplay() == ContentDisplay.LEFT &&
            reportBtn.getContentDisplay() == ContentDisplay.LEFT
        ){
            homeBtn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            orderBtn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            inventoryBtn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            reportBtn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }else {
            homeBtn.setContentDisplay(ContentDisplay.LEFT);
            orderBtn.setContentDisplay(ContentDisplay.LEFT);
            inventoryBtn.setContentDisplay(ContentDisplay.LEFT);
            reportBtn.setContentDisplay(ContentDisplay.LEFT);
        }
    }

    public void profileBtnOnAction(ActionEvent actionEvent) {

    }

    @SneakyThrows
    public void logoutBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/homepageFrom.fxml"))));
        stage.setTitle("Cashier");
        stage.centerOnScreen();
        stage.show();
    }
}
