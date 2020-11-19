package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class deleteexistingConditionsHeadNeckOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.deleteexistingConditionsHeadNeckRowByID(Integer.parseInt(request.getParameter("rowToDelete")));
        response.sendRedirect("./existingConditonsHeadNeck.jsp");
    }
}
