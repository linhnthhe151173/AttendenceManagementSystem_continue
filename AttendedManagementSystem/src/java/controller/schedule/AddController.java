package controller.schedule;

import dal.AccountDBContext;
import dal.AttendenceDBContext;
import dal.ClassDBContext;
import dal.ScheduleDBContext;
import dal.StudentDBContext;
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
public class AddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int total_subject = new SubjectDBContext().countSubject();
        
        int total_class = new ClassDBContext().countClass();
        
        int total_account = new AccountDBContext().countAccount();
        
        int total_schedule = new ScheduleDBContext().countSchedule();
        
        int total_teacher = new TeacherDBContext().countTeacher();
        
        int total_student = new StudentDBContext().countStudent();
        
        int total_attendence = new AttendenceDBContext().countAttendence();
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
        request.setAttribute("total_subject", total_subject);
        request.setAttribute("total_class", total_class);
        request.setAttribute("total_account", total_account);
        request.setAttribute("total_schedule", total_schedule);
        request.setAttribute("total_teacher", total_teacher);
        request.setAttribute("total_student", total_student);
        request.setAttribute("total_attendence", total_attendence);
        request.getRequestDispatcher("../view/admin/add_schedule.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int subject = Integer.parseInt(request.getParameter("subject"));
        int classID = Integer.parseInt(request.getParameter("class"));
        int teacher = Integer.parseInt(request.getParameter("teacher"));
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
        c = new ClassDBContext().getOne(c);
        
        TimeSlot ts = TimeSlot.builder()
                .TimeSlotID(time).build();
        ts = new TimeSlotDBContext().getOne(ts);
        
        Schedule s = Schedule.builder()
                .TeacherID(t)
                .SubjectID(su)
                .ClassID(c)
                .TimeSlotID(ts)
                .ScheduleDate(date).build();
        
        ScheduleDBContext dbSche = new ScheduleDBContext();
        dbSche.insert(s);
        response.sendRedirect("../schedule_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
