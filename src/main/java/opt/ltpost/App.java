package opt.ltpost;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import opt.ltpost.model.ViewManager;


/**
 * JavaFX App
 */
public class App extends Application {

    //Main javaFX Stage
    private static Stage primaryStage;

    private static Scene scene;
    private final Image windowIconImage = new Image(getClass().getResource("images/icons8-price-tag-80.png").toString());

    // CSS file path
    public static final String PATH_CSS_STYLE = "css/modena.css";

    // FXML Locations
    public static final String PATH_ROOT_LAYOUT = "fxml/RootLayout.fxml";
    public static final String PATH_VIEW_POST_LABEL_SIGN = "fxml/PostLabelsSign.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        //Image
        primaryStage.getIcons().add(windowIconImage);
        // title
        primaryStage.setTitle("LT Post");

        ViewManager.getInstance().showPostLabelSignView();

    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

}
