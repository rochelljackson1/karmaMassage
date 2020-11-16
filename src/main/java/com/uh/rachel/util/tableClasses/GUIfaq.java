package com.uh.rachel.util.tableClasses;

public class GUIfaq {
    int faqNumber;
    String question;
    String answer;

    public GUIfaq(){

    }

    public GUIfaq(int faqNumber, String question, String answer){
        this.faqNumber = faqNumber;
        this.question = question;
        this.answer = answer;
    }

    public int getFaqNumber() {return faqNumber;}
    public void setFaqNumber(int faqNumber) {this.faqNumber = faqNumber;}

    public String getQuestion() {return question;}
    public void setQuestion(String question) {this.question = question;}

    public String getAnswer() {return answer;}
    public void setAnswer(String answer) {this.answer = answer;}
}
