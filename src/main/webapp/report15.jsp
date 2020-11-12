<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.City" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.report15" %>
<%@ page import="com.uh.rachel.util.tableClasses.appointmentsTable" %>

<%--
  Created by IntelliJ IDEA.
  User: YCasasola
  Date: 11/05/20
  Time: 06:41 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 15</title>
</head>
<body>
<table>
    <tr>

        <th>Client ID Number</th>
        <th>Appointment Number</th>
        <th>Chosen Package</th>
        <th>Chosen Service'</th>
        <th>Service Description</th>
        <th>Add-On Service</th>
        <th>Add-On Description</th>

    </tr>
    <% Vector<report15> v = DataHandler.getReport15();
        for (report15 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getAppointments().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getAppointments().getAppointmentNumber())%></td>
        <td><%= String.valueOf(c.getPackages().getPackageNumber())%></td>
        <td><%= String.valueOf(c.getServices().getServiceNumber())%></td>
        <td><%= String.valueOf(c.getServices().getServiceDescription())%></td>
        <td><%= String.valueOf(c.getAddOns().getAddOnNumber())%></td>
        <td><%= String.valueOf(c.getAddOns().getAddOnDescription())%></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
