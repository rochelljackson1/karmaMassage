<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.customerTable" %>
<%@ page import="java.util.Vector" %>
<%--
  Created by IntelliJ IDEA.
  User: ramirosantibanez
  Date: 11/9/20
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 11</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <% Vector<customerTable> v = DataHandler.getReport11();
        for (customerTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber  ())%></td>
        <td><%= String.valueOf(c.getFirstName())%></td>
        <td><%= String.valueOf(c.getLastName())%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
