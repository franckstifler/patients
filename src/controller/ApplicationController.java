
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.scene.*;
import javafx.stage.*;
import database.DBModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXMLLoader;

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
    public TableColumn nameColumn;
    public TableColumn phoneColumn;
    public TableColumn emailColumn;
    public TableColumn locationColumn;
    public TableColumn pobColumn;
    public TableColumn dobColumn;
    public TableColumn otherColumn;

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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddPatient.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Patient");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/EditPatient.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Patient");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

}
