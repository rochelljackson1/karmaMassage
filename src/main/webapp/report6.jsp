<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report6" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/10/20
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 6</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Family History of Respiratory Condition</th>
        <th>Asthma</th>
        <th>Bronchitis</th>
        <th>Chronic Cough</th>
        <th>Emphysemat</th>
        <th>Shortness of Breathe</th>
        <th>Status</th>

    </tr>
    <% Vector<report6> v = DataHandler.getReport6();
        for (report6 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getLastName())%></td>
        <td><%= String.valueOf(c.getFamilyPackage().isCardiovascularConditions())%></td>
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
