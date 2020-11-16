<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report14" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/10/20
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 14</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Infectious Skin Condition</th>
        <th>Bruise Easily</th>
        <th>Hypersensitive Reaction</th>
        <th>Melanoma</th>
        <th>Skin Conditions</th>
        <th>Skin Irritations</th>
        <th>Current Status</th>

    </tr>
    <% Vector<report14> v = DataHandler.getReport14();
        for (report14 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getLastName())%></td>
        <td><%= String.valueOf(c.getInfectiousPackage().isSkinConditions())%></td>
        <td><%= String.valueOf(c.getSkinPackage().isBruiseEasily())%></td>
        <td><%= String.valueOf(c.getSkinPackage().isHypersensitiveReaction())%></td>
        <td><%= String.valueOf(c.getSkinPackage().isMelanoma())%></td>
        <td><%= String.valueOf(c.getSkinPackage().isSkinConditions())%></td>
        <td><%= String.valueOf(c.getSkinPackage().isSkinIrritations())%></td>
        <td><%= String.valueOf(c.getCompanyClientHistoryPackage().getCurrentClient())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
