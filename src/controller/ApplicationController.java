
package controller;

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
    public TextField pname;
    public TextField psurname;
    public Button btnAdd;
    public Button btnEdit;
    public Button btnDelete;
    public TableColumn idColumn;
    public TableColumn nameColumn;
    public TableColumn surnameColumn;
    public TableColumn phoneColumn;
    public TableColumn emailColumn;
    public TableColumn cityColumn;
    
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
        System.out.println(tfSearch.getCharacters());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddPatient.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void saveUsers(){
        System.out.println(pname.getCharacters());
    }
}
