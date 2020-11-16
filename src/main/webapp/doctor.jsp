<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.doctorTable" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/1/20
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor</title>

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

<form action="deleteDoctorOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertDoctorOptions" id="insertForm" style="display:none;" method="post">
    <input name="rowToInsert" type="text">
    <input name="rowToInsert2" type="text">
    <input name="rowToInsert3" type="text">
    <input name="rowToInsert4" type="text">
    <input name="rowToInsert5" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateDoctorOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="doctorNuberInput" type="text">
    <input name="physicianFirstnameInput" type="text">
    <input name="physicianLastnameInput" type="text">
    <input name="physicianPhoneInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Doctor ID</th>
        <th>Physician First Name</th>
        <th>Physician Last Name</th>
        <th>Physician Phone Number</th>
    </tr>
    <% Vector<doctorTable> v = DataHandler.getDoctors();
        for (doctorTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getDoctorNuber())%></td>
        <td><%= String.valueOf(c.getPhysicianFirstname())%></td>
        <td><%= String.valueOf(c.getPhysicianLastname())%></td>
        <td><%= String.valueOf(c.getPhysicianPhone())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
