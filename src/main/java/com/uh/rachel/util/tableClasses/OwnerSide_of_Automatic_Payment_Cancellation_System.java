package com.uh.rachel.util.tableClasses;

public class OwnerSide_of_Automatic_Payment_Cancellation_System {
    String timeCondition;
    String deductionPrecentage;



    public OwnerSide_of_Automatic_Payment_Cancellation_System() {

    }

    public OwnerSide_of_Automatic_Payment_Cancellation_System(String timeCondition, String deductionPrecentage) {
        this.timeCondition = timeCondition;
        this.deductionPrecentage = deductionPrecentage;

    }

    public String getTimeCondition() {
        return timeCondition;
    }

    public void setTimeCondition(String timeCondition) {
        this.timeCondition = timeCondition;
    }

    public String getDeductionPrecentage() {
        return deductionPrecentage;
    }

    public void setDeductionPrecentage(String deductionPrecentage) {
        this.deductionPrecentage = deductionPrecentage;
    }




}
