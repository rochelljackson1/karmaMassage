<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.packagesTable" %>

<%--
  Created by IntelliJ IDEA.
  User: YCasasola
  Date: 11/04/20
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Packages</title>

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
    <option value="deleteRow">Delete Package</option>
    <option value="insertRow">Insert Package</option>
    <option value="updateRow">Update Package</option>
</select>

<button onclick="makeVisible();">Make Form Visible</button>

<form action="deleteOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>
<br>
<form action="insertOptions" id="insertForm" style="display:none;" method="post">
    <input name="rowToInsert" type="text">
    <input name="rowToInsert2" type="text">
    <input name="rowToInsert3" type="text">
    <input name="rowToInsert4" type="text">
    <input name="rowToInsert5" type="text">
    <button type="submit">Insert This Row</button>
</form>
<br>
<form action="updateOptions" id="updateForm" style="display:none;" method="post">
    <input name="packageNumber" type="text">
    <input name="serviceNumber" type="text">
    <input name="packageDescription" type="text">
    <input name="price" type="text">
    <input name="status" type="text">

    <button type="submit">Update This Row</button>
</form>

<table class="center">
    <h2 align="center" class="w3-grey">Packages List</h2>
    <tr>
        <th style="text-align:center">Package Number</th>
        <th style="text-align:center">Service Number</th>
        <th style="text-align:center">Package Description</th>
        <th style="text-align:center">Price</th>
        <th style="text-align:center">Status</th>
    </tr>

    <% Vector<packagesTable> v = DataHandler.getPackages();
        for (packagesTable c : v) {
    %>
    <tr>
        <td style="text-align:center"><%= String.valueOf(c.getPackageNumber()) %></td>
        <td style="text-align:center"><%= String.valueOf(c.getServiceNumber())%></td>
        <td style="text-align:center"><%= String.valueOf(c.getPackageDescription())%></td>
        <td style="text-align:center"><%= String.valueOf(c.getPrice()) %></td>
        <td style="text-align:center"><%= String.valueOf(c.getStatus()) %></td>

    </tr>

    <%
        }
    %>
</table>
</body>
</html>
