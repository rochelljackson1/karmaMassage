package com.uh.rachel.util.tableClasses;

public class Location {
    int locationNumber;
    int customerNumber;
    boolean inBound;
    boolean outBound;




    public Location() {

    }

    public Location(int locationNumber, int customerNumber, boolean inBound, boolean outBound) {
        this.locationNumber = locationNumber;
        this.customerNumber = customerNumber;
        this.inBound = inBound;
        this.outBound = outBound;
    }


    public int getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(int locationNumber) {
        this.locationNumber = locationNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean getInBound() {
        return inBound;
    }

    public void setInBound(boolean inBound) {
        this.inBound = inBound;
    }

    public boolean getOutBound() {
        return outBound;
    }

    public void setOutBound(boolean outBound) {
        this.outBound = outBound;
    }

}
