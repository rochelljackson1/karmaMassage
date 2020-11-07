<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.customerTable" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 10/31/20
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Profile</title>

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

<form action="deleteOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertOptions" id="insertForm" style="display:none;" method="post">
    <input name="rowToInsert" type="text">
    <input name="rowToInsert2" type="text">
    <input name="rowToInsert3" type="text">
    <input name="rowToInsert4" type="text">
    <input name="rowToInsert5" type="text">
    <input name="rowToInsert6" type="text">
    <input name="rowToInsert7" type="text">
    <input name="rowToInsert8" type="text">
    <input name="rowToInsert9" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="storeCreditInput" type="text">
    <input name="firstNameInput" type="text">
    <input name="lastNameInput" type="text">
    <input name="genderInput" type="text">
    <input name="phoneInput" type="text">
    <input name="emailInput" type="text">
    <input name="birthdayInput" type="text">
    <input name="addressInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Store Credit</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Phone Number</th>
        <th>Email Address</th>
        <th>Birthday</th>
        <th>Address</th>
    </tr>

    <% Vector<customerTable> v = DataHandler.getCustomers();
        for (customerTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getStoreCredit())%></td>
        <td><%= String.valueOf(c.getFirstName())%></td>
        <td><%= String.valueOf(c.getLastName())%></td>
        <td><%= String.valueOf(c.getGender())%></td>
        <td><%= String.valueOf(c.getPhone())%></td>
        <td><%= String.valueOf(c.getEmail())%></td>
        <td><%= String.valueOf(c.getBirthday())%></td>
        <td><%= String.valueOf(c.getAddress())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
