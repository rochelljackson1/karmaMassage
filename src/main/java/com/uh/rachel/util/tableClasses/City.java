package com.uh.rachel.util.tableClasses;


public class City {

    String cityName;
    String internationalCity;


    public City() {

    }

    public City(String cityName, String internationalCity) {
        this.cityName = cityName;
        this.internationalCity = internationalCity;


    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getInternationalCity() {
        return internationalCity;
    }

    public void setInternationalCity(String internationalCity) {
        this.internationalCity = internationalCity;
    }



}
