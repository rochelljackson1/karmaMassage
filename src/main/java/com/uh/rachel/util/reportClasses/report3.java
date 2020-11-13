package com.uh.rachel.util.reportClasses;

import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.companyClientHistoryTable;

public class report3 {
    customerTable customerPackage;
    companyClientHistoryTable companyClientHistoryPackage;

    public report3(customerTable customerPackage, companyClientHistoryTable companyClientHistoryPackage) {
        this.customerPackage = customerPackage;
        this.companyClientHistoryPackage = companyClientHistoryPackage;
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
}
