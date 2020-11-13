package com.uh.rachel.util.reportClasses;
import com.uh.rachel.util.tableClasses.appointmentsTable;
import com.uh.rachel.util.tableClasses.FAQTable;
public class report17 {
    appointmentsTable appointmentsTablePackage;
    FAQTable questionPackage;

    public report17(appointmentsTable appointmentsTablePackage, FAQTable questionPackage) {
        this.appointmentsTablePackage = appointmentsTablePackage;
        this.questionPackage = questionPackage;
    }

    public report17(String appointmentDate, int customerNumber, int packageNumber, int serviceNumber, int addOnNumber, String question) {

    }

    public appointmentsTable getAppointmentsTablePackage() {
        return appointmentsTablePackage;
    }

    public void setAppointmentsTablePackage(appointmentsTable appointmentsTablePackage) {
        this.appointmentsTablePackage = appointmentsTablePackage;
    }

    public FAQTable getQuestionPackage() {
        return questionPackage;
    }

    public void setQuestionPackage(FAQTable questionPackage) {
        this.questionPackage = questionPackage;
    }
}
