package controller.attendence;

import dal.AttendenceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendence;

/**
 *
 * @author Linh
 */
public class AttendenceDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        ArrayList<Attendence> list_attendence = new AttendenceDBContext().getAttendeds(scheduleID);
        request.setAttribute("list_attendence", list_attendence);
        request.getRequestDispatcher("../view/attendence/attendence_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
