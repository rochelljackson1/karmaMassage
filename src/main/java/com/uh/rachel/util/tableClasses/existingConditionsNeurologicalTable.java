package com.uh.rachel.util.tableClasses;

public class existingConditionsNeurologicalTable {
    int customerNumber;
    boolean tingling;
    boolean stabbingPain;
    boolean parkinsons;
    boolean numbness;
    boolean multipleSclerosis;
    boolean herniatedDisc;
    boolean cerebralPaisy;
    boolean burning;

    public existingConditionsNeurologicalTable() {
    }

    public existingConditionsNeurologicalTable(int customerNumber, boolean tingling, boolean stabbingPain, boolean parkinsons, boolean numbness, boolean multipleSclerosis, boolean herniatedDisc, boolean cerebralPaisy, boolean burning) {
        this.customerNumber = customerNumber;
        this.tingling = tingling;
        this.stabbingPain = stabbingPain;
        this.parkinsons = parkinsons;
        this.numbness = numbness;
        this.multipleSclerosis = multipleSclerosis;
        this.herniatedDisc = herniatedDisc;
        this.cerebralPaisy = cerebralPaisy;
        this.burning = burning;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isTingling() {
        return tingling;
    }

    public void setTingling(boolean tingling) {
        this.tingling = tingling;
    }

    public boolean isStabbingPain() {
        return stabbingPain;
    }

    public void setStabbingPain(boolean stabbingPain) {
        this.stabbingPain = stabbingPain;
    }

    public boolean isParkinsons() {
        return parkinsons;
    }

    public void setParkinsons(boolean parkinsons) {
        this.parkinsons = parkinsons;
    }

    public boolean isNumbness() {
        return numbness;
    }

    public void setNumbness(boolean numbness) {
        this.numbness = numbness;
    }

    public boolean isMultipleSclerosis() {
        return multipleSclerosis;
    }

    public void setMultipleSclerosis(boolean multipleSclerosis) {
        this.multipleSclerosis = multipleSclerosis;
    }

    public boolean isHerniatedDisc() {
        return herniatedDisc;
    }

    public void setHerniatedDisc(boolean herniatedDisc) {
        this.herniatedDisc = herniatedDisc;
    }

    public boolean isCerebralPaisy() {
        return cerebralPaisy;
    }

    public void setCerebralPaisy(boolean cerebralPaisy) {
        this.cerebralPaisy = cerebralPaisy;
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(boolean burning) {
        this.burning = burning;
    }
}
