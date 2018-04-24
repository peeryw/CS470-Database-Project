package com.CS470Project.model;

import java.sql.*;
import java.util.Scanner;

public class UpdateRecords {

    private static final String DB_NAME = "unit.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\willi\\Desktop" +
            "\\JavaPrograms\\Military Readiness\\" + DB_NAME;

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;

    private Scanner scanner = new Scanner(System.in);

    public UpdateRecords() {

        System.out.println("Please select which table to update:\n");
        System.out.println("1. Soldier\n" + "2.Company\n" + "3.HQ Platoon\n" + "4.Platoon\n" + "5.Squad\n"
                + "6.Assignment");
        int TABLE_SELECTION = scanner.nextInt();

        switch (TABLE_SELECTION) {
            case 1:
                updateSoldier();
                break;
            case 2:
                updateCompany();
                break;
            case 3:
                updateHQ_Platoon();
                break;
            case 4:
                updatePlatoon();
                break;
            case 5:
                updateSquad();
                break;
            case 6:
                updateAssignment();
                break;
            default:
                break;
        }
    }

    private void updateSoldier() {

        System.out.println("Which soldiers record do you wish to update?\n");
        System.out.println("Please enter soldiers ID: ");
        int m_id = scanner.nextInt();
        System.out.println("Which part of the record do you want to update?\n");
        System.out.println("1. Soldier Name\n" + "2. DOR\n" + "3.Component\n" + "4. Rank\n" + "5. Position\n");
        int selection2 = scanner.nextInt();

        switch (selection2) {
            case 1:
                System.out.println("Please enter new name: ");
                String m_name = scanner.next();
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "Update soldier SET m_name = ? WHERE m_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setString(1, m_name);
                    pst.setInt(2, m_id);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("Please enter new DOR: ");
                int dor = scanner.nextInt();
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "Update soldier SET dor = ? WHERE m_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, dor);
                    pst.setInt(2, m_id);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("Please enter new component: ");
                String component = scanner.next();
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "Update soldier SET component = ? WHERE m_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setString(1, component);
                    pst.setInt(2, m_id);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println("Please enter new Rank: ");
                String rank = scanner.next();
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "Update soldier SET rank = ? WHERE m_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setString(1, rank);
                    pst.setInt(2, m_id);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                System.out.println("Please enter new position: ");
                String position = scanner.next();
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "Update soldier SET position = ? WHERE m_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setString(1, position);
                    pst.setInt(2, m_id);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Something has gone wrong and the DB will close.");
        }
    }

    private void updateAssignment() {

        System.out.println("Which  soldier assignment record do you wish to update?\n");
        System.out.println("Please enter soldiers ID: ");
        int m_id = scanner.nextInt();
        System.out.println("Which part of the record do you want to update?\n");
        System.out.println("1. Current Assignment\n" + "2. Projected Assignment\n" + "3.Previous Assignemnt\n");
        int selection2 = scanner.nextInt();

        switch (selection2) {
            case 1:
                System.out.println("Please enter Current Assignment: ");
                String current = scanner.next();
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "Update assignment SET current = ? WHERE m_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setString(1, current);
                    pst.setInt(2, m_id);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("Please enter Projected Assignment: ");
                String projected = scanner.next();
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "Update assignment SET projected = ? WHERE m_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setString(1, projected);
                    pst.setInt(2, m_id);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("Please enter Previous Assignment: ");
                String prev_assg = scanner.next();
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "Update assignment SET prev_assg = ? WHERE m_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setString(1, prev_assg);
                    pst.setInt(2, m_id);
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Something has gone wrong updating assignments");
        }
    }

    private void updateSquad() {
        System.out.println("Which squad do you want to update?\n");
        System.out.println("Please enter squad id: ");
        int squad_id = scanner.nextInt();
        System.out.println("Please enter New Squad Leader ID: ");
        int squad_leader_id = scanner.nextInt();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                    " Readiness\\unit.db");
            String insertStatement = "UPDATE squad SET squad_leader_id = ? WHERE squad_id = ?";
            pst = conn.prepareStatement(insertStatement);
            pst.setInt(1, squad_leader_id);
            pst.setInt(2, squad_id);
            pst.execute();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private void updatePlatoon() {
        System.out.println("Which platoon do you wish to update?\n");
        System.out.println("Please enter platoon id: ");
        int platoon_id = scanner.nextInt();
        System.out.println("Which field do you wish to update in platoon?\n");
        System.out.println("Please select from the following:\n" + "1.Platton Leader\n" + "2. Platoon Sergeant\n");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Please enter the new Platoon Leader ID: ");
                int p_leader_id = scanner.nextInt();
                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE platoon SET p_leader_id = ? WHERE platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, p_leader_id);
                    pst.setInt(2, platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("Please enter new Platoon Sergeant ID: ");
                int p_sergeant_id = scanner.nextInt();
                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE platoon SET p_sergeant_id = ? WHERE platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, p_sergeant_id);
                    pst.setInt(2, platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Something went wrong updating Platoon.");
        }
    }

    private void updateHQ_Platoon() {
        System.out.println("Please enter the HQ Platoon ID you want to update: ");
        int hq_platoon_id = scanner.nextInt();
        System.out.println("Please select the field you want to update:");
        System.out.println("1. CO's ID\n" + "2. XO's ID\n" + "3. 1SG's ID\n" + "4. Medic's ID\n" + "5. RTO's ID\n" +
                            "6. NBC NCO's ID\n" + "7. Commo NCO's ID\n" + "8. Supply NCO's ID\n");
        int selection = scanner.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Please enter the new CO ID: ");
                int co_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE hq_platoon SET co_id = ? WHERE hq_platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, co_id);
                    pst.setInt(2, hq_platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("Please enter the new XO ID: ");
                int xo_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE hq_platoon SET xo_id = ? WHERE hq_platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, xo_id);
                    pst.setInt(2, hq_platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("Please enter the new 1SG ID: ");
                int fsg_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE hq_platoon SET fsg_id = ? WHERE hq_platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, fsg_id);
                    pst.setInt(2, hq_platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println("Please enter the new Medic ID: ");
                int medic_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE hq_platoon SET medic_id = ? WHERE hq_platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, medic_id);
                    pst.setInt(2, hq_platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                System.out.println("Please enter the new RTO ID: ");
                int rto_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE hq_platoon SET rto_id = ? WHERE hq_platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, rto_id);
                    pst.setInt(2, hq_platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 6:
                System.out.println("Please enter the new NBC NCO ID: ");
                int nbc_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE hq_platoon SET nbc_id = ? WHERE hq_platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, nbc_id);
                    pst.setInt(2, hq_platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 7:
                System.out.println("Please enter the new Commo NCO ID: ");
                int commo_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE hq_platoon SET commo_id = ? WHERE hq_platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, commo_id);
                    pst.setInt(2, hq_platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 8:
                System.out.println("Please enter the new Supply NOC ID: ");
                int supply_id = scanner.nextInt();

                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                            " Readiness\\unit.db");
                    String insertStatement = "UPDATE hq_platoon SET supply_id = ? WHERE hq_platoon_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, supply_id);
                    pst.setInt(2, hq_platoon_id);
                    pst.execute();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Something went wrong updating HQ Platoon.");
        }
    }

    private void updateCompany() {

        System.out.println("Please enter the Company ID you want to update: ");
        int company_id = scanner.nextInt();
        System.out.println("Please enter the new Company Name: ");
        String company_name = scanner.next();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\JavaPrograms\\Military" +
                    " Readiness\\unit.db");
            String insertStatement = "UPDATE company SET company_name = ? WHERE company_id = ?";
            pst = conn.prepareStatement(insertStatement);
            pst.setString(1, company_name);
            pst.setInt(2, company_id);
            pst.execute();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
