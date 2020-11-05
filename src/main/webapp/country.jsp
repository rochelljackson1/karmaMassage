<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.Country" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Makki
  Date: 11/5/20
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country</title>
</head>
<body>
<table>
    <tr>
        <th>Country ID</th>
        <th>Country Name</th>



    </tr>
    <% Vector<Country> v = DataHandler.getCountry();
        for (Country c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getId())%></td>
        <td><%= String.valueOf(c.getCountryName())%></td>


    </tr>
    <%
        }
    %>
</table>
</body>
</html>
