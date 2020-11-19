package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class updateexistingConditionsHeadNeckOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateexistingConditionsHeadNeckRowByID(
                (Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("visionProblemInput")!=""?request.getParameter("visionProblemInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("visionProblemsInput")!=""?request.getParameter("visionLossInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("sinusProblemsInput")!=""?request.getParameter("sinusProblemsInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("migrainesInput")!=""?request.getParameter("migrainesInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("jawPainInput")!=""?request.getParameter("jawPainInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("hearingLossInput")!=""?request.getParameter("hearingLossInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("headachesInput")!=""?request.getParameter("headachesInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("earProblemsInput")!=""?request.getParameter("earProblemsInput"):"0"))
                );
        response.sendRedirect("./existingConditionsHeadNeck.jsp");
    }
}
