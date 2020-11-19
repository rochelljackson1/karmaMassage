<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.City" %>
<%@ page import="java.util.Vector" %>
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
        <th>Appointment Date</th>
        <th>Appointment Time</th>
        <th>Add-On Service</th>
    </tr>
    <% Vector<appointmentsTable> v = DataHandler.getReport15();
        for (appointmentsTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getScheduledDate())%></td>
        <td><%= String.valueOf(c.getScheduledTime())%></td>
        <td><%= String.valueOf(c.getAddOnNumber())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
