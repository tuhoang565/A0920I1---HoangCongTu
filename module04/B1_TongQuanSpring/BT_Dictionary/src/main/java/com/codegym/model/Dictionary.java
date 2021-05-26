package com.codegym.model;

public class Dictionary {
    private int id;
    private String vietnamese;

    public Dictionary() {
    }

    public Dictionary(int id, String vietnamese) {
        this.id = id;
        this.vietnamese = vietnamese;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

}
