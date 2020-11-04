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

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

}

