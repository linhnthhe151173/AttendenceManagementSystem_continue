package controller.schedule;

import dal.ClassDBContext;
import dal.ScheduleDBContext;
import dal.SubjectDBContext;
import dal.TeacherDBContext;
import dal.TimeSlotDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Schedule;
import model.Subject;
import model.Teacher;
import model.TimeSlot;

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
        
        ArrayList<Subject> list_subject = new ArrayList<>();
        list_subject = new SubjectDBContext().getAll();
        
        ArrayList<model.Class> list_class = new ArrayList<>();
        list_class = new ClassDBContext().getAll();
        
        ArrayList<Teacher> list_teacher = new ArrayList<>();
        list_teacher = new TeacherDBContext().getAll();
        
        ArrayList<TimeSlot> list_timeslot = new ArrayList<>();
        list_timeslot = new TimeSlotDBContext().getAll();
        
        request.setAttribute("list_subject", list_subject);
        request.setAttribute("list_class", list_class);
        request.setAttribute("list_teacher", list_teacher);
        request.setAttribute("list_timeslot", list_timeslot);
        request.setAttribute("s", s);
        request.getRequestDispatcher("../view/schedule/schedule_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        int teacher = Integer.parseInt(request.getParameter("teacher"));
        int subject = Integer.parseInt(request.getParameter("subject"));
        int classID = Integer.parseInt(request.getParameter("class"));
        Date date = Date.valueOf(request.getParameter("date"));
        int time = Integer.parseInt(request.getParameter("time"));
        
        Teacher t = Teacher.builder()
                .TeacherID(teacher).build();
        t = new TeacherDBContext().getOne(t);
        
        Subject su = Subject.builder()
                .SubjectID(subject).build();
        su = new SubjectDBContext().getOne(su);
                
        model.Class c = model.Class.builder()
                .ClassID(classID).build();
        c= new ClassDBContext().getOne(c);
        
        TimeSlot ts = TimeSlot.builder()
                .TimeSlotID(time).build();
        ts = new TimeSlotDBContext().getOne(ts);
        
        Schedule s = Schedule.builder()
                .ScheduleID(scheduleID)
                .TeacherID(t)
                .SubjectID(su)
                .ClassID(c)
                .ScheduleDate(date)
                .TimeSlotID(ts)
                .build();
        
        ScheduleDBContext db = new ScheduleDBContext();
        db.update(s);
        response.sendRedirect("../schedule_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
