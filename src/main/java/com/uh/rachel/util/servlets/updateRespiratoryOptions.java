package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class updateRespiratoryOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateRespiratoryRowByID((
                Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("shortnessOfBreathInput")!=""?request.getParameter("shortnessOfBreathInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("emphysemaInput")!=""?request.getParameter("emphysemaInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("chronicCoughInput")!=""?request.getParameter("chronicCoughInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("bronchitisInput")!=""?request.getParameter("bronchitisInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("asthmaInput")!=""?request.getParameter("asthmaInput"):"0")));
        response.sendRedirect("./existingConditionsRespiratory.jsp");
    }
}

