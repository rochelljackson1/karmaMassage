package com.uh.rachel.util.tableClasses;

public class FAQTable {

        int faqNumber;
        String question;
        String answer;
        int serviceNumber;
        int addOnNumber;
        int packageNumber;
        int locationNumber;

        public FAQTable(int faqNumber, String question, String answer, int serviceNumber, int addOnNumber, int packageNumber, int locationNumber) {
        }

        public FAQTable(String question, String answer) {
            this.faqNumber = faqNumber;
            this.question = question;
            this.answer = answer;
            this.serviceNumber = serviceNumber;
            this.addOnNumber = addOnNumber;
            this.packageNumber = packageNumber;
            this.locationNumber = locationNumber;
        }


    public int getFaqNumber() { return faqNumber; }
    public void setFaqNumber(int faqNumber) { this.faqNumber = faqNumber; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public int getServiceNumber() { return serviceNumber; }
    public void setServiceNumber(int serviceNumber) { this.serviceNumber = serviceNumber; }

    public int getAddOnNumber() { return addOnNumber; }
    public void setAddOnNumber(int addOnNumber) { this.addOnNumber = addOnNumber; }

    public int getPackageNumber() { return packageNumber; }
    public void setPackageNumber(int packageNumber) { this.packageNumber = packageNumber; }

    public int getLocationNumber() { return locationNumber; }
    public void setLocationNumber(int locationNumber) { this.locationNumber = locationNumber; }
}

