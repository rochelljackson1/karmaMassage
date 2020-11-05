package com.uh.rachel.util.tableClasses;

public class Country {
    int id;
    String countryName;



    public Country() {

    }

    public Country(int id, String countryName) {
        this.id = id;
        this.countryName = countryName;



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

   }
