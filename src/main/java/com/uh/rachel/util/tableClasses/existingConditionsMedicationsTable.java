package com.uh.rachel.util.tableClasses;

public class existingConditionsMedicationsTable {
    int customerNumber;
    String other;

    public existingConditionsMedicationsTable() {
    }

    public existingConditionsMedicationsTable(int customerNumber, String other) {
        this.customerNumber = customerNumber;
        this.other = other;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
