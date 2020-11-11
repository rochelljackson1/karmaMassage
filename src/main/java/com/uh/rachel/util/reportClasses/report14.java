package com.uh.rachel.util.reportClasses;

import com.uh.rachel.util.tableClasses.companyClientHistoryTable;
import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.existingConditionsInfectiousTable;
import com.uh.rachel.util.tableClasses.existingConditionsSkinTable;

public class report14 {
    customerTable customerPackage;
    existingConditionsInfectiousTable infectiousPackage;
    existingConditionsSkinTable skinPackage;
    companyClientHistoryTable companyClientHistoryPackage;

    public report14(customerTable customerPackage, existingConditionsInfectiousTable infectiousPackage, existingConditionsSkinTable skinPackage, companyClientHistoryTable companyClientHistoryPackage) {
        this.customerPackage = customerPackage;
        this.infectiousPackage = infectiousPackage;
        this.skinPackage = skinPackage;
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

    public existingConditionsSkinTable getSkinPackage() {
        return skinPackage;
    }

    public void setSkinPackage(existingConditionsSkinTable skinPackage) {
        this.skinPackage = skinPackage;
    }

    public companyClientHistoryTable getCompanyClientHistoryPackage() {
        return companyClientHistoryPackage;
    }

    public void setCompanyClientHistoryPackage(companyClientHistoryTable companyClientHistoryPackage) {
        this.companyClientHistoryPackage = companyClientHistoryPackage;
    }
}
