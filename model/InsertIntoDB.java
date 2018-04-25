package com.CS470Project.model;

import java.sql.*;
import java.util.Scanner;

public class InsertIntoDB {

    private static final String CONNECTION_STRING = DataSource.CONNECTION_STRING;
    private Connection conn;
    private PreparedStatement pst;

    public InsertIntoDB(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which table do you want to insert a record into?");
        System.out.println("1. Soldier\n" + "2. Company\n" + "3. HQ Platoon\n" +
                "4. Platoon\n" + "5.Squad\n" + "6. Assignment");
        int selection = scanner.nextInt();

        switch(selection){
            case 1:
                System.out.println("Please input the following information:\n" +
                        "Soldiers ID (integer only):");
                int m_id = scanner.nextInt();
                System.out.println("Soldiers Last Name ONLY:");
                String m_name = scanner.next();
                System.out.println("Soldiers Date of Rank(DOR):");
                int dor = scanner.nextInt();
                System.out.println("Soldiers Component(Branch):");
                String component = scanner.next();
                System.out.println("Soldiers Rank(3 letter abbreviation):");
                String rank = scanner.next();
                System.out.println("Soldiers Position:");
                String position = scanner.next();

                try{
                    conn = DriverManager.getConnection(CONNECTION_STRING);
                    String insertStatement = "INSERT INTO soldier VALUES ( ?,?,?,?,?,?)";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, m_id);
                    pst.setString(2, m_name);
                    pst.setInt(3, dor);
                    pst.setString(4, component);
                    pst.setString(5, rank);
                    pst.setString(6, position);
                    pst.execute();

                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("Please enter the following information:\n");
                System.out.println("Company ID: ");
                int company_id = scanner.nextInt();
                System.out.println("Company Name: ");
                String company_name = scanner.next();

                try{
                    conn = DriverManager.getConnection(CONNECTION_STRING);
                    String insertStatement = "INSERT INTO company VALUES ( ?,?)";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, company_id);
                    pst.setString(2, company_name);
                    pst.execute();

                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("Please enter the following information:\n");
                System.out.println("HQ Platoon ID: ");
                int hq_platoon_id = scanner.nextInt();
                System.out.println("CO ID: ");
                int co_id = scanner.nextInt();
                System.out.println("XO ID: ");
                int xo_id = scanner.nextInt();
                System.out.println("1SG ID: ");
                int fsg_id = scanner.nextInt();
                System.out.println("Medic ID: ");
                int medic_id = scanner.nextInt();
                System.out.println("RTO ID: ");
                int rto_id = scanner.nextInt();
                System.out.println("NBD ID: ");
                int nbc_id = scanner.nextInt();
                System.out.println("COMMO ID: ");
                int commo_id = scanner.nextInt();
                System.out.println("Supply ID: ");
                int supply_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection(CONNECTION_STRING);
                    String insertStatement = "INSERT INTO hq_platoon VALUES ( ?,?,?,?,?,?,?,?,?)";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, hq_platoon_id);
                    pst.setInt(2, co_id);
                    pst.setInt(3, xo_id);
                    pst.setInt(4, fsg_id);
                    pst.setInt(5, medic_id);
                    pst.setInt(6, rto_id);
                    pst.setInt(7,nbc_id);
                    pst.setInt(8,commo_id);
                    pst.setInt(9,supply_id);
                    pst.execute();

                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println("Please enter the following information:\n");
                System.out.println("Platoon ID: ");
                int platoon_id = scanner.nextInt();
                System.out.println("Platoon Leader ID: ");
                int p_leader_id = scanner.nextInt();
                System.out.println("Platoon Sergeant ID: ");
                int p_sergeant_id = scanner.nextInt();
                System.out.println("RTO ID: ");
                int rto_id1 = scanner.nextInt();

                try {
                    conn = DriverManager.getConnection(CONNECTION_STRING);
                    String insertStatement = "INSERT INTO platoon VALUES ( ?,?,?,?)";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, platoon_id);
                    pst.setInt(2, p_leader_id);
                    pst.setInt(3, p_sergeant_id);
                    pst.setInt(4, rto_id1);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                System.out.println("Please enter the following information:\n");
                System.out.println("Squad ID: ");
                int squad_id = scanner.nextInt();
                System.out.println("Sqaud Leader ID: ");
                int squad_leader_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection(CONNECTION_STRING);
                    String insertStatement = "INSERT INTO squad VALUES ( ?,?)";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, squad_id);
                    pst.setInt(2, squad_leader_id);
                    pst.execute();

                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 6:
                System.out.println("Please enter the following information:\n");
                System.out.println("Soldier ID: ");
                int m_id1 = scanner.nextInt();
                System.out.println("Current Assignment: ");
                String current = scanner.next();
                System.out.println("Projected Assignment: ");
                String projected = scanner.next();
                System.out.println("Previous Assignment: ");
                String prev_assg = scanner.next();

                try{
                    conn = DriverManager.getConnection(CONNECTION_STRING);
                    String insertStatement = "INSERT INTO hq_platoon VALUES ( ?,?,?,?)";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, m_id1);
                    pst.setString(2, current);
                    pst.setString(3, projected);
                    pst.setString(4, prev_assg);
                    pst.execute();

                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Something went wrong insert into the DB system.");
                System.exit(0);
        }
    }
}