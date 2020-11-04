package com.uh.rachel.util.tableClasses;

public class appointmentsTable {

        int appointmentNumber;
        int customerNumber;
        int serviceNumber;
        int packageNumber;
        int addOnNumber;
        String scheduledDate;
        String scheduledTime;
        double originalFullPrice;
        String dateCancelled;
        String timeCancelled;
        double actualPricePaid;
        String defaultPayment;
        String cardNumberType;
        String cardNumber;
        int staff_number;

        public appointmentsTable() {

        }

        public appointmentsTable(int customerNumber, int appointmentNumber, int serviceNumber, int packageNumber, int addOnNumber, String scheduledDate, String scheduledTime, double originalFullPrice, String dateCancelled, String timeCancelled, double actualPricePaid, String defaultPayment, String cardNumberType, String cardNumber, int staff_number) {
            this.customerNumber = customerNumber;
            this.appointmentNumber = appointmentNumber;
            this.serviceNumber = serviceNumber;
            this.packageNumber = packageNumber;
            this.addOnNumber = addOnNumber;
            this.scheduledDate = scheduledDate;
            this.scheduledTime = scheduledTime;
            this.originalFullPrice = originalFullPrice;
            this.dateCancelled = dateCancelled;
            this.timeCancelled = timeCancelled;
            this.actualPricePaid = actualPricePaid;
            this.defaultPayment = defaultPayment;
            this.cardNumberType = cardNumberType;
            this.cardNumber = cardNumber;
            this.staff_number = staff_number;
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

    public String getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(String scheduledDate) { this.scheduledDate = scheduledDate; }

    public String getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(String scheduledTime) { this.scheduledTime = scheduledTime; }

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
}


