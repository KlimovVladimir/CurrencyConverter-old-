package com.example.currencyconverter.items;

public class Currency {
    private long ID;
    private long NumCode;
    private String CharCode;
    private int Nominal;
    private String Name;
    private float Value;


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

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
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

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        Value = value;
    }
}
