package com.uh.rachel.util;

import com.uh.rachel.util.reportClasses.*;
import com.uh.rachel.util.tableClasses.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class DataHandler {
    public static Vector<customerTable> getCustomers() {
        Vector<customerTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customerTable");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new customerTable(result.getInt("customerNumber"),
                        result.getInt("storeCredit"), result.getString("firstName"),
                        result.getString("lastName"), result.getString("gender"),
                        result.getString("phone"), result.getString("email"),
                        result.getString("birthday"), result.getString("address")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<doctorTable> getDoctors() {
        Vector<doctorTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctorTable");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new doctorTable(result.getInt("customerNumber"),
                        result.getInt("doctorNumber"), result.getString("physicianFirstname"),
                        result.getString("physicianLastname"), result.getString("physicianPhone")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

 //Nafisa Chowdhury
    public static Vector<report1> getReport1() {
        Vector<report1> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@ack bit = 0,\n" +
                    "@doctorNoPhone nvarchar(50),\n" +
                    "@emergencyNoPhone nvarchar(50)\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @ack = 1\n" +
                    "SELECT @doctorNoPhone = 'NULL'\n" +
                    "SELECT @emergencyNoPhone = 'NULL'\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "waiverTable.signiture AS 'Waiver Signiture',\n" +
                    "waiverTable.acknowledgment AS 'Acknowledgment',\n" +
                    "doctorTable.physicianLastname AS 'Doctor Last Name',\n" +
                    "doctorTable.physicianPhone AS 'Doctor Phone Number',\n" +
                    "emergencyContactTable.emergencyFirstName AS 'Emergency First Name',\n" +
                    "emergencyContactTable.emergencyLastName AS 'Emergency Last Name',\n" +
                    "emergencyContactTable.relationship AS 'Emergency Relationship',\n" +
                    "emergencyContactTable.emergencyPhone AS 'Emergency Phone Number',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status'\n" +
                    "\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN doctorTable ON customerTable.customerNumber = doctorTable.customerNumber\n" +
                    "JOIN waiverTable ON customerTable.customerNumber = waiverTable.customerNumber\n" +
                     "JOIN emergencyContactTable ON customerTable.customerNumber = emergencyContactTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND waiverTable.acknowledgment = @ack\n" +
                    "AND doctorTable.physicianPhone != @doctorNoPhone\n" +
                    "AND emergencyContactTable.emergencyPhone != @emergencyNoPhone");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                v.add(new report1(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")),
                        new waiverTable(result.getString("Waiver Signiture"), result.getBoolean("Acknowledgment")),
                        new doctorTable(result.getString("Doctor Last Name"), result.getString("Doctor Phone Number")),
                        new emergencyContactTable(result.getString("Emergency First Name"), result.getString("Emergency Last Name"),
                                result.getString("Emergency Phone Number"), result.getString("Emergency Relationship")),
                        new companyClientHistoryTable(result.getBoolean("Status"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

//Nafisa Chowdhury
    public static Vector<report2> getReport2() {
        Vector<report2> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@ack bit = 0,\n" +
                    "@doctorNoPhone nvarchar(50),\n" +
                    "@emergencyNoPhone nvarchar(50)\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @ack = 0\n" +
                    "SELECT @doctorNoPhone = 'NULL'\n" +
                    "SELECT @emergencyNoPhone = 'NULL'\n" +
                    "\n" +
                    "SELECT\n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "waiverTable.signiture AS 'Waiver Signiture',\n" +
                    "waiverTable.acknowledgment AS 'Acknowledgment',\n" +
                    "doctorTable.physicianLastname AS 'Doctor Last Name',\n" +
                    "doctorTable.physicianPhone AS 'Doctor Phone Number',\n" +
                    "emergencyContactTable.emergencyFirstName AS 'Emergency First Name',\n" +
                    "emergencyContactTable.emergencyLastName AS 'Emergency Last Name',\n" +
                    "emergencyContactTable.relationship AS 'Emergency Relationship',\n" +
                    "emergencyContactTable.emergencyPhone AS 'Emergency Phone Number',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status'\n" +
                    "\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN doctorTable ON customerTable.customerNumber = doctorTable.customerNumber\n" +
                    "JOIN waiverTable ON customerTable.customerNumber = waiverTable.customerNumber\n" +
                    "JOIN emergencyContactTable ON customerTable.customerNumber = emergencyContactTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE emergencyContactTable.emergencyPhone != @emergencyNoPhone\n" +
                    "AND waiverTable.acknowledgment = @ack\n" +
                    "AND doctorTable.physicianPhone != @doctorNoPhone\n" +
                    "AND companyClientHistoryTable.currentClient = @status");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                v.add(new report2(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")),
                        new waiverTable(result.getString("Waiver Signiture"), result.getBoolean("Acknowledgment")),
                        new doctorTable(result.getString("Doctor Last Name"), result.getString("Doctor Phone Number")),
                        new emergencyContactTable(result.getString("Emergency First Name"), result.getString("Emergency Last Name"),
                                result.getString("Emergency Phone Number"), result.getString("Emergency Relationship")),
                        new companyClientHistoryTable(result.getBoolean("Status"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

//Nafisa Chowdhury
    public static Vector<report3> getReport3() {
        Vector<report3> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@phone nvarchar(50),\n" +
                    "@email nvarchar(50)\n" +
                    "\n" +
                    "SELECT @status = 0\n" +
                    "SELECT @phone = 'NULL'\n" +
                    "SELECT @email = 'NULL'\n" +
                    "\n" +
                    "SELECT\n" +
                    "\n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "customerTable.phone AS 'Client Phone Number',\n" +
                    "customerTable.email AS 'Client Email Address',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN doctorTable ON customerTable.customerNumber = doctorTable.customerNumber\n" +
                    "JOIN waiverTable ON customerTable.customerNumber = waiverTable.customerNumber\n" +
                    "JOIN emergencyContactTable ON customerTable.customerNumber = emergencyContactTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (customerTable.phone != @phone OR customerTable.email != @email)");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                v.add(new report3(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name"),
                        result.getString("Client Phone Number"), result.getString("Client Email Address")),
                        new companyClientHistoryTable(result.getBoolean("Status"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

//Nafisa Chowdhury
    public static Vector<report4> getReport4() {
        Vector<report4> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@phone nvarchar(50),\n" +
                    "@email nvarchar(50)\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @phone = 'NULL'\n" +
                    "SELECT @email = 'NULL'\n" +
                    "\n" +
                    "SELECT\n" +
                    "\n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "customerTable.phone AS 'Client Phone Number',\n" +
                    "customerTable.email AS 'Client Email Address',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN doctorTable ON customerTable.customerNumber = doctorTable.customerNumber\n" +
                    "JOIN waiverTable ON customerTable.customerNumber = waiverTable.customerNumber\n" +
                    "JOIN emergencyContactTable ON customerTable.customerNumber = emergencyContactTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (customerTable.phone != @phone OR customerTable.email != @email)");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                v.add(new report4(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name"),
                        result.getString("Client Phone Number"), result.getString("Client Email Address")),
                        new companyClientHistoryTable(result.getBoolean("Status"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

//Ramiro Santibanez
    public static Vector<customerTable> getReport10() {
        Vector<customerTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@cardioTrue bit = 0,\n" +
                    "@resTrue bit = 0,\n" +
                    "@hnTrue bit = 0,\n" +
                    "@iTrue bit = 0\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @cardioTrue = 1\n" +
                    "SELECT @resTrue = 1\n" +
                    "SELECT @hnTrue = 1\n" +
                    "SELECT @iTrue = 1\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsCardiovascularTable ON customerTable.customerNumber = existingConditionsCardiovascularTable.customerNumber\n" +
                    "JOIN existingConditionsHeadNeckTable ON customerTable.customerNumber = existingConditionsHeadNeckTable.customerNumber\n" +
                    "JOIN existingConditionsInfectiousTable ON customerTable.customerNumber = existingConditionsInfectiousTable.customerNumber\n" +
                    "JOIN existingConditionsNeurologicalTable ON customerTable.customerNumber = existingConditionsNeurologicalTable.customerNumber\n" +
                    "JOIN existingConditionsRespiratoryTable ON customerTable.customerNumber = existingConditionsRespiratoryTable.customerNumber\n" +
                    "JOIN existingConditionsSkinTable ON customerTable.customerNumber = existingConditionsSkinTable.customerNumber\n" +
                    "JOIN existingConditionsSTJDTable ON customerTable.customerNumber = existingConditionsSTJDTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (existingConditionsCardiovascularTable.bloodClots = @cardioTrue OR existingConditionsCardiovascularTable.cardiovascularAccident = @cardioTrue or existingConditionsCardiovascularTable.cerebralVascularAccident = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.coldFeet = @cardioTrue OR existingConditionsCardiovascularTable.coldHands = @cardioTrue OR existingConditionsCardiovascularTable.congestiveHeartFailure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.heartAttack = @cardioTrue OR existingConditionsCardiovascularTable.heartDisease = @cardioTrue OR existingConditionsCardiovascularTable.highBloodPressure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.lowBloodPressure = @cardioTrue OR existingConditionsCardiovascularTable.lymphedema = @cardioTrue OR existingConditionsCardiovascularTable.myocardialInfarction = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.paceMaker = @cardioTrue OR existingConditionsCardiovascularTable.phlebitis = @cardioTrue OR existingConditionsCardiovascularTable.stroke = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.thrombosisEmbolism = @cardioTrue OR existingConditionsCardiovascularTable.varicoseVeins = @cardioTrue)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @resTrue OR existingConditionsRespiratoryTable.bronchitis = @resTrue OR existingConditionsRespiratoryTable.chronicCough = @resTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @resTrue)\n" +
                    "AND (existingConditionsHeadNeckTable.earProblems = @hnTrue OR existingConditionsHeadNeckTable.headaches = @hnTrue OR existingConditionsHeadNeckTable.hearingLoss = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.jawPain = @hnTrue OR existingConditionsHeadNeckTable.migraines = @hnTrue OR existingConditionsHeadNeckTable.sinusProblems = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.visionLoss = @hnTrue OR existingConditionsHeadNeckTable.visionProblems = @hnTrue)\n" +
                    "AND (existingConditionsInfectiousTable.altheletsFoot = @iTrue OR existingConditionsInfectiousTable.hepatitis = @iTrue OR existingConditionsInfectiousTable.herpes = @iTrue\n" +
                    "\tOR existingConditionsInfectiousTable.hiv = @iTrue OR existingConditionsInfectiousTable.respiratoryConditions = @iTrue OR existingConditionsInfectiousTable.skinConditions = @iTrue)\n" +
                    "AND (existingConditionsNeurologicalTable.burning = @iTrue OR existingConditionsNeurologicalTable.cerebralPaisy = @iTrue OR existingConditionsNeurologicalTable.herniatedDisc = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.multipleSclerosis = @iTrue OR existingConditionsNeurologicalTable.numbness = @iTrue OR existingConditionsNeurologicalTable.parkinsons = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.stabbingPain = @iTrue OR existingConditionsNeurologicalTable.tingling = @iTrue)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @iTrue OR existingConditionsRespiratoryTable.bronchitis = @iTrue OR existingConditionsRespiratoryTable.chronicCough = @iTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @iTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @iTrue)\n" +
                    "AND (existingConditionsSkinTable.bruiseEasily = @iTrue OR existingConditionsSkinTable.hypersensitiveReaction = @iTrue OR existingConditionsSkinTable.melanoma = @iTrue\n" +
                    "\tOR existingConditionsSkinTable.skinConditions = @iTrue OR existingConditionsSkinTable.skinIrritations = @iTrue)\n" +
                    "AND (existingConditionsSTJDTable.anklesLeft = @iTrue OR existingConditionsSTJDTable.anklesRight = @iTrue OR existingConditionsSTJDTable.armsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.armsRight = @iTrue OR existingConditionsSTJDTable.feetLeft = @iTrue OR existingConditionsSTJDTable.feetRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.handsLeft = @iTrue OR existingConditionsSTJDTable.handsRight = @iTrue OR existingConditionsSTJDTable.hipsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.hipsRight = @iTrue OR existingConditionsSTJDTable.kneesLeft = @iTrue OR existingConditionsSTJDTable.kneesRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.legsLeft = @iTrue OR existingConditionsSTJDTable.legsRight = @iTrue OR existingConditionsSTJDTable.lowerBackLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.lowerBackRight = @iTrue OR existingConditionsSTJDTable.midBackLeft = @iTrue OR existingConditionsSTJDTable.midBackRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.neckLeft = @iTrue OR existingConditionsSTJDTable.neckRight = @iTrue OR existingConditionsSTJDTable.shouldersLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.shouldersRight = @iTrue OR existingConditionsSTJDTable.upperBackLeft = @iTrue OR existingConditionsSTJDTable.upperBackRight = @iTrue)");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                v.add(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"),
                        result.getString("Client Last Name")));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return v;
    }
//Ramiro Santibaez
    public static Vector<customerTable> getReport11() {
        Vector<customerTable> v = new Vector<>();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@cardioTrue bit = 0,\n" +
                    "@resTrue bit = 0,\n" +
                    "@hnTrue bit = 0,\n" +
                    "@iTrue bit = 0\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @cardioTrue = 1\n" +
                    "SELECT @resTrue = 1\n" +
                    "SELECT @hnTrue = 1\n" +
                    "SELECT @iTrue = 1\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsCardiovascularTable ON customerTable.customerNumber = existingConditionsCardiovascularTable.customerNumber\n" +
                    "JOIN existingConditionsHeadNeckTable ON customerTable.customerNumber = existingConditionsHeadNeckTable.customerNumber\n" +
                    "JOIN existingConditionsInfectiousTable ON customerTable.customerNumber = existingConditionsInfectiousTable.customerNumber\n" +
                    "JOIN existingConditionsNeurologicalTable ON customerTable.customerNumber = existingConditionsNeurologicalTable.customerNumber\n" +
                    "JOIN existingConditionsRespiratoryTable ON customerTable.customerNumber = existingConditionsRespiratoryTable.customerNumber\n" +
                    "JOIN existingConditionsSkinTable ON customerTable.customerNumber = existingConditionsSkinTable.customerNumber\n" +
                    "JOIN existingConditionsSTJDTable ON customerTable.customerNumber = existingConditionsSTJDTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND \n" +
                    "((existingConditionsCardiovascularTable.bloodClots = @cardioTrue OR existingConditionsCardiovascularTable.cardiovascularAccident = @cardioTrue or existingConditionsCardiovascularTable.cerebralVascularAccident = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.coldFeet = @cardioTrue OR existingConditionsCardiovascularTable.coldHands = @cardioTrue OR existingConditionsCardiovascularTable.congestiveHeartFailure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.heartAttack = @cardioTrue OR existingConditionsCardiovascularTable.heartDisease = @cardioTrue OR existingConditionsCardiovascularTable.highBloodPressure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.lowBloodPressure = @cardioTrue OR existingConditionsCardiovascularTable.lymphedema = @cardioTrue OR existingConditionsCardiovascularTable.myocardialInfarction = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.paceMaker = @cardioTrue OR existingConditionsCardiovascularTable.phlebitis = @cardioTrue OR existingConditionsCardiovascularTable.stroke = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.thrombosisEmbolism = @cardioTrue OR existingConditionsCardiovascularTable.varicoseVeins = @cardioTrue)\n" +
                    "OR (existingConditionsRespiratoryTable.asthma = @resTrue OR existingConditionsRespiratoryTable.bronchitis = @resTrue OR existingConditionsRespiratoryTable.chronicCough = @resTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @resTrue)\n" +
                    "OR (existingConditionsHeadNeckTable.earProblems = @hnTrue OR existingConditionsHeadNeckTable.headaches = @hnTrue OR existingConditionsHeadNeckTable.hearingLoss = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.jawPain = @hnTrue OR existingConditionsHeadNeckTable.migraines = @hnTrue OR existingConditionsHeadNeckTable.sinusProblems = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.visionLoss = @hnTrue OR existingConditionsHeadNeckTable.visionProblems = @hnTrue)\n" +
                    "OR (existingConditionsInfectiousTable.altheletsFoot = @iTrue OR existingConditionsInfectiousTable.hepatitis = @iTrue OR existingConditionsInfectiousTable.herpes = @iTrue\n" +
                    "\tOR existingConditionsInfectiousTable.hiv = @iTrue OR existingConditionsInfectiousTable.respiratoryConditions = @iTrue OR existingConditionsInfectiousTable.skinConditions = @iTrue)\n" +
                    "OR (existingConditionsNeurologicalTable.burning = @iTrue OR existingConditionsNeurologicalTable.cerebralPaisy = @iTrue OR existingConditionsNeurologicalTable.herniatedDisc = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.multipleSclerosis = @iTrue OR existingConditionsNeurologicalTable.numbness = @iTrue OR existingConditionsNeurologicalTable.parkinsons = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.stabbingPain = @iTrue OR existingConditionsNeurologicalTable.tingling = @iTrue)\n" +
                    "OR (existingConditionsRespiratoryTable.asthma = @iTrue OR existingConditionsRespiratoryTable.bronchitis = @iTrue OR existingConditionsRespiratoryTable.chronicCough = @iTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @iTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @iTrue)\n" +
                    "OR (existingConditionsSkinTable.bruiseEasily = @iTrue OR existingConditionsSkinTable.hypersensitiveReaction = @iTrue OR existingConditionsSkinTable.melanoma = @iTrue\n" +
                    "\tOR existingConditionsSkinTable.skinConditions = @iTrue OR existingConditionsSkinTable.skinIrritations = @iTrue)\n" +
                    "OR (existingConditionsSTJDTable.anklesLeft = @iTrue OR existingConditionsSTJDTable.anklesRight = @iTrue OR existingConditionsSTJDTable.armsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.armsRight = @iTrue OR existingConditionsSTJDTable.feetLeft = @iTrue OR existingConditionsSTJDTable.feetRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.handsLeft = @iTrue OR existingConditionsSTJDTable.handsRight = @iTrue OR existingConditionsSTJDTable.hipsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.hipsRight = @iTrue OR existingConditionsSTJDTable.kneesLeft = @iTrue OR existingConditionsSTJDTable.kneesRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.legsLeft = @iTrue OR existingConditionsSTJDTable.legsRight = @iTrue OR existingConditionsSTJDTable.lowerBackLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.lowerBackRight = @iTrue OR existingConditionsSTJDTable.midBackLeft = @iTrue OR existingConditionsSTJDTable.midBackRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.neckLeft = @iTrue OR existingConditionsSTJDTable.neckRight = @iTrue OR existingConditionsSTJDTable.shouldersLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.shouldersRight = @iTrue OR existingConditionsSTJDTable.upperBackLeft = @iTrue OR existingConditionsSTJDTable.upperBackRight = @iTrue))");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                v.add(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"),
                        result.getString("Client Last Name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<FAQTable> getFAQ(){
        Vector<FAQTable> v = new Vector<>();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM FAQTable");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                v.add(new FAQTable(result.getInt("faqNumber"), result.getString("question"),
                        result.getString("answer"), result.getInt("serviceNumber"),
                        result.getInt("addOnNumber"), result.getInt("packageNumber"),
                        result.getInt("locationNumber")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<appointmentsTable> getAppointments(){
        Vector<appointmentsTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM appointmentsTable");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new appointmentsTable(result.getInt("appointmentNumber"),
                        result.getInt("customerNumber"), result.getInt("serviceNumber"),
                        result.getInt("packageNumber"), result.getInt("addOnNumber"),
                        result.getString("scheduledDate"), result.getString("scheduledTime"),
                        result.getDouble("originalFullPrice"), result.getString("dateCancelled"),
                        result.getString("timeCancelled"), result.getDouble("actualPricePaid"),
                        result.getString("defaultPayment"), result.getString("cardNumberType"),
                        result.getString("cardNumber"), result.getInt("staff_NUmber")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<customerTable> getReport9() {
        Vector<customerTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@cardioTrue bit = 0,\n" +
                    "@resTrue bit = 0,\n" +
                    "@hnTrue bit = 0,\n" +
                    "@iTrue bit = 0\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @cardioTrue = 0\n" +
                    "SELECT @resTrue = 0\n" +
                    "SELECT @hnTrue = 0\n" +
                    "SELECT @iTrue = 0\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsCardiovascularTable ON customerTable.customerNumber = existingConditionsCardiovascularTable.customerNumber\n" +
                    "JOIN existingConditionsHeadNeckTable ON customerTable.customerNumber = existingConditionsHeadNeckTable.customerNumber\n" +
                    "JOIN existingConditionsInfectiousTable ON customerTable.customerNumber = existingConditionsInfectiousTable.customerNumber\n" +
                    "JOIN existingConditionsNeurologicalTable ON customerTable.customerNumber = existingConditionsNeurologicalTable.customerNumber\n" +
                    "JOIN existingConditionsRespiratoryTable ON customerTable.customerNumber = existingConditionsRespiratoryTable.customerNumber\n" +
                    "JOIN existingConditionsSkinTable ON customerTable.customerNumber = existingConditionsSkinTable.customerNumber\n" +
                    "JOIN existingConditionsSTJDTable ON customerTable.customerNumber = existingConditionsSTJDTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (existingConditionsCardiovascularTable.bloodClots = @cardioTrue OR existingConditionsCardiovascularTable.cardiovascularAccident = @cardioTrue or existingConditionsCardiovascularTable.cerebralVascularAccident = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.coldFeet = @cardioTrue OR existingConditionsCardiovascularTable.coldHands = @cardioTrue OR existingConditionsCardiovascularTable.congestiveHeartFailure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.heartAttack = @cardioTrue OR existingConditionsCardiovascularTable.heartDisease = @cardioTrue OR existingConditionsCardiovascularTable.highBloodPressure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.lowBloodPressure = @cardioTrue OR existingConditionsCardiovascularTable.lymphedema = @cardioTrue OR existingConditionsCardiovascularTable.myocardialInfarction = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.paceMaker = @cardioTrue OR existingConditionsCardiovascularTable.phlebitis = @cardioTrue OR existingConditionsCardiovascularTable.stroke = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.thrombosisEmbolism = @cardioTrue OR existingConditionsCardiovascularTable.varicoseVeins = @cardioTrue)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @resTrue OR existingConditionsRespiratoryTable.bronchitis = @resTrue OR existingConditionsRespiratoryTable.chronicCough = @resTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @resTrue)\n" +
                    "AND (existingConditionsHeadNeckTable.earProblems = @hnTrue OR existingConditionsHeadNeckTable.headaches = @hnTrue OR existingConditionsHeadNeckTable.hearingLoss = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.jawPain = @hnTrue OR existingConditionsHeadNeckTable.migraines = @hnTrue OR existingConditionsHeadNeckTable.sinusProblems = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.visionLoss = @hnTrue OR existingConditionsHeadNeckTable.visionProblems = @hnTrue)\n" +
                    "AND (existingConditionsInfectiousTable.altheletsFoot = @iTrue OR existingConditionsInfectiousTable.hepatitis = @iTrue OR existingConditionsInfectiousTable.herpes = @iTrue\n" +
                    "\tOR existingConditionsInfectiousTable.hiv = @iTrue OR existingConditionsInfectiousTable.respiratoryConditions = @iTrue OR existingConditionsInfectiousTable.skinConditions = @iTrue)\n" +
                    "AND (existingConditionsNeurologicalTable.burning = @iTrue OR existingConditionsNeurologicalTable.cerebralPaisy = @iTrue OR existingConditionsNeurologicalTable.herniatedDisc = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.multipleSclerosis = @iTrue OR existingConditionsNeurologicalTable.numbness = @iTrue OR existingConditionsNeurologicalTable.parkinsons = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.stabbingPain = @iTrue OR existingConditionsNeurologicalTable.tingling = @iTrue)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @iTrue OR existingConditionsRespiratoryTable.bronchitis = @iTrue OR existingConditionsRespiratoryTable.chronicCough = @iTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @iTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @iTrue)\n" +
                    "AND (existingConditionsSkinTable.bruiseEasily = @iTrue OR existingConditionsSkinTable.hypersensitiveReaction = @iTrue OR existingConditionsSkinTable.melanoma = @iTrue\n" +
                    "\tOR existingConditionsSkinTable.skinConditions = @iTrue OR existingConditionsSkinTable.skinIrritations = @iTrue)\n" +
                    "AND (existingConditionsSTJDTable.anklesLeft = @iTrue OR existingConditionsSTJDTable.anklesRight = @iTrue OR existingConditionsSTJDTable.armsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.armsRight = @iTrue OR existingConditionsSTJDTable.feetLeft = @iTrue OR existingConditionsSTJDTable.feetRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.handsLeft = @iTrue OR existingConditionsSTJDTable.handsRight = @iTrue OR existingConditionsSTJDTable.hipsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.hipsRight = @iTrue OR existingConditionsSTJDTable.kneesLeft = @iTrue OR existingConditionsSTJDTable.kneesRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.legsLeft = @iTrue OR existingConditionsSTJDTable.legsRight = @iTrue OR existingConditionsSTJDTable.lowerBackLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.lowerBackRight = @iTrue OR existingConditionsSTJDTable.midBackLeft = @iTrue OR existingConditionsSTJDTable.midBackRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.neckLeft = @iTrue OR existingConditionsSTJDTable.neckRight = @iTrue OR existingConditionsSTJDTable.shouldersLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.shouldersRight = @iTrue OR existingConditionsSTJDTable.upperBackLeft = @iTrue OR existingConditionsSTJDTable.upperBackRight = @iTrue)");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<customerTable> getReport12() {
        Vector<customerTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@cardioTrue bit = 0,\n" +
                    "@cardioFalse bit = 0,\n" +
                    "@resTrue bit = 0,\n" +
                    "@resFalse bit = 0,\n" +
                    "@hnTrue bit = 0,\n" +
                    "@hnFalse bit = 0,\n" +
                    "@iTrue bit = 0,\n" +
                    "@iFalse bit = 0,\n" +
                    "@ack bit = 0,\n" +
                    "@doctorNoPhone nvarchar(50),\n" +
                    "@emergencyNoPhone nvarchar(50)\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @cardioTrue = 1\n" +
                    "SELECT @cardioFalse = 0\n" +
                    "SELECT @resTrue = 1\n" +
                    "SELECT @resFalse = 0\n" +
                    "SELECT @hnTrue = 1\n" +
                    "SELECT @hnFalse = 0\n" +
                    "SELECT @iTrue = 1\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @ack = 1\n" +
                    "SELECT @doctorNoPhone = 'NULL'\n" +
                    "SELECT @emergencyNoPhone = 'NULL'\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsCardiovascularTable ON customerTable.customerNumber = existingConditionsCardiovascularTable.customerNumber\n" +
                    "JOIN existingConditionsHeadNeckTable ON customerTable.customerNumber = existingConditionsHeadNeckTable.customerNumber\n" +
                    "JOIN existingConditionsInfectiousTable ON customerTable.customerNumber = existingConditionsInfectiousTable.customerNumber\n" +
                    "JOIN existingConditionsNeurologicalTable ON customerTable.customerNumber = existingConditionsNeurologicalTable.customerNumber\n" +
                    "JOIN existingConditionsRespiratoryTable ON customerTable.customerNumber = existingConditionsRespiratoryTable.customerNumber\n" +
                    "JOIN existingConditionsSkinTable ON customerTable.customerNumber = existingConditionsSkinTable.customerNumber\n" +
                    "JOIN existingConditionsSTJDTable ON customerTable.customerNumber = existingConditionsSTJDTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "--\n" +
                    "JOIN doctorTable ON customerTable.customerNumber = doctorTable.customerNumber\n" +
                    "JOIN waiverTable ON customerTable.customerNumber = waiverTable.customerNumber\n" +
                    "JOIN emergencyContactTable ON customerTable.customerNumber = emergencyContactTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (existingConditionsCardiovascularTable.bloodClots = @cardioTrue OR existingConditionsCardiovascularTable.cardiovascularAccident = @cardioTrue or existingConditionsCardiovascularTable.cerebralVascularAccident = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.coldFeet = @cardioTrue OR existingConditionsCardiovascularTable.coldHands = @cardioTrue OR existingConditionsCardiovascularTable.congestiveHeartFailure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.heartAttack = @cardioTrue OR existingConditionsCardiovascularTable.heartDisease = @cardioTrue OR existingConditionsCardiovascularTable.highBloodPressure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.lowBloodPressure = @cardioTrue OR existingConditionsCardiovascularTable.lymphedema = @cardioTrue OR existingConditionsCardiovascularTable.myocardialInfarction = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.paceMaker = @cardioTrue OR existingConditionsCardiovascularTable.phlebitis = @cardioTrue OR existingConditionsCardiovascularTable.stroke = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.thrombosisEmbolism = @cardioTrue OR existingConditionsCardiovascularTable.varicoseVeins = @cardioTrue)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @resTrue OR existingConditionsRespiratoryTable.bronchitis = @resTrue OR existingConditionsRespiratoryTable.chronicCough = @resTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @resTrue)\n" +
                    "AND (existingConditionsHeadNeckTable.earProblems = @hnTrue OR existingConditionsHeadNeckTable.headaches = @hnTrue OR existingConditionsHeadNeckTable.hearingLoss = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.jawPain = @hnTrue OR existingConditionsHeadNeckTable.migraines = @hnTrue OR existingConditionsHeadNeckTable.sinusProblems = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.visionLoss = @hnTrue OR existingConditionsHeadNeckTable.visionProblems = @hnTrue)\n" +
                    "AND (existingConditionsInfectiousTable.altheletsFoot = @iTrue OR existingConditionsInfectiousTable.hepatitis = @iTrue OR existingConditionsInfectiousTable.herpes = @iTrue\n" +
                    "\tOR existingConditionsInfectiousTable.hiv = @iTrue OR existingConditionsInfectiousTable.respiratoryConditions = @iTrue OR existingConditionsInfectiousTable.skinConditions = @iTrue)\n" +
                    "AND (existingConditionsNeurologicalTable.burning = @iTrue OR existingConditionsNeurologicalTable.cerebralPaisy = @iTrue OR existingConditionsNeurologicalTable.herniatedDisc = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.multipleSclerosis = @iTrue OR existingConditionsNeurologicalTable.numbness = @iTrue OR existingConditionsNeurologicalTable.parkinsons = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.stabbingPain = @iTrue OR existingConditionsNeurologicalTable.tingling = @iTrue)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @iTrue OR existingConditionsRespiratoryTable.bronchitis = @iTrue OR existingConditionsRespiratoryTable.chronicCough = @iTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @iTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @iTrue)\n" +
                    "AND (existingConditionsSkinTable.bruiseEasily = @iTrue OR existingConditionsSkinTable.hypersensitiveReaction = @iTrue OR existingConditionsSkinTable.melanoma = @iTrue\n" +
                    "\tOR existingConditionsSkinTable.skinConditions = @iTrue OR existingConditionsSkinTable.skinIrritations = @iTrue)\n" +
                    "AND (existingConditionsSTJDTable.anklesLeft = @iTrue OR existingConditionsSTJDTable.anklesRight = @iTrue OR existingConditionsSTJDTable.armsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.armsRight = @iTrue OR existingConditionsSTJDTable.feetLeft = @iTrue OR existingConditionsSTJDTable.feetRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.handsLeft = @iTrue OR existingConditionsSTJDTable.handsRight = @iTrue OR existingConditionsSTJDTable.hipsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.hipsRight = @iTrue OR existingConditionsSTJDTable.kneesLeft = @iTrue OR existingConditionsSTJDTable.kneesRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.legsLeft = @iTrue OR existingConditionsSTJDTable.legsRight = @iTrue OR existingConditionsSTJDTable.lowerBackLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.lowerBackRight = @iTrue OR existingConditionsSTJDTable.midBackLeft = @iTrue OR existingConditionsSTJDTable.midBackRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.neckLeft = @iTrue OR existingConditionsSTJDTable.neckRight = @iTrue OR existingConditionsSTJDTable.shouldersLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.shouldersRight = @iTrue OR existingConditionsSTJDTable.upperBackLeft = @iTrue OR existingConditionsSTJDTable.upperBackRight = @iTrue)\n" +
                    "--\n" +
                    "AND (existingConditionsCardiovascularTable.bloodClots = @cardioFalse OR existingConditionsCardiovascularTable.cardiovascularAccident = @cardioFalse or existingConditionsCardiovascularTable.cerebralVascularAccident = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.coldFeet = @cardioFalse OR existingConditionsCardiovascularTable.coldHands = @cardioFalse OR existingConditionsCardiovascularTable.congestiveHeartFailure = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.heartAttack = @cardioFalse OR existingConditionsCardiovascularTable.heartDisease = @cardioFalse OR existingConditionsCardiovascularTable.highBloodPressure = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.lowBloodPressure = @cardioFalse OR existingConditionsCardiovascularTable.lymphedema = @cardioFalse OR existingConditionsCardiovascularTable.myocardialInfarction = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.paceMaker = @cardioFalse OR existingConditionsCardiovascularTable.phlebitis = @cardioFalse OR existingConditionsCardiovascularTable.stroke = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.thrombosisEmbolism = @cardioFalse OR existingConditionsCardiovascularTable.varicoseVeins = @cardioFalse)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @resFalse OR existingConditionsRespiratoryTable.bronchitis = @resFalse OR existingConditionsRespiratoryTable.chronicCough = @resFalse\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resFalse OR existingConditionsRespiratoryTable.shortnessOfBreath = @resFalse)\n" +
                    "AND (existingConditionsHeadNeckTable.earProblems = @hnFalse OR existingConditionsHeadNeckTable.headaches = @hnFalse OR existingConditionsHeadNeckTable.hearingLoss = @hnFalse\n" +
                    "\tOR existingConditionsHeadNeckTable.jawPain = @hnFalse OR existingConditionsHeadNeckTable.migraines = @hnFalse OR existingConditionsHeadNeckTable.sinusProblems = @hnFalse\n" +
                    "\tOR existingConditionsHeadNeckTable.visionLoss = @hnFalse OR existingConditionsHeadNeckTable.visionProblems = @hnFalse)\n" +
                    "AND (existingConditionsInfectiousTable.altheletsFoot = @iFalse OR existingConditionsInfectiousTable.hepatitis = @iFalse OR existingConditionsInfectiousTable.herpes = @iFalse\n" +
                    "\tOR existingConditionsInfectiousTable.hiv = @iFalse OR existingConditionsInfectiousTable.respiratoryConditions = @iFalse OR existingConditionsInfectiousTable.skinConditions = @iFalse)\n" +
                    "AND (existingConditionsNeurologicalTable.burning = @iFalse OR existingConditionsNeurologicalTable.cerebralPaisy = @iFalse OR existingConditionsNeurologicalTable.herniatedDisc = @iFalse\n" +
                    "\tOR existingConditionsNeurologicalTable.multipleSclerosis = @iFalse OR existingConditionsNeurologicalTable.numbness = @iFalse OR existingConditionsNeurologicalTable.parkinsons = @iFalse\n" +
                    "\tOR existingConditionsNeurologicalTable.stabbingPain = @iFalse OR existingConditionsNeurologicalTable.tingling = @iFalse)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @iFalse OR existingConditionsRespiratoryTable.bronchitis = @iFalse OR existingConditionsRespiratoryTable.chronicCough = @iFalse\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @iFalse OR existingConditionsRespiratoryTable.shortnessOfBreath = @iFalse)\n" +
                    "AND (existingConditionsSkinTable.bruiseEasily = @iFalse OR existingConditionsSkinTable.hypersensitiveReaction = @iFalse OR existingConditionsSkinTable.melanoma = @iFalse\n" +
                    "\tOR existingConditionsSkinTable.skinConditions = @iFalse OR existingConditionsSkinTable.skinIrritations = @iFalse)\n" +
                    "AND (existingConditionsSTJDTable.anklesLeft = @iFalse OR existingConditionsSTJDTable.anklesRight = @iFalse OR existingConditionsSTJDTable.armsLeft = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.armsRight = @iFalse OR existingConditionsSTJDTable.feetLeft = @iFalse OR existingConditionsSTJDTable.feetRight = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.handsLeft = @iFalse OR existingConditionsSTJDTable.handsRight = @iFalse OR existingConditionsSTJDTable.hipsLeft = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.hipsRight = @iFalse OR existingConditionsSTJDTable.kneesLeft = @iFalse OR existingConditionsSTJDTable.kneesRight = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.legsLeft = @iFalse OR existingConditionsSTJDTable.legsRight = @iFalse OR existingConditionsSTJDTable.lowerBackLeft = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.lowerBackRight = @iFalse OR existingConditionsSTJDTable.midBackLeft = @iFalse OR existingConditionsSTJDTable.midBackRight = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.neckLeft = @iFalse OR existingConditionsSTJDTable.neckRight = @iFalse OR existingConditionsSTJDTable.shouldersLeft = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.shouldersRight = @iFalse OR existingConditionsSTJDTable.upperBackLeft = @iFalse OR existingConditionsSTJDTable.upperBackRight = @iFalse)\n" +
                    "--\n" +
                    "AND waiverTable.acknowledgment = @ack\n" +
                    "AND doctorTable.physicianPhone != @doctorNoPhone\n" +
                    "AND emergencyContactTable.emergencyPhone != @emergencyNoPhone");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<report13> getReport13() {
        Vector<report13> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@ihres bit = 0,\n" +
                    "@resTrue bit = 0\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @ihres = 1\n" +
                    "SELECT @resTrue = 1\n" +
                    "\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "existingConditionsInfectiousTable.respiratoryConditions AS 'Infectious Respiratory Condition',\n" +
                    "existingConditionsRespiratoryTable.asthma AS 'Asthma',\n" +
                    "existingConditionsRespiratoryTable.bronchitis AS 'Bronchitis',\n" +
                    "existingConditionsRespiratoryTable.chronicCough AS 'Chronic Cough',\n" +
                    "existingConditionsRespiratoryTable.emphysema AS 'Emphysema',\n" +
                    "existingConditionsRespiratoryTable.shortnessOfBreath AS 'Shortness of Breathe',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsInfectiousTable ON customerTable.customerNumber = existingConditionsInfectiousTable.customerNumber\n" +
                    "JOIN existingConditionsRespiratoryTable ON customerTable.customerNumber = existingConditionsRespiratoryTable.customerNumber\n" +
                    "JOIN reasonForMassageTable ON customerTable.customerNumber = reasonForMassageTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (existingConditionsInfectiousTable.respiratoryConditions = @ihres)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @resTrue OR existingConditionsRespiratoryTable.bronchitis = @resTrue OR existingConditionsRespiratoryTable.chronicCough = @resTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @resTrue)");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new report13(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")),
                        new existingConditionsInfectiousTable(result.getBoolean("Infectious Respiratory Condition")),
                        new existingConditionsRespiratoryTable(result.getInt("Asthma"),
                        result.getBoolean("Bronchitis"), result.getBoolean("Chronic Cough"),
                        result.getBoolean("Emphysema"), result.getBoolean("Shortness of Breathe")),
                        new companyClientHistoryTable(result.getBoolean("Status"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<report14> getReport14() {
        Vector<report14> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@iskin bit = 0,\n" +
                    "@skinTrue bit = 0\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @iskin = 1\n" +
                    "SELECT @skinTrue = 1\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "existingConditionsInfectiousTable.skinConditions AS 'Infectious Skin Condition',\n" +
                    "existingConditionsSkinTable.bruiseEasily AS 'Bruise Easily',\n" +
                    "existingConditionsSkinTable.hypersensitiveReaction AS 'HypersensitiveReaction',\n" +
                    "existingConditionsSkinTable.melanoma AS 'Melanoma',\n" +
                    "existingConditionsSkinTable.skinConditions AS 'Skin Conditions',\n" +
                    "existingConditionsSkinTable.skinIrritations AS 'Skin Irritations',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsInfectiousTable ON customerTable.customerNumber = existingConditionsInfectiousTable.customerNumber\n" +
                    "JOIN existingConditionsSkinTable ON customerTable.customerNumber = existingConditionsSkinTable.customerNumber\n" +
                    "JOIN reasonForMassageTable ON customerTable.customerNumber = reasonForMassageTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (existingConditionsInfectiousTable.skinConditions = @iskin)\n" +
                    "AND (existingConditionsSkinTable.bruiseEasily = @skinTrue OR existingConditionsSkinTable.hypersensitiveReaction = @skinTrue OR existingConditionsSkinTable.melanoma = @skinTrue\n" +
                    "\tOR existingConditionsSkinTable.melanoma = @skinTrue OR existingConditionsSkinTable.skinConditions = @skinTrue OR existingConditionsSkinTable.skinIrritations = @skinTrue)");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new report14(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")),
                        new existingConditionsInfectiousTable(result.getBoolean("Infectious Skin Condition")),
                        new existingConditionsSkinTable(result.getBoolean("Bruise Easily"),
                                result.getBoolean("HypersensitiveReaction"), result.getBoolean("Melanoma"),
                                result.getBoolean("Skin Conditions"), result.getBoolean("Skin Irritations")),
                        new companyClientHistoryTable(result.getBoolean("Status"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<report5> getReport5() {
        Vector<report5> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@fhcardio bit = 0,\n" +
                    "@reason1 nvarchar(50),\n" +
                    "@reason2 nvarchar(50),\n" +
                    "@cardioTrue bit = 0\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @fhcardio = 1\n" +
                    "SELECT @reason1 = 'heart'\n" +
                    "SELECT @reason2 = 'heart and respiratory'\n" +
                    "SELECT @cardioTrue = 1\n" +
                    "\n" +
                    "\n" +
                    "SELECT\n" +
                    "\n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "existingConditionsFamilyHistoryTable.cardiovascularConditions AS 'Family History of Cardiovasular Condition',\n" +
                    "reasonForMassageTable.cause AS 'Reason for Massage',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status',\n" +
                    "existingConditionsCardiovascularTable.bloodClots AS 'Blood Clots',\n" +
                    "existingConditionsCardiovascularTable.cardiovascularAccident AS 'Cardiovascular Accident',\n" +
                    "existingConditionsCardiovascularTable.cerebralVascularAccident AS 'Cerebral Vascular Accident',\n" +
                    "existingConditionsCardiovascularTable.coldFeet AS 'Cold Feet',\n" +
                    "existingConditionsCardiovascularTable.coldHands AS 'Cold Hands',\n" +
                    "existingConditionsCardiovascularTable.congestiveHeartFailure AS 'Congestive Heart Failure',\n" +
                    "existingConditionsCardiovascularTable.heartAttack AS 'Heart Attack',\n" +
                    "existingConditionsCardiovascularTable.heartDisease AS 'Heart Disease',\n" +
                    "existingConditionsCardiovascularTable.highBloodPressure AS 'High Blood Pressure',\n" +
                    "existingConditionsCardiovascularTable.lowBloodPressure AS 'Low Blood Pressure',\n" +
                    "existingConditionsCardiovascularTable.lymphedema AS 'Lymphedema',\n" +
                    "existingConditionsCardiovascularTable.myocardialInfarction AS 'Myocardial Infarctin',\n" +
                    "existingConditionsCardiovascularTable.paceMaker AS 'Pace Maker',\n" +
                    "existingConditionsCardiovascularTable.phlebitis AS 'Phlebitis',\n" +
                    "existingConditionsCardiovascularTable.stroke AS 'Stroke',\n" +
                    "existingConditionsCardiovascularTable.thrombosisEmbolism AS 'Thrombosis Embolism',\n" +
                    "existingConditionsCardiovascularTable.varicoseVeins AS 'Varicose Veins'\n" +
                    "\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsFamilyHistoryTable ON customerTable.customerNumber = existingConditionsFamilyHistoryTable.customerNumber\n" +
                    "JOIN existingConditionsCardiovascularTable ON customerTable.customerNumber = existingConditionsCardiovascularTable.customerNumber\n" +
                    "JOIN reasonForMassageTable ON customerTable.customerNumber = reasonForMassageTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (existingConditionsFamilyHistoryTable.cardiovascularConditions = @fhcardio)\n" +
                    "AND (existingConditionsCardiovascularTable.bloodClots = @cardioTrue OR existingConditionsCardiovascularTable.cardiovascularAccident = @cardioTrue or existingConditionsCardiovascularTable.cerebralVascularAccident = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.coldFeet = @cardioTrue OR existingConditionsCardiovascularTable.coldHands = @cardioTrue OR existingConditionsCardiovascularTable.congestiveHeartFailure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.heartAttack = @cardioTrue OR existingConditionsCardiovascularTable.heartDisease = @cardioTrue OR existingConditionsCardiovascularTable.highBloodPressure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.lowBloodPressure = @cardioTrue OR existingConditionsCardiovascularTable.lymphedema = @cardioTrue OR existingConditionsCardiovascularTable.myocardialInfarction = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.paceMaker = @cardioTrue OR existingConditionsCardiovascularTable.phlebitis = @cardioTrue OR existingConditionsCardiovascularTable.stroke = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.thrombosisEmbolism = @cardioTrue OR existingConditionsCardiovascularTable.varicoseVeins = @cardioTrue)\n" +
                    "AND (reasonForMassageTable.cause like @reason1 OR reasonForMassageTable.cause like @reason2)");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new report5(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")),
                        new existingConditionsFamilyHistoryTable(result.getBoolean("Family History of Cardiovasular Condition")),
                        new reasonForMassageTable(result.getString("Reason for Massage")),
                        new companyClientHistoryTable(result.getBoolean("Status")),
                        new existingConditionsCardiovascularTable(result.getBoolean("Blood Clots"),
                                result.getBoolean("Cardiovascular Accident"), result.getBoolean("Cerebral Vascular Accident"),
                                result.getBoolean("Cold Feet"), result.getBoolean("Cold Hands"),
                                result.getBoolean("Congestive Heart Failure"), result.getBoolean("Heart Attack"),
                                result.getBoolean("Heart Disease"), result.getBoolean("High Blood Pressure"),
                                result.getBoolean("Low Blood Pressure"), result.getBoolean("Lymphedema"),
                                result.getBoolean("Myocardial Infarctin"), result.getBoolean("Pace Maker"),
                                result.getBoolean("Phlebitis"), result.getBoolean("Stroke"),
                                result.getBoolean("Thrombosis Embolism"), result.getBoolean("Varicose Veins"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<report6> getReport6() {
        Vector<report6> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@fhres bit = 0,\n" +
                    "@resTrue bit = 0\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @fhres = 1\n" +
                    "SELECT @resTrue = 1\n" +
                    "\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "existingConditionsFamilyHistoryTable.respiratoryConditions AS 'Family History of Respiratory Condition',\n" +
                    "existingConditionsRespiratoryTable.asthma AS 'Asthma',\n" +
                    "existingConditionsRespiratoryTable.bronchitis AS 'Bronchitis',\n" +
                    "existingConditionsRespiratoryTable.chronicCough AS 'Chronic Cough',\n" +
                    "existingConditionsRespiratoryTable.emphysema AS 'Emphysema',\n" +
                    "existingConditionsRespiratoryTable.shortnessOfBreath AS 'Shortness of Breathe',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsFamilyHistoryTable ON customerTable.customerNumber = existingConditionsFamilyHistoryTable.customerNumber\n" +
                    "JOIN existingConditionsRespiratoryTable ON customerTable.customerNumber = existingConditionsRespiratoryTable.customerNumber\n" +
                    "JOIN reasonForMassageTable ON customerTable.customerNumber = reasonForMassageTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND (existingConditionsFamilyHistoryTable.respiratoryConditions = @fhres)\n" +
                    "AND (existingConditionsRespiratoryTable.asthma = @resTrue OR existingConditionsRespiratoryTable.bronchitis = @resTrue OR existingConditionsRespiratoryTable.chronicCough = @resTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @resTrue)");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new report6(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")),
                        new existingConditionsFamilyHistoryTable(result.getBoolean("Family History of Respiratory Condition")),
                        new existingConditionsRespiratoryTable(result.getBoolean("Asthma"),
                                result.getBoolean("Bronchitis"), result.getBoolean("Chronic Cough"),
                                result.getBoolean("Emphysema"), result.getBoolean("Shortness of Breathe")),
                        new companyClientHistoryTable(result.getBoolean("Status"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<report7> getReport7() {
        Vector<report7> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@misTrue bit = 0,\n" +
                    "@reason nvarchar(50),\n" +
                    "@medTrue nvarchar(50)\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @misTrue = 1\n" +
                    "SELECT @reason = 'NULL'\n" +
                    "SELECT @medTrue = 'NULL'\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status',\n" +
                    "existingConditionsMedicationsTable.other AS 'Taking Medication',\n" +
                    "reasonForMassageTable.cause AS 'Reason',\n" +
                    "existingConditionsMisTable.arthritis AS 'Arthritis',\n" +
                    "existingConditionsMisTable.anaphylaxis AS 'Anaphylaxis',\n" +
                    "existingConditionsMisTable.artificialJointsSpecialEquipment AS 'Artificial Joint',\n" +
                    "existingConditionsMisTable.allergies AS 'Allergies',\n" +
                    "existingConditionsMisTable.cancer AS 'Cancer',\n" +
                    "existingConditionsMisTable.chrohnsDisease AS 'Chrohns Disease',\n" +
                    "existingConditionsMisTable.diabetes AS 'Diabetes',\n" +
                    "existingConditionsMisTable.digestiveConditions AS 'Digestive Conditions',\n" +
                    "existingConditionsMisTable.dizziness AS 'Dizziness',\n" +
                    "existingConditionsMisTable.epilepsy AS 'Epilepsy',\n" +
                    "existingConditionsMisTable.fibromyalgia AS 'Fibromyalgia',\n" +
                    "existingConditionsMisTable.hemophilia AS 'Hemophilia',\n" +
                    "existingConditionsMisTable.insomnia AS 'Insomnia',\n" +
                    "existingConditionsMisTable.lossOfSensation AS 'Loss of Sensation',\n" +
                    "existingConditionsMisTable.lupus AS 'Lupus',\n" +
                    "existingConditionsMisTable.mentalIllness AS 'Mental Illness',\n" +
                    "existingConditionsMisTable.osteoArthritis AS 'OsteoArthritis',\n" +
                    "existingConditionsMisTable.osteoporosis AS 'Osteoporosis',\n" +
                    "existingConditionsMisTable.otherDiagnosedDiseases AS 'Other Diagnosed Disease',\n" +
                    "existingConditionsMisTable.otherMedicalConditions AS 'Other Medical Conditions',\n" +
                    "existingConditionsMisTable.rheumatoidArthritis AS 'RheumadtoidArthritis',\n" +
                    "existingConditionsMisTable.shingles AS 'Shingles',\n" +
                    "existingConditionsMisTable.stress AS 'Stress',\n" +
                    "existingConditionsMisTable.surgicalPinsOrWire AS 'Surgical Pins or Wire'\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsMisTable ON customerTable.customerNumber = existingConditionsMisTable.customerNumber\n" +
                    "JOIN existingConditionsMedicationsTable ON customerTable.customerNumber = existingConditionsMedicationsTable.customerNumber\n" +
                    "JOIN reasonForMassageTable ON customerTable.customerNumber = reasonForMassageTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND reasonForMassageTable.cause != 'NULL'\n" +
                    "AND (existingConditionsMisTable.allergies = @misTrue OR existingConditionsMisTable.anaphylaxis = @misTrue\n" +
                    "\tOR existingConditionsMisTable.arthritis = @misTrue OR existingConditionsMisTable.artificialJointsSpecialEquipment = @misTrue\n" +
                    "\tOR existingConditionsMisTable.cancer = @misTrue OR existingConditionsMisTable.chrohnsDisease = @misTrue\n" +
                    "\tOR existingConditionsMisTable.diabetes = @misTrue OR existingConditionsMisTable.digestiveConditions = @misTrue\n" +
                    "\tOR existingConditionsMisTable.digestiveConditions = @misTrue OR existingConditionsMisTable.dizziness = @misTrue\n" +
                    "\tOR existingConditionsMisTable.epilepsy = @misTrue OR existingConditionsMisTable.fibromyalgia = @misTrue\n" +
                    "\tOR existingConditionsMisTable.hemophilia = @misTrue OR existingConditionsMisTable.insomnia = @misTrue\n" +
                    "\tOR existingConditionsMisTable.lossOfSensation = @misTrue OR existingConditionsMisTable.lupus = @misTrue\n" +
                    "\tOR existingConditionsMisTable.mentalIllness = @misTrue OR existingConditionsMisTable.osteoArthritis = @misTrue\n" +
                    "\tOR existingConditionsMisTable.osteoporosis = @misTrue OR existingConditionsMisTable.otherDiagnosedDiseases = @misTrue\n" +
                    "\tOR existingConditionsMisTable.otherMedicalConditions = @misTrue OR existingConditionsMisTable.rheumatoidArthritis = @misTrue\n" +
                    "\tOR existingConditionsMisTable.shingles = @misTrue OR existingConditionsMisTable.stress = @misTrue\n" +
                    "\tOR existingConditionsMisTable.surgicalPinsOrWire = @misTrue)\n" +
                    "AND existingConditionsMedicationsTable.other != @medTrue");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new report7(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")),
                        new companyClientHistoryTable(result.getBoolean("Status")),
                        new existingConditionsMedicationsTable(result.getString("Taking Medication")),
                        new reasonForMassageTable(result.getString("Reason")),
                        new existingConditionsMisTable(result.getBoolean("Arthritis"), result.getBoolean("Anaphylaxis"),
                                result.getBoolean("Artificial Joint"), result.getBoolean("Allergies"), result.getBoolean("Cancer"),
                                result.getBoolean("Chrohns Disease"), result.getBoolean("Diabetes"), result.getBoolean("Digestive Conditions"),
                                result.getBoolean("Dizziness"), result.getBoolean("Epilepsy"), result.getBoolean("Fibromyalgia"),
                                result.getBoolean("Hemophilia"), result.getBoolean("Insomnia"), result.getBoolean("Loss of Sensation"),
                                result.getBoolean("Lupus"), result.getBoolean("Mental Illness"), result.getBoolean("OsteoArthritis"),
                                result.getBoolean("Osteoporosis"), result.getBoolean("Other Diagnosed Disease"),
                                result.getBoolean("Other Medical Conditions"), result.getBoolean("RheumadtoidArthritis"),
                                result.getBoolean("Shingles"), result.getBoolean("Stress"), result.getBoolean("Surgical Pins or Wire"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<report8> getReport8() {
        Vector<report8> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@status bit = 0,\n" +
                    "@cardioTrue bit = 0,\n" +
                    "@cardioFalse bit = 0,\n" +
                    "@resTrue bit = 0,\n" +
                    "@resFalse bit = 0,\n" +
                    "@hnTrue bit = 0,\n" +
                    "@hnFalse bit = 0,\n" +
                    "@iTrue bit = 0,\n" +
                    "@iFalse bit = 0,\n" +
                    "@preg bit = 0,\n" +
                    "@ack bit = 0,\n" +
                    "@doctorNoPhone nvarchar(50),\n" +
                    "@emergencyNoPhone nvarchar(50)\n" +
                    "\n" +
                    "SELECT @status = 1\n" +
                    "SELECT @cardioTrue = 1\n" +
                    "SELECT @cardioFalse = 0\n" +
                    "SELECT @resTrue = 1\n" +
                    "SELECT @resFalse = 0\n" +
                    "SELECT @hnTrue = 1\n" +
                    "SELECT @hnFalse = 0\n" +
                    "SELECT @iTrue = 1\n" +
                    "SELECT @preg = 1\n" +
                    "SELECT @ack = 1\n" +
                    "SELECT @doctorNoPhone = 'NULL'\n" +
                    "SELECT @emergencyNoPhone = 'NULL'\n" +
                    "\n" +
                    "SELECT \n" +
                    "customerTable.customerNumber AS 'Client Profile Number',\n" +
                    "customerTable.firstName AS 'Client First Name',\n" +
                    "customerTable.lastName AS 'Client Last Name',\n" +
                    "companyClientHistoryTable.currentClient AS 'Status',\n" +
                    "existingConditionsMedicationsTable.other AS 'Medications',\n" +
                    "doctorTable.physicianLastname AS 'Physician Last Name',\n" +
                    "doctorTable.physicianPhone AS 'Physician Phone Number',\n" +
                    "emergencyContactTable.emergencyFirstName AS 'Emergency First Name',\n" +
                    "emergencyContactTable.emergencyLastName AS 'Emergency Last Name',\n" +
                    "emergencyContactTable.emergencyPhone AS 'Emergency Phone Number',\n" +
                    "emergencyContactTable.relationship AS 'Emergency Relationship'\n" +
                    "\n" +
                    "\n" +
                    "FROM customerTable\n" +
                    "JOIN existingConditionsCardiovascularTable ON customerTable.customerNumber = existingConditionsCardiovascularTable.customerNumber\n" +
                    "JOIN existingConditionsHeadNeckTable ON customerTable.customerNumber = existingConditionsHeadNeckTable.customerNumber\n" +
                    "JOIN existingConditionsInfectiousTable ON customerTable.customerNumber = existingConditionsInfectiousTable.customerNumber\n" +
                    "JOIN existingConditionsMedicationsTable ON customerTable.customerNumber = existingConditionsMedicationsTable.customerNumber\n" +
                    "JOIN existingConditionsNeurologicalTable ON customerTable.customerNumber = existingConditionsNeurologicalTable.customerNumber\n" +
                    "JOIN existingConditionsRespiratoryTable ON customerTable.customerNumber = existingConditionsRespiratoryTable.customerNumber\n" +
                    "JOIN existingConditionsSkinTable ON customerTable.customerNumber = existingConditionsSkinTable.customerNumber\n" +
                    "JOIN existingConditionsSTJDTable ON customerTable.customerNumber = existingConditionsSTJDTable.customerNumber\n" +
                    "JOIN existingConditionsWomenTable ON customerTable.customerNumber = existingConditionsWomenTable.customerNumber\n" +
                    "JOIN companyClientHistoryTable ON customerTable.customerNumber = companyClientHistoryTable.customerNumber\n" +
                    "--\n" +
                    "JOIN doctorTable ON customerTable.customerNumber = doctorTable.customerNumber\n" +
                    "JOIN waiverTable ON customerTable.customerNumber = waiverTable.customerNumber\n" +
                    "JOIN emergencyContactTable ON customerTable.customerNumber = emergencyContactTable.customerNumber\n" +
                    "\n" +
                    "WHERE companyClientHistoryTable.currentClient = @status\n" +
                    "AND existingConditionsWomenTable.pregnant = @preg\n" +
                    "AND ((existingConditionsCardiovascularTable.bloodClots = @cardioTrue OR existingConditionsCardiovascularTable.cardiovascularAccident = @cardioTrue or existingConditionsCardiovascularTable.cerebralVascularAccident = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.coldFeet = @cardioTrue OR existingConditionsCardiovascularTable.coldHands = @cardioTrue OR existingConditionsCardiovascularTable.congestiveHeartFailure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.heartAttack = @cardioTrue OR existingConditionsCardiovascularTable.heartDisease = @cardioTrue OR existingConditionsCardiovascularTable.highBloodPressure = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.lowBloodPressure = @cardioTrue OR existingConditionsCardiovascularTable.lymphedema = @cardioTrue OR existingConditionsCardiovascularTable.myocardialInfarction = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.paceMaker = @cardioTrue OR existingConditionsCardiovascularTable.phlebitis = @cardioTrue OR existingConditionsCardiovascularTable.stroke = @cardioTrue\n" +
                    "\tOR existingConditionsCardiovascularTable.thrombosisEmbolism = @cardioTrue OR existingConditionsCardiovascularTable.varicoseVeins = @cardioTrue)\n" +
                    "OR (existingConditionsRespiratoryTable.asthma = @resTrue OR existingConditionsRespiratoryTable.bronchitis = @resTrue OR existingConditionsRespiratoryTable.chronicCough = @resTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @resTrue)\n" +
                    "OR (existingConditionsHeadNeckTable.earProblems = @hnTrue OR existingConditionsHeadNeckTable.headaches = @hnTrue OR existingConditionsHeadNeckTable.hearingLoss = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.jawPain = @hnTrue OR existingConditionsHeadNeckTable.migraines = @hnTrue OR existingConditionsHeadNeckTable.sinusProblems = @hnTrue\n" +
                    "\tOR existingConditionsHeadNeckTable.visionLoss = @hnTrue OR existingConditionsHeadNeckTable.visionProblems = @hnTrue)\n" +
                    "OR (existingConditionsInfectiousTable.altheletsFoot = @iTrue OR existingConditionsInfectiousTable.hepatitis = @iTrue OR existingConditionsInfectiousTable.herpes = @iTrue\n" +
                    "\tOR existingConditionsInfectiousTable.hiv = @iTrue OR existingConditionsInfectiousTable.respiratoryConditions = @iTrue OR existingConditionsInfectiousTable.skinConditions = @iTrue)\n" +
                    "OR (existingConditionsNeurologicalTable.burning = @iTrue OR existingConditionsNeurologicalTable.cerebralPaisy = @iTrue OR existingConditionsNeurologicalTable.herniatedDisc = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.multipleSclerosis = @iTrue OR existingConditionsNeurologicalTable.numbness = @iTrue OR existingConditionsNeurologicalTable.parkinsons = @iTrue\n" +
                    "\tOR existingConditionsNeurologicalTable.stabbingPain = @iTrue OR existingConditionsNeurologicalTable.tingling = @iTrue)\n" +
                    "OR (existingConditionsRespiratoryTable.asthma = @iTrue OR existingConditionsRespiratoryTable.bronchitis = @iTrue OR existingConditionsRespiratoryTable.chronicCough = @iTrue\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @iTrue OR existingConditionsRespiratoryTable.shortnessOfBreath = @iTrue)\n" +
                    "OR (existingConditionsSkinTable.bruiseEasily = @iTrue OR existingConditionsSkinTable.hypersensitiveReaction = @iTrue OR existingConditionsSkinTable.melanoma = @iTrue\n" +
                    "\tOR existingConditionsSkinTable.skinConditions = @iTrue OR existingConditionsSkinTable.skinIrritations = @iTrue)\n" +
                    "OR (existingConditionsSTJDTable.anklesLeft = @iTrue OR existingConditionsSTJDTable.anklesRight = @iTrue OR existingConditionsSTJDTable.armsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.armsRight = @iTrue OR existingConditionsSTJDTable.feetLeft = @iTrue OR existingConditionsSTJDTable.feetRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.handsLeft = @iTrue OR existingConditionsSTJDTable.handsRight = @iTrue OR existingConditionsSTJDTable.hipsLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.hipsRight = @iTrue OR existingConditionsSTJDTable.kneesLeft = @iTrue OR existingConditionsSTJDTable.kneesRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.legsLeft = @iTrue OR existingConditionsSTJDTable.legsRight = @iTrue OR existingConditionsSTJDTable.lowerBackLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.lowerBackRight = @iTrue OR existingConditionsSTJDTable.midBackLeft = @iTrue OR existingConditionsSTJDTable.midBackRight = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.neckLeft = @iTrue OR existingConditionsSTJDTable.neckRight = @iTrue OR existingConditionsSTJDTable.shouldersLeft = @iTrue\n" +
                    "\tOR existingConditionsSTJDTable.shouldersRight = @iTrue OR existingConditionsSTJDTable.upperBackLeft = @iTrue OR existingConditionsSTJDTable.upperBackRight = @iTrue)\n" +
                    "--\n" +
                    "OR (existingConditionsCardiovascularTable.bloodClots = @cardioFalse OR existingConditionsCardiovascularTable.cardiovascularAccident = @cardioFalse or existingConditionsCardiovascularTable.cerebralVascularAccident = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.coldFeet = @cardioFalse OR existingConditionsCardiovascularTable.coldHands = @cardioFalse OR existingConditionsCardiovascularTable.congestiveHeartFailure = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.heartAttack = @cardioFalse OR existingConditionsCardiovascularTable.heartDisease = @cardioFalse OR existingConditionsCardiovascularTable.highBloodPressure = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.lowBloodPressure = @cardioFalse OR existingConditionsCardiovascularTable.lymphedema = @cardioFalse OR existingConditionsCardiovascularTable.myocardialInfarction = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.paceMaker = @cardioFalse OR existingConditionsCardiovascularTable.phlebitis = @cardioFalse OR existingConditionsCardiovascularTable.stroke = @cardioFalse\n" +
                    "\tOR existingConditionsCardiovascularTable.thrombosisEmbolism = @cardioFalse OR existingConditionsCardiovascularTable.varicoseVeins = @cardioFalse)\n" +
                    "OR (existingConditionsRespiratoryTable.asthma = @resFalse OR existingConditionsRespiratoryTable.bronchitis = @resFalse OR existingConditionsRespiratoryTable.chronicCough = @resFalse\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @resFalse OR existingConditionsRespiratoryTable.shortnessOfBreath = @resFalse)\n" +
                    "OR (existingConditionsHeadNeckTable.earProblems = @hnFalse OR existingConditionsHeadNeckTable.headaches = @hnFalse OR existingConditionsHeadNeckTable.hearingLoss = @hnFalse\n" +
                    "\tOR existingConditionsHeadNeckTable.jawPain = @hnFalse OR existingConditionsHeadNeckTable.migraines = @hnFalse OR existingConditionsHeadNeckTable.sinusProblems = @hnFalse\n" +
                    "\tOR existingConditionsHeadNeckTable.visionLoss = @hnFalse OR existingConditionsHeadNeckTable.visionProblems = @hnFalse)\n" +
                    "OR (existingConditionsInfectiousTable.altheletsFoot = @iFalse OR existingConditionsInfectiousTable.hepatitis = @iFalse OR existingConditionsInfectiousTable.herpes = @iFalse\n" +
                    "\tOR existingConditionsInfectiousTable.hiv = @iFalse OR existingConditionsInfectiousTable.respiratoryConditions = @iFalse OR existingConditionsInfectiousTable.skinConditions = @iFalse)\n" +
                    "OR (existingConditionsNeurologicalTable.burning = @iFalse OR existingConditionsNeurologicalTable.cerebralPaisy = @iFalse OR existingConditionsNeurologicalTable.herniatedDisc = @iFalse\n" +
                    "\tOR existingConditionsNeurologicalTable.multipleSclerosis = @iFalse OR existingConditionsNeurologicalTable.numbness = @iFalse OR existingConditionsNeurologicalTable.parkinsons = @iFalse\n" +
                    "\tOR existingConditionsNeurologicalTable.stabbingPain = @iFalse OR existingConditionsNeurologicalTable.tingling = @iFalse)\n" +
                    "OR (existingConditionsRespiratoryTable.asthma = @iFalse OR existingConditionsRespiratoryTable.bronchitis = @iFalse OR existingConditionsRespiratoryTable.chronicCough = @iFalse\n" +
                    "\tOR existingConditionsRespiratoryTable.emphysema = @iFalse OR existingConditionsRespiratoryTable.shortnessOfBreath = @iFalse)\n" +
                    "OR (existingConditionsSkinTable.bruiseEasily = @iFalse OR existingConditionsSkinTable.hypersensitiveReaction = @iFalse OR existingConditionsSkinTable.melanoma = @iFalse\n" +
                    "\tOR existingConditionsSkinTable.skinConditions = @iFalse OR existingConditionsSkinTable.skinIrritations = @iFalse)\n" +
                    "OR (existingConditionsSTJDTable.anklesLeft = @iFalse OR existingConditionsSTJDTable.anklesRight = @iFalse OR existingConditionsSTJDTable.armsLeft = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.armsRight = @iFalse OR existingConditionsSTJDTable.feetLeft = @iFalse OR existingConditionsSTJDTable.feetRight = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.handsLeft = @iFalse OR existingConditionsSTJDTable.handsRight = @iFalse OR existingConditionsSTJDTable.hipsLeft = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.hipsRight = @iFalse OR existingConditionsSTJDTable.kneesLeft = @iFalse OR existingConditionsSTJDTable.kneesRight = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.legsLeft = @iFalse OR existingConditionsSTJDTable.legsRight = @iFalse OR existingConditionsSTJDTable.lowerBackLeft = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.lowerBackRight = @iFalse OR existingConditionsSTJDTable.midBackLeft = @iFalse OR existingConditionsSTJDTable.midBackRight = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.neckLeft = @iFalse OR existingConditionsSTJDTable.neckRight = @iFalse OR existingConditionsSTJDTable.shouldersLeft = @iFalse\n" +
                    "\tOR existingConditionsSTJDTable.shouldersRight = @iFalse OR existingConditionsSTJDTable.upperBackLeft = @iFalse OR existingConditionsSTJDTable.upperBackRight = @iFalse)\n" +
                    "--\n" +
                    "AND waiverTable.acknowledgment = @ack\n" +
                    "AND doctorTable.physicianPhone != @doctorNoPhone\n" +
                    "AND emergencyContactTable.emergencyPhone != @emergencyNoPhone)");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new report8(new customerTable(result.getInt("Client Profile Number"),
                        result.getString("Client First Name"), result.getString("Client Last Name")),
                        new companyClientHistoryTable(result.getBoolean("Status")),
                        new existingConditionsMedicationsTable(result.getString("Medications")),
                        new doctorTable(result.getString("Physician Last Name"), result.getString("Physician Phone Number")),
                        new emergencyContactTable(result.getString("Emergency First Name"), result.getString("Emergency Last Name"),
                            result.getString("Emergency Phone Number"), result.getString("Emergency Relationship"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static void updateRowByID(int customerNumberInput,int storeCreditInput, String firstNameInput, String lastNameInput, String genderInput, String phoneInput, String emailInput, String birthdayInput, String addressInput) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE customerTable SET storeCredit=?, firstName=?, lastName=?, gender=?, phone=?, email=?, birthday=?, address=? WHERE customerNumber=?");
            ps.setInt(1, storeCreditInput);
            ps.setString(2, firstNameInput);
            ps.setString(3, lastNameInput);
            ps.setString(4, genderInput);
            ps.setString(5, phoneInput);
            ps.setString(6, emailInput);
            ps.setString(7, birthdayInput);
            ps.setString(8, addressInput);
            ps.setInt(9, customerNumberInput);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void updateDoctorRowByID(int customerNumberInput,int doctoNuberInput, String physicianFirstnameInput, String physicianLastnameInput, String physicianPhoneInput) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE doctorTable SET doctorNuber=?, physicianFirstname=?, physicianLastname=?, physicianPhone=? WHERE customerNumber=?");
            ps.setInt(1, doctoNuberInput);
            ps.setString(2, physicianFirstnameInput);
            ps.setString(3, physicianLastnameInput);
            ps.setString(4, physicianPhoneInput);
            ps.setInt(5, customerNumberInput);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void updateCompanyRowByID(int customerNumberInput, boolean currentClient) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE companyClientHistoryTable SET currentClient=? WHERE customerNumber=?");
            ps.setBoolean(1, currentClient);
            ps.setInt(2, customerNumberInput);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void updateWaiverRowByID(int customerNumberInput, String signiture, String date, boolean acknowledgment) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE waiverTable SET signiture=?, date=?, acknowledgment=? WHERE customerNumber=?");
            ps.setString(1, signiture);
            ps.setString(2, date);
            ps.setBoolean(3, acknowledgment);
            ps.setInt(4, customerNumberInput);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void updateEmergencyRowByID(int customerNumberInput, String emergencyFirstNameInput, String emergencyLastNameInput, String emergencyPhoneInput, String relationshipInput) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE emergencyContactTable SET emergencyFirstName=?, emergencyLastName=?, emergencyPhone=?, relationship=? WHERE customerNumber=?");
            ps.setString(1, emergencyFirstNameInput);
            ps.setString(2, emergencyLastNameInput);
            ps.setString(3, emergencyPhoneInput);
            ps.setString(4, relationshipInput);
            ps.setInt(5, customerNumberInput);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void insertRowByID(int rowToInsert,int rowToInsert2, String rowToInsert3, String rowToInsert4, String rowToInsert5, String rowToInsert6, String rowToInsert7, String rowToInsert8, String rowToInsert9) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO customerTable (customerNumber, firstName, lastName, gender, phone, email, birthday, address, storeCredit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, rowToInsert);
            ps.setInt(9, rowToInsert2);
            ps.setString(2, rowToInsert3);
            ps.setString(3, rowToInsert4);
            ps.setString(4, rowToInsert5);
            ps.setString(5, rowToInsert6);
            ps.setString(6, rowToInsert7);
            ps.setString(7, rowToInsert8);
            ps.setString(8, rowToInsert9);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void insertDoctorRowByID(int rowToInsert,int rowToInsert2, String rowToInsert3, String rowToInsert4, String rowToInsert5) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO doctorTable (customerNumber, doctorNuber, physicianFirstname, physicianLastname, physicianPhone) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, rowToInsert);
            ps.setInt(2, rowToInsert2);
            ps.setString(3, rowToInsert3);
            ps.setString(4, rowToInsert4);
            ps.setString(5, rowToInsert5);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void insertCompanyRowByID(int rowToInsert, boolean rowToInsert2) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO companyClientHistoryTable (customerNumber, currentClient) VALUES (?, ?)");
            ps.setInt(1, rowToInsert);
            ps.setBoolean(2, rowToInsert2);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void insertWaiverRowByID(int customerNumber, String signiture, String date, boolean acknowledgment) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO waiverTable (customerNumber, signiture, date, acknowledgment) VALUES (?, ?, ?, ?)");
            ps.setInt(1, customerNumber);
            ps.setString(2, signiture);
            ps.setString(3, date);
            ps.setBoolean(4, acknowledgment);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void insertEmergencyRowByID(int customerNumberInput, String emergencyFirstNameInput, String emergencyLastNameInput, String emergencyPhoneInput, String relationshipInput) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO emergencyContactTable (customerNumber, emergencyFirstName, emergencyLastName, emergencyPhone, relationship) VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, customerNumberInput);
            ps.setString(2, emergencyFirstNameInput);
            ps.setString(3, emergencyLastNameInput);
            ps.setString(4, emergencyPhoneInput);
            ps.setString(5, relationshipInput);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void deleteRowByID(int rowToDelete) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM customerTable WHERE customerNumber=?");
            ps.setInt(1, rowToDelete);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDoctorRowByID(int rowToDelete) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM doctorTable WHERE customerNumber=?");
            ps.setInt(1, rowToDelete);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteCompanyRowByID(int rowToDelete) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM companyClientHistoryTable WHERE customerNumber=?");
            ps.setInt(1, rowToDelete);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteWaiverRowByID(int rowToDelete) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM waiverTable WHERE customerNumber=?");
            ps.setInt(1, rowToDelete);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmergencyRowByID(int rowToDelete) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM emergencyContactTable WHERE customerNumber=?");
            ps.setInt(1, rowToDelete);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Vector<appointmentsTable> getReport15() {
        Vector<appointmentsTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@hotStone int = 0,\n" +
                    "@startDate nvarchar(10),\n" +
                    "@date2 nvarchar(10), \n" +
                    "@date3 nvarchar(10), \n" +
                    "@date4 nvarchar(10), \n" +
                    "@endDate nvarchar(10), \n" +
                    "\n" +
                    "SELECT @hotStone = 4\n" +
                    "SELECT @startDate = '7/13/2020', \n" +
                    "SELECT @date2 = '7/14/2020', \n" +
                    "SELECT @date3 = '7/15/2020', \n" +
                    "SELECT @date4 = '7/16/2020', \n" +
                    "SELECT @endDate = '7/17/2020', \n" +
                    "\n" +
                    "SELECT \n" +
                    "appointmentsTable.customerNumber AS 'Client ID',\n" +
                    "appointmentsTable.scheduledDate AS 'Appointment Date',\n" +
                    "appointmentsTable.scheduledTime AS 'Appointment Time',\n" +
                    "appointmentsTable.addOnNumber AS 'Add-On',\n" +
                    "\n" +
                    "FROM appointmentsTable\n" +
                    "JOIN addOnsTable ON appointmentsTable.addOnNumber = addOnsTable.addOnNumber\n" +
                    "JOIN packagesTable ON appointmentsTable.packageNumber = packagesTable.packageNumber\n" +
                    "JOIN servicesTable ON appointmentsTable.serviceNumber = servicesTable.serviceNumber\n" +
                    "JOIN FAQTable ON appointmentsTable.serviceNumber = FAQTable.serviceNumber\n" +
                    "\n" +
                    "WHERE appointmentsTable.addOnNumber = @hotStone\n" +
                    "AND (appointmentsTable.scheduledDate = @startDate OR appointmentsTable.scheduledDate = @date2)\n" +
                    "\tOR (appointmentsTable.scheduledDate = @date3 OR appointmentsTable.scheduledDate = @date4)" +
                    "\tOR appointmentsTable.scheduledDate = @endDate)");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new appointmentsTable(result.getInt("Client ID Number"),
                        (result.getString("Appointment Date")),
                        (result.getString("Appointment Time")),
                        (result.getInt("Add-On"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<appointmentsTable> getReport16() {
        Vector<appointmentsTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@smallNum int = 0,\n" +
                    "\n" +
                    "SELECT @smallNum = 995\n" +
                    "\n" +
                    "SELECT \n" +
                    "appointmentsTable.customerNumber AS 'Client ID',\n" +
                    "appointmentsTable.scheduledDate AS 'Appointment Date',\n" +
                    "appointmentsTable.packageNumber AS 'Appointment Time',\n" +
                    "appointmentsTable.addOnNumber AS 'Add-On',\n" +
                    "appointmentsTable.actualPricePaid AS 'Price Paid',\n" +
                    "\n" +
                    "FROM appointmentsTable\n" +
                    "JOIN customerTable ON appointmentsTable.customerNumber = customerTable.customerNumber\n" +
                    "JOIN addOnsTable ON appointmentsTable.addOnNumber = addOnsTable.addOnNumber\n" +
                    "JOIN servicesTable ON appointmentsTable.serviceNumber = servicesTable.serviceNumber\n" +
                    "JOIN FAQTable ON appointmentsTable.serviceNumber = FAQTable.serviceNumber\n" +
                    "\n" +
                    "WHERE appointmentsTable.actualPricePaid = @smallNum\n");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new appointmentsTable(result.getInt("Client ID Number"),
                        (result.getString("Purchase Date")),
                        (result.getInt("Package Number")),
                        (result.getInt("Add-On")),
                        (result.getDouble("Price Paid"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }
    public static Vector<report17> getReport17() {
        Vector<report17> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@hotStone int = 0,\n" +
                    "@startDate nvarchar(10),\n" +
                    "@date2 nvarchar(10), \n" +
                    "@date3 nvarchar(10), \n" +
                    "@date4 nvarchar(10), \n" +
                    "@endDate nvarchar(10), \n" +
                    "\n" +
                    "SELECT @hotStone = 4\n" +
                    "SELECT @startDate = '7/13/2020', \n" +
                    "SELECT @date2 = '7/14/2020', \n" +
                    "SELECT @date3 = '7/15/2020', \n" +
                    "SELECT @date4 = '7/16/2020', \n" +
                    "SELECT @endDate = '7/17/2020', \n" +
                    "\n" +
                    "SELECT \n" +
                    "appointmentsTable.scheduledDate AS 'Appointment Date',\n" +
                    "appointmentsTable.customerNumber AS 'Customer ID',\n" +
                    "appointmentsTable.packageNumber AS 'Package Purchased',\n" +
                    "appointmentsTable.serviceNumber AS 'Service Number',\n" +
                    "appointmentsTable.addOnNumber AS 'Add-On',\n" +
                    "FAQTable.question AS 'Question Asked',\n" +
                    "\n" +
                    "FROM appointmentsTable\n" +
                    "JOIN addOnsTable ON appointmentsTable.addOnNumber = addOnsTable.addOnNumber\n" +
                    "JOIN packagesTable ON appointmentsTable.packageNumber = packagesTable.packageNumber\n" +
                    "JOIN servicesTable ON appointmentsTable.serviceNumber = servicesTable.serviceNumber\n" +
                    "JOIN FAQTable ON appointmentsTable.serviceNumber = FAQTable.serviceNumber\n" +
                    "\n" +
                    "WHERE appointmentsTable.scheduledDate = @startDate OR appointmentsTable.scheduledDate = @date2 OR " +
                    "appointmentsTable.scheduledDate = @date3 \n" +
                    "\tOR appointmentsTable.scheduledDate = @endDate OR appointmentsTable.scheduledDate = @date4");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new report17(result.getString("Appointment Date"),
                        (result.getInt("Client ID")),
                        (result.getInt("Package Bought")),
                        (result.getInt("Service Number")),
                        (result.getInt("Add-On")),
                        (result.getString("Question Asked"))));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<report18> getReport18() {
        Vector<report18> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("DECLARE\n" +
                    "@importantQuestion,\n" +
                    "@startDate nvarchar(10),\n" +
                    "@date2 nvarchar(10), \n" +
                    "@date3 nvarchar(10), \n" +
                    "@date4 nvarchar(10), \n" +
                    "@endDate nvarchar(10), \n" +
                    "\n" +
                    "SELECT @importantQuestion = 11\n" +
                    "SELECT @startDate = '5/13/2020', \n" +
                    "SELECT @date2 = '5/14/2020', \n" +
                    "SELECT @date3 = '5/15/2020', \n" +
                    "SELECT @date4 = '5/16/2020', \n" +
                    "SELECT @endDate = '5/17/2020', \n" +
                    "\n" +
                    "SELECT \n" +
                    "appointmentsTable.customerNumber AS 'Customer ID',\n" +
                    "appointmentsTable.packageNumber AS 'Appointment Date',\n" +
                    "appointmentsTable.serviceNumber AS 'Service Number',\n" +
                    "FAQTable.question AS 'Question Asked',\n" +
                    "\n" +
                    "FROM appointmentsTable\n" +
                    "JOIN addOnsTable ON appointmentsTable.addOnNumber = addOnsTable.addOnNumber\n" +
                    "JOIN packagesTable ON appointmentsTable.packageNumber = packagesTable.packageNumber\n" +
                    "JOIN servicesTable ON appointmentsTable.serviceNumber = servicesTable.serviceNumber\n" +
                    "JOIN FAQTable ON appointmentsTable.serviceNumber = FAQTable.serviceNumber\n" +
                    "\n" +
                    "WHERE FAQTable.faqNumber = @importantQuesiton " +
                    "AND appointmentsTable.scheduledDate = @startDate OR " +
                    "appointmentsTable.scheduledDate = @date2 OR appointmentsTable.scheduledDate = @date3\n" +
                    "\tOR appointmentsTable.scheduledDate = @endDate OR appointmentsTable.scheduledDate = @date4");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new report18(
                        (result.getInt("Client ID")),
                        (result.getString("Appointment Date")),
                        (result.getString("Question Asked")),
                        (result.getInt("Service Number"))
                        ));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }


    public static void cancelAppointment(int aptNum, boolean isLate) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT actualPricePaid FROM appointmentsTable WHERE appointmentNumber=?");
            preparedStatement.setInt(1, aptNum);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                double price = resultSet.getInt(1);
                preparedStatement = connection.prepareStatement("UPDATE appointmentsTable SET actualPricePaid=?, cancelledDateTime=? WHERE appointmentNumber=?");
                preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
                preparedStatement.setInt(3, aptNum);
                if (isLate){
                    preparedStatement.setDouble(1, price*.5);
                } else {
                    preparedStatement.setDouble(1, 0);
                }
                preparedStatement.setInt(2, aptNum);
                preparedStatement.executeUpdate();
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Vector<companyClientHistoryTable> getcompanyClientHistory() {
        Vector<companyClientHistoryTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM companyClientHistoryTable");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new companyClientHistoryTable(result.getInt("customerNumber"),
                        result.getBoolean("currentClient")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<existingConditionsWomenTable> getExistingConditionsWomen() {
        Vector<existingConditionsWomenTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM existingConditionsWomenTable");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new existingConditionsWomenTable(result.getInt("customerNumber"),
                        result.getBoolean("pregnant"), result.getBoolean("gynecologicalConditions")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<existingConditionsSTJDTable> getExistingConditionsSTJD() {
        Vector<existingConditionsSTJDTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM existingConditionsSTJDTable");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new existingConditionsSTJDTable(result.getInt("customerNumber"),
                        result.getBoolean("upperBackRight"), result.getBoolean("upperBackLeft"),
                        result.getBoolean("shouldersRight"), result.getBoolean("shouldersLeft"),
                        result.getBoolean("neckRight"), result.getBoolean("neckLeft"),
                        result.getBoolean("midBackRight"), result.getBoolean("midBackLeft"),
                        result.getBoolean("lowerBackRight"), result.getBoolean("lowerBackLeft"),
                        result.getBoolean("legsRight"), result.getBoolean("legsLeft"),
                        result.getBoolean("kneesRight"), result.getBoolean("kneesLeft"),
                        result.getBoolean("hipsRight"), result.getBoolean("hipsLeft"),
                        result.getBoolean("handsRight"), result.getBoolean("handsLeft"),
                        result.getBoolean("feetRight"), result.getBoolean("feetLeft"),
                        result.getBoolean("armsRight"), result.getBoolean("armsLeft"),
                        result.getBoolean("anklesRight"), result.getBoolean("anklesLeft")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<existingConditionsSkinTable> getExistingConditionsSkin() {
        Vector<existingConditionsSkinTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM existingConditionsSkinTable");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new existingConditionsSkinTable(result.getInt("customerNumber"),
                        result.getBoolean("skinIrritations"), result.getBoolean("skinConditions"),
                        result.getBoolean("melanoma"), result.getBoolean("hypersensitiveReaction"),
                        result.getBoolean("bruiseEasily")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<existingConditionsRespiratoryTable> getExistingConditionsRespiratory() {
        Vector<existingConditionsRespiratoryTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM existingConditionsRespiratoryTable");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new existingConditionsRespiratoryTable(result.getInt("customerNumber"),
                        result.getBoolean("shortnessOfBreath"), result.getBoolean("emphysema"),
                        result.getBoolean("chronicCough"), result.getBoolean("bronchitis"),
                        result.getBoolean("asthma")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<packagesTable> getPackages() {
        Vector<packagesTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM packagesTable");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                v.add(new packagesTable(result.getInt("packagesNumber"),
                        result.getInt("serviceNumber"),
                        result.getString("packageDescription"),
                        result.getDouble("price"),
                        result.getBoolean("0")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<emergencyContactTable> getEmergencyContact() {
        Vector<emergencyContactTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM emergencyContactTable");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                v.add(new emergencyContactTable(result.getInt("customerNumber"),
                        result.getString("emergencyFirstName"),
                        result.getString("emergencyLastName"),
                        result.getString("emergencyPhone"),
                        result.getString("relationship")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<waiverTable> getWaiver() {
        Vector<waiverTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM waiverTable");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                v.add(new waiverTable(result.getInt("customerNumber"), result.getString("signiture"),
                        result.getString("date"), result.getBoolean("acknowledgment")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    // Yeslyn Packages Delete

    public static void deletePackagesRowByID(int rowToDelete) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM packagesTable WHERE packageNumber=?");
            ps.setInt(1, rowToDelete);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Yeslyn Packages Update
    public static void updatePackagesRowByID(int packageNumber, String packageDescription, double price) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE packagesTable SET packageNumber=?, packageDescription=?, price=? WHERE packageNumber=?");
            preparedStatement.setInt(1, packageNumber);
            preparedStatement.setString(2, packageDescription);
            preparedStatement.setDouble(3, price);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    // Yeslyn Pakcages Insert
    public static void insertPackagesRowByID(int rowToInsert, String rowToInsert2, double  String) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO packagesTable (packageNumber, packageDescription, price) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, rowToInsert);
            preparedStatement.setString(3, rowToInsert2);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {e.printStackTrace();}
    }
}
