<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.existingConditionsNeurologicalTable" %>
<%@ page import="java.util.Vector" %>

<%--
  Created by IntelliJ IDEA.
  User: ramirosantibanez
  Date: 11/17/20
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>existing Conditions Neurological</title>

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

<form action="deleteexistingConditionsNeurologicalOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertexistingConditionsNeurologicalOptions" id="insertForm" style="display:none;" method="post">
    <input name="customerNumberInout" type="text">
    <input name="tinglingInput" type="text">
    <input name="stabbingPainInput" type="text">
    <input name="parkinsonsInput" type="text">
    <input name="numbnessInput" type="text">
    <input name="multipleSclerosisInput" type="text">
    <input name="herniateDiscInput" type="text">
    <input name="cerebralPaisyInput" type="text">
    <input name="burningInput" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateexistingConditionsNeurologicalOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInout" type="text">
    <input name="tinglingInput" type="text">
    <input name="stabbingPainInput" type="text">
    <input name="parkinsonsInput" type="text">
    <input name="numbnessInput" type="text">
    <input name="multipleSclerosisInput" type="text">
    <input name="herniateDiscInput" type="text">
    <input name="cerebralPaisyInput" type="text">
    <input name="burningInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Tingling </th>
        <th>Stabbing Pain</th>
        <th>Parkinsons</th>
        <th>Numbness</th>
        <th>Multiple Sclerosis</th>
        <th>Herniate Disc</th>
        <th>Cerebral Paisy</th>
        <th>Burning</th>
    </tr>
    <% Vector<existingConditionsNeurologicalTable> v = DataHandler.getExistingConditionsNeurological();
        for (existingConditionsNeurologicalTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.isTingling())%></td>
        <td><%= String.valueOf(c.isStabbingPain())%></td>
        <td><%= String.valueOf(c.isParkinsons())%></td>
        <td><%= String.valueOf(c.isNumbness())%></td>
        <td><%= String.valueOf(c.isMultipleSclerosis())%></td>
        <td><%= String.valueOf(c.isHerniatedDisc()))%></td>
        <td><%= String.valueOf(c.isCerebralPaisy())%></td>
        <td><%= String.valueOf(c.isBurning())%></td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
