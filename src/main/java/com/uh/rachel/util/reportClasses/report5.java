package com.uh.rachel.util.reportClasses;

import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.companyClientHistoryTable;
import com.uh.rachel.util.tableClasses.existingConditionsFamilyHistoryTable;
import com.uh.rachel.util.tableClasses.reasonForMassageTable;
import com.uh.rachel.util.tableClasses.existingConditionsCardiovascularTable;


public class report5 {
    customerTable customerPackage;
    companyClientHistoryTable companyClientHistoryPackage;
    existingConditionsFamilyHistoryTable familyPackage;
    reasonForMassageTable reasonPackage;
    existingConditionsCardiovascularTable cardioPackage;

    public report5(customerTable customerPackage, existingConditionsFamilyHistoryTable familyPackage, reasonForMassageTable reasonPackage, companyClientHistoryTable companyClientHistoryPackage, existingConditionsCardiovascularTable cardioPackage) {
        this.customerPackage = customerPackage;
        this.companyClientHistoryPackage = companyClientHistoryPackage;
        this.familyPackage = familyPackage;
        this.reasonPackage = reasonPackage;
        this.cardioPackage = cardioPackage;
    }

    public customerTable getCustomerPackage() {
        return customerPackage;
    }

    public void setCustomerPackage(customerTable customerPackage) {
        this.customerPackage = customerPackage;
    }

    public companyClientHistoryTable getCompanyClientHistoryPackage() {
        return companyClientHistoryPackage;
    }

    public void setCompanyClientHistoryPackage(companyClientHistoryTable companyClientHistoryPackage) {
        this.companyClientHistoryPackage = companyClientHistoryPackage;
    }

    public existingConditionsFamilyHistoryTable getFamilyPackage() {
        return familyPackage;
    }

    public void setFamilyPackage(existingConditionsFamilyHistoryTable familyPackage) {
        this.familyPackage = familyPackage;
    }

    public reasonForMassageTable getReasonPackage() {
        return reasonPackage;
    }

    public void setReasonPackage(reasonForMassageTable reasonPackage) {
        this.reasonPackage = reasonPackage;
    }

    public existingConditionsCardiovascularTable getCardioPackage() {
        return cardioPackage;
    }

    public void setCardioPackage(existingConditionsCardiovascularTable cardioPackage) {
        this.cardioPackage = cardioPackage;
    }
}


