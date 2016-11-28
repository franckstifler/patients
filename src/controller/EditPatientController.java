package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by root on 11/28/16.
 */
public class EditPatientController implements Initializable{

    public TextField pname;
    public TextField psurname;
    public TextField pphone;
    public TextField pemail;
    public TextField plocation;
    public TextArea potherinfo;
    public Button btnUpdate;
    public Button btnReset;
    public Button btnCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnResetOnAction(ActionEvent actionEvent) {
        pname.setText("");
        psurname.setText("");
        pphone.setText("");
        pemail.setText("");
        plocation.setText("");
        potherinfo.setText("");
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnUpdate.getScene().getWindow();
        stage.close();
    }
}
