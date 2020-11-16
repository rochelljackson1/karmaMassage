<%@ page import="com.uh.rachel.util.tableClasses.GUIContactUs" %>
<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: domin
  Date: 11/14/2020
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Us</title>
</head>
<body>
<table>
    <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>email</th>
        <th>phone</th>
        <th>subjectLine</th>
        <th>message</th>
        <th>serviceNumber</th>
    </tr>

    <% Vector<GUIContactUs> v = DataHandler.getGUIContactUS();
        for (GUIContactUs c : v) {
    %>
    <tr>
        <td><%=String.valueOf(c.getfirstName())%></td>
        <td><%=String.valueOf(c.getLastName())%></td>
        <td><%=String.valueOf(c.getEmail())%></td>
        <td><%=String.valueOf(c.getPhone())%></td>
        <td><%=String.valueOf(c.getSubjectLine())%></td>
        <td><%=String.valueOf(c.getMessage())%></td>
        <td><%=String.valueOf(c.getServiceNumber())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
