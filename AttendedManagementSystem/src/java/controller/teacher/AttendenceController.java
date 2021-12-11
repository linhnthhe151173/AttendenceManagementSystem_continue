package controller.teacher;

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
public class AttendenceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        int classID = Integer.parseInt(request.getParameter("classID"));

        Schedule s = new ScheduleDBContext().getScheduleByID(scheduleID);
        ArrayList<Student> students = new ArrayList<>();
        StudentDBContext dbStu = new StudentDBContext();
        students = dbStu.getStudentByClassID(classID);

        request.setAttribute("s", s);
        request.setAttribute("students", students);
        request.getRequestDispatcher("../view/teacher/attendence.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        String[] studentID = request.getParameterValues("studentID");
        ArrayList<Attendence> list_attendence = new ArrayList<>();
        AttendenceDBContext dbAt = new AttendenceDBContext();

        long millis = System.currentTimeMillis();
        Date attendenceDate = new Date(millis);
        for (String s : studentID) {
            Student student = Student.builder().StudentID(s).build();
            student = new StudentDBContext().getOne(student);

            Schedule schedule = new ScheduleDBContext().getScheduleByID(scheduleID);

            Attendence at = Attendence.builder()
                    .StudentID(student)
                    .ScheduleID(schedule)
                    .Present(Boolean.parseBoolean(request.getParameter("attendence" + s)))
                    .AttendenceDate(attendenceDate)
                    .build();

            list_attendence.add(at);
        }
        dbAt.insert(list_attendence);
        
        request.setAttribute("list_attendence", list_attendence);
        request.getRequestDispatcher("../view/teacher/submitted_attendence.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
