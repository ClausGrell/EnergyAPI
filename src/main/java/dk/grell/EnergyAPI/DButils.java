package dk.grell.EnergyAPI;

import java.sql.*;
import java.util.Date;



public class DButils {

    public static Connection dbConnection;
    public static Statement dbStatement;
    public static ResultSet resultSet;

    public void getConnection() throws SQLException {
        String dbURL = "jdbc:oracle:thin:@(DESCRIPTION= (ADDRESS= (PROTOCOL=TCP) (HOST=192.168.0.242) (PORT=1521)) (CONNECT_DATA= (SERVICE_NAME=XEPDB1)))";
        String strUserID = "workspace";
        String strPassword = "S0r0ver";
        dbConnection = DriverManager.getConnection(dbURL,strUserID,strPassword);
    }


    public void closeDBconnection() throws SQLException {
        dbConnection.close();
        dbConnection = null;
    }

    public void createStatement() throws SQLException {
        dbStatement = dbConnection.createStatement();
    }

}


