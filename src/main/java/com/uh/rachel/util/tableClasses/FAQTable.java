package com.uh.rachel.util.tableClasses;

public class FAQTable {

        String question;
        String answer;

        public FAQTable() {

        }

        public FAQTable(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getPhysicianLastname() {
            return question;
        }
        public void setPhysicianLastname(String question) {
            question = question;
        }

        public String getPhysicianPhone() {
            return answer;
        }
        public void setPhysicianPhone(String answer) {
            this.answer = answer;
        }
}

