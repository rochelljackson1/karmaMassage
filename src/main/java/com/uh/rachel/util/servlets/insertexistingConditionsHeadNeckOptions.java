package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")
public class insertexistingConditionsHeadNeckOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertexistingConditionsHeadNeckRowByID(
                Integer.parseInt(request.getParameter("customerNumberInput")),
                (Boolean.parseBoolean(request.getParameter("visionProblemsInput"))),
                (Boolean.parseBoolean(request.getParameter("visionLossInput"))),
                (Boolean.parseBoolean(request.getParameter("sinusProblemsInput"))),
                (Boolean.parseBoolean(request.getParameter("migrainesInput"))),
                (Boolean.parseBoolean(request.getParameter("jawPainInput"))),
                (Boolean.parseBoolean(request.getParameter("hearingLossInput"))),
                (Boolean.parseBoolean(request.getParameter("headachesInput"))),
                (Boolean.parseBoolean(request.getParameter("earProblemsInput")))
        );
        response.sendRedirect("./existingConditionsHeadNeck.jsp");
    }
}
