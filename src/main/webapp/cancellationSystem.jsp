<%@ page import="com.uh.rachel.util.DataHandler" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.uh.rachel.util.tableClasses.appointmentsTable" %>
<%@ page import="com.uh.rachel.util.tableClasses.cancellationObjects" %>

<%--
  Created by IntelliJ IDEA.
  User: YCasasola
  Date: 11/05/20
  Time: 06:41 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int userId = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")); %>

<html>
<head>
    <title>Cancellation System</title>
    <script type="text/javascript">

    </script>
</head>
<body>


<table>
    <tr>
        <th>Appointment Number</th>
        <th>Scheduled Date</th>
        <th>Original Full Price</th>
    </tr>
    <tr>
            <% Vector<cancellationObjects> v = DataHandler.getCancellationsByUserId(userId);
        for (cancellationObjects c : v) {
    %>
    <tr>
        <td><%= String.valueOf(c.getTable().getAppointmentNumber())%></td>
        <td><%= String.valueOf(c.getTable().getScheduledDate())%></td>
       <td><%= String.valueOf(c.getTable().getOriginalFullPrice())%></td>
    </tr>
    <%
        }
    %>
    </tr>
</table>

</body>
</html>