<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.existingConditionsSkinTable" %><%--
  Created by IntelliJ IDEA.
  User: nafis
  Date: 11/13/2020
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Existing Conditions Skin</title>

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

<form action="deleteSkinOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertSkinOptions" id="insertForm" style="display:none;" method="post">
    <input name="rowToInsert" type="text">
    <input name="rowToInsert2" type="text">
    <input name="rowToInsert3" type="text">
    <input name="rowToInsert4" type="text">
    <input name="rowToInsert5" type="text">
    <input name="rowToInsert6" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateSkinOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="skinIrritationsInput" type="text">
    <input name="skinConditionsInput" type="text">
    <input name="melanomaInput" type="text">
    <input name="hypersensitiveReactionInput" type="text">
    <input name="bruiseEasilyInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Skin Irritations</th>
        <th>Skin Conditions</th>
        <th>Melanoma</th>
        <th>Hypersensitive Reaction</th>
        <th>Bruise Easily</th>
    </tr>

    <% Vector<existingConditionsSkinTable> v = DataHandler.getExistingConditionsSkin();
        for (existingConditionsSkinTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.isSkinIrritations())%></td>
        <td><%= String.valueOf(c.isSkinConditions())%></td>
        <td><%= String.valueOf(c.isMelanoma())%></td>
        <td><%= String.valueOf(c.isHypersensitiveReaction())%></td>
        <td><%= String.valueOf(c.isBruiseEasily())%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
