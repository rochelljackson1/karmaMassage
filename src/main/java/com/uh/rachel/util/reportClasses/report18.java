package com.uh.rachel.util.reportClasses;
import com.uh.rachel.util.tableClasses.appointmentsTable;
import com.uh.rachel.util.tableClasses.FAQTable;
public class report18 {
    appointmentsTable appointmentsTablePackage;
    FAQTable questionPackage;

    public report18(appointmentsTable appointmentsTablePackage, FAQTable questionPackage) {
        this.appointmentsTablePackage = appointmentsTablePackage;
        this.questionPackage = questionPackage;
    }

    public report18(int customerNumber, String appointmentDate, String question, int serviceNumber) {

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
