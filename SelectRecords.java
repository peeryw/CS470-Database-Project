package com.CS470Project.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SelectRecords {

    private static final String CONNECTION_STRING = DataSource.CONNECTION_STRING;

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;

    private static final String COLUMN_M_ID = "m_id";

    private static final String COLUMN_COMPANY_ID = "company_id";
    private static final String COLUMN_COMPANY_NAME = "company_name";

    private static final String COLUMN_HQ_PLATOON_ID = "hq_platoon_id";
    private static final String COLUMN_CO_ID = "co_id";
    private static final String COLUMN_XO_ID = "xo_id";
    private static final String COLUMN_FSG_ID = "fsg_id";
    private static final String COLUMN_MEDIC_ID = "medic_id";
    private static final String COLUMN_RTO_ID = "rto_id";
    private static final String COLUMN_NBC_ID = "nbc_id";
    private static final String COLUMN_COMMO_ID = "commo_id";
    private static final String COLUMN_SUPPLY_ID = "supply_id";

    private static final String COLUMN_PLATOON_ID = "platoon_id";
    private static final String COLUMN_P_LEADER_ID = "p_leader_id";
    private static final String COLUMN_P_SERGEANT_ID = "p_sergeant_id";

    private static final String COLUMN_M_NAME = "m_name";
    private static final String COLUMN_DOR = "dor";
    private static final String COLUMN_COMPONENT = "component";
    private static final String COLUMN_RANK = "rank";
    private static final String COLUMN_POSITION = "position";

    private static final String COLUMN_SQUAD_ID = "squad_id";
    private static final String COLUMN_SQUAD_LEADER_ID = "squad_leader_id";

    public SelectRecords() {

        Scanner scanner = new Scanner(System.in);
        DataSource datasource = new DataSource();

        System.out.println("Please select the table you want to query.");
        System.out.println("1. Soldier\n" + "2. Company\n" + "3. HQ Platoon\n" + "4. Platoon\n" + "5. Squad\n");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1://soldier
                System.out.println("Do you want to view an individual record or all recordds:");
                System.out.println("1. Individual Soldier\n" + "2. All Soldiers\n");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1://view individual soldier record
                        System.out.println("Please enter in the soldier ID you want to view: ");
                        int m_id = scanner.nextInt();
                        try {
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = "SELECT * FROM soldier WHERE m_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, m_id);
                            rs = pst.executeQuery();
                            while (rs.next()) {
                                System.out.println(rs.getInt(COLUMN_M_ID) + " " + rs.getString(COLUMN_M_NAME) + " " +
                                        rs.getString(COLUMN_DOR) + " " + rs.getString(COLUMN_COMPONENT)
                                        + " " + rs.getString(COLUMN_RANK) + " " + rs.getString(COLUMN_POSITION) + "\n");
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2://view all soldier records
                        querySoldiers();
                }
                break;

            case 2://company
                System.out.println("Please enter company id you want to view: ");
                int company_id = scanner.nextInt();
                try {
                    conn = DriverManager.getConnection(CONNECTION_STRING);
                    String insertStatement = "SELECT * FROM company WHERE company_id = ?";
                    pst = conn.prepareStatement(insertStatement);
                    pst.setInt(1, company_id);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(COLUMN_COMPANY_ID) + " " + rs.getString(COLUMN_COMPANY_NAME) + "\n");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3://hq platoon
                System.out.println("Do you want to view all HQ Platoon's or a single HQ Platoon?");
                System.out.println("1. ALL HQ Platoon's\n" + "2. Single HQ Platoon\n");
                int selection3 = scanner.nextInt();
                switch (selection3) {
                    case 1:
                        queryHQ_Platoons();
                        break;

                    case 2:
                        System.out.println("Please enter the HQ Platoon's ID you want to view: ");
                        int hq_platoon_id = scanner.nextInt();
                        try {
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = "SELECT * FROM hq_platoon WHERE hq_platoon_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, hq_platoon_id);
                            rs = pst.executeQuery();
                            while (rs.next()) {
                                System.out.println(rs.getInt(COLUMN_HQ_PLATOON_ID) + " " + rs.getString(COLUMN_COMMO_ID)
                                        + " " + rs.getString(COLUMN_XO_ID) + " " + rs.getString(COLUMN_FSG_ID)
                                        + " " + rs.getString(COLUMN_MEDIC_ID) + " " + rs.getString(COLUMN_RTO_ID)
                                        + " " + rs.getString(COLUMN_NBC_ID) + " " + rs.getString(COLUMN_COMMO_ID)
                                        + " " + rs.getString(COLUMN_SUPPLY_ID) + "\n");
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }

            case 4://platoon
                System.out.println("Do you want to view all platoon information or a single platoon? ");
                System.out.println("1. ALL Platoon's\n" + "2. Single Platoon\n");
                int selection2 = scanner.nextInt();
                switch (selection2) {
                    case 1:
                        queryPlatoon();
                        break;

                    case 2:
                        System.out.println("Please enter the platoon id you want to view: ");
                        int platoon_id = scanner.nextInt();
                        try {
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = "SELECT * FROM platoon WHERE platoon_id = ?";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, platoon_id);
                            rs = pst.executeQuery();
                            while(rs.next()){
                                System.out.println("Platoon ID= " + rs.getString(COLUMN_PLATOON_ID) +
                                        "Platoon Leader ID= " + rs.getString(COLUMN_P_LEADER_ID)+ "Platoon Sergeant ID= "
                                        +  rs.getString(COLUMN_P_SERGEANT_ID));
                            }

                        } catch (SQLException e) {
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
                switch (selection5) {
                    case 1:
                        querySquad();
                        break;

                    case 2:
                        System.out.println("Please enter Squad ID: ");
                        int squad_id = scanner.nextInt();
                        try {
                            conn = DriverManager.getConnection(CONNECTION_STRING);
                            String insertStatement = "SELECT * FROM squad_id = ? WHERE squad_leader_id = soldier.m_id";
                            pst = conn.prepareStatement(insertStatement);
                            pst.setInt(1, squad_id);
                            pst.execute();

                        } catch (SQLException e) {
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

    private void querySquad() {
        Statement statement = null;
        ResultSet rs = null;
        List<Squad> squads = new ArrayList<>();

        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM squad");
            while (rs.next()){
                Squad squad = new Squad();
                squad.setSquad_id(rs.getInt(COLUMN_SQUAD_ID));
                squad.setSquad_leader_id(rs.getInt(COLUMN_SQUAD_LEADER_ID));
                squads.add(squad);
            }
            for (Squad squad : squads){
                System.out.println("Squad ID= " + squad.getSquad_id() + "Squad Leader ID= "
                        + squad.getSquad_leader_id());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            try{
                if (statement !=null){
                    statement.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void queryPlatoon() {
        Statement statement = null;
        ResultSet rs = null;
        List<Platoon> platoons = new ArrayList<>();

        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM platoon");
            while(rs.next()){
                Platoon platoon = new Platoon();
                platoon.setPlatoon_id(rs.getInt(COLUMN_PLATOON_ID));
                platoon.setP_leader_id(rs.getInt(COLUMN_P_LEADER_ID));
                platoon.setP_sergeant_id(rs.getInt(COLUMN_P_SERGEANT_ID));
                platoons.add(platoon);
            }
            for (Platoon platoon : platoons){
                System.out.println("Platoon ID= " + platoon.getPlatoon_id() + "Platoon Leader ID="
                        + platoon.getP_leader_id() + "Platoon Sergeant ID= " + platoon.getP_sergeant_id());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing ResultsSet: " + e.getMessage());
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing Statement: " + e.getMessage());
            }
        }

    }

    private void querySoldiers() {
        Statement statement = null;
        ResultSet results = null;
        List<Soldier> soldiers = new ArrayList<>();

        try {
            //DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection(CONNECTION_STRING);
            statement = conn.createStatement();
            results = statement.executeQuery("SELECT * FROM soldier");
            while (results.next()) {
                Soldier soldier = new Soldier();
                soldier.setM_id(results.getInt(COLUMN_M_ID));
                soldier.setM_name(results.getString(COLUMN_M_NAME));
                soldier.setDor(results.getString(COLUMN_DOR));
                soldier.setComponent(results.getString(COLUMN_COMPONENT));
                soldier.setRank(results.getString(COLUMN_RANK));
                soldier.setPosition((results.getString(COLUMN_POSITION)));
                soldiers.add(soldier);
            }
            for (Soldier soldier : soldiers) {
                System.out.println("ID= " + soldier.getM_id() + ", Name= " + soldier.getM_name() +
                        ", DOR= " + soldier.getDor() +
                        ", Component= " + soldier.getComponent() + ", Rank= " + soldier.getRank() +
                        ", Position= " + soldier.getPosition());
            }

        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing ResultsSet: " + e.getMessage());
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing Statement: " + e.getMessage());
            }
        }

    }

    private void queryHQ_Platoons() {
        Statement statement = null;
        ResultSet rs = null;
        List<HQPlatoon> HQ_PLATOON = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT* FROM hq_platoon");
            while (rs.next()) {
                HQPlatoon temp = new HQPlatoon();
                temp.setHq_platoon_id(rs.getInt(COLUMN_HQ_PLATOON_ID));
                temp.setCo_id(rs.getInt(COLUMN_CO_ID));
                temp.setXo_id(rs.getInt(COLUMN_XO_ID));
                temp.setFsg_id(rs.getInt(COLUMN_FSG_ID));
                temp.setMedic_id(rs.getInt(COLUMN_MEDIC_ID));
                temp.setRto_id(rs.getInt(COLUMN_RTO_ID));
                temp.setNbc_id(rs.getInt(COLUMN_NBC_ID));
                temp.setCommo_id(rs.getInt(COLUMN_COMMO_ID));
                temp.setSupply_id(rs.getInt(COLUMN_SUPPLY_ID));
                HQ_PLATOON.add(temp);
            }
            for (HQPlatoon temp : HQ_PLATOON) {
                System.out.println("ID= " + temp.getHq_platoon_id() + "CO ID= " + temp.getCo_id() + "XO ID= "
                        + temp.getXo_id() + "1SG ID= " + temp.getFsg_id() + "Medic ID= " + temp.getMedic_id()
                        + "RTO ID= " + temp.getRto_id() + "NBC NCO ID= " + temp.getNbc_id() + "Commo NCO ID= "
                        + temp.getCommo_id() + "Supply NCO ID= " + temp.getSupply_id());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing ResultsSet: " + e.getMessage());
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing Statement: " + e.getMessage());
            }
        }
    }

}
