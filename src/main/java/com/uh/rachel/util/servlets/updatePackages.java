package com.uh.rachel.util.servlets;
import com.uh.rachel.util.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updatePackages extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updatePackagesRowByID(
                (Integer.parseInt(request.getParameter("packageNumber")!=""?request.getParameter("packageNumber"):"0")),
                (Integer.parseInt(request.getParameter("serviceNumber")!=""?request.getParameter("serviceNumber"):"0")),
                request.getParameter (("packageDescription")!=""?request.getParameter("packageDescription"):"null"),
                (Double.parseDouble(request.getParameter("price")!=""?request.getParameter("price"):"0")),
                (Boolean.parseBoolean(request.getParameter("status")!=""?request.getParameter("status"):"0")));
        response.sendRedirect("./packages.jsp");
    }
}



