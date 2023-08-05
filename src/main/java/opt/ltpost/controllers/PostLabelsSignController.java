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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import opt.ltpost.model.ModelPrefs;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Trakis
 */
public class PostLabelsSignController implements Initializable {

    private Stage mainStage;
    private ModelPrefs modelPrefs;

    @FXML
    private VBox vBoxInfoContainer;
    @FXML
    private TextField txtBox_PostLabelLocation;
    @FXML
    private TextField txtBox_SignedPostLabelFolderLocation;
    @FXML
    private TextField txtBox_SignatureImageLocation;
    @FXML
    private DatePicker DPicker_DateSigned;
    @FXML
    private Slider Slider_StampPointX;
    @FXML
    private Slider Slider_StampPointY;
    @FXML
    private Slider Slider_StampWidth;
    @FXML
    private Slider Slider_SignatureHeight;
    @FXML
    private Slider Slider_DateSize;

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
    public void initParameters(Stage primaryStage, ModelPrefs modelPrefs) {
        this.mainStage = primaryStage;
        this.modelPrefs = modelPrefs;

        loadFormWithDataWithSaveRecords();
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

                modelPrefs.setPostLabelLocationKey(KKLDBFile.getAbsolutePath());

            } catch (Exception e) {

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

        try {
            modelPrefs.setSignedPostLabelFolderLocation(selectedDirectory.getAbsolutePath());
        } catch (Exception e) {
            showWarningMessage("error: " + e, "Signed Post Label directory field");
        }

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
                modelPrefs.setSignatureImageLocation(KKLDBFile.getAbsolutePath());
            } catch (Exception e) {
                showWarningMessage("error: " + e, "Signature Image");
            }

        }
    }

    /**
     * Fill in all form fields with the data stored in local
     */
    private void loadFormWithDataWithSaveRecords() {
        txtBox_PostLabelLocation.setText(modelPrefs.getPostLabelLocationKey());
        txtBox_SignedPostLabelFolderLocation.setText(modelPrefs.getSignedPostLabelFolderLocation());
        txtBox_SignatureImageLocation.setText(modelPrefs.getSignatureImageLocation());

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
