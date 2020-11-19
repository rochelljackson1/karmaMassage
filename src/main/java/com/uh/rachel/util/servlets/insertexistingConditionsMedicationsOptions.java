package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")
public class insertexistingConditionsMedicationsOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertexistingConditionsMedicationsRowByID(
                Integer.parseInt(request.getParameter("customerNumberInput")),
                (request.getParameter("otherInput"))
        );
        response.sendRedirect("./existingConditionsMedications.jsp");
    }
}
