package com.uh.rachel.util.tableClasses;

public class existingConditionsCardiovascularTable {
    int customerNumber;
    boolean varicoseVeins;
    boolean thrombosisEmbolism;
    boolean stroke;
    boolean phlebitis;
    boolean paceMaker;
    boolean myocardialInfarction;
    boolean lymphedema;
    boolean lowBloodPressure;
    boolean highBloodPressure;
    boolean heartDisease;
    boolean heartAttack;
    boolean congestiveHeartFailure;
    boolean coldHands;
    boolean coldFeet;
    boolean cerebralVascularAccident;
    boolean cardiovascularAccident;
    boolean bloodClots;

    public existingConditionsCardiovascularTable() {
    }

    public existingConditionsCardiovascularTable(int customerNumber, boolean varicoseVeins, boolean thrombosisEmbolism, boolean stroke, boolean phlebitis, boolean paceMaker, boolean myocardialInfarction, boolean lymphedema, boolean lowBloodPressure, boolean highBloodPressure, boolean heartDisease, boolean heartAttack, boolean congestiveHeartFailure, boolean coldHands, boolean coldFeet, boolean cerebralVascularAccident, boolean cardiovascularAccident, boolean bloodClots) {
        this.customerNumber = customerNumber;
        this.varicoseVeins = varicoseVeins;
        this.thrombosisEmbolism = thrombosisEmbolism;
        this.stroke = stroke;
        this.phlebitis = phlebitis;
        this.paceMaker = paceMaker;
        this.myocardialInfarction = myocardialInfarction;
        this.lymphedema = lymphedema;
        this.lowBloodPressure = lowBloodPressure;
        this.highBloodPressure = highBloodPressure;
        this.heartDisease = heartDisease;
        this.heartAttack = heartAttack;
        this.congestiveHeartFailure = congestiveHeartFailure;
        this.coldHands = coldHands;
        this.coldFeet = coldFeet;
        this.cerebralVascularAccident = cerebralVascularAccident;
        this.cardiovascularAccident = cardiovascularAccident;
        this.bloodClots = bloodClots;
    }

    public existingConditionsCardiovascularTable(boolean bloodClots, boolean cardiovascularAccident, boolean cerebralVascularAccident, boolean coldFeet, boolean coldHands, boolean congestiveHeartFailure, boolean heartAttack, boolean heartDisease, boolean highBloodPressure, boolean lowBloodPressure, boolean lymphedema, boolean myocardialInfarction, boolean paceMaker, boolean phlebitis, boolean stroke, boolean thrombosisEmbolism, boolean varicoseVeins) {
        this.varicoseVeins = varicoseVeins;
        this.thrombosisEmbolism = thrombosisEmbolism;
        this.stroke = stroke;
        this.phlebitis = phlebitis;
        this.paceMaker = paceMaker;
        this.myocardialInfarction = myocardialInfarction;
        this.lymphedema = lymphedema;
        this.lowBloodPressure = lowBloodPressure;
        this.highBloodPressure = highBloodPressure;
        this.heartDisease = heartDisease;
        this.heartAttack = heartAttack;
        this.congestiveHeartFailure = congestiveHeartFailure;
        this.coldHands = coldHands;
        this.coldFeet = coldFeet;
        this.cerebralVascularAccident = cerebralVascularAccident;
        this.cardiovascularAccident = cardiovascularAccident;
        this.bloodClots = bloodClots;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isVaricoseVeins() {
        return varicoseVeins;
    }

    public void setVaricoseVeins(boolean varicoseVeins) {
        this.varicoseVeins = varicoseVeins;
    }

    public boolean isThrombosisEmbolism() {
        return thrombosisEmbolism;
    }

    public void setThrombosisEmbolism(boolean thrombosisEmbolism) {
        this.thrombosisEmbolism = thrombosisEmbolism;
    }

    public boolean isStroke() {
        return stroke;
    }

    public void setStroke(boolean stroke) {
        this.stroke = stroke;
    }

    public boolean isPhlebitis() {
        return phlebitis;
    }

    public void setPhlebitis(boolean phlebitis) {
        this.phlebitis = phlebitis;
    }

    public boolean isPaceMaker() {
        return paceMaker;
    }

    public void setPaceMaker(boolean paceMaker) {
        this.paceMaker = paceMaker;
    }

    public boolean isMyocardialInfarction() {
        return myocardialInfarction;
    }

    public void setMyocardialInfarction(boolean myocardialInfarction) {
        this.myocardialInfarction = myocardialInfarction;
    }

    public boolean isLymphedema() {
        return lymphedema;
    }

    public void setLymphedema(boolean lymphedema) {
        this.lymphedema = lymphedema;
    }

    public boolean isLowBloodPressure() {
        return lowBloodPressure;
    }

    public void setLowBloodPressure(boolean lowBloodPressure) {
        this.lowBloodPressure = lowBloodPressure;
    }

    public boolean isHighBloodPressure() {
        return highBloodPressure;
    }

    public void setHighBloodPressure(boolean highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public boolean isHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(boolean heartDisease) {
        this.heartDisease = heartDisease;
    }

    public boolean isHeartAttack() {
        return heartAttack;
    }

    public void setHeartAttack(boolean heartAttack) {
        this.heartAttack = heartAttack;
    }

    public boolean isCongestiveHeartFailure() {
        return congestiveHeartFailure;
    }

    public void setCongestiveHeartFailure(boolean congestiveHeartFailure) {
        this.congestiveHeartFailure = congestiveHeartFailure;
    }

    public boolean isColdHands() {
        return coldHands;
    }

    public void setColdHands(boolean coldHands) {
        this.coldHands = coldHands;
    }

    public boolean isColdFeet() {
        return coldFeet;
    }

    public void setColdFeet(boolean coldFeet) {
        this.coldFeet = coldFeet;
    }

    public boolean isCerebralVascularAccident() {
        return cerebralVascularAccident;
    }

    public void setCerebralVascularAccident(boolean cerebralVascularAccident) {
        this.cerebralVascularAccident = cerebralVascularAccident;
    }

    public boolean isCardiovascularAccident() {
        return cardiovascularAccident;
    }

    public void setCardiovascularAccident(boolean cardiovascularAccident) {
        this.cardiovascularAccident = cardiovascularAccident;
    }

    public boolean isBloodClots() {
        return bloodClots;
    }

    public void setBloodClots(boolean bloodClots) {
        this.bloodClots = bloodClots;
    }
}
