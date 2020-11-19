package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class updateexistingConditionsMedicationsOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateexistingConditionsMedicationsRowByID(
                (Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")),
                (request.getParameter ("otherInput")!=""?request.getParameter("otherInput"):"null")
        );
        response.sendRedirect("./existingConditionsMedications.jsp");
    }
}
