<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.GUIfaq" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: domin
  Date: 11/5/2020
  Time: 5:52 PM
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
        <th>#</th>
        <th>Question</th>
        <th>Answer</th>
    </tr>

    <% Vector<GUIfaq> v = DataHandler.getGUIfaq();
        for (GUIfaq c : v) {
    %>

    <tr>
        <td><%= String.valueOf(c.getFaqNumber()) %></td>
        <td><%= String.valueOf(c.getQuestion())%></td>
        <td><%= String.valueOf(c.getAnswer())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
