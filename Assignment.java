package com.CS470Project.model;

public class Assignment {

    private int m_id;
    private String current;
    private String projected;
    private String prev_assg;

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getProjected() {
        return projected;
    }

    public void setProjected(String projected) {
        this.projected = projected;
    }

    public String getPrev_assg() {
        return prev_assg;
    }

    public void setPrev_assg(String prev_assg) {
        this.prev_assg = prev_assg;
    }

}
