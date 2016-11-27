package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBModel {

    private PreparedStatement preparedStatement;

    public void createDatabase() {
        DBConnection connection = new DBConnection();
        try {

            preparedStatement = connection.getConnection().prepareStatement("create database if not exists Patient DEFAULT CHARACTER SET utf8 \n"
                    + "  DEFAULT COLLATE utf8_general_ci");
            preparedStatement.execute();

            preparedStatement = connection.getConnection().prepareStatement("CREATE TABLE if not exists `Patient`.`patient` (\n"
                    + "  `Id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `Nom` VARCHAR(20) NOT NULL,\n"
                    + "  `Prenom` VARCHAR(100) ,\n"
                    + "  `NumeroTel` VARCHAR(100) ,\n"
                    + "  `AdressEmail` VARCHAR(100) ,\n"
                    + "  `Address` text,\n"
                    + "  PRIMARY KEY (`Id`));");
            preparedStatement.execute();

            System.out.println("Database Created");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}