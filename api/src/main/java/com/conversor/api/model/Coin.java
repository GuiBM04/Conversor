package com.conversor.api.model;

public class Coin {

    private int id;
    private String name;
    private double value;

    public Coin() {
    }

    public Coin(int id, String name, double value) {
        setId(this.id);
        setName(this.name);
        setValue(this.value);
    }

    public int getId() {
        return id;
    }

    public void setId(int number) {
        this.id = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


}
