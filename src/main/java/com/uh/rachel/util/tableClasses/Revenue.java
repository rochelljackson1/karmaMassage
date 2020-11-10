package com.uh.rachel.util.tableClasses;

public class Revenue {
    String date;
    Double revenueMonthlyActual;
    Double revenueWeeklyActual;
    Double revenueMonthlyFromCancellations;
    Double potentialRevenueMonthlyFromScheduled;
    Double revenueByStaff;


    public Revenue() {

    }

    public Revenue(String date, Double revenueMonthlyActual, Double revenueWeeklyActual, Double revenueMonthlyFromCancellations, Double potentialRevenueMonthlyFromScheduled, Double revenueByStaff) {
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

    public Double getRevenueMonthlyActual() {
        return revenueMonthlyActual;
    }

    public void setRevenueMonthlyActual(Double revenueMonthlyActual) {
        this.revenueMonthlyActual = revenueMonthlyActual;
    }

    public Double getRevenueWeeklyActual() {
        return revenueWeeklyActual;
    }

    public void setRevenueWeeklyActual(Double revenueWeeklyActual) {
        this.revenueWeeklyActual = revenueWeeklyActual;
    }

    public Double getRevenueMonthlyFromCancellations() {
        return revenueMonthlyFromCancellations;
    }

    public void setRevenueMonthlyFromCancellations(Double revenueMonthlyFromCancellations) {
        this.revenueMonthlyFromCancellations = revenueMonthlyFromCancellations;
    }

    public Double getPotentialRevenueMonthlyFromScheduled() {
        return potentialRevenueMonthlyFromScheduled;
    }

    public void setPotentialRevenueMonthlyFromScheduled(Double potentialRevenueMonthlyFromScheduled) {
        this.potentialRevenueMonthlyFromScheduled = potentialRevenueMonthlyFromScheduled;
    }

    public Double getRevenueByStaff() {
        return revenueByStaff;
    }

    public void setRevenueByStaff(Double revenueByStaff) {
        this.revenueByStaff = revenueByStaff;
    }


    }

