package com.uh.rachel.util.servlets;

        import com.uh.rachel.util.DataHandler;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

public class updateCompanyOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateCompanyRowByID((Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")), Boolean.parseBoolean(request.getParameter("currentClient")!=""?request.getParameter("currentClient"):"0"));
        response.sendRedirect("./companyClientHistory.jsp");
    }
}