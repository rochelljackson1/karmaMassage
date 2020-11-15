<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.customerTable" %>
<%@ page import="com.uh.rachel.util.tableClasses.cancellationObjects" %>
<%@ page import="com.uh.rachel.util.tableClasses.appointmentsTable" %>


<%--
  Created by IntelliJ IDEA.
  User: YCasasola
  Date: 11/05/20
  Time: 06:41 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int userId = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")); %>

<html lang="en">
<head>
    <title>Cancellation System</title>
    <meta charset="UTF-8">
    <script type="text/javascript">
        window.onload = function (){
            showToast();
        }
        function showToast(){
            console.log("a")
            var x = document.getElementById("snackbar");
            x.className = "show";
            setTimeout(function (){x.className = x.className.replace("show", ""); }, 3000);
        }
    </script>
</head>

<body>
<% if (request.getParameter("t") != null) {
    switch (Integer.parseInt(request.getParameter("t"))){
        case 1: {
%><div id="snackbar" onload="showToast()">Thank you, your cancellation is complete.</div><%
        break;
        }
    case 2: {
%><div id="snackbar" onload="showToast()">Your appointment has been cancelled, your account will be charged.</div><%
    break;
    }
        default: {
            break;
        }
    }
}%>

<form class="centered-form" action="cancellationSystem" id="deleteForm" style="display:none;" method="post">
    <input type="text" name="rowToDelete">
    <button type="submit" name="DeleteAppt">Cancel</button>

</form>
</body>
</html>