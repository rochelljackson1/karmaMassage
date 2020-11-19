<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.existingConditionsSTJDTable" %><%--
  Created by IntelliJ IDEA.
  User: nafis
  Date: 11/13/2020
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Existing Conditions STJD </title>

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

<form action="deleteSTJDOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertSTJDOptions" id="insertForm" style="display:none;" method="post">
    <input name="rowToInsert" type="text">
    <input name="rowToInsert2" type="text">
    <input name="rowToInsert3" type="text">
    <input name="rowToInsert4" type="text">
    <input name="rowToInsert5" type="text">
    <input name="rowToInsert6" type="text">
    <input name="rowToInsert7" type="text">
    <input name="rowToInsert8" type="text">
    <input name="rowToInsert9" type="text">
    <input name="rowToInsert10" type="text">
    <input name="rowToInsert11" type="text">
    <input name="rowToInsert12" type="text">
    <input name="rowToInsert13" type="text">
    <input name="rowToInsert14" type="text">
    <input name="rowToInsert15" type="text">
    <input name="rowToInsert16" type="text">
    <input name="rowToInsert17" type="text">
    <input name="rowToInsert18" type="text">
    <input name="rowToInsert19" type="text">
    <input name="rowToInsert20" type="text">
    <input name="rowToInsert21" type="text">
    <input name="rowToInsert22" type="text">
    <input name="rowToInsert23" type="text">
    <input name="rowToInsert24" type="text">
    <input name="rowToInsert25" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateSTJDOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="upperBackRightInput" type="text">
    <input name="upperBackLeftInput" type="text">
    <input name="shouldersRightInput" type="text">
    <input name="shouldersLeftInput" type="text">
    <input name="neckRightInput" type="text">
    <input name="neckLeftInput" type="text">
    <input name="midBackRightInput" type="text">
    <input name="midBackLeftInput" type="text">
    <input name="lowerBackRightInput" type="text">
    <input name="lowerBackLeftInput" type="text">
    <input name="legsRightInput" type="text">
    <input name="legsLeftInput" type="text">
    <input name="kneesRightInput" type="text">
    <input name="kneesLeftInput" type="text">
    <input name="hipsRightInput" type="text">
    <input name="hipsLeftInput" type="text">
    <input name="handsRightInput" type="text">
    <input name="handsLeftInput" type="text">
    <input name="feetRightInput" type="text">
    <input name="feetLeftInput" type="text">
    <input name="armsRightInput" type="text">
    <input name="armsLeftInput" type="text">
    <input name="anklesRightInput" type="text">
    <input name="anklesLeftInput" type="text">
    <button type="submit">Update This Row</button>
</form>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Upper Back Right</th>
        <th>Upper Back Left</th>
        <th>Shoulders Right</th>
        <th>Shoulders Left</th>
        <th>Neck Right</th>
        <th>Neck Left</th>
        <th>Mid Back Right</th>
        <th>Mid Back Left</th>
        <th>Lower Back Right</th>
        <th>Lower Back Left</th>
        <th>Legs Right</th>
        <th>Legs Left</th>
        <th>Knees Right</th>
        <th>Knees Left</th>
        <th>Hips Right</th>
        <th>Hips Left</th>
        <th>Hands Right</th>
        <th>Hands Left</th>
        <th>Feet Right</th>
        <th>Feet Left</th>
        <th>Arms Right</th>
        <th>Arms Left</th>
        <th>Ankles Right</th>
        <th>Ankles Left</th>
    </tr>

    <% Vector<existingConditionsSTJDTable> v = DataHandler.getExistingConditionsSTJD();
        for (existingConditionsSTJDTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <td><%= String.valueOf(c.isUpperBackRight())%></td>
        <td><%= String.valueOf(c.isUpperBackLeft())%></td>
        <td><%= String.valueOf(c.isShouldersRight())%></td>
        <td><%= String.valueOf(c.isShouldersLeft())%></td>
        <td><%= String.valueOf(c.isNeckRight())%></td>
        <td><%= String.valueOf(c.isNeckLeft())%></td>
        <td><%= String.valueOf(c.isMidBackRight())%></td>
        <td><%= String.valueOf(c.isMidBackLeft())%></td>
        <td><%= String.valueOf(c.isLowerBackRight())%></td>
        <td><%= String.valueOf(c.isLowerBackLeft())%></td>
        <td><%= String.valueOf(c.isLegsRight())%></td>
        <td><%= String.valueOf(c.isLegsLeft())%></td>
        <td><%= String.valueOf(c.isKneesRight())%></td>
        <td><%= String.valueOf(c.isKneesLeft())%></td>
        <td><%= String.valueOf(c.isHipsRight())%></td>
        <td><%= String.valueOf(c.isHipsLeft())%></td>
        <td><%= String.valueOf(c.isHandsRight())%></td>
        <td><%= String.valueOf(c.isHandsLeft())%></td>
        <td><%= String.valueOf(c.isFeetRight())%></td>
        <td><%= String.valueOf(c.isFeetLeft())%></td>
        <td><%= String.valueOf(c.isArmsRight())%></td>
        <td><%= String.valueOf(c.isArmsLeft())%></td>
        <td><%= String.valueOf(c.isAnklesRight())%></td>
        <td><%= String.valueOf(c.isAnklesLeft())%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
