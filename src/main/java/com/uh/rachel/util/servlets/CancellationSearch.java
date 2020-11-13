package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;
import com.uh.rachel.util.tableClasses.customerTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "CancellationSearch")
public class CancellationSearch extends HttpServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("custID");
        int id = 0;
        if (idString != null && !idString.isEmpty()){
          id = Integer.parseInt(idString);
        }else {
           String firstname = request.getParameter("firstname");
           String lastname = request.getParameter("lastname");
           Vector<customerTable> customer = DataHandler.getUserByName(firstname, lastname);
           if(customer != null) {
               id = customer.get(customerNumber);

           }
        }
        response.sendRedirect("./cancellationSystem.jsp?id=" + id);
    }*/
}
