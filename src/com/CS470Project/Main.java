package com.CS470Project;

import com.CS470Project.model.DataSource;
import com.CS470Project.model.LogIn;
import com.CS470Project.model.Soldier;
import com.CS470Project.model.UserInterface;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Military Readiness Tracker\n");
        //initiate login procedures and establish connection
        DataSource datasource = new DataSource();
        if (!datasource.open()) {
           System.out.println("Cannot open data source.");
            return;
        }
        //determine if user is authorized to log in to db
        LogIn logIn = new LogIn();
        //display selection table for user to perform queries
        UserInterface session = new UserInterface(logIn.getStoredID());
        //close all connections
        datasource.close();
    }


}