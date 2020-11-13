package com.uh.rachel.util.tableClasses;

public class reasonForMassageTable {
    int customerNumber;
    String pastTreatment;
    String treatmentGoal;
    String lengthOfTime;
    String cause;

    public reasonForMassageTable() {
    }

    public reasonForMassageTable(int customerNumber, String pastTreatment, String treatmentGoal, String lengthOfTime, String cause) {
        this.customerNumber = customerNumber;
        this.pastTreatment = pastTreatment;
        this.treatmentGoal = treatmentGoal;
        this.lengthOfTime = lengthOfTime;
        this.cause = cause;
    }

    public reasonForMassageTable(String cause) {
        this.cause = cause;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getPastTreatment() {
        return pastTreatment;
    }

    public void setPastTreatment(String pastTreatment) {
        this.pastTreatment = pastTreatment;
    }

    public String getTreatmentGoal() {
        return treatmentGoal;
    }

    public void setTreatmentGoal(String treatmentGoal) {
        this.treatmentGoal = treatmentGoal;
    }

    public String getLengthOfTime() {
        return lengthOfTime;
    }

    public void setLengthOfTime(String lengthOfTime) {
        this.lengthOfTime = lengthOfTime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
