package com.uh.rachel.util.tableClasses;

public class State {
    int stateID;
    String stateCode;
    String stateName;



    public State() {

    }

    public State(int stateID, String stateCode, String stateName) {
        this.stateID = stateID;
        this.stateCode = stateCode;
        this.stateName = stateName;


    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }



}
