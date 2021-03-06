<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.existingConditionsMedicationsTable" %>
<%@ page import="java.util.Vector" %>

<%--
  Created by IntelliJ IDEA.
  User: ramirosantibanez
  Date: 11/16/20
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>existing Conditions Medications</title>

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

<form action="deleteExistingConditionsMedicationsOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertexistingConditionsMedicationsOptions" id="insertForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="otherInput" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateexistingConditionsMedicationsOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="otherInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Other</th>
    </tr>
    <% Vector<existingConditionsMedicationsTable> v = DataHandler.getExistingConditionsMedications();
        for (existingConditionsMedicationsTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getOther())%></td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
