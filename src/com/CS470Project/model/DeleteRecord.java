package com.CS470Project.model;

//uses sql commands to delete from tables in a DB

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Scanner;


public class DeleteRecord {

    private static final String CONNECTION_STRING = DataSource.CONNECTION_STRING;
    private static final String WARNING_MESSAGE = "\n" + "!!!!!!!WARNING!!!!!!!\n" +
            "Are you sure you want to DELETE this record?\n " +
            "This cannot be undone!\n" + "1. YES\n" + "2. NO";

    private Connection conn;
    private PreparedStatement pst;

    public DeleteRecord(String user_id) {

        Scanner scanner = new Scanner(System.in);
        DataSource dataSource = new DataSource();

        System.out.println("Please select the table you want to delete a record from:");
        System.out.println("1. Soldier\n" + "2. Company\n" + "3. HQ Platoon\n"
                + "4. Platoon\n" + "5. Squad\n" + "6. Assignment");
        int selection = scanner.nextInt();
        switch (selection) {
            case 1://soldier
                System.out.println("Please enter the Soldier's ID of the record you want to DELETE: ");
                int m_id = scanner.nextInt();
                System.out.println(WARNING_MESSAGE);
                int choice1 = scanner.nextInt();
                switch (choice1) {
                    case 1:
                        try {
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = " DELETE FROM soldier WHERE m_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, m_id);
                            pst.execute();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            if (pst != null) {
                                try {
                                    pst.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                        }
                    case 2:
                        UserInterface goBack = new UserInterface(user_id);
                }
                break;

            case 2://company
                System.out.println("Please enter the Company ID of the record you want to DELETE: ");
                int company_id = scanner.nextInt();
                System.out.println(WARNING_MESSAGE);
                int choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        try {
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = " DELETE FROM company WHERE company_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, company_id);
                            pst.execute();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            if (pst != null) {
                                try {
                                    pst.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                        }
                    case 2:
                        UserInterface goBack = new UserInterface(user_id);
                }
                break;

            case 3://hq platoon
                System.out.println("Please enter the HQ Platoon ID of the record that you want to DELETE: ");
                int hq_platoon_id = scanner.nextInt();
                System.out.println(WARNING_MESSAGE);
                int choice3 = scanner.nextInt();
                switch (choice3) {
                    case 1:
                        try {
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = " DELETE FROM hq_platoon WHERE hq_platoon_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, hq_platoon_id);
                            pst.execute();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            if (pst != null) {
                                try {
                                    pst.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                        }
                    case 2:
                        UserInterface goBack = new UserInterface(user_id);
                }
                break;

            case 4://platoon
                System.out.println("Please enter the Platoon ID of the record you want to DELETE: ");
                int platoon_id = scanner.nextInt();
                System.out.println(WARNING_MESSAGE);
                int choice4 = scanner.nextInt();
                switch (choice4) {
                    case 1:
                        try {
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = " DELETE FROM platoon WHERE platoon_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, platoon_id);
                            pst.execute();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            if (pst != null) {
                                try {
                                    pst.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                        }
                    case 2:
                        UserInterface goBack = new UserInterface(user_id);
                }
                break;

            case 5://squad
                System.out.println("Please enter the Squad ID for the record you want to DELETE: ");
                int squad_id = scanner.nextInt();
                System.out.println(WARNING_MESSAGE);
                int choice5 = scanner.nextInt();
                switch(choice5){
                    case 1:
                        try{
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = " DELETE FROM squad WHERE squad_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, squad_id);
                            pst.execute();

                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        } finally {
                            if (pst != null) {
                                try {
                                    pst.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                        }
                    case 2:
                        UserInterface goBack = new UserInterface(user_id);
                }
                break;

            case 6://assignment
                System.out.println("Please enter the Assignment ID for the record that you want to DELETE: ");
                int assignment_id = scanner.nextInt();
                System.out.println(WARNING_MESSAGE);
                int choice6 = scanner.nextInt();
                switch(choice6){
                    case 1:
                        try{
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = " DELETE FROM assignment WHERE assignment_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, assignment_id);
                            pst.execute();

                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        } finally {
                            if (pst != null) {
                                try {
                                    pst.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {/* IGNORED */}
                            }
                        }
                    case 2:
                        UserInterface goBack = new UserInterface(user_id);
                }
                break;

            default:
                System.out.println("Something has gone wrong with deleting the record in the DB.");
                System.exit(0);
        }
    }
}
