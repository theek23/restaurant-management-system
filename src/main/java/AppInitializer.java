import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/homepageFrom.fxml"))));
        primaryStage.setTitle("HOME");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("asset/Logo.png"));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
