package com.CS470Project.model;

import java.sql.*;
import java.util.Scanner;


public class UserInterface {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;


    private final static String HEADER = "QUERY SELECTION SCREEN";
    private final static String CREATE = "Insert new record in a table";
    private final static String UPDATE = "Update record in a table";
    private final static String READ = "Read a record in a table";
    private final static String DELETE = "Delete a record from a table";
    public String M_ID, M_NAME, DOR, POSITION, RANK, COMPONENT;

    //interface for the user to select action to perform on the db
    public UserInterface() {

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
                InsertIntoDB insert = new InsertIntoDB();
                break;
            case 2:
                UpdateRecords update = new UpdateRecords();
                break;
            case 3:
                SelectRecords select = new SelectRecords();
                break;
            case 4:
               DeleteRecord delete = new DeleteRecord();
            default:
                System.out.println("Invalid Input");
        }
        System.out.println("Which table would you like to perform this operation on?\n" );
        System.out.println("1. Soldier\n" + "2. Company\n" + "3. HQ Platoon\n" + "4. Platoon\n" + "5. Squad\n" +
                "6. Assignment\n");
        int selection2 = scanner.nextInt();
        //System.out.println(" You selected " + selection2);

        switch (selection2) {
            case 1:
                TABLE = "soldier";
                break;
            case 2:
                TABLE = "company";
                break;
            case 3:
                TABLE = "hq_platoon";
                break;
            case 4:
                TABLE = "platoon";
                break;
            case 5:
                TABLE = "squad";
                break;
            case 6:
                TABLE = "assignment";
                break;
            default:
                System.out.println("Invalid Input\n");
        }

        System.out.println("Would you like to perform another action in the DB or exit the program?");
        System.out.println("1. Return to Query Selection Screen\n" + "2. Close DataBase");
        int programOperation = scanner.nextInt();
        switch(programOperation){
            case 1:
                UserInterface session = new UserInterface();
                break;
            case 2:
                System.exit(0);
        }
    }

}