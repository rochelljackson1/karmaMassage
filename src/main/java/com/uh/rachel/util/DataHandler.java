package com.uh.rachel.util;

import com.uh.rachel.util.reportClasses.*;
import com.uh.rachel.util.tableClasses.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                        result.getInt("doctorNuber"), result.getString("physicianFirstname"),
                        result.getString("physicianLastname"), result.getString("physicianPhone")));
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


    // yCasasola
    public static Vector<addOnsTable> getAddOns(){
        Vector<addOnsTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM addOnsTable");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new addOnsTable(result.getInt("addOnNumber"),
                        result.getDouble("price"),
                        result.getString("addOnDescription"),
                        result.getInt("customerNumber")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    // yCasasola
    public static Vector<addOnsAppointmentAssociativeTable> getAddOnsAppointmentAssociative(){
        Vector<addOnsAppointmentAssociativeTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM addOnsAppointmentAssociativeTable");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new addOnsAppointmentAssociativeTable(result.getInt("addOnNumber"),
                        result.getInt("appointmentNumber")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    // yCasasola
    public static Vector<contactUsTable> getContactUS(){
        Vector<contactUsTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM contactUsTable");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new contactUsTable(result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("email"),
                        result.getInt("phone"),
                        result.getString("subjectLine"),
                        result.getString("message"),
                        result.getInt("serviceNumber")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    // yCasasola
    public static Vector<packagesTable> getPackages(){
        Vector<packagesTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM packagesTable");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new packagesTable(result.getInt("packageNumber"),
                        result.getInt("serviceNumber"),
                        result.getString("packageDescription"),
                        result.getDouble("price"),
                        result.getBoolean("status")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    // yCasasola
    public static Vector<serviceAppointmentAssociativeTable> getServiceAppointmentAssociative(){
        Vector<serviceAppointmentAssociativeTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM serviceAppointmentAssociativeTable");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new serviceAppointmentAssociativeTable(result.getInt("serviceNumber"),
                        result.getInt("appointmentNumber")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    // yCasasola
    public static Vector<servicesTable> getServices(){
        Vector<servicesTable> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM servicesTable");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                v.add(new servicesTable(result.getInt("serviceNumber"),
                        result.getString("serviceDescription"),
                        result.getDouble("price"),
                        result.getBoolean("status"),
                        result.getBoolean("discount")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    //Makki
    public static Vector<Address> getAddress() {
        Vector<Address> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Address");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new Address(result.getInt("customerNumber"),
                        result.getString("street"),
                        result.getString("cityName"),
                        result.getString("stateName"),
                        result.getString("zipCode"),
                        result.getString("countryName")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }
    //Makki
    public static Vector<Revenue> getRevenue() {
        Vector<Revenue> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Revenue");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new Revenue(
                        result.getString("date"),
                        result.getDouble("revenueMonthlyActual"),
                        result.getDouble("revenueWeeklyActual"),
                        result.getDouble("revenueMonthlyFromCancellations"),
                        result.getDouble("potentialRevenueMonthlyFromScheduled"),
                        result.getDouble("revenueByStaff")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    //Makki
    public static Vector<City> getCiy() {
        Vector<City> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM City");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new City(
                        result.getString("cityName"),
                        result.getString("internationalCity")));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }



    //Makki
    public static Vector<state> getState() {
        Vector<state> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM state");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new state(
                        result.getInt("stateID"),
                        result.getString("stateCode"),
                        result.getString("stateName")));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }


    //Makki
    public static Vector<Country> getCountry() {
        Vector<Country> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Country");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new Country(
                        result.getInt("id"),
                        result.getString("countryName")));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }




    //Makki
    public static Vector<Staff> getStaff() {
        Vector<Staff> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Staff");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new Staff(
                        result.getInt("staff_Number"),
                        result.getString("tips"),
                        result.getString("date"),
                        result.getString("totalPTO"),
                        result.getString("revenueByStaff")));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }


    //Makki
    public static Vector<PTO_Staff> getPTO_Staff() {
        Vector<PTO_Staff> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PTO_Staff");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new PTO_Staff(
                        result.getInt("staffNumber"),
                        result.getString("maxPTO"),
                        result.getString("maxSickPTO"),
                        result.getString("maxMaternatyPTO"),
                        result.getString("maxEmergencyPTO"),
                        result.getString("totalPTO")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }



    //Makki
    public static Vector<Staff_PTO_Staff_Associative> getStaff_PTO_Staff_Associative() {
        Vector<Staff_PTO_Staff_Associative> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Staff_PTO_Staff_Associative");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new Staff_PTO_Staff_Associative(
                        result.getInt("staff_Number"),
                        result.getInt("staffNumber")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }



    //Makki
    public static Vector<OwnerSide_of_Automatic_Payment_Cancellation_System> getOwnerSide_of_Automatic_Payment_Cancellation_System() {
        Vector<OwnerSide_of_Automatic_Payment_Cancellation_System> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM OwnerSide_of_Automatic_Payment_Cancellation_System");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new OwnerSide_of_Automatic_Payment_Cancellation_System(
                        result.getString("timeCondition"),
                        result.getString("deductionPrecentage")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }



    //Makki
    public static Vector<Location> getLocation() {
        Vector<Location> v = new Vector<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Location");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                v.add(new Location(
                        result.getInt("locationNumber"),
                        result.getInt("customerNumber"),
                        result.getBoolean("inBound"),
                        result.getBoolean("outBound")));
            }

        } catch (Exception e) {
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

    public static void deleteRowByID(int rowToDelete) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM customerTable WHERE customerNumber=?");
            ps.setInt(1, rowToDelete);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {e.printStackTrace();}
    }
}
