<%@ page import="com.uh.rachel.util.tableClasses.report13" %>
<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/6/20
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 13</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Infectious Respiratory Condition</th>
        <th>Asthma</th>
        <th>Bronchitis</th>
        <th>Chronic Cough</th>
        <th>Emphysema</th>
        <th>Shortness of Breath</th>
        <th>Current Status</th>

    </tr>
    <% Vector<report13> v = DataHandler.getReport13();
        for (report13 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getLastName())%></td>
        <td><%= String.valueOf(c.getInfectiousPackage().isRespiratoryConditions())%></td>
        <td><%= String.valueOf(c.getRespiratoryPackage().isAsthma())%></td>
        <td><%= String.valueOf(c.getRespiratoryPackage().isBronchitis())%></td>
        <td><%= String.valueOf(c.getRespiratoryPackage().isChronicCough())%></td>
        <td><%= String.valueOf(c.getRespiratoryPackage().isEmphysema())%></td>
        <td><%= String.valueOf(c.getRespiratoryPackage().isShortnessOfBreath())%></td>
        <td><%= String.valueOf(c.getCompanyClientHistoryPackage().getCurrentClient())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
