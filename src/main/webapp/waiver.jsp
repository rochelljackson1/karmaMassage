<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.waiverTable" %>
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
    <title>Waiver</title>

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

<form action="deleteWaiverOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertWaiverOptions" id="insertForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="signitureInput" type="text">
    <input name="dateInput" type="text">
    <input name="acknowledgmentInput" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateWaiverOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="signitureInput" type="text">
    <input name="dateInput" type="text">
    <input name="acknowledgmentInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Signiture</th>
        <th>Date</th>
        <th>Acknowledgment</th>
    </tr>
    <% Vector<waiverTable> v = DataHandler.getWaiver();
        for (waiverTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.getSigniture())%></td>
        <td><%= String.valueOf(c.getDate())%></td>
        <td><%= String.valueOf(c.isAcknowledgment())%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>