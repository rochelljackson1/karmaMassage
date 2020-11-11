<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report8" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/10/20
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 8</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Status</th>
        <th>Medication</th>
        <th>Physician Last Name</th>
        <th>Physician Phone Number</th>
        <th>Emergency First Name</th>
        <th>Emergency Last Name</th>
        <th>Emergency Phone Number</th>
        <th>Emergency Relationship</th>


    </tr>
    <% Vector<report8> v = DataHandler.getReport8();
        for (report8 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getLastName())%></td>
        <td><%= String.valueOf(c.getCompanyClientHistoryPackage().getCurrentClient())%></td>
        <td><%= String.valueOf(c.getMedicationsPackage().getOther())%></td>
        <td><%= String.valueOf(c.getDoctorPackage().getPhysicianLastname())%></td>
        <td><%= String.valueOf(c.getDoctorPackage().getPhysicianPhone())%></td>
        <td><%= String.valueOf(c.getEmergencyPackage().getEmergencyFirstName())%></td>
        <td><%= String.valueOf(c.getEmergencyPackage().getEmergencyLastName())%></td>
        <td><%= String.valueOf(c.getEmergencyPackage().getEmergencyPhone())%></td>
        <td><%= String.valueOf(c.getEmergencyPackage().getRelationship())%></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
