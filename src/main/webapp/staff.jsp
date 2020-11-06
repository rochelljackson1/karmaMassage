<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.Staff" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Makki
  Date: 11/4/20
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff</title>
</head>
<body>
<table>
    <tr>
        <th>Staff ID</th>
        <th>Tips</th>
        <th>Date</th>
        <th>Total PTO</th>
        <th>Revenue By Staff</th>


    </tr>
    <% Vector<Staff> v = DataHandler.getStaff();
        for (Staff c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getStaff_Number())%></td>
        <td><%= String.valueOf(c.getTips())%></td>
        <td><%= String.valueOf(c.getDate())%></td>
        <td><%= String.valueOf(c.getTotalPTO())%></td>
        <td><%= String.valueOf(c.getRevenueByStaff())%></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
