package com.uh.rachel.util.servlets;

        import com.uh.rachel.util.DataHandler;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

@WebServlet(name = "Options")

public class insertCompanyOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertCompanyRowByID(Integer.parseInt(request.getParameter("rowToInsert")), (Boolean.parseBoolean(request.getParameter("rowToInsert2"))));
        response.sendRedirect("./companyClientHistory.jsp");
    }
}