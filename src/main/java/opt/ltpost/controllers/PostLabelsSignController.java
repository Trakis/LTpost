/*
 * Copyright (C) 2023 Trakis
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package opt.ltpost.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Trakis
 */
public class PostLabelsSignController implements Initializable {

    private Stage mainStage;

    @FXML
    private VBox vBoxInfoContainer;
    @FXML
    private TextField txtBox_PostLabelLocation;
    @FXML
    private TextField txtBox_SignedPostLabelFolderLocation;
    @FXML
    private TextField txtBox_SignatureImageLocation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Initialize additional parameters
     *
     * @param primaryStage
     */
    public void initParameters(Stage primaryStage) {
        this.mainStage = primaryStage;

    }

    @FXML
    private void onClickPostLabelLocation_Browse(ActionEvent event) {

        //  
        File KKLDBFile;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Please Select Post Label");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Pdf", "*.pdf"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        KKLDBFile = fileChooser.showOpenDialog(mainStage);
        if (KKLDBFile != null) {

            txtBox_PostLabelLocation.setText(KKLDBFile.getAbsolutePath());
            try {
                System.out.println("path: " + KKLDBFile.getAbsolutePath());
                //  modelFabricSamples.setDatabasePath(KKLDBFile.getAbsolutePath());

            } catch (Exception e) {
                //  System.out.println("DatabaseConfigurationViewController.onClickExpensesDb_Browse: Database path Setup Error " + e);
                showWarningMessage("error: " + e, "PostLabelLocation");
            }

        }

    }

    @FXML
    private void onClickSignedPostLabelFolderLocation_Browse(ActionEvent event) {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        //directoryChooser.setInitialDirectory(new File("src"));

        File selectedDirectory = directoryChooser.showDialog(mainStage);
        txtBox_SignedPostLabelFolderLocation.setText(selectedDirectory.getAbsolutePath());

    }

    @FXML
    private void onClickSignatureImageLocation_Browse(ActionEvent event) {
        //  
        File KKLDBFile;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Please Select Signature image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.gif", "*.png", "*.bmp"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        KKLDBFile = fileChooser.showOpenDialog(mainStage);
        if (KKLDBFile != null) {

            txtBox_SignatureImageLocation.setText(KKLDBFile.getAbsolutePath());
            try {
                System.out.println("path: " + KKLDBFile.getAbsolutePath());
                //  modelFabricSamples.setDatabasePath(KKLDBFile.getAbsolutePath());

            } catch (Exception e) {
                //  System.out.println("DatabaseConfigurationViewController.onClickExpensesDb_Browse: Database path Setup Error " + e);
                showWarningMessage("error: " + e, "Signature Image");
            }

        }
    }

    /**
     * warning messages method
     *
     * @param message
     * @param title
     */
    private void showWarningMessage(String message, String title) {
        Notifications notify = Notifications.create()
                .title(title)
                .text(message)
                .owner(mainStage);

        // notify.darkStyle();
        notify.showWarning();
    }

}
