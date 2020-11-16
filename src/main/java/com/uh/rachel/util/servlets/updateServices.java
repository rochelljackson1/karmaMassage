package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateServices extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateServicesRowByID(
                (Integer.parseInt(request.getParameter("serviceNumber")!=""?request.getParameter("serviceNumber"):"0")),
                request.getParameter (("serviceDescription")!=""?request.getParameter("serviceDescription"):"null"),
                (Double.parseDouble(request.getParameter("price")!=""?request.getParameter("price"):"0")),
                Boolean.parseBoolean(request.getParameter("status")!=""?request.getParameter("status"):"0"),
                Boolean.parseBoolean(request.getParameter("discount")!=""?request.getParameter("discount"):"0"));
        response.sendRedirect("./services.jsp");
    }
}
