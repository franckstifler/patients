package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by root on 11/28/16.
 */
public class AddPatientController implements Initializable {

    public TextField pname;
    public TextField psurname;
    public TextField pphone;
    public TextField pemail;
    public TextField plocation;
    public TextArea potherinfo;
    public Button btnSave;
    public Button btnReset;
    public Button btnCancel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnResetOnAction(ActionEvent actionEvent) {
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }
}
