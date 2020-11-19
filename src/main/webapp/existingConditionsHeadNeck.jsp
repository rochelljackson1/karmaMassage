<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.existingConditionsHeadNeckTable" %>
<%@ page import="java.util.Vector" %>
<%--
  Created by IntelliJ IDEA.
  User: ramirosantibanez
  Date: 11/16/20
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>existing Conditions Head and Neck</title>

    <script type="text/javascript">
        function makeVisible(){
            var valuey = document.getElementById('selection').value;
            if (valuey ==="deleteRow") {
                document.getElementById('deleteForm').style.display = "flex";
            }
            if (valuey == "insertRow") {
                document.getElementById('insertForm').style.display = "flex";
            }
            if (valuey == "updateRow") {}
            document.getElementById('updateForm').style.display = "flex";
        }
    </script>
</head>
<body>
<select id="selection">
    <option value="deleteRow">Delete Customer</option>
    <option value="insertRow">Insert Customer</option>
    <option value="updateRow">Update Customer</option>
</select>

<button onclick="makeVisible();">Make Form Visible</button>

<form action="deleteexistingConditionsHeadNeckOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertexistingConditionsHeadNeckOptions" id="insertForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="visionProblemsInput" type="text">
    <input name="vissionLossInput" type="text">
    <input name="sinusProblemsInput" type="text">
    <input name="migrainesInput" type="text">
    <input name="jawPainInput" type="text">
    <input name="hearingLossInput" type="text">
    <input name="HeadachesInput" type="text">
    <input name="earProblemsInput" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateexistingConditionsHeadNeckOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="vissionProblemsInput" type="text">
    <input name="vissionLossInput" type="text">
    <input name="sinusProblemInput" type="text">
    <input name="migrainesInput" type="text">
    <input name="jawPainInput" type="text">
    <input name="hearingLossInput" type="text">
    <input name="headachesInput" type="text">
    <input name="earProblemsInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Vission Problems </th>
        <th>Vission Loss</th>
        <th>Sinus Problems</th>
        <th>Migraines</th>
        <th>Jaw Pain</th>
        <th>Hearing Loss</th>
        <th>Headaches</th>
        <th>Ear Problems</th>
    </tr>
    <% Vector<existingConditionsHeadNeckTable> v = DataHandler.getExistingConditonsHeadNeck();
        for (existingConditionsHeadNeckTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.isVisionProblems())%></td>
        <td><%= String.valueOf(c.isVisionLoss())%></td>
        <td><%= String.valueOf(c.isSinusProblems())%></td>
        <td><%= String.valueOf(c.isMigraines())%></td>
        <td><%= String.valueOf(c.isJawPain())%></td>
        <td><%= String.valueOf(c.isHearingLoss())%></td>
        <td><%= String.valueOf(c.isHeadaches())%></td>
        <td><%= String.valueOf(c.isEarProblems())%></td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
