package com.uh.rachel.util.tableClasses;

public class emergencyContactTable {
    int customerNumber;
    String emergencyFirstName;
    String emergencyLastName;
    String emergencyPhone;
    String relationship;

    public emergencyContactTable() {

    }

    public emergencyContactTable(int customerNumber, String emergencyFirstName, String emergencyLastName, String emergencyPhone, String relationship) {
        this.customerNumber = customerNumber;
        this.emergencyFirstName = emergencyFirstName;
        this.emergencyLastName = emergencyLastName;
        this.emergencyPhone = emergencyPhone;
        this.relationship = relationship;
    }

    public emergencyContactTable(String emergencyFirstName, String emergencyLastName, String emergencyPhone, String relationship) {
        this.emergencyFirstName = emergencyFirstName;
        this.emergencyLastName = emergencyLastName;
        this.emergencyPhone = emergencyPhone;
        this.relationship = relationship;
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
