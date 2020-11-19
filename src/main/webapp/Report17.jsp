<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.appointmentsTable" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.reportClasses.report17" %>

<%--
  Created by IntelliJ IDEA.
  User: YCasasola
  Date: 11/16/20
  Time: 5:18 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 16</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
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
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getAppointmentDateTime())%></td>
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
