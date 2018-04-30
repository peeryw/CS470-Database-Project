package com.CS470Project.model;

public class Platoon {

    private int platoon_id;
    private int p_leader_id;
    private int p_sergeant_id;
    private int rto_id;

    public int getPlatoon_id() {
        return platoon_id;
    }

    public void setPlatoon_id(int platoon_id) {
        this.platoon_id = platoon_id;
    }

    public int getP_leader_id() {
        return p_leader_id;
    }

    public void setP_leader_id(int p_leader_id) {
        this.p_leader_id = p_leader_id;
    }

    public int getP_sergeant_id() {
        return p_sergeant_id;
    }

    public void setP_sergeant_id(int p_sergeant_id) {
        this.p_sergeant_id = p_sergeant_id;
    }

    public int getRto_id() {
        return rto_id;
    }

    public void setRto_id(int rto_id) {
        this.rto_id = rto_id;
    }
}
