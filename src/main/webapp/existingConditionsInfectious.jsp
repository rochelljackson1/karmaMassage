<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.existingConditionsInfectiousTable" %>
<%@ page import="java.util.Vector" %>

<%--
  Created by IntelliJ IDEA.
  User: ramirosantibanez
  Date: 11/16/20
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>existing Conditions Infectious</title>

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

<form action="deleteexistingConditionsInfectiousOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertexistingConditionsInfectiousOptions" id="insertForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="skinConditionsInput" type="text">
    <input name="respiratoryConditionsInput" type="text">
    <input name="hivInput" type="text">
    <input name="herpesInput" type="text">
    <input name="hepatitisInput" type="text">
    <input name="altheletsFootInput" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateexistingConditionsInfectiousOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="skinConditionsInput" type="text">
    <input name="respiratoryConditionsInput" type="text">
    <input name="hivInput" type="text">
    <input name="herpesInput" type="text">
    <input name="hepatitisInput" type="text">
    <input name="altheletsFootInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Skin Conditions</th>
        <th>Respiratory Conditions</th>
        <th>HIV</th>
        <th>Herpes</th>
        <th>Hepatitis</th>
        <th>Althelets Foot</th>
    </tr>
    <% Vector<existingConditionsInfectiousTable> v =DataHandler.getExistingConditonsInfectious();
        for (existingConditionsInfectiousTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.isSkinConditions())%></td>
        <td><%= String.valueOf(c.isRespiratoryConditions())%></td>
        <td><%= String.valueOf(c.isHiv())%></td>
        <td><%= String.valueOf(c.isHerpes())%></td>
        <td><%= String.valueOf(c.isHepatitis())%></td>
        <td><%= String.valueOf(c.isAltheletsFoot())%></td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
