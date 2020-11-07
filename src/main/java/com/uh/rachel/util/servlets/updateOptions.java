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
            DataHandler.updateRowByID(Integer.parseInt(request.getParameter("customerNumberInput")), Integer.parseInt(request.getParameter("storeCreditInput")), request.getParameter (("firstNameInput")), (request.getParameter("lastNameInput")), (request.getParameter("genderInput")), (request.getParameter("phoneInput")), (request.getParameter("emailInput")), (request.getParameter("birthdayInput")), (request.getParameter("addressInput")));
            response.sendRedirect("./customerProfile.jsp");
        }
    }
