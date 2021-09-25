package com.example.currencyconverter.items;

public class Currency {
    private long ID;
    private long NumCode;
    private int Nominal;
    private String Name;
    private double Value;


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getNumCode() {
        return NumCode;
    }

    public void setNumCode(long numCode) {
        NumCode = numCode;
    }

    public int getNominal() {
        return Nominal;
    }

    public void setNominal(int nominal) {
        Nominal = nominal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }
}
