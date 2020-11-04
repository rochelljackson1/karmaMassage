package com.uh.rachel.util.tableClasses;

public class addOnsTable {
    int addOnNumber;
    double price;
    String addOnDescription;
    int customerNumber;

    public addOnsTable() {
    }

    public addOnsTable(int addOnNumber, double price, String addOnDescription, int customerNumber){
        this.addOnNumber = addOnNumber;
        this.price = price;
        this.addOnDescription = addOnDescription;
        this.customerNumber = customerNumber;
    }

    public int getAddOnNumber() { return addOnNumber; }
    public void setAddOnNumber(int addOnNumber) { this.addOnNumber = addOnNumber; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getAddOnDescription() { return addOnDescription; }
    public void setAddOnDescription(String addOnDescription) { this.addOnDescription = addOnDescription; }

    public int getCustomerNumber() { return customerNumber; }
    public void setCustomerNumber(int customerNumber) { this.customerNumber = customerNumber; }
}