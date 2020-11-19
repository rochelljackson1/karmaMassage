package com.uh.rachel.util.tableClasses;

public class appointmentsTable {
        String appointmentDateTime;
        int appointmentNumber;
        int customerNumber;
        int serviceNumber;
        int packageNumber;
        int addOnNumber;
        double originalFullPrice;
        String dateCancelled;
        String timeCancelled;
        double actualPricePaid;
        String defaultPayment;
        String cardNumberType;
        String cardNumber;
        int staff_number;
        String cancelledDateTime;

        public appointmentsTable() {

        }

    public appointmentsTable(int appointmentNumber, int customerNumber, int serviceNumber, int packageNumber, int addOnNumber, double originalFullPrice, String dateCancelled, String timeCancelled, double actualPricePaid, String defaultPayment, String cardNumberType, String cardNumber, int staff_number, String cancelledDateTime, String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
        this.appointmentNumber = appointmentNumber;
        this.customerNumber = customerNumber;
        this.serviceNumber = serviceNumber;
        this.packageNumber = packageNumber;
        this.addOnNumber = addOnNumber;
        this.originalFullPrice = originalFullPrice;
        this.dateCancelled = dateCancelled;
        this.timeCancelled = timeCancelled;
        this.actualPricePaid = actualPricePaid;
        this.defaultPayment = defaultPayment;
        this.cardNumberType = cardNumberType;
        this.cardNumber = cardNumber;
        this.staff_number = staff_number;
        this.cancelledDateTime = cancelledDateTime;
    }

    public appointmentsTable(int appointmentNumber, int customerNumber, int serviceNumber, int packageNumber, int addOnNumber, String appointmentDateTime, double originalFullPrice, String dateCancelled, String timeCancelled, double actualPricePaid, String defaultPayment, String cardNumberType, String cardNumber, int staff_number) {
            this.appointmentDateTime = appointmentDateTime;
            this.customerNumber = customerNumber;
            this.appointmentNumber = appointmentNumber;
            this.serviceNumber = serviceNumber;
            this.packageNumber = packageNumber;
            this.addOnNumber = addOnNumber;
            this.originalFullPrice = originalFullPrice;
            this.dateCancelled = dateCancelled;
            this.timeCancelled = timeCancelled;
            this.actualPricePaid = actualPricePaid;
            this.defaultPayment = defaultPayment;
            this.cardNumberType = cardNumberType;
            this.cardNumber = cardNumber;
            this.staff_number = staff_number;
        }

    public appointmentsTable(int customerNumber, String appointmentDateTime, int addOnNumber) {
            this.customerNumber = customerNumber;
            this.appointmentDateTime = appointmentDateTime;
            this.addOnNumber = addOnNumber;

    }

    public appointmentsTable(int customerNumber, int appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
        this.customerNumber = customerNumber;
    }

    //Report16
    public appointmentsTable(int customerNumber, String appointmentDateTime, int packageNumber, int addOnNumber, double actualPricePaid) {
            this.customerNumber = customerNumber;
            this.appointmentDateTime = appointmentDateTime;
            this.packageNumber = packageNumber;
            this.addOnNumber = addOnNumber;
            this.actualPricePaid = actualPricePaid;
    }

    public appointmentsTable(String appointmentDateTime, int customerNumber, int packageNumber, int serviceNumber, int addOnNumber){
            this.appointmentDateTime = appointmentDateTime;
            this.customerNumber = customerNumber;
            this.packageNumber = packageNumber;
            this.serviceNumber = serviceNumber;
            this.addOnNumber = addOnNumber;
    }

    public int getAppointmentNumber() { return appointmentNumber; }
    public void setAppointmentNumber(int appointmentNumber) { this.appointmentNumber = appointmentNumber; }

    public int getCustomerNumber() { return customerNumber; }
    public void setCustomerNumber(int customerNumber) { this.customerNumber = customerNumber; }

    public int getServiceNumber() { return serviceNumber; }
    public void setServiceNumber(int serviceNumber) { this.serviceNumber = serviceNumber; }

    public int getPackageNumber() { return packageNumber; }
    public void setPackageNumber(int packageNumber) { this.packageNumber = packageNumber; }

    public int getAddOnNumber() { return addOnNumber; }
    public void setAddOnNumber(int addOnNumber) { this.addOnNumber = addOnNumber; }

    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public double getOriginalFullPrice() { return originalFullPrice; }
    public void setOriginalFullPrice(double originalFullPrice) { this.originalFullPrice = originalFullPrice; }

    public String getDateCancelled() { return dateCancelled; }
    public void setDateCancelled(String dateCancelled) { this.dateCancelled = dateCancelled; }

    public String getTimeCancelled() { return timeCancelled; }
    public void setTimeCancelled(String timeCancelled) { this.timeCancelled = timeCancelled; }

    public double getActualPricePaid() { return actualPricePaid; }
    public void setActualPricePaid(double actualPricePaid) { this.actualPricePaid = actualPricePaid; }

    public String getDefaultPayment() { return defaultPayment; }
    public void setDefaultPayment(String defaultPayment) { this.defaultPayment = defaultPayment; }

    public String getCardNumberType() { return cardNumberType; }
    public void setCardNumberType(String cardNumberType) { this.cardNumberType = cardNumberType; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public int getStaff_number() { return staff_number; }
    public void setStaff_number(int staff_number) { this.staff_number = staff_number; }

    public appointmentsTable(int customerNumber, int addOnNumber, String appointmentDateTime) {
        this.customerNumber = customerNumber;
        this.addOnNumber = addOnNumber;
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getCancelledDateTime() {
        return cancelledDateTime;
    }

    public void setCancelledDateTime(String cancelledDateTime) {
        this.cancelledDateTime = cancelledDateTime;
    }
}
