package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class updateexistingConditionsInfectiousOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateexistingConditionsInfectiousRowByID(
                (Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("skinConditionsInput")!=""?request.getParameter("skinConditionsInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("respiratoryConditionInput")!=""?request.getParameter("respiratoryConditionInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("hivInput")!=""?request.getParameter("hivInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("herpesInput")!=""?request.getParameter("herpesInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("hepatitisInput")!=""?request.getParameter("hepatitisInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("altheletsFootInput")!=""?request.getParameter("altheletsFootInput"):"0"))
        );
        response.sendRedirect("./existingConditionsInfectious.jsp");
    }
}
