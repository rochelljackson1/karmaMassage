package com.uh.rachel.util.servlets;

    import com.uh.rachel.util.DataHandler;

    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;

@WebServlet(name = "Options")

public class insertSTJDOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.insertSTJDRowByID(Integer.parseInt(request.getParameter("rowToInsert")),
                (Boolean.parseBoolean(request.getParameter("rowToInsert2"))),
                Boolean.parseBoolean(request.getParameter("rowToInsert3")),
                Boolean.parseBoolean(request.getParameter("rowToInsert4")),
                Boolean.parseBoolean(request.getParameter("rowToInsert5")),
                Boolean.parseBoolean(request.getParameter("rowToInsert6")),
                Boolean.parseBoolean(request.getParameter("rowToInsert7")),
                Boolean.parseBoolean(request.getParameter("rowToInsert8")),
                Boolean.parseBoolean(request.getParameter("rowToInsert9")),
                Boolean.parseBoolean(request.getParameter("rowToInsert10")),
                Boolean.parseBoolean(request.getParameter("rowToInsert11")),
                Boolean.parseBoolean(request.getParameter("rowToInsert12")),
                Boolean.parseBoolean(request.getParameter("rowToInsert13")),
                Boolean.parseBoolean(request.getParameter("rowToInsert14")),
                Boolean.parseBoolean(request.getParameter("rowToInsert15")),
                Boolean.parseBoolean(request.getParameter("rowToInsert16")),
                Boolean.parseBoolean(request.getParameter("rowToInsert17")),
                Boolean.parseBoolean(request.getParameter("rowToInsert18")),
                Boolean.parseBoolean(request.getParameter("rowToInsert19")),
                Boolean.parseBoolean(request.getParameter("rowToInsert20")),
                Boolean.parseBoolean(request.getParameter("rowToInsert21")),
                Boolean.parseBoolean(request.getParameter("rowToInsert22")),
                Boolean.parseBoolean(request.getParameter("rowToInsert23")),
                Boolean.parseBoolean(request.getParameter("rowToInsert24")),
                Boolean.parseBoolean(request.getParameter("rowToInsert25")));
        response.sendRedirect("./existingConditionsSTJD.jsp");
    }
}
