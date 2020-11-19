package com.uh.rachel.util.servlets;

        import com.uh.rachel.util.DataHandler;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

@WebServlet(name = "Options")

public class insertSkinOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertSkinRowByID(Integer.parseInt(request.getParameter("rowToInsert")),
                (Boolean.parseBoolean(request.getParameter("rowToInsert2"))),
                Boolean.parseBoolean(request.getParameter("rowToInsert3")),
                Boolean.parseBoolean(request.getParameter("rowToInsert4")),
                Boolean.parseBoolean(request.getParameter("rowToInsert5")),
                Boolean.parseBoolean(request.getParameter("rowToInsert6")));
        response.sendRedirect("./existingConditionsSkin.jsp");
    }
}
