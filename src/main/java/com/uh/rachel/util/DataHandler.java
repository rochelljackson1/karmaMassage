package com.uh.rachel.util;

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

    // yCasasola
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

    // yCasasola
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
                        result.getString("cardNumber"), result.getInt("staff_Number")));
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
                        result.getString("revenueMonthlyActual"),
                        result.getString("revenueWeeklyActual"),
                        result.getString("revenueMonthlyFromCancellations"),
                        result.getString("potentialRevenueMonthlyFromScheduled"),
                        result.getString("revenueByStaff")));
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



}
