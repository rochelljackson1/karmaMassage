package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateSkinOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateSkinRowByID((Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("skinIrritationsInput")!=""?request.getParameter("skinIrritationsInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("skinConditionsInput")!=""?request.getParameter("skinConditionsInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("melanomaInput")!=""?request.getParameter("melanomaInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("hypersensitiveReactionInput")!=""?request.getParameter("hypersensitiveReactionInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("bruiseEasilyInput")!=""?request.getParameter("bruiseEasilyInput"):"0")));
        response.sendRedirect("./existingConditionsSkin.jsp");
    }
}
