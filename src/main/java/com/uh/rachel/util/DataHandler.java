package com.uh.rachel.util;

import com.uh.rachel.util.tableClasses.FAQTable;
import com.uh.rachel.util.tableClasses.appointmentsTable;
import com.uh.rachel.util.tableClasses.customerTable;
import com.uh.rachel.util.tableClasses.doctorTable;

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

    public static void insertRowByID(int rowToInsert) {

    }

    public static void deleteRowByID(int rowToDelete) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM customerTable WHERE customerNumber=?");
            ps.setInt(1, rowToDelete);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {e.printStackTrace();}
    }
}
