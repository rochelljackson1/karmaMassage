<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report4" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: nafis
  Date: 11/12/2020
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 4</title>
</head>
<body>
<table>
    <tr>
        <th>Client Profile Number</th>
        <th>Client First Name</th>
        <th>Client Last Name</th>
        <th>Client Phone Number</th>
        <th>Client Email Address</th>
        <th>Status</th>
    </tr>

    <% Vector<report4> v = DataHandler.getReport4();
        for (report4 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getLastName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getPhone())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getEmail())%></td>
        <td><%= String.valueOf(c.getCompanyClientHistoryPackage().getCurrentClient())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
