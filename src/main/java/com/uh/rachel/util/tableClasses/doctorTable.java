package com.uh.rachel.util.tableClasses;

public class doctorTable {
    int customerNumber;
    int doctorNuber;
    String physicianFirstname;
    String PhysicianLastname;
    String physicianPhone;

    public doctorTable() {

    }

    public doctorTable(int customerNumber, int doctorNumber, String physicianFirstname, String physicianLastname, String physicianPhone) {
        this.customerNumber = customerNumber;
        this.doctorNuber = doctorNumber;
        this.physicianFirstname = physicianFirstname;
        this.PhysicianLastname = physicianLastname;
        this.physicianPhone = physicianPhone;
    }

    public doctorTable(String physicianLastname, String physicianPhone) {
        this.physicianPhone = physicianPhone;
        this.PhysicianLastname = physicianLastname;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getDoctorNuber() {
        return doctorNuber;
    }

    public void setDoctorNuber(int doctorNuber) {
        this.doctorNuber = doctorNuber;
    }

    public String getPhysicianFirstname() {
        return physicianFirstname;
    }

    public void setPhysicianFirstname(String physicianFirstname) {
        this.physicianFirstname = physicianFirstname;
    }

    public String getPhysicianLastname() {
        return PhysicianLastname;
    }

    public void setPhysicianLastname(String physicianLastname) {
        PhysicianLastname = physicianLastname;
    }

    public String getPhysicianPhone() {
        return physicianPhone;
    }

    public void setPhysicianPhone(String physicianPhone) {
        this.physicianPhone = physicianPhone;
    }
}
