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

    public servicesTable(int serviceNumber, String serviceDescription) {
        this.serviceNumber = serviceNumber;
        this.serviceDescription = serviceDescription;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }
}
