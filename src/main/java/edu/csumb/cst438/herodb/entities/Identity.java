package edu.csumb.cst438.herodb.entities;

public class Identity {
    private String name;

    public Identity (String name){
        this.name = name;
    }

    public String getName () {
        return this.name;
    }
}