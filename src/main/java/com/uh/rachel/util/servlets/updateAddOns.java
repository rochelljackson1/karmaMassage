package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateAddOns extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateAddOnsRowByID(
                (Integer.parseInt(request.getParameter("addOnNumber")!=""?request.getParameter("addOnNumber"):"0")),
                (Double.parseDouble(request.getParameter("price")!=""?request.getParameter("price"):"0")),
                request.getParameter (("addOnDescription")!=""?request.getParameter("addOnDescription"):"null"),
                (Integer.parseInt(request.getParameter("customerNumber")!=""?request.getParameter("customerNumber"):"0")));
        response.sendRedirect("./addOns.jsp");
    }
}
