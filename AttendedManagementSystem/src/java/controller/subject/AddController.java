package controller.subject;

import dal.AccountDBContext;
import dal.ClassDBContext;
import dal.ScheduleDBContext;
import dal.SemesterDBContext;
import dal.SubjectDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Semester;
import model.Subject;

/**
 *
 * @author Linh
 */
public class AddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Semester> list_semester = new ArrayList<>();
        list_semester = new SemesterDBContext().getAll();
        int total_subject = new SubjectDBContext().countSubject();
        
        int total_class = new ClassDBContext().countClass();
        
        int total_account = new AccountDBContext().countAccount();
        
        int total_schedule = new ScheduleDBContext().countSchedule();
        
        request.setAttribute("total_subject", total_subject);
        request.setAttribute("total_class", total_class);
        request.setAttribute("total_account", total_account);
        request.setAttribute("total_schedule", total_schedule);
        request.setAttribute("list_semester", list_semester);
        request.getRequestDispatcher("../view/admin/add_subject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String subject_code = request.getParameter("subject_code");
        String subject_name = request.getParameter("subject_name");
        int total_slot = Integer.parseInt(request.getParameter("total_slot"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        
        Semester se = Semester.builder()
                .SemesterID(semester).build();
        se = new SemesterDBContext().getOne(se);
        
        Subject s = Subject.builder()
                .SubjectCode(subject_code)
                .SubjectName(subject_name)
                .TotalSlot(total_slot)
                .SemesterID(se)
                .build();
        
        SubjectDBContext dbSu = new SubjectDBContext();
        //int subject_id = 
        dbSu.insert(s);
        response.sendRedirect("../subject_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
