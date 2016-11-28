package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public boolean insertPatient(String name, String location, String phone, String email, String pob, String dob, String other) {
        try {
            DBConnection connection = new DBConnection();
            String query = "INSERT INTO Patient.patient (name, location, phone, email, pob, dob, other) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pr = connection.getConnection().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, location);
            pr.setString(3, phone);
            pr.setString(4, email);
            pr.setString(5, pob);
            pr.setString(6, dob);
            pr.setString(7, other);
            pr.execute();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void
}