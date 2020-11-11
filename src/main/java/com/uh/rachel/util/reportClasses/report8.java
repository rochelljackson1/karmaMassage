package com.uh.rachel.util.reportClasses;

import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.companyClientHistoryTable;
import com.uh.rachel.util.tableClasses.existingConditionsMedicationsTable;
import com.uh.rachel.util.tableClasses.doctorTable;
import com.uh.rachel.util.tableClasses.emergencyContactTable;

public class report8 {
    customerTable customerPackage;
    companyClientHistoryTable companyClientHistoryPackage;
    existingConditionsMedicationsTable medicationsPackage;
    doctorTable doctorPackage;
    emergencyContactTable emergencyPackage;

    public report8(customerTable customerPackage, companyClientHistoryTable companyClientHistoryPackage, existingConditionsMedicationsTable medicationsPackage, doctorTable doctorPackage, emergencyContactTable emergencyPackage) {
        this.customerPackage = customerPackage;
        this.companyClientHistoryPackage = companyClientHistoryPackage;
        this.medicationsPackage = medicationsPackage;
        this.doctorPackage = doctorPackage;
        this.emergencyPackage = emergencyPackage;
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

    public existingConditionsMedicationsTable getMedicationsPackage() {
        return medicationsPackage;
    }

    public void setMedicationsPackage(existingConditionsMedicationsTable medicationsPackage) {
        this.medicationsPackage = medicationsPackage;
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
}
