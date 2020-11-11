package com.uh.rachel.util.tableClasses;

public class Address {
    int customerNumber;
    String street;
    String cityName;
    String stateName;
    String zipCode;
    String countryName;


    public Address() {

    }

    public Address(int customerNumber, String street, String cityName, String stateName, String zipCode, String countryName) {
        this.customerNumber = customerNumber;
        this.street = street;
        this.cityName = cityName;
        this.stateName = stateName;
        this.zipCode = zipCode;
        this.countryName = countryName;

    }


    public Address(String cityName, String stateName, String countryName) {
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;

    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


}
