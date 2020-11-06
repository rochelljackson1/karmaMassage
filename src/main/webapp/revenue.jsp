<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.Revenue" %>
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
    <title>Revenue</title>
</head>
<body>
<table>
    <tr>
        <th>Date</th>
        <th>Revenue Monthly Actual</th>
        <th>Revenue Weekly Actual</th>
        <th>Revenue Monthly From Cancellations</th>
        <th>Potential Revenue Monthly From Scheduled</th>
        <th>Revenue By Staff</th>

    </tr>
    <% Vector<Revenue> v = DataHandler.getRevenue();
        for (Revenue c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getDate())%></td>
        <td><%= String.valueOf(c.getRevenueMonthlyActual())%></td>
        <td><%= String.valueOf(c.getRevenueWeeklyActual())%></td>
        <td><%= String.valueOf(c.getRevenueMonthlyFromCancellations())%></td>
        <td><%= String.valueOf(c.getPotentialRevenueMonthlyFromScheduled())%></td>
        <td><%= String.valueOf(c.getRevenueByStaff())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>