package com.uh.rachel.util.tableClasses;

public class PTO_Staff {
    int staffNumber;
    String maxPTO;
    String maxSickPTO;
    String maxMaternatyPTO;
    String maxEmergencyPTO;
    String totalPTO;


    public PTO_Staff() {

    }

    public PTO_Staff(int staffNumber, String maxPTO, String maxSickPTO, String maxMaternatyPTO, String maxEmergencyPTO, String totalPTO) {
        this.staffNumber = staffNumber;
        this.maxPTO = maxPTO;
        this.maxSickPTO = maxSickPTO;
        this.maxMaternatyPTO = maxMaternatyPTO;
        this.maxEmergencyPTO = maxEmergencyPTO;
        this.totalPTO = totalPTO;

    }

    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getMaxPTO() {
        return maxPTO;
    }

    public void setMaxPTO(String maxPTO) {
        this.maxPTO = maxPTO;
    }

    public String getMaxSickPTO() {
        return maxSickPTO;
    }

    public void setMaxSickPTO(String maxSickPTO) {
        this.maxSickPTO = maxSickPTO;
    }

    public String getMaxMaternatyPTO() {
        return maxMaternatyPTO;
    }

    public void setMaxMaternatyPTO(String maxMaternatyPTO) {
        this.maxSickPTO = maxMaternatyPTO;
    }

    public String getMaxEmergencyPTO() {
        return maxEmergencyPTO;
    }

    public void setMaxEmergencyPTO(String maxEmergencyPTO) {
        this.maxEmergencyPTO = maxEmergencyPTO;
    }

    public String getTotalPTO() {
        return totalPTO;
    }

    public void setTotalPTO(String totalPTO) {
        this.totalPTO = totalPTO;
    }


}
