<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.doctorTable" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/1/20
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>Doctor ID</th>
        <th>Physician First Name</th>
        <th>Physician Last Name</th>
        <th>Physician Phone Number</th>
    </tr>
    <% Vector<doctorTable> v = DataHandler.getDoctors();
        for (doctorTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getDoctorNuber())%></td>
        <td><%= String.valueOf(c.getPhysicianFirstname())%></td>
        <td><%= String.valueOf(c.getPhysicianLastname())%></td>
        <td><%= String.valueOf(c.getPhysicianPhone())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
