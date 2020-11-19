package com.uh.rachel.util.servlets;

        import com.uh.rachel.util.DataHandler;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

@WebServlet(name = "Options")

public class insertWomenOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertWomenRowByID(Integer.parseInt(request.getParameter("rowToInsert")), (Boolean.parseBoolean(request.getParameter("rowToInsert2"))), Boolean.parseBoolean(request.getParameter("rowToInsert3")));
        response.sendRedirect("./existingConditionsWomen.jsp");
    }
}
