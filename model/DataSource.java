package com.CS470Project.model;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {


    public static final String DB_NAME = "unit.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:c:\\databases\\ " + DB_NAME;

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
            //System.out.println("Connected to DB");
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


}
