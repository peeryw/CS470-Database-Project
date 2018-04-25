package com.CS470Project.model;

import org.sqlite.JDBC;

import java.sql.*;

public class DataSource {


    public static final String DB_NAME = "unit.db";
    static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\willi\\Desktop" +
            "\\JavaPrograms\\Military Readiness\\" + DB_NAME;
    //public static final String CONNECTION_STRING = "jdbc:sqlite:c\\databases\\" + DB_NAME;
    private Connection conn;

    public boolean open(){
        try{
            DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("Connected to DB");
            return true;
        }catch (SQLException e){
            System.out.println("Problem connecting to DB: " +e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
            if (conn != null){
                conn.close();
            }
        }catch(SQLException e){
            System.out.println("Problem closing DB: " + e.getMessage());
        }
    }
}