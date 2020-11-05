<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.City" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Makki
  Date: 11/4/20
  Time: 06:41 PM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City</title>
</head>
<body>
<table>
    <tr>

        <th>City</th>
        <th>International City</th>


    </tr>
    <% Vector<City> v = DataHandler.getCiy();
        for (City c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCityName())%></td>
        <td><%= String.valueOf(c.getInternationalCity())%></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
