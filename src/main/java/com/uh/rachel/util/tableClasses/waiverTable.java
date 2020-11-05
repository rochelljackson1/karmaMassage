package com.uh.rachel.util.tableClasses;

public class waiverTable {
    int customerNumber;
    String signiture;
    String date;
    boolean acknowledgment;

    public waiverTable() {

    }

    public waiverTable(int customerNumber, String signiture, String date, boolean acknowledgment) {
        this.customerNumber = customerNumber;
        this.signiture = signiture;
        this.date = date;
        this.acknowledgment = acknowledgment;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getSigniture() {
        return signiture;
    }

    public void setSigniture(String signiture) {
        this.signiture = signiture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isAcknowledgment() {
        return acknowledgment;
    }

    public void setAcknowledgment(boolean acknowledgment) {
        this.acknowledgment = acknowledgment;
    }
}
