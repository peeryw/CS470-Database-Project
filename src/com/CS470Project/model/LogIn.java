package com.CS470Project.model;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class LogIn {
    // login to database, check that user exists and password is valid
    // if invalid, display message, if valid , check user roles and load db
    // with those roles for the user

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;
    private String StoredID;

    public LogIn() {
        connect();
        String sqlStatement = "SELECT * FROM user WHERE user_name = ? AND user_password = ?";

        Scanner scanner = new Scanner(System.in);
        //prompt used id
        System.out.println("UserID: ");
        //get user input as string
        String logInID = scanner.next();
        //prompt for user password
        System.out.println("Password: ");
        //get user password as int
        String logInPassword = scanner.next();
        //
        try {
            conn = DriverManager.getConnection(DataSource.CONNECTION_STRING);
            pst = conn.prepareStatement(sqlStatement);
            pst.setString(1, logInID);
            pst.setString(2, logInPassword);
            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Login complete\n.");
                this.StoredID = rs.getString("user_id");
            } else {
                System.out.println("Invalid User Name and Password.");
                System.exit(0);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        // test input
        //System.out.println(String.format ("userid is %s, password is %s", logInID, logInPassword));
        //query DB for user id and password. handle errors
    }

    public String getStoredID() {
        return StoredID;
    }

    private static void connect() {
        Connection conn = null;
        try {
            //db parameters
            DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection(DataSource.CONNECTION_STRING);
            //System.out.println("Connection to SQLite has been established");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}