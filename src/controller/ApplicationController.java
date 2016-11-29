
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.util.Callback;
import patients.Patient;

/**
 *
 * @author Tchowa Adonis
 */
public class ApplicationController implements Initializable {

    public TextField tfSearch;
    public Button btnAdd;
    public Button btnEdit;
    public Button btnDelete;
    public TableView<Patient> table;
    public TableColumn<Patient, Integer> idColumn;
    public TableColumn<Patient, String> nameColumn;
    public TableColumn<Patient, String> phoneColumn;
    public TableColumn<Patient, String> emailColumn;
    public TableColumn<Patient, String> locationColumn;
    public TableColumn<Patient, String> pobColumn;
    public TableColumn<Patient, String> dobColumn;
    public TableColumn<Patient, String> otherColumn;

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

        initialize();

    }

    public void tfSearchOnKeyReleased(KeyEvent keyEvent) {
        table.getItems().clear();
        table.setItems(dbModel.searchPatient(tfSearch.getText().trim()));
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
        if (table.getSelectionModel().getSelectedItem() != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/EditPatient.fxml"));
                Parent root = fxmlLoader.load();
                EditPatientController editPatientController = fxmlLoader.getController();
                editPatientController.pid.setText(String.valueOf(table.getSelectionModel().getSelectedItem().id));
                editPatientController.pname.setText(String.valueOf(table.getSelectionModel().getSelectedItem().name));
                editPatientController.plocation.setText(String.valueOf(table.getSelectionModel().getSelectedItem().location));
                editPatientController.pphone.setText(String.valueOf(table.getSelectionModel().getSelectedItem().phone));
                editPatientController.pemail.setText(String.valueOf(table.getSelectionModel().getSelectedItem().email));
                editPatientController.ppob.setText(String.valueOf(table.getSelectionModel().getSelectedItem().pob));
                editPatientController.pdob.setText(String.valueOf(table.getSelectionModel().getSelectedItem().dob));
                editPatientController.potherinfo.setText(String.valueOf(table.getSelectionModel().getSelectedItem().other));

                Stage stage = new Stage();
                stage.setTitle("Add Patient");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (table.getSelectionModel().getSelectedItem() != null) {
            dbModel.removePatient(table.getSelectionModel().getSelectedItem().id);
            initialize();
        }
    }

    public void initialize() {

        table.getItems().clear();

        idColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("location"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("email"));
        pobColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("pob"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("dob"));
        otherColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("other"));

        table.getItems().addAll(dbModel.viewPatient());
    }

    public void btnRefreshOnAction(ActionEvent actionEvent) {
        initialize();
    }
}
