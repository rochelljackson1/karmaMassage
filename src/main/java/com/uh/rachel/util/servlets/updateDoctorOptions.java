package com.uh.rachel.util.servlets;

        import com.uh.rachel.util.DataHandler;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

public class updateDoctorOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateDoctorRowByID(Integer.parseInt(request.getParameter("customerNumberInput")), Integer.parseInt(request.getParameter("doctorNuberInput")), request.getParameter (("physicianFirstnameInput")), (request.getParameter("physicianLastnameInput")), (request.getParameter("physicianPhoneInput")));
        response.sendRedirect("./doctor.jsp");
    }
}