package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class insertDoctorOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertDoctorRowByID(Integer.parseInt(request.getParameter("rowToInsert")), (Integer.parseInt(request.getParameter("rowToInsert2"))), (request.getParameter("rowToInsert3")), (request.getParameter("rowToInsert4")), (request.getParameter("rowToInsert5")));
        response.sendRedirect("./doctor.jsp");
    }
}
