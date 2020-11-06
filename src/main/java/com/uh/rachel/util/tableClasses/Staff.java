package com.uh.rachel.util.tableClasses;

public class Staff {
    int staff_Number;
    String tips;
    String date;
    String totalPTO;
    String revenueByStaff;



    public Staff() {

    }

    public Staff(int staff_Number, String tips, String date, String totalPTO, String revenueByStaff) {
        this.staff_Number = staff_Number;
        this.tips = tips;
        this.date = date;
        this.totalPTO = totalPTO;
        this.revenueByStaff = revenueByStaff;


    }

    public int getStaff_Number() {
        return staff_Number;
    }

    public void setStaff_Number(int staff_Number) {
        this.staff_Number = staff_Number;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalPTO() {
        return totalPTO;
    }

    public void setTotalPTO(String totalPTO) {
        this.totalPTO = totalPTO;
    }

    public String getRevenueByStaff() {
        return revenueByStaff;
    }

    public void setRevenueByStaff(String revenueByStaff) {
        this.revenueByStaff = revenueByStaff;
    }



}
