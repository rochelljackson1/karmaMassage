<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="com.uh.rachel.util.tableClasses.Country" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Makki
  Date: 11/16/20
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country</title>

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
    <option value="deleteRow">Delete Country</option>
    <option value="insertRow">Insert Country</option>
    <option value="updateRow">Update Country</option>
</select>

<button onclick="makeVisible();">Make Form Visible</button>

<form action="deleteCountry" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Country</button>
</form>

<form action="insertCountry" id="insertForm" style="display:none;" method="post">
    <input name="countryNameInput" type="text">
    <button type="submit">Insert New Country</button>
</form>

<form action="updateCountry" id="updateForm" style="display:none;" method="post">
    <input name="IdInput" type="text">
    <input name="countryNameInput" type="text">

    <button type="submit">Update Country</button>
</form>



<table>
    <tr>
        <th>Country ID</th>
        <th>Country Name</th>



    </tr>
    <% Vector<Country> v = DataHandler.getCountry();
        for (Country c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getId())%></td>
        <td><%= String.valueOf(c.getCountryName())%></td>


    </tr>
    <%
        }
    %>

</table>
</body>
</html>
