package com.uh.rachel.util.tableClasses;

public class addOnsAppointmentAssociativeTable {
    int addOnNumner;
    int appointmentNumber;


    public addOnsAppointmentAssociativeTable() {
    }

    public addOnsAppointmentAssociativeTable(int addOnNumner, int appointmentNumber) {
        this.addOnNumner = addOnNumner;
        this.appointmentNumber = appointmentNumber;
    }

    public int getAddOnNumner() { return addOnNumner; }
    public void setAddOnNumner(int addOnNumner) { this.addOnNumner = addOnNumner; }

    public int getAppointmentNumber() { return appointmentNumber; }
    public void setAppointmentNumber(int appointmentNumber) { this.appointmentNumber = appointmentNumber; }
}