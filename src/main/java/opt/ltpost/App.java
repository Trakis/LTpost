package opt.ltpost;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import opt.ltpost.model.ModelView;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.lineawesome.LineAwesomeSolid;

/**
 * JavaFX App
 */
public class App extends Application {

    //Main javaFX Stage
    private static Stage primaryStage;

    private static Scene scene;
    private final Image windowIconImage = new Image(getClass().getResource("images/icons8-parcel-66.png").toString());

    FontIcon icon = new FontIcon(LineAwesomeSolid.FILE_SIGNATURE);

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

        ModelView.getInstance().showPostLabelSignView();

    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

}
