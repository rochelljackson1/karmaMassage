package com.uh.rachel.util.tableClasses;

public class servicesTable {

    int serviceNumber;
    String serviceDescription;
    double price;
    Boolean status;
    Boolean discount;

    public servicesTable(){}

    public servicesTable(int serviceNumber, String serviceDescription, double price, Boolean status, Boolean discount){
       this.serviceNumber = serviceNumber;
        this.serviceDescription = serviceDescription;
        this.price = price;
        this.status = status;
        this.discount = discount;
    }
}

