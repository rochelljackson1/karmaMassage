package com.uh.rachel.util.reportClasses;

import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.companyClientHistoryTable;
import com.uh.rachel.util.tableClasses.existingConditionsFamilyHistoryTable;
import com.uh.rachel.util.tableClasses.existingConditionsRespiratoryTable;


public class report6 {
    customerTable customerPackage;
    existingConditionsFamilyHistoryTable familyPackage;
    existingConditionsRespiratoryTable respiratoryPackage;
    companyClientHistoryTable companyClientHistoryPackage;

    public report6(customerTable customerPackage, existingConditionsFamilyHistoryTable familyPackage, existingConditionsRespiratoryTable respiratoryPackage, companyClientHistoryTable companyClientHistoryPackage) {
        this.customerPackage = customerPackage;
        this.familyPackage = familyPackage;
        this.respiratoryPackage = respiratoryPackage;
        this.companyClientHistoryPackage = companyClientHistoryPackage;
    }

    public customerTable getCustomerPackage() {
        return customerPackage;
    }

    public void setCustomerPackage(customerTable customerPackage) {
        this.customerPackage = customerPackage;
    }

    public existingConditionsFamilyHistoryTable getFamilyPackage() {
        return familyPackage;
    }

    public void setFamilyPackage(existingConditionsFamilyHistoryTable familyPackage) {
        this.familyPackage = familyPackage;
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