package com.simplilearn.zumbamanagement.model;

public class Batch {
    private int id;
    private String session;

    public Batch(String session) {
        this.session = session;
    }
    public Batch(int id, String session) {
        this.id = id;
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
