package com.uh.rachel.util.tableClasses;

public class GUIContactUs {
    String firstName;
    String lastName;
    String email;
    int phone;
    String subjectLine;
    String message;
    int serviceNumber;

    public GUIContactUs(){

    }

    public GUIContactUs(String firstName, String lastName, String email, int phone, String subjectLine, String message, int serviceNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.subjectLine = subjectLine;
        this.message = message;
        this. serviceNumber = serviceNumber;
    }

    public GUIContactUs(String firstName, String lastName, String answer, String email, int phone, String subjectLine, String message) {

    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public int getPhone() {return phone;}
    public void setPhone(int phone) {this.phone = phone;}

    public String getSubjectLine() {return subjectLine;}
    public void setSubjectLine(String subjectLine) {this.subjectLine = subjectLine;}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public int getServiceNumber() {return serviceNumber;}
    public void setServiceNumber(int serviceNumber) {this.serviceNumber = serviceNumber;}

    public Object getfirstName() {

        return null;
    }

}


