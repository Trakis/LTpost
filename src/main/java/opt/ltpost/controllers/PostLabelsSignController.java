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
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import opt.ltpost.model.ModelPdf;
import opt.ltpost.model.ModelPrefs;
import opt.ltpost.model.blogic.PdfData;
import org.controlsfx.control.Notifications;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignE;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import org.kordamp.ikonli.simpleicons.SimpleIcons;

/**
 * FXML Controller class
 *
 * @author Trakis
 */
public class PostLabelsSignController implements Initializable {

    private Stage mainStage;
    private ModelPrefs modelPrefs;
    private ModelPdf modelPdf;
    private Long stampPointX;
    private Long stampPointY;
    private Long stampWidth;
    private Long stampDateFontSize;
    private Long stampSignatureImageHeight;

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
    private Slider Slider_StampSignatureHeight;
    @FXML
    private Slider Slider_StampDateSize;
    @FXML
    private Label Label_StampPointX;
    @FXML
    private Label Label_StampPointY;
    @FXML
    private Label Label_StampWidth;
    @FXML
    private Label Label_StampSignatureHeight;
    @FXML
    private Label Label_StampDateSize;
    @FXML
    private Button btt_PostLabelLocation;
    @FXML
    private Button btt_SignedPostLabelFolderLocation;
    @FXML
    private Button btt_SignDocument;
    @FXML
    private Button btt_SignatureImageLocation;
    @FXML
    private Accordion Accordion_microAdjustment;
    @FXML
    private TitledPane tpl_MicroAdjustments;

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
    public void initParameters(Stage primaryStage, ModelPrefs modelPrefs, ModelPdf modelPdf) {
        this.mainStage = primaryStage;
        this.modelPrefs = modelPrefs;
        this.modelPdf = modelPdf;

        // set date picker object to todays date
        DPicker_DateSigned.setValue(LocalDate.now());

        loadFormWithDataWithSaveRecords();

        //design
        // Set Image to the reload Button
        FontIcon iconDownload = new FontIcon(MaterialDesignP.POSTAGE_STAMP);
        iconDownload.setIconColor(Color.GREY);
        iconDownload.setIconSize(40);

        btt_SignDocument.setGraphic(iconDownload);

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

                modelPrefs.setPostLabelLocation(KKLDBFile.getAbsolutePath());

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

    @FXML
    private void onClickSignDocument(ActionEvent event) {

        String postLabelLocation;
        String signatureImageLocation;
        String signedPostLabelFolderLocation;

        postLabelLocation = txtBox_PostLabelLocation.getText();
        signatureImageLocation = txtBox_SignatureImageLocation.getText();
        signedPostLabelFolderLocation = txtBox_SignedPostLabelFolderLocation.getText();

//check fields for null
        if (postLabelLocation == null || signatureImageLocation == null || signedPostLabelFolderLocation == null) {

            showWarningMessage("Some of the fields are empty!", "Fields issues");

            return;

        }
// check fields for empty or blank
        if (postLabelLocation.isEmpty() || signatureImageLocation.isEmpty() || signedPostLabelFolderLocation.isEmpty()
                || postLabelLocation.isBlank() || signatureImageLocation.isBlank() || signedPostLabelFolderLocation.isBlank()) {

            showWarningMessage("Some of the fields are empty!", "Fields issues");

            return;
        }

        try {
            modelPdf.signPDFFile(getData());
        } catch (IOException ex) {

            showWarningMessage(ex.getMessage(), "Signing Process");

        } catch (Exception e) {
            showWarningMessage(e.getMessage(), "Error");
        }

    }

    /**
     * Fill in all form fields with the data stored locally
     */
    private void loadFormWithDataWithSaveRecords() {
        //initial values, before user saves it to the register
        stampPointX = 20L;
        stampPointY = 15L;
        stampWidth = 200L;
        stampDateFontSize = 10L;
        stampSignatureImageHeight = 20L;

        // define settings for Sliders
        setGenericSliderParameter(-20, 40, Slider_StampPointX, 5, 4);
        setGenericSliderParameter(-20, 40, Slider_StampPointY, 5, 4);
        setGenericSliderParameter(100, 300, Slider_StampWidth, 20, 0);
        setGenericSliderParameter(10, 50, Slider_StampSignatureHeight, 5, 4);
        setGenericSliderParameter(10, 20, Slider_StampDateSize, 1, 0);

        // fill info to locations text boxes
        txtBox_PostLabelLocation.setText(modelPrefs.getPostLabelLocation());
        txtBox_SignedPostLabelFolderLocation.setText(modelPrefs.getSignedPostLabelFolderLocation());
        txtBox_SignatureImageLocation.setText(modelPrefs.getSignatureImageLocation());

        // set data for sliders 
        if (modelPrefs.getStampPointX() != null) {
            Slider_StampPointX.setValue(modelPrefs.getStampPointX());
        } else {
            Slider_StampPointX.setValue(stampPointX);
        }

        if (modelPrefs.getStampPointY() != null) {
            Slider_StampPointY.setValue(modelPrefs.getStampPointY());
        } else {
            Slider_StampPointY.setValue(stampPointY);
        }

        if (modelPrefs.getStampWidth() != null) {
            Slider_StampWidth.setValue(modelPrefs.getStampWidth());
        } else {
            Slider_StampWidth.setValue(stampWidth);
        }

        if (modelPrefs.getStampDateFontSize() != null) {
            Slider_StampDateSize.setValue(modelPrefs.getStampDateFontSize());
        } else {
            Slider_StampDateSize.setValue(stampDateFontSize);
        }

        if (modelPrefs.getStampSignatureImageHeight() != null) {
            Slider_StampSignatureHeight.setValue(modelPrefs.getStampSignatureImageHeight());
        } else {
            Slider_StampSignatureHeight.setValue(stampSignatureImageHeight);
        }

        // update sliders info label with value of the slider
        Label_StampPointX.setText("(" + Double.valueOf(Slider_StampPointX.getValue()).longValue() + ")");
        Label_StampPointY.setText("(" + Double.valueOf(Slider_StampPointY.getValue()).longValue() + ")");
        Label_StampWidth.setText("(" + Double.valueOf(Slider_StampWidth.getValue()).longValue() + ")");
        Label_StampSignatureHeight.setText("(" + Double.valueOf(Slider_StampSignatureHeight.getValue()).longValue() + ")");
        Label_StampDateSize.setText("(" + Double.valueOf(Slider_StampDateSize.getValue()).longValue() + ")");

        // set listeners for sliders, if slider value changed, it updates to register values & info label
        Slider_StampPointX.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                modelPrefs.setStampPointX(Double.valueOf(Slider_StampPointX.getValue()).longValue());
                //info label updated with the value
                Label_StampPointX.setText("(" + Double.valueOf(Slider_StampPointX.getValue()).longValue() + ")");

            }
        });

        Slider_StampPointY.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                modelPrefs.setStampPointY(Double.valueOf(Slider_StampPointY.getValue()).longValue());
                //info label updated with the value
                Label_StampPointY.setText("(" + Double.valueOf(Slider_StampPointY.getValue()).longValue() + ")");
            }
        });

        Slider_StampWidth.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                modelPrefs.setStampWidth(Double.valueOf(Slider_StampWidth.getValue()).longValue());
                //info label updated with the value
                Label_StampWidth.setText("(" + Double.valueOf(Slider_StampWidth.getValue()).longValue() + ")");
            }
        });

        Slider_StampSignatureHeight.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                modelPrefs.setStampSignatureImageHeight(Double.valueOf(Slider_StampSignatureHeight.getValue()).longValue());
                //info label updated with the value
                Label_StampSignatureHeight.setText("(" + Double.valueOf(Slider_StampSignatureHeight.getValue()).longValue() + ")");
            }
        });

        Slider_StampDateSize.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                modelPrefs.setStampDateFontSize(Double.valueOf(Slider_StampDateSize.getValue()).longValue());
                //info label updated with the value
                Label_StampDateSize.setText("(" + Double.valueOf(Slider_StampDateSize.getValue()).longValue() + ")");
            }
        });

    }

    /**
     * warning messages
     *
     * @param message
     * @param title
     */
    private void showWarningMessage(String message, String title) {

        FontIcon iconNotification = new FontIcon(MaterialDesignE.EXCLAMATION);
        iconNotification.setIconColor(Color.DARKRED);
        iconNotification.setIconSize(30);

        Notifications notify = Notifications.create()
                .title(title)
                .graphic(iconNotification)
                .text(message)
                .owner(mainStage);

      
        notify.show();
    }

    /**
     * General settings for sliders on the form
     *
     * @param min
     * @param max
     * @param sliderToChange
     * @param majorTickUnit
     * @param minorTickCount
     */
    private void setGenericSliderParameter(double min, double max, Slider sliderToChange, double majorTickUnit, int minorTickCount) {
        sliderToChange.setMin(min);
        sliderToChange.setMax(max);

        sliderToChange.setShowTickLabels(true);
        sliderToChange.setShowTickMarks(true);
        sliderToChange.setSnapToTicks(true);

        sliderToChange.setMajorTickUnit(majorTickUnit);
        sliderToChange.setMinorTickCount(minorTickCount);
        sliderToChange.setBlockIncrement(5);

    }

    /**
     * Collect data from the user's form and load it to the object
     *
     * @return PDFData object
     */
    private PdfData getData() {
        PdfData data = new PdfData();
        data.setPostLabelLocation(txtBox_PostLabelLocation.getText());
        data.setSignatureImageLocation(txtBox_SignatureImageLocation.getText());
        data.setSignedPostLabelFolderLocation(txtBox_SignedPostLabelFolderLocation.getText());

        data.setStampPointX(Double.valueOf(Slider_StampPointX.getValue()).longValue());
        data.setStampPointY(Double.valueOf(Slider_StampPointY.getValue()).longValue());
        data.setStampSignatureHeight(Double.valueOf(Slider_StampSignatureHeight.getValue()).longValue());
        data.setStampWidth(Double.valueOf(Slider_StampWidth.getValue()).longValue());
        data.setStampDateFontSize(Double.valueOf(Slider_StampDateSize.getValue()).longValue());
        data.setSignedDate(DPicker_DateSigned.getValue());

        // DPicker_DateSigned.getValue()
        return data;
    }

}
