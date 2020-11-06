package com.uh.rachel.util.tableClasses;

public class serviceAppointmentAssociativeTable {
    int serviceNumber;
    int appointmentNumber;

    public serviceAppointmentAssociativeTable(){}

    public serviceAppointmentAssociativeTable(int serviceNumber, int appointmentNumber){
        this.serviceNumber = serviceNumber;
        this.appointmentNumber = appointmentNumber;
    }

    public int getServiceNumber() { return serviceNumber; }
    public void setServiceNumber(int serviceNumber) { this.serviceNumber = serviceNumber; }

    public int getAppointmentNumber() { return appointmentNumber; }
    public void setAppointmentNumber(int appointmentNumber) { this.appointmentNumber = appointmentNumber; }
}
