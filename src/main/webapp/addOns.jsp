<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.addOnsTable" %>

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
    <title>Add-Ons</title>

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
    <option value="deleteRow">Delete Add-On</option>
    <option value="insertRow">Insert Add-On</option>
    <option value="updateRow">Update Add-On</option>
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
    <button type="submit">Insert This Row</button>
</form>
<br>
<form action="updateOptions" id="updateForm" style="display:none;" method="post">
    <input name="addOnNumber" type="text">
    <input name="price" type="text">
    <input name="addOnDescription" type="text">
    <input name="customerNumber" type="text">
    <button type="submit">Update This Row</button>
</form>

<table class="center">
    <h2 align="center" class="w3-grey">Add Ons List</h2>
    <tr>
        <th style="text-align:center">Add-On Number</th>
        <th style="text-align:center">Price</th>
        <th style="text-align:center">Add-On Description</th>
    </tr>

    <% Vector<addOnsTable> v = DataHandler.getAddOns();
        for (addOnsTable c : v) {
    %>
    <tr>
        <td style="text-align:center"><%= String.valueOf(c.getAddOnNumber())%></td>
        <td style="text-align:center"><%= String.valueOf(c.getPrice())%></td>
        <td style="text-align:center"><%= String.valueOf(c.getAddOnDescription()) %></td>
    </tr>
    <%
        }
    %>

</body>
</html>
