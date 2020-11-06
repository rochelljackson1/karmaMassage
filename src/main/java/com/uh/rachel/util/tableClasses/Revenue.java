package com.uh.rachel.util.tableClasses;

public class Revenue {
    String date;
    String revenueMonthlyActual;
    String revenueWeeklyActual;
    String revenueMonthlyFromCancellations;
    String potentialRevenueMonthlyFromScheduled;
    String revenueByStaff;


    public Revenue() {

    }

    public Revenue(String date, String revenueMonthlyActual, String revenueWeeklyActual, String revenueMonthlyFromCancellations, String potentialRevenueMonthlyFromScheduled, String revenueByStaff) {
        this.revenueByStaff = revenueByStaff;
        this.date = date;
        this.revenueMonthlyActual = revenueMonthlyActual;
        this.revenueWeeklyActual = revenueWeeklyActual;
        this.revenueMonthlyFromCancellations = revenueMonthlyFromCancellations;
        this.potentialRevenueMonthlyFromScheduled = potentialRevenueMonthlyFromScheduled;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRevenueMonthlyActual() {
        return revenueMonthlyActual;
    }

    public void setRevenueMonthlyActual(String revenueMonthlyActual) {
        this.revenueMonthlyActual = revenueMonthlyActual;
    }

    public String getRevenueWeeklyActual() {
        return revenueWeeklyActual;
    }

    public void setRevenueWeeklyActual(String revenueWeeklyActual) {
        this.revenueWeeklyActual = revenueWeeklyActual;
    }

    public String getRevenueMonthlyFromCancellations() {
        return revenueMonthlyFromCancellations;
    }

    public void setRevenueMonthlyFromCancellations(String revenueMonthlyFromCancellations) {
        this.revenueMonthlyFromCancellations = revenueMonthlyFromCancellations;
    }

    public String getPotentialRevenueMonthlyFromScheduled() {
        return potentialRevenueMonthlyFromScheduled;
    }

    public void setPotentialRevenueMonthlyFromScheduled(String potentialRevenueMonthlyFromScheduled) {
        this.potentialRevenueMonthlyFromScheduled = potentialRevenueMonthlyFromScheduled;
    }

    public String getRevenueByStaff() {
        return revenueByStaff;
    }

    public void setRevenueByStaff(String revenueByStaff) {
        this.revenueByStaff = revenueByStaff;
    }


    }

