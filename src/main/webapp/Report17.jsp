<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report17" %>
<%@ page import="java.util.Vector" %>

<%--
Created by IntelliJ IDEA.
User: ycasasola
Date: 11/16/20
Time: 9:36 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 17</title>
</head>
<body>
<table>
    <tr>
        <th>Appointment Date</th>
        <th>Client ID</th>
        <th>Package Bought</th>
        <th>Service Number</th>
        <th>Add-On</th>
        <th>Question Asked</th>
    </tr>
    <% Vector<report17> v = DataHandler.getReport17();
        for (report17 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getScheduledDate())%></td>
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getPackageNumber())%></td>
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getServiceNumber())%></td>
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getAddOnNumber())%></td>
        <td><%= String.valueOf(c.getQuestionPackage().getQuestion())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
