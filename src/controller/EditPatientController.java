package controller;

import database.DBModel;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import patients.Patient;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by root on 11/28/16.
 */
public class EditPatientController implements Initializable {

    public TextField pid;
    public TextField pname;
    public TextField pphone;
    public TextField pemail;
    public TextField plocation;
    public TextField pdob;
    public TextField ppob;
    public TextArea potherinfo;
    public Button btnUpdate;
    public Button btnReset;
    public Button btnCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        DBModel dbModel = new DBModel();

        Patient patient = new Patient();

        patient.setId(Integer.parseInt(pid.getText().trim()));
        patient.setName(pname.getText().trim());
        patient.setPhone(pphone.getText().trim());
        patient.setEmail(pemail.getText().trim());
        patient.setLocation(plocation.getText().trim());
        patient.setDob(pdob.getText().trim());
        patient.setPob(ppob.getText().trim());
        patient.setOther(potherinfo.getText().trim());

        dbModel.updatePatient(patient);

        closeWindows();
    }

    public void btnResetOnAction(ActionEvent actionEvent) {
        pname.setText("");
        pphone.setText("");
        pemail.setText("");
        plocation.setText("");
        pdob.setText("");
        ppob.setText("");
        potherinfo.setText("");
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        closeWindows();
    }

    public void closeWindows() {
        Stage stage = (Stage) btnUpdate.getScene().getWindow();
        stage.close();
    }
}
