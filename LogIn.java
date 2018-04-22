package com.CS470Project;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.Scanner;


public class  LogIn  {
    // login to database, check that user exists and password is valid
    // if invalid, display message, if valid , check user roles and load db
    // with those rol;es for the user

    public Connection conn;
    public ResultSet rs;
    public PreparedStatement pst;


    public LogIn(){
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
            conn = DriverManager.getConnection("jdbc:sqlite:c:\\databases\\unit.db");
            pst = conn.prepareStatement(sqlStatement);
            pst.setString(1, logInID);
            pst.setString(2, logInPassword);
            rs=pst.executeQuery();
            if (rs.next()){
                System.out.println("User Name and Password are correct.");
            }
            else{
                System.out.println("Invalid User Name and Password.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        // test input
        //System.out.println(String.format ("userid is %s, password is %s", logInID, logInPassword));
        //query DB for user id and password. handle errors
    }
    private static void connect(){
        Connection conn = null;
        try{
            //db parameters
            DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection("jdbc:sqlite:c:\\databases\\unit.db");

            System.out.println("Connection to SQLite has been established");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }/*finally {
            try {
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            } */
        }
    }

