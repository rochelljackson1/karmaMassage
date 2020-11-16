package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class insertAddress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertAddressRowByID(Integer.parseInt(request.getParameter("customerNumberInput")),(request.getParameter("streetInput")), (request.getParameter("cityNameInput")), (request.getParameter("stateNameInput")), (request.getParameter("zipCodeInput")), (request.getParameter("countryNameInput")));
        response.sendRedirect("./address.jsp");
    }
}