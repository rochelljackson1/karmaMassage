package com.uh.rachel.util.tableClasses;

public class existingConditionsSkinTable {
    int customerNumber;
    boolean skinIrritations;
    boolean skinConditions;
    boolean melanoma;
    boolean hypersensitiveReaction;
    boolean bruiseEasily;

    public existingConditionsSkinTable() {
    }

    public existingConditionsSkinTable(int customerNumber, boolean skinIrritations, boolean skinConditions, boolean melanoma, boolean hypersensitiveReaction, boolean bruiseEasily) {
        this.customerNumber = customerNumber;
        this.skinIrritations = skinIrritations;
        this.skinConditions = skinConditions;
        this.melanoma = melanoma;
        this.hypersensitiveReaction = hypersensitiveReaction;
        this.bruiseEasily = bruiseEasily;
    }

    public existingConditionsSkinTable(boolean bruiseEasily, boolean hypersensitiveReaction, boolean melanoma, boolean skinConditions, boolean skinIrritations) {
        this.skinIrritations = skinIrritations;
        this.skinConditions = skinConditions;
        this.melanoma = melanoma;
        this.hypersensitiveReaction = hypersensitiveReaction;
        this.bruiseEasily = bruiseEasily;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isSkinIrritations() {
        return skinIrritations;
    }

    public void setSkinIrritations(boolean skinIrritations) {
        this.skinIrritations = skinIrritations;
    }

    public boolean isSkinConditions() {
        return skinConditions;
    }

    public void setSkinConditions(boolean skinConditions) {
        this.skinConditions = skinConditions;
    }

    public boolean isMelanoma() {
        return melanoma;
    }

    public void setMelanoma(boolean melanoma) {
        this.melanoma = melanoma;
    }

    public boolean isHypersensitiveReaction() {
        return hypersensitiveReaction;
    }

    public void setHypersensitiveReaction(boolean hypersensitiveReaction) {
        this.hypersensitiveReaction = hypersensitiveReaction;
    }

    public boolean isBruiseEasily() {
        return bruiseEasily;
    }

    public void setBruiseEasily(boolean bruiseEasily) {
        this.bruiseEasily = bruiseEasily;
    }
}
