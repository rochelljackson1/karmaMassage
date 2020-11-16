package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    public class updateOptions extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            DataHandler.updateRowByID((Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")), Integer.parseInt(request.getParameter("storeCreditInput")!=""?request.getParameter("storeCreditInput"):"0"), (request.getParameter ("firstNameInput")!=""?request.getParameter("firstNameInput"):"null"), (request.getParameter("lastNameInput")!=""?request.getParameter("lastNameInput"):"null"), (request.getParameter("genderInput")!=""?request.getParameter("genderInput"):"null"), (request.getParameter("phoneInput")!=""?request.getParameter("phoneInput"):"null"), (request.getParameter("emailInput")!=""?request.getParameter("emailInput"):"null"), (request.getParameter("birthdayInput")!=""?request.getParameter("birthdayInput"):"null"), (request.getParameter("addressInput")!=""?request.getParameter("addressInput"):"null"));
            response.sendRedirect("./customerProfile.jsp");
        }
    }
