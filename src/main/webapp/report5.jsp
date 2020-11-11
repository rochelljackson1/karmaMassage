<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report5" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/10/20
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 5</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Family History of Cardiovascular Condition</th>
        <th>Reason for Massage</th>
        <th>Current Client</th>
        <th>Blood Clots</th>
        <th>Cardiovascular Accident</th>
        <th>Cerebral Vascular Accident</th>
        <th>Cold Feet</th>
        <th>Cold Hands</th>
        <th>Congestive Heart Failure</th>
        <th>Heart Attack</th>
        <th>Heart Disease</th>
        <th>High Blood Pressure</th>
        <th>Low Blood Pressure</th>
        <th>Lymphedema</th>
        <th>Myocardial Infarctin</th>
        <th>Pace Maker</th>
        <th>Phlebitis</th>
        <th>Stroke</th>
        <th>Thrombosis Embolism</th>
        <th>Varicose Veins</th>

    </tr>
    <% Vector<report5> v = DataHandler.getReport5();
        for (report5 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getLastName())%></td>
        <td><%= String.valueOf(c.getFamilyPackage().isCardiovascularConditions())%></td>
        <td><%= String.valueOf(c.getReasonPackage().getCause())%></td>
        <td><%= String.valueOf(c.getCompanyClientHistoryPackage().getCurrentClient())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isBloodClots())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isCardiovascularAccident())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isCerebralVascularAccident())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isColdFeet())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isColdHands())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isCongestiveHeartFailure())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isHeartAttack())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isHeartDisease())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isHighBloodPressure())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isLowBloodPressure())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isLymphedema())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isMyocardialInfarction())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isPaceMaker())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isPhlebitis())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isStroke())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isThrombosisEmbolism())%></td>
        <td><%= String.valueOf(c.getCardioPackage().isVaricoseVeins())%></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
