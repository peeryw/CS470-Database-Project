package com.CS470Project.model;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.Scanner;


public class UserInterface {

//    private Connection conn;
//    private ResultSet rs;


    private final static String HEADER = "QUERY SELECTION SCREEN";
    private final static String CREATE = "Insert new record in a table";
    private final static String UPDATE = "Update record in a table";
    private final static String READ = "Read a record in a table";
    private final static String DELETE = "Delete a record from a table";
    public String M_ID, M_NAME, DOR, POSITION, RANK, COMPONENT;

    //interface for the user to select action to perform on the db
    public UserInterface(String user_id) {

        Scanner scanner = new Scanner(System.in);
        String CRUD = "";
        String TABLE = "";

        //select DRUD operation
        System.out.println(HEADER);
        System.out.println("Please select from the options listed below: ");
        System.out.println("1." + CREATE + "\n" + "2." + UPDATE + "\n" + "3." + READ + "\n" + "4." + DELETE);
        int selection = scanner.nextInt();
        //System.out.println("You selected " + selection "\n");
        //select table to perform CRUD operation

        switch (selection) {
            case 1:
                if (AuthenticateRights(user_id)) {
                InsertIntoDB insert = new InsertIntoDB(user_id);}
                break;
            case 2:
                if (AuthenticateRights(user_id)) {
                UpdateRecords update = new UpdateRecords(user_id);}
                break;
            case 3:
                SelectRecords select = new SelectRecords(user_id);
                break;
            case 4:
                if (AuthenticateRights(user_id)) {
               DeleteRecord delete = new DeleteRecord(user_id);}
            default:
                System.out.println("Invalid Input");
        }

        System.out.println("Would you like to perform another action in the DB or exit the program?");
        System.out.println("1. Return to Query Selection Screen\n" + "2. Close DataBase");
        int programOperation = scanner.nextInt();
        switch(programOperation){
            case 1:
                UserInterface session = new UserInterface(user_id);
                break;
            case 2:
                System.exit(0);
        }
    }

    public boolean AuthenticateRights(String user_id) {
        //This function is to check database for user rights to access portions of system.
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        connect();
        String sqlStatement = "SELECT * FROM user_role WHERE user_id = ?";

        //Try to verify user right's level from DB
        try {
            conn = DriverManager.getConnection(DataSource.CONNECTION_STRING);
            pst = conn.prepareStatement(sqlStatement);
            pst.setString(1, user_id);
            rs = pst.executeQuery();

            if (rs.getString("user_rights").equals("admin")){
                //DO nothing, since user has sufficient rights.
                //System.out.println(rs.getString("user_rights"));
                return true;
            } else {
                System.out.println("User does not have sufficient Rights to perform this function.\n" +
                    "Please select a different menu option.\n");
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
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