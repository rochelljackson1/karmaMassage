package com.uh.rachel.util.servlets;

import com.uh.rachel.util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class updateSTJDOptions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.updateSTJDRowByID((Integer.parseInt(request.getParameter("customerNumberInput")!=""?request.getParameter("customerNumberInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("upperBackRightInput")!=""?request.getParameter("upperBackRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("upperBackLeftInput")!=""?request.getParameter("upperBackLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("shouldersRightInput")!=""?request.getParameter("shouldersRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("shouldersLeftInput")!=""?request.getParameter("shouldersLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("neckRightInput")!=""?request.getParameter("neckRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("neckLeftInput")!=""?request.getParameter("neckLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("midBackRightInput")!=""?request.getParameter("midBackRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("midBackLeftInput")!=""?request.getParameter("midBackLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("lowerBackRightInput")!=""?request.getParameter("lowerBackRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("lowerBackLeftInput")!=""?request.getParameter("lowerBackLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("legsRightInput")!=""?request.getParameter("legsRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("legsLeftInput")!=""?request.getParameter("legsLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("kneesRightInput")!=""?request.getParameter("kneesRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("kneesLeftInput")!=""?request.getParameter("kneesLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("hipsRightInput")!=""?request.getParameter("hipsRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("hipsLeftInput")!=""?request.getParameter("hipsLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("handsRightInput")!=""?request.getParameter("handsRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("handsLeftInput")!=""?request.getParameter("handsLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("feetRightInput")!=""?request.getParameter("feetRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("feetLeftInput")!=""?request.getParameter("feetLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("armsRightInput")!=""?request.getParameter("armsRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("armsLeftInput")!=""?request.getParameter("armsLeftInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("anklesRightInput")!=""?request.getParameter("anklesRightInput"):"0")),
                (Boolean.parseBoolean(request.getParameter("anklesLeftInput")!=""?request.getParameter("anklesLeftInput"):"0")));
        response.sendRedirect("./existingConditionsSTJD.jsp");
    }
}
