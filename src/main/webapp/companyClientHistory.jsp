<%@ page import="com.uh.rachel.util.tableClasses.companyClientHistoryTable" %>
<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.customerTable" %>
<%@ page import="javax.xml.crypto.Data" %><%--
  Created by IntelliJ IDEA.
  User: rjvoigt
  Date: 11/3/20
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Client History</title>

    <script type="text/javascript" id="test">
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

<form action="deleteCompanyOptions" id="deleteForm" style="display:none;" method="post">
    <input name="rowToDelete" type="text">
    <button type="submit">Delete This Row</button>
</form>

<form action="insertCompanyOptions" id="insertForm" style="display:none;" method="post">
    <input name="rowToInsert" type="text">
    <input name="rowToInsert2" type="text">
    <button type="submit">Insert This Row</button>
</form>

<form action="updateCompanyOptions" id="updateForm" style="display:none;" method="post">
    <input name="customerNumberInput" type="text">
    <input name="currentClient" type="text">
    <button type="submit">Update This Row</button>
</form>


<table>
    <tr>
        <th>Customer ID</th>
        <th>Current Client</th>
    </tr>
    <% Vector<companyClientHistoryTable> v = DataHandler.getcompanyClientHistory();
        for (companyClientHistoryTable c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getCustomerNumber())%></td>
        <script type="text/javascript" id = "test3">
            function validateForm() {
                var x = document.forms["updateForm"]["currentClient"].value;
                if ((x == "true") || (x == "True") || (x == "TRue" || (x == "TRUe") || (x == "TRUE") || (x == "tRue") || (x == "tRUe") || (x == "tRUE") || (x == "trUe") || (x == "trUE") || (x == "truE"))) {
                    <% //This is not showing true on HTML, but it is being changed in DataGrip
                        c.setCurrentClient(true);%>
                }
                else if ((x == "false") || (x == "False") || (x == "FAlse") || (x == "FALse") || (x == "FALSe") || (x == "FALSE") || (x == "fAlse") || (x == "fALse") || (x == "fALSe") || (x == "fALSE") || (x == "faLse") || (x == "faLSe") || (x == "faLSE") || (x == "falSe") || (x == "falSE") || (x == "falsE")){
                    <% //This is not showing true on HTML, but it is being changed in DataGrip
                        c.setCurrentClient(false);%>
                }
                else {
                    //This is not showing true on HTML, but it is being changed in DataGrip
                    System.out.println("This is not a word. Please check spelling.");
                }
            }
        </script>
        <td><%= String.valueOf(c.getCurrentClient())%></td>
    </tr>

    <%
        }
    %>
</table>
</body>
</html>
