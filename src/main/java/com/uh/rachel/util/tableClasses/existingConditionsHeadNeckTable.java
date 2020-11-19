package com.uh.rachel.util.tableClasses;

public class existingConditionsHeadNeckTable {
    int customerNumber;
    boolean visionProblems;
    boolean visionLoss;
    boolean sinusProblems;
    boolean migraines;
    boolean jawPain;
    boolean hearingLoss;
    boolean headaches;
    boolean earProblems;

    public existingConditionsHeadNeckTable() {
    }

    public existingConditionsHeadNeckTable(int customerNumber, boolean visionProblems, boolean visionLoss, boolean sinusProblems, boolean migraines, boolean jawPain, boolean hearingLoss, boolean headaches, boolean earProblems) {
        this.customerNumber = customerNumber;
        this.visionProblems = visionProblems;
        this.visionLoss = visionLoss;
        this.sinusProblems = sinusProblems;
        this.migraines = migraines;
        this.jawPain = jawPain;
        this.hearingLoss = hearingLoss;
        this.headaches = headaches;
        this.earProblems = earProblems;
    }



    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isVisionProblems() {
        return visionProblems;
    }

    public void setVisionProblems(boolean visionProblems) {
        this.visionProblems = visionProblems;
    }

    public boolean isVisionLoss() {
        return visionLoss;
    }

    public void setVisionLoss(boolean visionLoss) {
        this.visionLoss = visionLoss;
    }

    public boolean isSinusProblems() {
        return sinusProblems;
    }

    public void setSinusProblems(boolean sinusProblems) {
        this.sinusProblems = sinusProblems;
    }

    public boolean isMigraines() {
        return migraines;
    }

    public void setMigraines(boolean migraines) {
        this.migraines = migraines;
    }

    public boolean isJawPain() {
        return jawPain;
    }

    public void setJawPain(boolean jawPain) {
        this.jawPain = jawPain;
    }

    public boolean isHearingLoss() {
        return hearingLoss;
    }

    public void setHearingLoss(boolean hearingLoss) {
        this.hearingLoss = hearingLoss;
    }

    public boolean isHeadaches() {
        return headaches;
    }

    public void setHeadaches(boolean headaches) {
        this.headaches = headaches;
    }

    public boolean isEarProblems() {
        return earProblems;
    }

    public void setEarProblems(boolean earProblems) {
        this.earProblems = earProblems;
    }
}
