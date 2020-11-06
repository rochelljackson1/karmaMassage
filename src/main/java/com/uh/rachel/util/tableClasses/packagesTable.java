package com.uh.rachel.util.tableClasses;

public class packagesTable {
    int packageNumber;
    int serviceNumber;
    String packageDescription;
    double price;
    boolean status;

    public packagesTable(){}

    public packagesTable(int packageNumber, int serviceNumber, String packageDescription, double price, boolean status){
        this.packageNumber = packageNumber;
        this.serviceNumber = serviceNumber;
        this.packageDescription = packageDescription;
        this.price = price;
        this.status = status;
    }

    public int getPackageNumber() { return packageNumber; }
    public void setPackageNumber(int packageNumber) { this.packageNumber = packageNumber; }

    public int getServiceNumber() { return serviceNumber; }
    public void setServiceNumber(int serviceNumber) { this.serviceNumber = serviceNumber; }

    public String getPackageDescription() { return packageDescription; }
    public void setPackageDescription(String packageDescription) { this.packageDescription = packageDescription; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

}
