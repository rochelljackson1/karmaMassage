package com.uh.rachel.util.tableClasses;

public class existingConditionsWomenTable {
    int customerNumber;
    boolean pregnant;
    boolean gynecologicalConditions;

    public existingConditionsWomenTable() {
    }

    public existingConditionsWomenTable(int customerNumber, boolean pregnant, boolean gynecologicalConditions) {
        this.customerNumber = customerNumber;
        this.pregnant = pregnant;
        this.gynecologicalConditions = gynecologicalConditions;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public boolean isGynecologicalConditions() {
        return gynecologicalConditions;
    }

    public void setGynecologicalConditions(boolean gynecologicalConditions) {
        this.gynecologicalConditions = gynecologicalConditions;
    }
}
