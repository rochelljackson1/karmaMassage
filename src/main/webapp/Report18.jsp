<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report18" %>
<%@ page import="java.util.Vector" %>

<%--
  Created by IntelliJ IDEA.
  User: ycasasola
  Date: 11/16/20
  Time: 9:36 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 18</title>
</head>
<body>
<table>
    <tr>
        <th>Client ID</th>
        <th>Appointment Date</th>
        <th>Question Asked</th>
        <th>Service Number</th>
    </tr>
    <% Vector<report18> v = DataHandler.getReport18();
        for (report18 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getScheduledDate())%></td>
        <td><%= String.valueOf(c.getQuestionPackage().getQuestion())%></td>
        <td><%= String.valueOf(c.getAppointmentsTablePackage().getServiceNumber())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
