<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.reportClasses.report7" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/10/20
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 7</title>
</head>
<body>
<table>
    <tr>
        <th>Customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Status</th>
        <th>Taking Medication</th>
        <th>Reason</th>
        <th>Arthritis</th>
        <th>Anaphylaxis</th>
        <th>Artificial Joint</th>
        <th>Allergies</th>
        <th>Cancer</th>
        <th>Chrohn's Disease</th>
        <th>Diabetes</th>
        <th>Digestive Conditions</th>
        <th>Dizziness</th>
        <th>Epilepsy</th>
        <th>Fibromyalgia</th>
        <th>Hemophilia</th>
        <th>Insomnia</th>
        <th>Loss of Sensation</th>
        <th>Lupus</th>
        <th>Mental Illness</th>
        <th>OsteoArthritis</th>
        <th>Osteoporosis</th>
        <th>Other Diagnosed Disease</th>
        <th>Other Medical Conditions</th>
        <th>Rheumadtoid Arthritis</th>
        <th>Shingles</th>
        <th>Stress</th>
        <th>Surgical Pins or Wire</th>

    </tr>
    <% Vector<report7> v = DataHandler.getReport7();
        for (report7 c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerPackage().getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getFirstName())%></td>
        <td><%= String.valueOf(c.getCustomerPackage().getLastName())%></td>
        <td><%= String.valueOf(c.getCompanyClientHistoryPackage().getCurrentClient())%></td>
        <td><%= String.valueOf(c.getMedPackage().getOther())%></td>
        <td><%= String.valueOf(c.getReasonPackage().getCause())%></td>
        <td><%= String.valueOf(c.getMisPackage().isArthritis())%></td>
        <td><%= String.valueOf(c.getMisPackage().isAnaphylaxis())%></td>
        <td><%= String.valueOf(c.getMisPackage().isArtificialJointsSpecialEquipment())%></td>
        <td><%= String.valueOf(c.getMisPackage().isAllergies())%></td>
        <td><%= String.valueOf(c.getMisPackage().isCancer())%></td>
        <td><%= String.valueOf(c.getMisPackage().isChrohnsDisease())%></td>
        <td><%= String.valueOf(c.getMisPackage().isDiabetes())%></td>
        <td><%= String.valueOf(c.getMisPackage().isDigestiveConditions())%></td>
        <td><%= String.valueOf(c.getMisPackage().isDizziness())%></td>
        <td><%= String.valueOf(c.getMisPackage().isEpilepsy())%></td>
        <td><%= String.valueOf(c.getMisPackage().isFibromyalgia())%></td>
        <td><%= String.valueOf(c.getMisPackage().isHemophilia())%></td>
        <td><%= String.valueOf(c.getMisPackage().isInsomnia())%></td>
        <td><%= String.valueOf(c.getMisPackage().isLossOfSensation())%></td>
        <td><%= String.valueOf(c.getMisPackage().isLupus())%></td>
        <td><%= String.valueOf(c.getMisPackage().isMentalIllness())%></td>
        <td><%= String.valueOf(c.getMisPackage().isOsteoArthritis())%></td>
        <td><%= String.valueOf(c.getMisPackage().isOsteoporosis())%></td>
        <td><%= String.valueOf(c.getMisPackage().isOtherDiagnosedDiseases())%></td>
        <td><%= String.valueOf(c.getMisPackage().isOtherMedicalConditions())%></td>
        <td><%= String.valueOf(c.getMisPackage().isRheumatoidArthritis())%></td>
        <td><%= String.valueOf(c.getMisPackage().isShingles())%></td>
        <td><%= String.valueOf(c.getMisPackage().isStress())%></td>
        <td><%= String.valueOf(c.getMisPackage().isSurgicalPinsOrWire())%></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
