<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.appointmentsTable" %>

<%--
  Created by IntelliJ IDEA.
  User: YCasasola
  Date: 11/04/20
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Appointments</title>
</head>
<body>
<table>
    <tr>
        <th>Appointment Number</th>
        <th> Customer Number</th>
        <th>Service Number</th>
        <th>Package Number</th>
        <th>Add On Number</th>
        <th>Scheduled Date</th>
        <th>Schuduled Time</th>
        <th>Original Price</th>
        <th>Date Cancelled</th>
        <th>Time Cancelled</th>
        <th>Price Paid</th>
        <th>Default Payment</th>
        <th>Card Number Type</th>
        <th>Card Number</th>
        <th>Staff Number</th>
    </tr>
    <% Vector<appointmentsTable> v = DataHandler.getAppointments();
        for (appointmentsTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getAppointmentNumber())%></td>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getServiceNumber())%></td>
        <td><%= String.valueOf(c.getPackageNumber())%></td>
        <td><%= String.valueOf(c.getAddOnNumber())%></td>
        <td><%= String.valueOf(c.getOriginalFullPrice())%></td>
        <td><%= String.valueOf(c.getDateCancelled())%></td>
        <td><%= String.valueOf(c.getTimeCancelled())%></td>
        <td><%= String.valueOf(c.getActualPricePaid())%></td>
        <td><%= String.valueOf(c.getDefaultPayment())%></td>
        <td><%= String.valueOf(c.getCardNumberType())%></td>
        <td><%= String.valueOf(c.getCardNumber())%></td>
        <td><%= String.valueOf(c.getStaff_number())%></td>
        <td><%= String.valueOf(c.getAppointmentDateTime())%></td>
        <td><%= String.valueOf(c.getCancelledDateTime())%></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
