package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import org.omg.CORBA.TRANSACTION_MODE;
import patients.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//new db
public class DBModel {

    public void createDatabase() {
        try {
            PreparedStatement preparedStatement;
            DBConnection connection = new DBConnection();
            preparedStatement = connection.getConnection().prepareStatement("create database if not exists Patient DEFAULT CHARACTER SET utf8 \n"
                    + "  DEFAULT COLLATE utf8_general_ci");
            preparedStatement.execute();

            preparedStatement = connection.getConnection().prepareStatement("CREATE TABLE if not exists `Patient`.`patient` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `name` VARCHAR(20) NOT NULL,\n"
                    + "  `location` VARCHAR(100) ,\n"
                    + "  `phone` VARCHAR(30) ,\n"
                    + "  `email` VARCHAR(100) ,\n"
                    + "  `pob` VARCHAR(30),\n"
                    + "  `dob` VARCHAR(15),\n"
                    + "  `other` text,\n"
                    + "  PRIMARY KEY (`Id`));");
            preparedStatement.execute();

            System.out.println("Database Created");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertPatient(Patient patient) {
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getDBConnection();
            String query = "INSERT INTO Patient.patient (name, location, phone, email, pob, dob, other) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, patient.name);
            preparedStatement.setString(2, patient.location);
            preparedStatement.setString(3, patient.phone);
            preparedStatement.setString(4, patient.email);
            preparedStatement.setString(5, patient.pob);
            preparedStatement.setString(6, patient.dob);
            preparedStatement.setString(7, patient.other);
            preparedStatement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePatient(Patient patient) {
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getDBConnection();
            String query = "UPDATE Patient.patient SET name=?, location=?, phone=?, email=?, pob=?, dob=?, other=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, patient.name);
            preparedStatement.setString(2, patient.location);
            preparedStatement.setString(3, patient.phone);
            preparedStatement.setString(4, patient.email);
            preparedStatement.setString(5, patient.pob);
            preparedStatement.setString(6, patient.dob);
            preparedStatement.setString(7, patient.other);
            preparedStatement.setInt(8, patient.id);
            preparedStatement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void removePatient(Patient patient) {
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getDBConnection();
            String query = "DELETE FROM Patient.patient WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, patient.id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Patient> viewPatient() {
        ObservableList<Patient> data = null;
        try {
            data = FXCollections.observableArrayList();

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getDBConnection();
            String query = "SELECT * FROM Patient.patient";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            Patient patient = new Patient();

            while (resultSet.next()) {
                patient.id = resultSet.getInt(1);
                patient.name = resultSet.getString(2);
                patient.location = resultSet.getString(3);
                patient.phone = resultSet.getString(4);
                patient.email = resultSet.getString(5);
                patient.pob = resultSet.getString(6);
                patient.dob = resultSet.getString(7);
                patient.other = resultSet.getString(8);

                data.add(patient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}