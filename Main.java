package com.CS470Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //initiate system log in by gettting user info and password
        //check this info with what is in DB.
        //take input from user for id and check table to see if exist. if it does exist,
        //check the password to see if it matches. if the password doesnt match, exit
        // with warning. if user id doesnt exist, then exit with warning. do we lock them
        // out after one try or do we give them multiple?

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
        System.out.println(String.format ("userid is %s, password is %d", logInID, logInPassword));
        //query DB for user id and password. handle errors





    }
}
