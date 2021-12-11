package controller.teacher;

import dal.AttendenceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendence;

/**
 *
 * @author Linh
 */
@WebServlet(name = "EditController", urlPatterns = {"/teacher/edit"})
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentID = request.getParameter("studentID");
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));

        Attendence a_edit = new AttendenceDBContext().getAttendenceBySIdAndSchID(studentID, scheduleID);

        request.setAttribute("a_edit", a_edit);
        request.getRequestDispatcher("../view/teacher/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        String studentID = request.getParameter("studentID");
        boolean attendence = Boolean.parseBoolean(request.getParameter("attendence"));
        
        AttendenceDBContext dbAt = new AttendenceDBContext();
        Attendence a = dbAt.getAttendenceBySIdAndSchID(studentID, scheduleID);
        dbAt.update(a, attendence);
        
        ArrayList<Attendence> list_attendence = new AttendenceDBContext().getAttendeds(scheduleID);
        request.setAttribute("list_attendence", list_attendence);
        request.getRequestDispatcher("../view/teacher/submitted_attendence.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
