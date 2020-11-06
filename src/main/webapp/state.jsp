<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.state" %>
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
    <title>state</title>
</head>
<body>
<table>
    <tr>
        <th>Sate ID</th>
        <th>State Code</th>
        <th>State Name</th>



    </tr>
    <% Vector<state> v = DataHandler.getState();
        for (state c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getStateID())%></td>
        <td><%= String.valueOf(c.getStateCode())%></td>
        <td><%= String.valueOf(c.getStateName())%></td>


    </tr>
    <%
        }
    %>
</table>
</body>
</html>
