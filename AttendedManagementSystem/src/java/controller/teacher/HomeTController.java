package controller.teacher;

import controller.authentication.BasedAuthentication;
import dal.AccountDBContext;
import dal.AttendenceDBContext;
import dal.ScheduleDBContext;
import dal.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Attendence;
import model.Schedule;
import model.Teacher;

/**
 *
 * @author Linh
 */
public class HomeTController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //chay today_schedule
            Account a = (Account) request.getSession().getAttribute("account");
            
            Teacher t = Teacher.builder()
                    .TeacherEmail(a.getUsername()).build();
            t = new TeacherDBContext().getTeacherByEmail(t);
            
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);

            //get today's schedule
            ArrayList<Schedule> list_schedule = new ArrayList<>();
            ScheduleDBContext dbSche = new ScheduleDBContext();

            list_schedule = dbSche.getScheduleByDate(date, t);

            request.setAttribute("date", date);
            request.setAttribute("t", t);
            request.setAttribute("list_schedule", list_schedule);
            request.getRequestDispatcher("../view/teacher/today_schedule.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
