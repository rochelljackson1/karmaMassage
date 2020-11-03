package com.uh.rachel.util.tableClasses;

public class companyClientHistoryTable {
    int customerNumber;
    boolean currentClient;

    public companyClientHistoryTable() {
    }

    public companyClientHistoryTable(int customerNumber, boolean currentClient) {
        this.customerNumber = customerNumber;
        this.currentClient = currentClient;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(boolean currentClient) {
        this.currentClient = currentClient;
    }
}
