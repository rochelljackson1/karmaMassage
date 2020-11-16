package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")
public class updateAddress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateAddressRowByID((Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")), (request.getParameter("streetInput")!=""?request.getParameter("streetInput"):"0"), (request.getParameter ("cityNameInput")!=""?request.getParameter("cityNameInput"):"0"), (request.getParameter("stateNameInput")!=""?request.getParameter("stateNameInput"):"0"), (request.getParameter("zipCodeInput")!=""?request.getParameter("zipCodeInput"):"0"), (request.getParameter("countryNameInput")!=""?request.getParameter("countryNameInput"):"0"));
        response.sendRedirect("./address.jsp");
    }
}