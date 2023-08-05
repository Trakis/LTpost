/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opt.ltpost.model.views;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import opt.ltpost.App;

/**
 * SINGLETON Required to reopen existing main layout ( with menus) without
 * creating a new one,
 *
 * @author gbruzgys
 */
public class LayoutRootView {

    private static LayoutRootView instance = null;

    FXMLLoader loader;

    private BorderPane rootLayout;

    public LayoutRootView() throws IOException {

        loader = new FXMLLoader();
        // Path to the main Layout (.FXML)
        loader.setLocation(App.class.getResource(App.PATH_ROOT_LAYOUT));
        rootLayout = (BorderPane) loader.load();

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        // Assign css file to root layout 
        scene.getStylesheets().clear();
        scene.getStylesheets().add(App.class.getResource(App.PATH_CSS_STYLE).toString());
        App.getPrimaryStage().setScene(scene);

        
    }

    /**
     * returnSingleton Instance 
     * @return
     * @throws IOException 
     */
    public static synchronized LayoutRootView getInstance() throws IOException {

        if (instance == null) {
            instance = new LayoutRootView();
        }

        return instance;

    }

    /**
     * Show main layout with top menu
     */
    public void show() {
        App.getPrimaryStage().show();

    }

    /**
     * Add Node to FXML(Border panel) center element
     * @param view 
     */
    public void SetVisibleView(Node view) {
        rootLayout.setCenter(view);
    }

}
