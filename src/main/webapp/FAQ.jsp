<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.FAQTable" %>

<%--
  Created by IntelliJ IDEA.
  User: YCasasola
  Date: 11/04/20
  Time: 10:06 AM
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
        <th>FAQ Number</th>
        <th>Question</th>
        <th>Answer</th>
        <th>Service Number</th>
        <th>Add On Number</th>
        <th>Package Number</th>
        <th>Location Number</th>

    </tr>
    <% Vector<FAQTable> v = DataHandler.getFAQ();
        for (FAQTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getFaqNumber()) %></td>
        <td><%= String.valueOf(c.getQuestion())%></td>
        <td><%= String.valueOf(c.getAnswer())%></td>
        <td><%= String.valueOf(c.getServiceNumber()) %></td>
        <td><%= String.valueOf(c.getAddOnNumber()) %></td>
        <td><%= String.valueOf(c.getPackageNumber()) %></td>
        <td><%= String.valueOf(c.getLocationNumber()) %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
