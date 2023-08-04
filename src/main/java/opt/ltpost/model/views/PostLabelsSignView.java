/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opt.ltpost.model.views;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import opt.ltpost.App;

/**
 *
 * @author gin
 */
public class PostLabelsSignView {

    private static PostLabelsSignView instance = null;
    private AnchorPane nodeView;
    private FXMLLoader loader;

    private PostLabelsSignView() throws IOException {

        loader = new FXMLLoader();
        loader.setLocation(App.class.getResource(App.PATH_VIEW_POST_LABEL_SIGN));
        nodeView = (AnchorPane) loader.load();

        // Give the controller access to the main app
        //   CustomLabelsController controller = loader.getController();
        // controller.initParameters();
    }

    public static synchronized PostLabelsSignView getInstance() throws IOException {

        if (instance == null) {
            instance = new PostLabelsSignView();
        }

        return instance;

    }

    public Node getViewNode() {
        return nodeView;
    }

}