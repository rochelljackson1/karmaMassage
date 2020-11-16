<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.Address" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Makki
  Date: 11/1/20
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address</title>
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

<form action="deleteAddress" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertAddress" id="insertForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="streetInput" type="text">
    <input name="cityNameInput" type="text">
    <input name="stateNameInput" type="text">
    <input name="zipCodeInput" type="text">
    <input name="countryNameInput" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateAddress" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="streetInput" type="text">
    <input name="cityNameInput" type="text">
    <input name="stateNameInput" type="text">
    <input name="zipCodeInput" type="text">
    <input name="countryNameInput" type="text">
    <button type="submit">Update This Row</button>
</form>


<table>
    <tr>
        <th>Customer ID</th>
        <th>Street</th>
        <th>City</th>
        <th>State</th>
        <th>Zip Code</th>
        <th>Country</th>

    </tr>
    <% Vector<Address> v = DataHandler.getAddress();
        for (Address c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getStreet())%></td>
        <td><%= String.valueOf(c.getCityName())%></td>
        <td><%= String.valueOf(c.getStateName())%></td>
        <td><%= String.valueOf(c.getZipCode())%></td>
        <td><%= String.valueOf(c.getCountryName())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
