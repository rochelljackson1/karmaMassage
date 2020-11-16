<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report2" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: nafis
  Date: 11/12/2020
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 2</title>
</head>
<body>
<table>
    <tr>
        <th>Client Profile Number</th>
        <th>Client First Name</th>
        <th>Client Last Name</th>
        <th>Waiver Signiture</th>
        <th>Acknowledgment</th>
        <th>Doctor Last Name</th>
        <th>Doctor Phone Number</th>
        <th>Emergency First Name</th>
        <th>Emergency Last Name</th>
        <th>Emergency Relationship</th>
        <th>Emergency Phone Number</th>
        <th>Status</th>
    </tr>

    <% Vector<report2> v = DataHandler.getReport2();
        for (report2 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getLastName())%></td>
        <td><%= String.valueOf(c.getWaiverPackage().getSigniture())%></td>
        <td><%= String.valueOf(c.getWaiverPackage().isAcknowledgment())%></td>
        <td><%= String.valueOf(c.getDoctorPackage().getPhysicianLastname())%></td>
        <td><%= String.valueOf(c.getDoctorPackage().getPhysicianPhone())%></td>
        <td><%= String.valueOf(c.getEmergencyPackage().getEmergencyFirstName())%></td>
        <td><%= String.valueOf(c.getEmergencyPackage().getEmergencyLastName())%></td>
        <td><%= String.valueOf(c.getEmergencyPackage().getRelationship())%></td>
        <td><%= String.valueOf(c.getEmergencyPackage().getEmergencyPhone())%></td>
        <td><%= String.valueOf(c.getCompanyClientHistoryPackage().getCurrentClient())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
