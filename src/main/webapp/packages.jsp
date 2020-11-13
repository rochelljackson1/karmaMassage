<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.packagesTable" %>

<%--
  Created by IntelliJ IDEA.
  User: YCasasola
  Date: 11/04/20
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Frequently Asked Questions</title>
</head>
<body>
<table>
    <tr>
        <th>Package Number</th>
        <th>Service Number</th>
        <th>Package Description</th>
        <th>Price</th>
        <th>Status</th>
    </tr>
    <% Vector<packagesTable> v = DataHandler.getPackages();
        for (packagesTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getPackageNumber()) %></td>
        <td><%= String.valueOf(c.getServiceNumber())%></td>
        <td><%= String.valueOf(c.getPackageDescription())%></td>
        <td><%= String.valueOf(c.getPrice()) %></td>
        <td><%= String.valueOf(c.getStatus()) %></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
