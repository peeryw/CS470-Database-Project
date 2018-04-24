package com.CS470Project.model;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static final String DB_NAME = "unit.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\willi\\Desktop" +
            "\\JavaPrograms\\Military Readiness\\" + DB_NAME;

    //constants for table names and columns
    public static final String TABLE_ASSIGNMENT = "assignment";
    public static final String COLUMN_M_ID = "m_id";
    public static final String COLUMN_CURRENT = "current";
    public static final String COLUMN_PROJECTED = "projected";
    public static final String COLUMN_PREV_ASSG = "prev_assgn";

    public static final String TABLE_COMPANY = "company";
    public static final String COLUMN_COMPANY_ID = "company_id";
    public static final String COLUMN_COMPANY_NAME = "company_name";

    public static final String TABLE_HQ_PLATOON = "hq_platoon";
    public static final String COLUMN_HQ_PLATOON_ID = "hq_platoon_id";
    public static final String COLUMN_CO_ID = "co_id";
    public static final String COLUMN_XO_ID = "xo_id";
    public static final String COLUMN_FSG_ID = "fsg_id";
    public static final String COLUMN_MEDIC_ID = "medic_id";
    public static final String COLUMN_RTO_ID = "rto_id";
    public static final String COLUMN_NBC_ID = "nbc_id";
    public static final String COLUMN_COMMO_ID = "commo_id";
    public static final String COLUMN_SUPPLY_ID = "supply_id";

    public static final String TABLE_PLATOON = "platoon";
    public static final String COLUMN_PLATOON_ID = "platoon_id";
    public static final String COLUMN_P_LEADER_ID = "p_leader_id";
    public static final String COLUMN_P_SERGEANT_ID = "p_sergeant_id";

    public static final String TABLE_SOLDIER = "soldier";
    public static final String COLUMN_M_NAME = "m_name";
    public static final String COLUMN_DOR = "dor";
    public static final String COLUMN_COMPONENT = "component";
    public static final String COLUMN_RANK = "rank";
    public static final String COLUMN_POSITION = "position";

    public static final String TABLE_SQUAD = "squad";
    public static final String COLUMN_SQUAD_ID = "squad_id";
    public static final String COLUMN_SQUAD_LEADER_ID = "squad_leader_id";

    public static final String TABLE_SQUAD_NORMAL = "squad_normal";
    public static final String COLUMN_TEAM_ID = "team_id";
    public static final String COLUMN_TEAM_LEADER_ID = "team_leader_id";
    public static final String COLUMN_AUTO_RIFLEMAN = "auto_rifleman_id";

    public static final String TABLE_SQUAD_WEAPONS = "squad_weapons";

    public static final String TABLE_USER = "user";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_PASSWORD = "user_password";

    public static final String TABLE_USER_ROLE = "user_role";
    public static final String COLUMN_USER_RIGHTS = "user_rights";
    public static final String COLUMN_USER_POSITION = "user_position";

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


    // this is a query test to make sure program is working
    //query soldiers
    public List<Soldier> querySoldiers() {
        Statement statement = null;
        ResultSet results = null;

        try {
            //DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection(CONNECTION_STRING);
            statement = conn.createStatement();
            results = statement.executeQuery("SELECT * FROM soldier" );
            List<Soldier> soldiers = new ArrayList<>();
            while (results.next()){
                Soldier soldier = new Soldier();
                soldier.setM_id(results.getInt(COLUMN_M_ID));
                soldier.setM_name(results.getString(COLUMN_M_NAME));
                soldier.setDor(results.getString(COLUMN_DOR));
                soldier.setComponent(results.getString(COLUMN_COMPONENT));
                soldier.setRank(results.getString(COLUMN_RANK));
                soldier.setPosition((results.getString(COLUMN_POSITION)));
                soldiers.add(soldier);
            }
            return soldiers;
        }catch (SQLException e){
            System.out.println("Query failed " + e.getMessage());
            return null;
        }finally{
            try{
                if(results != null){
                    results.close();
                }
            }catch(SQLException e){
                System.out.println("Error closing ResultsSet: " + e.getMessage());
            }
            try{
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                System.out.println("Error closing Statement: " + e.getMessage());
            }
        }

    }
}