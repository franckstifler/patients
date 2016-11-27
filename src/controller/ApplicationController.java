
package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.DBConnection;
import database.DBModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Tchowa Adonis
 */
public class ApplicationController implements Initializable {

    public TextField tfSearch;
    public Button btnAdd;
    public Button btnEdit;
    public Button btnDelete;
    public TableColumn idColumn;
    public TableColumn nomColumn;
    public TableColumn prenomColumn;
    public TableColumn telephoneColumn;
    public TableColumn emailColumn;
    public TableColumn addressColumn;
    
    Connection connection;
    DBModel dbModel;
    DBConnection dbConnection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dbModel = new DBModel();
        dbModel.createDatabase();

        dbConnection = new DBConnection();
        dbConnection.getDBConnection();

    }

    public void tfSearchOnKeyReleased(KeyEvent keyEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
