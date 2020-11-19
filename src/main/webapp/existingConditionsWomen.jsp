<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.existingConditionsWomenTable" %><%--
  Created by IntelliJ IDEA.
  User: nafis
  Date: 11/13/2020
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Existing Conditions Women</title>

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

<form action="deleteWomenOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertWomenOptions" id="insertForm" style="display:none;" method="post">
    <input name="rowToInsert" type="text">
    <input name="rowToInsert2" type="text">
    <input name="rowToInsert3" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateWomenOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="pregnantInput" type="text">
    <input name="gynecologicalConditionsInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Pregnant</th>
        <th>Gynecological Conditions</th>
    </tr>

    <% Vector<existingConditionsWomenTable> v = DataHandler.getExistingConditionsWomen();
        for (existingConditionsWomenTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.isPregnant())%></td>
        <td><%= String.valueOf(c.isGynecologicalConditions())%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
