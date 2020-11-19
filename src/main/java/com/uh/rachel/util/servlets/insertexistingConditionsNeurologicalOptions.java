package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class insertexistingConditionsNeurologicalOptions {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertexistingConditionsNeurologicalRowByID(
                Integer.parseInt(request.getParameter("customerNumberInput")),
                (Boolean.parseBoolean(request.getParameter("tinglingInput"))),
                (Boolean.parseBoolean(request.getParameter("stabbingPainInput"))),
                (Boolean.parseBoolean(request.getParameter("parkinsonsInput"))),
                (Boolean.parseBoolean(request.getParameter("numbnessInput"))),
                (Boolean.parseBoolean(request.getParameter("multipleSclerosisInput"))),
                (Boolean.parseBoolean(request.getParameter("herniatedDiscInput"))),
                (Boolean.parseBoolean(request.getParameter("cerebralPaisyInput"))),
                (Boolean.parseBoolean(request.getParameter("burningInput")))
        );
        response.sendRedirect("./existingConditionsNeurological.jsp");
    }

}
