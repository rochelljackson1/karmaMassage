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
    <title>Packages</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<h1 align="center" class="w3-grey">Service Packages</h1>
</head>

<body bgcolor="#aeb6f5">
<form method="post" action="/save">
    <fieldset>
        <legend><em>Please Update Your Service Package</em></legend>
        <em>Package Number:</em><br>
        <input type="text" name="packageNumber">
        <br>
        <input type="hidden" name="serviceNumber" value="">
        <br>
        <em>Package Description:</em><br>
        <input type="text" name="packageDescription">
        <br>
        <em>Price:</em><br>
        <input type="number" name="price">
        <br>
        <input type="hidden" name="status" value="">
    </fieldset>
</form>
<form>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
        }
        td, th {
            border: 1px solid lightgrey;
            text-align: left;
            padding: 8px;
            width: 100px;
        }
        table.center{
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</form>
<table class="center">
    <h2 align="center" class="w3-grey">Packages List</h2>
    <tr>
        <th style="text-align:center">Package Number</th>
        <th style="text-align:center">Service Number</th>
        <th style="text-align:center">Package Description</th>
        <th style="text-align:center">Price</th>
        <th style="text-align:center">Status</th>
    </tr>

    <% Vector<packagesTable> v = DataHandler.getPackages();
        for (packagesTable c : v) {
    %>
    <tr>
        <td style="text-align:center"><%= String.valueOf(c.getPackageNumber()) %></td>
        <td style="text-align:center"><%= String.valueOf(c.getServiceNumber())%></td>
        <td style="text-align:center"><%= String.valueOf(c.getPackageDescription())%></td>
        <td style="text-align:center"><%= String.valueOf(c.getPrice()) %></td>
        <td style="text-align:center"><%= String.valueOf(c.getStatus()) %></td>

    </tr>

    <%
        }
    %>
</table>
</body>
</html>
