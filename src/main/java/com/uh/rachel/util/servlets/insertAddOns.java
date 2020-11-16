package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Options")

public class insertAddOns extends HttpServlet{
protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        DataHandler.insertAddOnsRowByID(
                Integer.parseInt(request.getParameter("rowToInsert")),
                Double.parseDouble(request.getParameter("rowToInsert2")),
                (request.getParameter("rowToInsert3")),
                Integer.parseInt(request.getParameter("rowToInsert4")));
        response.sendRedirect("./addOns.jsp");
        }
}