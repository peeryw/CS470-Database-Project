package com.CS470Project.model;

import com.CS470Project.model.DataSource;
import com.CS470Project.model.Soldier;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

//!!!!!THIS IS A RESULT SET IF MORE THAN ONE REORD IS BREING VIEWED!! NEED TO RE-WRITE THIS CODE !&@*t*&@!t$!!!!!!

public class SelectRecords {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;

    public SelectRecords(){

        Scanner scanner = new Scanner(System.in);
        DataSource datasource = new DataSource();

        System.out.println("Please select the table you want to query.");
        System.out.println("1. Soldier\n" + "2. Company\n" + "3. HQ Platoon\n" + "4. Platoon\n" + "5. Squad\n" );
        int selection = scanner.nextInt();

        switch(selection){
            case 1://soldier
                System.out.println("Do you want to view an individual record or all recordds:");
                System.out.println("1. Individual Soldier\n" + "2. All Soldiers\n");
                int choice = scanner.nextInt();
                switch(choice){
                    case 1://view individual soldier record
                        System.out.println("Please enter in the soldier ID you want to view: ");
                        int m_id = scanner.nextInt();
                        try{
                            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\" +
                                    "JavaPrograms\\Military Readiness\\unit.db");
                            String insertStatement = "SELECT * FROM soldier WHERE m_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, m_id);
                            pst.execute();

                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2://view all soldier records

                        List<Soldier> soldiers = datasource.querySoldiers();
                        if(soldiers == null){
                            System.out.println("No soldiers");
                            return;
                        }

                        for (Soldier soldier : soldiers) {
                            System.out.println("ID= " + soldier.getM_id() + ", Name= " + soldier.getM_name() + ", DOR= " + soldier.getDor()+
                                    ", Component= " + soldier.getComponent() + ", Rank= " + soldier.getRank() +
                                    ", Position= " + soldier.getPosition());
                        }
                }
                break;

            case 2://company
                System.out.println("Please enter company id you want to view: ");
                int company_id = scanner.nextInt();
                try{
                    conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\" +
                            "JavaPrograms\\Military Readiness\\unit.db");
                    String insertStatement = "SELECT * FROM company WHERE company_id = ? AND co_id = soldier.m_id";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, company_id);
                    pst.execute();

                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 3://hq platoon
                System.out.println("Do you want to view all HQ Platoon's or a single HQ Platoon?");
                System.out.println("1. ALL HQ Platoon's\n" + "2. Single HQ Platoon\n");
                int selection3 = scanner.nextInt();
                switch(selection3){
                    case 1:
                        try{
                            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\" +
                                    "JavaPrograms\\Military Readiness\\unit.db") ;
                            String insertStatement = "SELECT * FROM hq_platoon WHERE co_id = soldier.m_id AND" +
                                    " xo_id = soldier.m_id AND fsg_id = soldier.m_id AND medic_id = soldier.m_id " +
                                    "AND rto_id = soldier.m_id AND nbc_id = soldier.m_id AND commo_id = soldier.m_id " +
                                    "AND supply_id = soldier.m_id";
                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Please enter the HQ Platoon's ID you want to view: ");
                        int hq_platoon_id = scanner.nextInt();
                        try{
                            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\" +
                                    "JavaPrograms\\Military Readiness\\unit.db") ;
                            String insertStatement = "SELECT * FROM hq_platoon WHERE co_id = soldier.m_id AND" +
                                    " xo_id = soldier.m_id AND fsg_id = soldier.m_id AND medic_id = soldier.m_id " +
                                    "AND rto_id = soldier.m_id AND nbc_id = soldier.m_id AND commo_id = soldier.m_id " +
                                    "AND supply_id = soldier.m_id";
                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    default:

                }

            case 4://platoon
                System.out.println("Do you want to view all platoon information or a single platoon? ");
                System.out.println("1. ALL Platoon's\n" + "2. Single Platoon\n");
                int selection2 = scanner.nextInt();
                switch(selection2){
                    case 1:
                        try{
                            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\" +
                                    "JavaPrograms\\Military Readiness\\unit.db") ;
                            String insertStatement = "SELECT * FROM platoon";
                            pst = conn.prepareStatement(insertStatement);
                            pst.execute();

                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Please enter the platoon id you want to view: ");
                        int platoon_id = scanner.nextInt();
                        try{
                            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\" +
                                    "JavaPrograms\\Military Readiness\\unit.db") ;
                            String insertStatement = "SELECT * FROM platoon WHERE platoon_id = ? AND" +
                                    " p_leader_id = soldier.m_id AND p_sergeant_id = soldier.m_id";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, platoon_id);
                            pst.execute();

                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Something has gone wrong trying to query Platoon");
                }
            case 5://squad
                System.out.println("Do you want to veiw all Squad's or an individual Squad?");
                System.out.println("1. ALL Squad's\n" + "2. Single Squad\n");
                int selection5 = scanner.nextInt();
                switch(selection5){
                    case 1:
                        try {
                            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\" +
                                    "JavaPrograms\\Military Readiness\\unit.db") ;
                            String insertStatement = "SELECT * FROM squad WHERE squad_leader_id = soldier.m_id";
                            pst = conn.prepareStatement(insertStatement);
                            pst.execute();

                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Please enter Squad ID: ");
                        int squad_id = scanner.nextInt();
                        try{
                            conn = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\willi\\Desktop\\" +
                                    "JavaPrograms\\Military Readiness\\unit.db") ;
                            String insertStatement = "SELECT * FROM squad_id = ? WHERE squad_leader_id = soldier.m_id";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, squad_id);
                            pst.execute();

                        }catch(SQLException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Something went wrong with the query on Squad.");
                }

            default:
                System.out.println("Something has gone wrong trying the query the DB.");
        }
    }
}
