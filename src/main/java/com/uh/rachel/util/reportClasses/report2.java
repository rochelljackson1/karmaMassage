package com.uh.rachel.util.reportClasses;

import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.waiverTable;
import com.uh.rachel.util.tableClasses.doctorTable;
import com.uh.rachel.util.tableClasses.emergencyContactTable;
import com.uh.rachel.util.tableClasses.companyClientHistoryTable;

public class report2 {
    customerTable customerPackage;
    waiverTable waiverPackage;
    doctorTable doctorPackage;
    emergencyContactTable emergencyPackage;
    companyClientHistoryTable companyClientHistoryPackage;

    public report2(customerTable customerPackage, waiverTable waiverPackage, doctorTable doctorPackage, emergencyContactTable emergencyPackage, companyClientHistoryTable companyClientHistoryPackage) {
        this.customerPackage = customerPackage;
        this.waiverPackage = waiverPackage;
        this.doctorPackage = doctorPackage;
        this.emergencyPackage = emergencyPackage;
        this.companyClientHistoryPackage = companyClientHistoryPackage;
    }

    public customerTable getCustomerPackage() {
        return customerPackage;
    }

    public void setCustomerPackage(customerTable customerPackage) {
        this.customerPackage = customerPackage;
    }

    public waiverTable getWaiverPackage() {
        return waiverPackage;
    }

    public void setWaiverPackage(waiverTable waiverPackage) {
        this.waiverPackage = waiverPackage;
    }

    public doctorTable getDoctorPackage() {
        return doctorPackage;
    }

    public void setDoctorPackage(doctorTable doctorPackage) {
        this.doctorPackage = doctorPackage;
    }

    public emergencyContactTable getEmergencyPackage() {
        return emergencyPackage;
    }

    public void setEmergencyPackage(emergencyContactTable emergencyPackage) {
        this.emergencyPackage = emergencyPackage;
    }

    public companyClientHistoryTable getCompanyClientHistoryPackage() {
        return companyClientHistoryPackage;
    }

    public void setCompanyClientHistoryPackage(companyClientHistoryTable companyClientHistoryPackage) {
        this.companyClientHistoryPackage = companyClientHistoryPackage;
    }
}
