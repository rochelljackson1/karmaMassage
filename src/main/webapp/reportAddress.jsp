<%@ page import="com.uh.rachel.util.reportClasses.reportAddress" %>
<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: makki
  Date: 11/6/20
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Address</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Country</th>


    </tr>
    <% Vector<reportAddress> v = DataHandler.getReportAddress();
        for (reportAddress c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackages().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackages().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackages().getLastName())%></td>
        <td><%= String.valueOf(c.getCustomerPackages().getAddress())%></td>
        <td><%= String.valueOf(c.getAddressPackage().getCityName())%></td>
        <td><%= String.valueOf(c.getAddressPackage().getStateName())%></td>
        <td><%= String.valueOf(c.getAddressPackage().getCountryName())%></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
