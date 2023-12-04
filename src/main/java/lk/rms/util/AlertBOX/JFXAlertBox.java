package lk.rms.util.AlertBOX;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.rms.controller.AlertFormController;
import lombok.SneakyThrows;

import java.io.IOException;

public class JFXAlertBox {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../view/alertForm.fxml"));
    Parent root = loader.load();
    AlertFormController controller = loader.getController();

    public JFXAlertBox() throws IOException {
    }


    public void success(String msg){
        show();
        controller.setUi(new Image("asset/Icons/done.gif"), "Success", msg);
    }
    public void error(String msg){
        show();
        controller.setUi(new Image("asset/Icons/error.gif"),"Error",msg);
    }
    public void warning(String msg){
        show();
        controller.setUi(new Image("asset/Icons/warning.gif"),"Warning",msg);
    }

    @SneakyThrows
    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("New Item");
        stage.setResizable(false);
        stage.getIcons().add(new Image("asset/Logo.png"));
        stage.centerOnScreen();
        stage.show();
    }
}
