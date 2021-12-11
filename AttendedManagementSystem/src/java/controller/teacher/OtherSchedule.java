package controller.teacher;

import dal.ScheduleDBContext;
import dal.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Schedule;
import model.Teacher;

/**
 *
 * @author Linh
 */
@WebServlet(urlPatterns = {"/teacher/other_schedule"})
public class OtherSchedule extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account a = (Account) request.getSession().getAttribute("account");
        Teacher t = Teacher.builder()
                .TeacherEmail(a.getUsername()).build();
        t = new TeacherDBContext().getTeacherByEmail(t);
        
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        
        ArrayList<Schedule> list_schedule_all = new ArrayList<>();
        ScheduleDBContext dbSche = new ScheduleDBContext();
        list_schedule_all = dbSche.getAllScheduleByTeacher(t);
        request.setAttribute("list_schedule_all", list_schedule_all);
        request.setAttribute("date", date);
        request.getRequestDispatcher("../view/teacher/other_schedule.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account a = (Account) request.getSession().getAttribute("account");
        Teacher t = Teacher.builder()
                .TeacherEmail(a.getUsername()).build();
        t = new TeacherDBContext().getTeacherByEmail(t);
        
        String raw_date = request.getParameter("search_date");

        //ArrayList<Schedule> list_schedule = new ScheduleDBContext().getScheduleByDate2(Date.valueOf(raw_date), t);
        
        ArrayList<Schedule> list_schedule_all = new ArrayList<>();
        ScheduleDBContext dbSche = new ScheduleDBContext();
        list_schedule_all = dbSche.getAllScheduleByTeacher(t);

        ArrayList<Schedule> list_schedule;
        Date search_date = null;

        if (raw_date.equals("")) {
            list_schedule = new ArrayList<>();
            list_schedule_all = dbSche.getAllScheduleByTeacher(t);
        } else {
            search_date = Date.valueOf(request.getParameter("search_date"));
            list_schedule = dbSche.getScheduleByDate2(search_date, t);
        }
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);

        request.setAttribute("list_schedule", list_schedule);
        request.setAttribute("search_date", search_date);
        request.setAttribute("date", date);
        request.setAttribute("list_schedule_all", list_schedule_all);
        request.getRequestDispatcher("../view/teacher/other_schedule.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
