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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Trakis
 */
public class PostLabelsSignController implements Initializable {

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

    @FXML
    private void onClickPostLabelLocation_Browse(ActionEvent event) {
    }

    @FXML
    private void onClickSignedPostLabelFolderLocation_Browse(ActionEvent event) {
    }

    @FXML
    private void onClickSignatureImageLocation_Browse(ActionEvent event) {
    }

    
}
