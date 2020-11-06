package com.uh.rachel.util.tableClasses;

public class customerTable {
    int customerNumber;
    int storeCredit;
    String firstName;
    String lastName;
    String gender;
    String phone;
    String email;
    String birthday;
    String address;

    public customerTable() {

    }

    public customerTable(int customerNumber, int storeCredit, String firstName, String lastName, String gender, String phone, String email, String birthday, String address) {
        this.customerNumber = customerNumber;
        this.storeCredit = storeCredit;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }

    public customerTable(int customerNumber, String firstName, String lastName) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getStoreCredit() {
        return storeCredit;
    }

    public void setStoreCredit(int storeCredit) {
        this.storeCredit = storeCredit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}

