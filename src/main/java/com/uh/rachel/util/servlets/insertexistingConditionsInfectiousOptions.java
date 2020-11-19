package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")
public class insertexistingConditionsInfectiousOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertexistingConditionsInfectiousRowByID(
                Integer.parseInt(request.getParameter("customerNumberInput")),
                (Boolean.parseBoolean(request.getParameter("skinConditionsInput"))),
                (Boolean.parseBoolean(request.getParameter("respiratoryConditionsInput"))),
                (Boolean.parseBoolean(request.getParameter("hivInput"))),
                (Boolean.parseBoolean(request.getParameter("herpesInput"))),
                (Boolean.parseBoolean(request.getParameter("hepatitisInput"))),
                (Boolean.parseBoolean(request.getParameter("attheletsFootInput")))
        );
        response.sendRedirect("./existingConditionsInfectious.jsp");
    }
}
