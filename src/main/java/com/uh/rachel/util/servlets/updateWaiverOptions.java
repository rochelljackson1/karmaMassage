package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class updateWaiverOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateWaiverRowByID((Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")), request.getParameter("signitureInput")!=""?request.getParameter("signitureInput"):"", request.getParameter("dateInput")!=""?request.getParameter("dateInput"):"", (Boolean.parseBoolean(request.getParameter("acknowledgmentInput")!=""?request.getParameter("acknowledgmentInput"):"0")));
        response.sendRedirect("./waiver.jsp");
    }
}
