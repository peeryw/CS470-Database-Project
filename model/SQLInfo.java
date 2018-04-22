package com.CS470Project.model;


import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLInfo {

    private java.sql.Connection con;
    @SuppressWarnings("unused")
    private static java.sql.Statement stmnt;

    public SQLInfo() throws SQLException {
        try {
            Class.forName("com.mysql.jdc.Driver");

        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }

        String url = getURL();
        String userID = getUserName();
        String password = getPassword();

        con = DriverManager.getConnection(url, userID, password);
        stmnt = con.createStatement();

    }

    protected static String getUserName() {
        //code for getting user input
        return ("");//input from user
    }

    protected static String getPassword() {
        //code for getting input from user
        return ("");//user input
    }

    protected static String getURL() {
        //what are we connecting to goes here
        return ("jdbc:sqlite:C:/sqlite/unit.db");
    }

    protected static String createUserAccount() throws SQLException{
        return("CREATE TABLE UserAccounts "
        + "(UserID INT NOT NULL PRIMARY KEY AUTO_INCREMENT, "
        + "UserName VARCHAR(64), "
        + "UserPassword VARCHAR(64) NOT NULL);");
    }

    protected static String createTable() throws SQLException{
        return ("create table useraccount (user_id INT NOT NULL AUTO_INCREMENT, "
        + "user_name VARCHAR(64), account_password INT NOT NULL,"
        + "PRIMARY KEY (user_id);");
    }

    //get Unit Info

    //get Soldier Info

    //populate Table from get Info

    //set Soldier Info

    //set Unit Info

    //create unit info table

    //create soldier info table


}

