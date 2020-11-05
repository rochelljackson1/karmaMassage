package com.uh.rachel.util.tableClasses;

public class existingConditionsInfectiousTable {
    int customerNumber;
    boolean skinConditions;
    boolean respiratoryConditions;
    boolean hiv;
    boolean herpes;
    boolean hepatitis;
    boolean altheletsFoot;

    public existingConditionsInfectiousTable() {
    }

    public existingConditionsInfectiousTable(int customerNumber, boolean skinConditions, boolean respiratoryConditions, boolean hiv, boolean herpes, boolean hepatitis, boolean altheletsFoot) {
        this.customerNumber = customerNumber;
        this.skinConditions = skinConditions;
        this.respiratoryConditions = respiratoryConditions;
        this.hiv = hiv;
        this.herpes = herpes;
        this.hepatitis = hepatitis;
        this.altheletsFoot = altheletsFoot;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isSkinConditions() {
        return skinConditions;
    }

    public void setSkinConditions(boolean skinConditions) {
        this.skinConditions = skinConditions;
    }

    public boolean isRespiratoryConditions() {
        return respiratoryConditions;
    }

    public void setRespiratoryConditions(boolean respiratoryConditions) {
        this.respiratoryConditions = respiratoryConditions;
    }

    public boolean isHiv() {
        return hiv;
    }

    public void setHiv(boolean hiv) {
        this.hiv = hiv;
    }

    public boolean isHerpes() {
        return herpes;
    }

    public void setHerpes(boolean herpes) {
        this.herpes = herpes;
    }

    public boolean isHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(boolean hepatitis) {
        this.hepatitis = hepatitis;
    }

    public boolean isAltheletsFoot() {
        return altheletsFoot;
    }

    public void setAltheletsFoot(boolean altheletsFoot) {
        this.altheletsFoot = altheletsFoot;
    }
}
