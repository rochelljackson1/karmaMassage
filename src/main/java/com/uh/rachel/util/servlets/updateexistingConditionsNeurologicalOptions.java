package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class updateexistingConditionsNeurologicalOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateexistingConditionsNeurologicalRowByID(
                (Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("tinglingInput")!=""?request.getParameter("tinglingInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("stabbingPainInput")!=""?request.getParameter("stabbingPainInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("parkinsonsInput")!=""?request.getParameter("parkinsonsInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("numbnessInput")!=""?request.getParameter("numbnessInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("multipleSclerosisInput")!=""?request.getParameter("multipleSclerosisInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("herniatedDiscInput")!=""?request.getParameter("herniatedDiscInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("cerebralPaisyInput")!=""?request.getParameter("cerebralPaisyInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("burningInput")!=""?request.getParameter("burningInput"):"0"))
        );
        response.sendRedirect("./existingConditionsNeurologicalOptions.jsp");
    }
}
