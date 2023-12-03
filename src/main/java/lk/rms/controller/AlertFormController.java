package lk.rms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class AlertFormController {
    public ImageView image;
    public Label msgTitleLbl;
    public Label msgLbl;
    public JFXButton okBtn;

    public void setUi(String imagePath, String msgTitle, String msg) {
        image.setImage(new Image(imagePath));
        msgTitleLbl.setText(msgTitle);
        msgLbl.setText(msg);
    }

    public void initialize(){

    }


    public void okBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();

        // Close the stage
        stage.close();
    }
}
