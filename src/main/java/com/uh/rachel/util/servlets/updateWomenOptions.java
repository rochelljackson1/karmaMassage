package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateWomenOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateWomenRowByID((Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("pregnantInput")!=""?request.getParameter("pregnantInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("gynecologicalConditionsInput")!=""?request.getParameter("gynecologicalConditionsInput"):"0")));
        response.sendRedirect("./existingConditionsWomen.jsp");
    }
}
