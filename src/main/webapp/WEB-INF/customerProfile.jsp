<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.customerTable" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 10/31/20
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Profile</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>Store Credit</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Phone Number</th>
        <th>Email Address</th>
        <th>Birthday</th>
        <th>Address</th>
    </tr>
    <% Vector<customerTable> v = DataHandler.getCustomers();
        for (customerTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getStoreCredit())%></td>
        <td><%= String.valueOf(c.getFirstName())%></td>
        <td><%= String.valueOf(c.getLastName())%></td>
        <td><%= String.valueOf(c.getGender())%></td>
        <td><%= String.valueOf(c.getPhone())%></td>
        <td><%= String.valueOf(c.getEmail())%></td>
        <td><%= String.valueOf(c.getBirthday())%></td>
        <td><%= String.valueOf(c.getAddress())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
