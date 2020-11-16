package com.uh.rachel.util.tableClasses;

public class emergencyContactTable {
    int customerNumber;
    String emergencyFirstName;
    String emergencyLastName;
    String emergencyPhone;
    String relationship;

    public emergencyContactTable() {

    }

    public emergencyContactTable(int customerNumber, String emergencyFirstName, String emergencyLastName, String relationship, String emergencyPhone) {
        this.customerNumber = customerNumber;
        this.emergencyFirstName = emergencyFirstName;
        this.emergencyLastName = emergencyLastName;
        this.relationship = relationship;
        this.emergencyPhone = emergencyPhone;
    }

    public emergencyContactTable(String emergencyFirstName, String emergencyLastName, String relationship, String emergencyPhone) {
        this.emergencyFirstName = emergencyFirstName;
        this.emergencyLastName = emergencyLastName;
        this.relationship = relationship;
        this.emergencyPhone = emergencyPhone;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getEmergencyFirstName() {
        return emergencyFirstName;
    }

    public void setEmergencyFirstName(String emergencyFirstName) {
        this.emergencyFirstName = emergencyFirstName;
    }

    public String getEmergencyLastName() {
        return emergencyLastName;
    }

    public void setEmergencyLastName(String emergencyLastName) {
        this.emergencyLastName = emergencyLastName;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
