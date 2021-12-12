package controller.class_model;

import dal.AccountDBContext;
import dal.AttendenceDBContext;
import dal.ClassDBContext;
import dal.ScheduleDBContext;
import dal.StudentDBContext;
import dal.SubjectDBContext;
import dal.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Linh
 */
@WebServlet(name = "AddClassController", urlPatterns = {"/class/add"})
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
        request.setAttribute("total_subject", total_subject);
        request.setAttribute("total_class", total_class);
        request.setAttribute("total_account", total_account);
        request.setAttribute("total_schedule", total_schedule);
        request.setAttribute("total_teacher", total_teacher);
        request.setAttribute("total_student", total_student);
        request.setAttribute("total_attendence", total_attendence);
        request.getRequestDispatcher("../view/admin/add_class.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String class_name = request.getParameter("class_name");
        
        model.Class c = model.Class.builder().ClassName(class_name).build();
        ClassDBContext dbC = new ClassDBContext();
        
        dbC.inert(c);
        response.sendRedirect("../class_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
