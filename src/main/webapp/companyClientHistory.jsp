<%@ page import="com.uh.rachel.util.tableClasses.companyClientHistoryTable" %>
<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.customerTable" %>
<%@ page import="javax.xml.crypto.Data" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/3/20
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Client History</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>Current Client</th>
    </tr>
    <% Vector<companyClientHistoryTable> v = DataHandler.getcompanyClientHistory();
        for (companyClientHistoryTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCurrentClient())%></td>
    </tr>

    <%
        }
    %>
    <%--<tr>
        <th>Store Credit</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Phone Number</th>
        <th>Email Address</th>
        <th>Birthday</th>
        <th>Address</th>
    </tr>
    <% Vector<customerTable> v1 = DataHandler.getCustomers();
        for (customerTable c : v1) {
    %>
    <tr>
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
    %>--%>
</table>
</body>
</html>
