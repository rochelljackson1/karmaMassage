package com.uh.rachel.util.tableClasses;

public class existingConditionsRespiratoryTable {
    int customerNumber;
    boolean shortnessOfBreath;
    boolean chronicCough;
    boolean bronchitis;
    boolean emphysema;
    boolean asthma;

    public existingConditionsRespiratoryTable() {
    }

    public existingConditionsRespiratoryTable(int customerNumber, boolean shortnessOfBreath, boolean chronicCough, boolean bronchitis, boolean asthma) {
        this.customerNumber = customerNumber;
        this.shortnessOfBreath = shortnessOfBreath;
        this.chronicCough = chronicCough;
        this.bronchitis = bronchitis;
        this.asthma = asthma;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(boolean shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public boolean isChronicCough() {
        return chronicCough;
    }

    public void setChronicCough(boolean chronicCough) {
        this.chronicCough = chronicCough;
    }

    public boolean isBronchitis() {
        return bronchitis;
    }

    public void setBronchitis(boolean bronchitis) {
        this.bronchitis = bronchitis;
    }

    public boolean isAsthma() {
        return asthma;
    }

    public void setAsthma(boolean asthma) {
        this.asthma = asthma;
    }

    public boolean isEmphysema() {
        return emphysema;
    }

    public void setEmphysema(boolean emphysema) {
        this.emphysema = emphysema;
    }
}
