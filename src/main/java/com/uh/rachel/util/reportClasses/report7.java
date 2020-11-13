package com.uh.rachel.util.reportClasses;

import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.companyClientHistoryTable;
import com.uh.rachel.util.tableClasses.existingConditionsMedicationsTable;
import com.uh.rachel.util.tableClasses.reasonForMassageTable;
import com.uh.rachel.util.tableClasses.existingConditionsMisTable;

public class report7 {

    customerTable customerPackage;
    companyClientHistoryTable companyClientHistoryPackage;
    existingConditionsMedicationsTable medPackage;
    reasonForMassageTable reasonPackage;
    existingConditionsMisTable misPackage;

    public report7(customerTable customerPackage, companyClientHistoryTable companyClientHistoryPackage, existingConditionsMedicationsTable medPackage, reasonForMassageTable reasonPackage, existingConditionsMisTable misPackage) {
        this.customerPackage = customerPackage;
        this.companyClientHistoryPackage = companyClientHistoryPackage;
        this.medPackage = medPackage;
        this.reasonPackage = reasonPackage;
        this.misPackage = misPackage;
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

    public existingConditionsMedicationsTable getMedPackage() {
        return medPackage;
    }

    public void setMedPackage(existingConditionsMedicationsTable medPackage) {
        this.medPackage = medPackage;
    }

    public reasonForMassageTable getReasonPackage() {
        return reasonPackage;
    }

    public void setReasonPackage(reasonForMassageTable reasonPackage) {
        this.reasonPackage = reasonPackage;
    }

    public existingConditionsMisTable getMisPackage() {
        return misPackage;
    }

    public void setMisPackage(existingConditionsMisTable misPackage) {
        this.misPackage = misPackage;
    }
}
