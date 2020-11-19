<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.appointmentsTable" %>
<%@ page import="java.util.Vector" %>

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
        <th>Parchase Date</th>
        <th>Package Number</th>
        <th>Add-On Number</th>
        <th>Price Paid</th>
    </tr>

    <% Vector<appointmentsTable> v = DataHandler.getReport16();
        for (appointmentsTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getScheduledDate())%></td>
        <td><%= String.valueOf(c.getPackageNumber())%></td>
        <td><%= String.valueOf(c.getAddOnNumber())%></td>
        <td><%= String.valueOf(c.getActualPricePaid())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
