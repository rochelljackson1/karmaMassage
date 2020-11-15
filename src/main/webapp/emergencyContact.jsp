<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.emergencyContactTable" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/1/20
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emergency Contact</title>

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

<form action="deleteEmergencyOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertEmergencyOptions" id="insertForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="emergencyFirstNameInput" type="text">
    <input name="emergencyLastNameInput" type="text">
    <input name="emergencyPhoneInput" type="text">
    <input name="relationshipInput" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateEmergencyOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="emergencyFirstNameInput" type="text">
    <input name="emergencyLastNameInput" type="text">
    <input name="emergencyPhoneInput" type="text">
    <input name="relationshipInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Emergency First Name</th>
        <th>Emergency Last Name</th>
        <th>Emergency Phone</th>
        <th>Relationship</th>
    </tr>
    <% Vector<emergencyContactTable> v = DataHandler.getEmergencyContact();
        for (emergencyContactTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getEmergencyFirstName())%></td>
        <td><%= String.valueOf(c.getEmergencyLastName())%></td>
        <td><%= String.valueOf(c.getEmergencyPhone())%></td>
        <td><%= String.valueOf(c.getRelationship())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
