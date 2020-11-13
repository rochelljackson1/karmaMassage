package com.uh.rachel.util.tableClasses;

public class existingConditionsFamilyHistoryTable {
    int customerNumber;
    boolean respiratoryConditions;
    boolean cardiovascularConditions;

    public existingConditionsFamilyHistoryTable() {
    }

    public existingConditionsFamilyHistoryTable(int customerNumber, boolean respiratoryConditions, boolean cardiovascularConditions) {
        this.customerNumber = customerNumber;
        this.respiratoryConditions = respiratoryConditions;
        this.cardiovascularConditions = cardiovascularConditions;
    }

    public existingConditionsFamilyHistoryTable(boolean cardiovascularConditions) {
        this.cardiovascularConditions = cardiovascularConditions;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isRespiratoryConditions() {
        return respiratoryConditions;
    }

    public void setRespiratoryConditions(boolean respiratoryConditions) {
        this.respiratoryConditions = respiratoryConditions;
    }

    public boolean isCardiovascularConditions() {
        return cardiovascularConditions;
    }

    public void setCardiovascularConditions(boolean cardiovascularConditions) {
        this.cardiovascularConditions = cardiovascularConditions;
    }
}
