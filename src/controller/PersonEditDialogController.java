
package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import database.DBModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Tchowa Adonis
 */
public class PersonEditDialogController implements Initializable {

    public TextField pnames;
    public TextField ppob;
    public TextField pemail;
    public TextField pphone;
    public TextField plocation;
    public TextArea pabout;
    public DatePicker pdob;
    public Button close;

    private Connection connection;
    DBModel dbModel;
    private DBConnection dbConnection;
    private PreparedStatement preparedStatement;
    ResultSet resultSet;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dbModel = new DBModel();
        dbConnection = new DBConnection();
        dbConnection.getDBConnection();

    }

    @FXML
    private void saveUsers(){
        String name = pnames.getText().trim();
        String location = plocation.getText().trim();
        String phone =  pphone.getText().trim();
        String pob = ppob.getText();
        String dob = pdob.getValue().toString();
        String email = pemail.getText();
        String about = pabout.getText();
        dbModel.insertPatient(name, location, phone, email, pob, dob, about);
        closeWindow();
    }

    @FXML
    private void closeWindow(){
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    private boolean verify(String param) {
        if ( param.trim().length() > 2) {
            return true;
        }
        return false;
    }
}
