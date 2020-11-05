<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.Address" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Makki
  Date: 11/1/20
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>Street</th>
        <th>City</th>
        <th>State</th>
        <th>Zip Code</th>
        <th>Country</th>

    </tr>
    <% Vector<Address> v = DataHandler.getAddress();
        for (Address c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getStreet())%></td>
        <td><%= String.valueOf(c.getCityName())%></td>
        <td><%= String.valueOf(c.getStateName())%></td>
        <td><%= String.valueOf(c.getZipCode())%></td>
        <td><%= String.valueOf(c.getCountryName())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
