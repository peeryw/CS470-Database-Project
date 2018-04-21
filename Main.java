package com.CS470Project;

import org.sqlite.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Main {

    private static void connect(){
        Connection conn = null;
        try{
            //db parameters
            DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection("jdbc:sqlite:c:\\databases\\unit.db");

            System.out.println("Connection to SQLite has been established");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
	/*
        write your code here
        initiate system log in by gettting user info and password
        check this info with what is in DB.
        take input from user for id and check table to see if exist. if it does exist,
        check the password to see if it matches. if the password doesnt match, exit
        with warning. if user id doesnt exist, then exit with warning. do we lock them
        out after one try or do we give them multiple?
        */
        connect();
        Scanner scanner = new Scanner(System.in);
        //print title header
        System.out.println("Military Readiness Tracker\n");
        //promt used id
        System.out.println("UserID: ");
        //get user input as string
        String logInID = scanner.next();
        //promt for user password
        System.out.println("Password: ");
        //get user password as int
        String logInPassword = scanner.next();
        // test input
        System.out.println(String.format ("userid is %s, password is %s", logInID, logInPassword));
        //query DB for user id and password. handle errors







    }
}
