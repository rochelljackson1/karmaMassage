<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.existingConditionsRespiratoryTable" %><%--
  Created by IntelliJ IDEA.
  User: nafis
  Date: 11/13/2020
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Existing Conditions Respiratory</title>

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

<form action="deleteRespiratoryOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertRespiratoryOptions" id="insertForm" style="display:none;" method="post">
    <input name="rowToInsert" type="text">
    <input name="rowToInsert2" type="text">
    <input name="rowToInsert3" type="text">
    <input name="rowToInsert4" type="text">
    <input name="rowToInsert5" type="text">
    <input name="rowToInsert6" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateRespiratoryOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="shortnessOfBreathInput" type="text">
    <input name="emphysemaInput" type="text">
    <input name="chronicCoughInput" type="text">
    <input name="bronchitisInput" type="text">
    <input name="asthmaInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Shortness Of Breath</th>
        <th>Emphysema</th>
        <th>Chronic Cough</th>
        <th>Bronchitis</th>
        <th>Asthma</th>
    </tr>

    <% Vector<existingConditionsRespiratoryTable> v = DataHandler.getExistingConditionsRespiratory();
        for (existingConditionsRespiratoryTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.isShortnessOfBreath())%></td>
        <td><%= String.valueOf(c.isEmphysema())%></td>
        <td><%= String.valueOf(c.isChronicCough())%></td>
        <td><%= String.valueOf(c.isBronchitis())%></td>
        <td><%= String.valueOf(c.isAsthma())%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
