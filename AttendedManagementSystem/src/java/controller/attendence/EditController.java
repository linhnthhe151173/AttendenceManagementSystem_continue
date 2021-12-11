package controller.attendence;

import dal.AttendenceDBContext;
import dal.ScheduleDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendence;
import model.Schedule;
import model.Student;

/**
 *
 * @author Linh
 */
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        Schedule s = new ScheduleDBContext().getScheduleByID(scheduleID);
        ArrayList<Attendence> list_edit = new ArrayList<>();
        list_edit = new AttendenceDBContext().getAttendeds(scheduleID);

        request.setAttribute("list_edit", list_edit);
        request.setAttribute("s", s);
        request.getRequestDispatcher("../view/attendence/attendence_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        String[] studentID = request.getParameterValues("studentID");

        long millis = System.currentTimeMillis();
        Date attendenceDate = new Date(millis);
        for (String s : studentID) {
            // Boolean attendence = Boolean.parseBoolean(request.getParameter("attendence")+studentID);
            Student student = Student.builder().StudentID(s).build();
            student = new StudentDBContext().getOne(student);

            Schedule schedule = new ScheduleDBContext().getScheduleByID(scheduleID);

            Attendence at = Attendence.builder()
                    .StudentID(student)
                    .ScheduleID(schedule)
                    .Present(Boolean.parseBoolean(request.getParameter("attendence" + s)))
                    .AttendenceDate(attendenceDate)
                    .build();

            AttendenceDBContext db = new AttendenceDBContext();
            db.updateAttendence(at);
            
        }
        response.sendRedirect("../teacher/other_schedule");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
