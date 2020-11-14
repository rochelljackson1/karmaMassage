package com.uh.rachel.util.servlets;
import com.uh.rachel.util.ConnectionProvider;
import com.uh.rachel.util.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;


@WebServlet(name = "Options")
public class cancellationSystem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aptNum = Integer.parseInt(request.getParameter("rowToDelete"));
       try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT appointmentDateTime FROM appointmentsTable WHERE appointmentNumber=?");
            preparedStatement.setInt(1, aptNum);
            ResultSet ResultSet = preparedStatement.executeQuery();
            if (ResultSet.next()) {
                Date now = new Date();
                Date appointmentDate = new Date(ResultSet.getTimestamp("appointmentDateTime").getTime());
                Calendar c = Calendar.getInstance();
                c.setTime(now);
                //replace 24 in the following line with the number of hours difference gotten from the database
                c.add(Calendar.HOUR_OF_DAY, 24);
                if (!appointmentDate.before(now)) {
                    DataHandler.cancelAppointment(aptNum, false);
                    //TODO cancelled within time limit
                    response.sendRedirect("./cancellationSystem.jsp?message=1");
                } else  {
                    DataHandler.cancelAppointment(aptNum, true);
                    //TODO not cancelled within time limit
                    response.sendRedirect("./cancellationSystem.jsp?message=2");
                }
            }
            ResultSet.close();
            preparedStatement.close();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./cancellationSystem.jsp");
    }
}



