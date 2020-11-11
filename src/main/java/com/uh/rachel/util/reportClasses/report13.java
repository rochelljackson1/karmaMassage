package com.uh.rachel.util.reportClasses;

import com.uh.rachel.util.tableClasses.companyClientHistoryTable;
import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.existingConditionsInfectiousTable;
import com.uh.rachel.util.tableClasses.existingConditionsRespiratoryTable;

public class report13 {
    customerTable customerPackage;
    existingConditionsInfectiousTable infectiousPackage;
    existingConditionsRespiratoryTable respiratoryPackage;
    companyClientHistoryTable companyClientHistoryPackage;

    public report13(customerTable customerPackage, existingConditionsInfectiousTable infectiousPackage, existingConditionsRespiratoryTable respiratoryPackage, companyClientHistoryTable companyClientHistoryPackage) {
        this.customerPackage = customerPackage;
        this.infectiousPackage = infectiousPackage;
        this.respiratoryPackage = respiratoryPackage;
        this.companyClientHistoryPackage = companyClientHistoryPackage;
    }

    public customerTable getCustomerPackage() {
        return customerPackage;
    }

    public void setCustomerPackage(customerTable customerPackage) {
        this.customerPackage = customerPackage;
    }

    public existingConditionsInfectiousTable getInfectiousPackage() {
        return infectiousPackage;
    }

    public void setInfectiousPackage(existingConditionsInfectiousTable infectiousPackage) {
        this.infectiousPackage = infectiousPackage;
    }

    public existingConditionsRespiratoryTable getRespiratoryPackage() {
        return respiratoryPackage;
    }

    public void setRespiratoryPackage(existingConditionsRespiratoryTable respiratoryPackage) {
        this.respiratoryPackage = respiratoryPackage;
    }

    public companyClientHistoryTable getCompanyClientHistoryPackage() {
        return companyClientHistoryPackage;
    }

    public void setCompanyClientHistoryPackage(companyClientHistoryTable companyClientHistoryPackage) {
        this.companyClientHistoryPackage = companyClientHistoryPackage;
    }
}
