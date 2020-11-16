package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")
public class updateCountry extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateCountryRowByID((Integer.parseInt(request.getParameter("IdInput")!=""?request.getParameter("IdInput"):"0")), (request.getParameter("countryNameInput")!=""?request.getParameter("countryNameInput"):"name"));
        response.sendRedirect("./country.jsp");
    }
}