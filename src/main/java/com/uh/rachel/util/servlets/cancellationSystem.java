package com.uh.rachel.util.servlets;
import com.uh.rachel.util.ConnectionProvider;
import com.uh.rachel.util.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;


@WebServlet(name = "Options")
public class cancellationSystem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //DataHandler.deleteRowByID(Integer.parseInt(request.getParameter("rowToDelete")));
        //response.sendRedirect("./customerProfile.jsp");
       /* try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT appointmentDateTime, cancelledDateTime FROM appointmentsTable");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date cancelledDate = new Date(rs.getTimestamp("cancelledDateTime").getTime());
                Date appointmentDate = new Date(rs.getTimestamp("appointmentDateTime").getTime());
                Calendar c = Calendar.getInstance();
                c.setTime(appointmentDate);
                //replace 24 in the following line with the number of hours difference gotten from the database
                c.add(Calendar.HOUR_OF_DAY, 24);
                appointmentDate = new Timestamp(c.getTime().getTime());
                if (appointmentDate.after(cancelledDate)) {
                    //TODO cancelled within time limit
                } else  {
                    //TODO not cancelled within time limit
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        */
    }
}



